package org.vbaklaiev.command;

import org.junit.jupiter.api.Test;
import org.vbaklaiev.controller.command.PlayGameCommand;
import org.vbaklaiev.model.GameContext;
import org.vbaklaiev.controller.OutcomeEvaluator;
import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayGameCommandTest {
    static class DummyPlayer implements Player {
        @Override
        public Move makeMove() {
            return Move.ROCK;
        }

        @Override
        public String getName() {
            return "dummy";
        }
    }

    @Test
    void executesAllSubcommandsInOrder() {
        FakeCommandInterface io = new FakeCommandInterface();
        io.addInput("1");

        GameContext context = new GameContext(new DummyPlayer(), new DummyPlayer(), io, new OutcomeEvaluator());
        PlayGameCommand command = new PlayGameCommand(context);

        command.execute();

        assertThat(context.totalRounds).isEqualTo(1);
        assertThat(context.currentRound).isEqualTo(1);
        assertThat(context.draws).isEqualTo(1);

        assertThat(io.getOutputs()).anySatisfy(line -> assertThat(line).contains("Round 1"));
        assertThat(io.getOutputs()).anySatisfy(line -> assertThat(line).contains("Final Results"));
    }
}
