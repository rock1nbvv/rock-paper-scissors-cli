package org.vbaklaiev.command;

import org.junit.jupiter.api.Test;
import org.vbaklaiev.controller.command.PlayTurnCommand;
import org.vbaklaiev.model.GameContext;
import org.vbaklaiev.controller.OutcomeEvaluator;
import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

    public class PlayTurnCommandTest {
    static class FixedPlayer implements Player {
        private final Move move;
        private final String name;

        FixedPlayer(Move move, String name) {
            this.move = move;
            this.name = name;
        }

        @Override
        public Move makeMove() {
            return move;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @Test
    void incrementsWinForPlayer1() {
        Player p1 = new FixedPlayer(Move.ROCK, "Player1");
        Player p2 = new FixedPlayer(Move.SCISSORS, "Player2");

        FakeCommandInterface io = new FakeCommandInterface();
        GameContext context = new GameContext(p1, p2, io, new OutcomeEvaluator());
        PlayTurnCommand cmd = new PlayTurnCommand(context);

        cmd.execute();

        assertThat(context.wins1).isEqualTo(1);
        assertThat(context.currentRound).isEqualTo(1);
    }

        @Test
        void incrementsWinForPlayer2() {
            Player p1 = new FixedPlayer(Move.ROCK, "Player1");
            Player p2 = new FixedPlayer(Move.PAPER, "Player2");

            FakeCommandInterface io = new FakeCommandInterface();
            GameContext context = new GameContext(p1, p2, io, new OutcomeEvaluator());
            PlayTurnCommand cmd = new PlayTurnCommand(context);

            cmd.execute();

            assertThat(context.wins2).isEqualTo(1);
            assertThat(context.currentRound).isEqualTo(1);
        }

    @Test
    void incrementsDrawWhenMovesAreEqual() {
        Player p1 = new FixedPlayer(Move.ROCK, "Player1");
        Player p2 = new FixedPlayer(Move.ROCK, "Player2");

        FakeCommandInterface io = new FakeCommandInterface();
        GameContext context = new GameContext(p1, p2, io, new OutcomeEvaluator());
        PlayTurnCommand cmd = new PlayTurnCommand(context);

        cmd.execute();

        assertThat(context.draws).isEqualTo(1);
    }
}
