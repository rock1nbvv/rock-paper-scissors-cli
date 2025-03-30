import org.junit.jupiter.api.Test;
import org.vbaklaiev.controller.GameEngine;
import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Player;

public class GameEngineTest {
    private static class FixedMovePlayer implements Player {
        private final Move move;
        private final String name;

        FixedMovePlayer(Move move, String name) {
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
    void playsCorrectNumberOfRoundsAndPrintsResults() {
        FakeCommandInterface io = new FakeCommandInterface();
        Player player = new FixedMovePlayer(Move.ROCK, "Player");
        Player computer = new FixedMovePlayer(Move.SCISSORS, "Computer");

        GameEngine engine = new GameEngine(player, computer, io);
        engine.playRounds(3);

        long winLines = io.getOutputs().stream().filter(l -> l.contains("Player wins this round")).count();
        long finalScoreLines = io.getOutputs().stream().filter(l -> l.contains("Game over")).count();

        assert winLines == 3;
        assert finalScoreLines == 1;
    }
}
