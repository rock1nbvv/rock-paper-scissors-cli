package org.vbaklaiev;

import org.junit.jupiter.api.Test;
import org.vbaklaiev.model.GameContext;
import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Result;

import static org.assertj.core.api.Assertions.assertThat;

public class OutcomeEvaluatorTest {

    @Test
    void returnsWinWhenPlayerMoveBeatsOpponent() {
        assertThat(GameContext.OutcomeEvaluator.evaluate(Move.ROCK, Move.SCISSORS)).isEqualTo(Result.WIN);
    }

    @Test
    void returnsLoseWhenPlayerMoveLosesToOpponent() {
        assertThat(GameContext.OutcomeEvaluator.evaluate(Move.SCISSORS, Move.ROCK)).isEqualTo(Result.LOSE);
    }

    @Test
    void returnsDrawWhenMovesAreEqual() {
        assertThat(GameContext.OutcomeEvaluator.evaluate(Move.PAPER, Move.PAPER)).isEqualTo(Result.DRAW);
    }
}
