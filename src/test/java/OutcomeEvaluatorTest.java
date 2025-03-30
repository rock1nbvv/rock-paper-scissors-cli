import org.junit.jupiter.api.Test;
import org.vbaklaiev.controller.OutcomeEvaluator;
import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Result;

import static org.assertj.core.api.Assertions.assertThat;

public class OutcomeEvaluatorTest {
    private final OutcomeEvaluator evaluator = new OutcomeEvaluator();

    @Test
    void returnsWinWhenPlayerMoveBeatsOpponent() {
        assertThat(evaluator.evaluate(Move.ROCK, Move.SCISSORS)).isEqualTo(Result.WIN);
    }

    @Test
    void returnsLoseWhenPlayerMoveLosesToOpponent() {
        assertThat(evaluator.evaluate(Move.SCISSORS, Move.ROCK)).isEqualTo(Result.LOSE);
    }

    @Test
    void returnsDrawWhenMovesAreEqual() {
        assertThat(evaluator.evaluate(Move.PAPER, Move.PAPER)).isEqualTo(Result.DRAW);
    }
}
