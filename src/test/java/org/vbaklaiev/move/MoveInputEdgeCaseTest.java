package org.vbaklaiev.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.vbaklaiev.model.Move;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests all valid and invalid input parsing cases for Move.fromString().
 */
public class MoveInputEdgeCaseTest {
    @Test
    @DisplayName("should return correct move for lowercase input")
    void validLowerCaseInputs() {
        assertThat(Move.fromString("rock")).contains(Move.ROCK);
        assertThat(Move.fromString("paper")).contains(Move.PAPER);
        assertThat(Move.fromString("scissors")).contains(Move.SCISSORS);
    }

    @Test
    @DisplayName("should return correct move for uppercase input")
    void validUpperCaseInputs() {
        assertThat(Move.fromString("ROCK")).contains(Move.ROCK);
        assertThat(Move.fromString("PAPER")).contains(Move.PAPER);
        assertThat(Move.fromString("SCISSORS")).contains(Move.SCISSORS);
    }

    @Test
    @DisplayName("should return correct move for mixed-case input")
    void validMixedCaseInputs() {
        assertThat(Move.fromString("RoCk")).contains(Move.ROCK);
        assertThat(Move.fromString("Paper")).contains(Move.PAPER);
        assertThat(Move.fromString("scISsOrS")).contains(Move.SCISSORS);
    }

    @Test
    @DisplayName("should trim input and return correct move")
    void inputWithWhitespace() {
        assertThat(Move.fromString("  rock ")).contains(Move.ROCK);
    }

    @Test
    @DisplayName("should return empty for completely invalid input")
    void invalidInputs() {
        assertThat(Move.fromString("vlad")).isEmpty();
        assertThat(Move.fromString("123")).isEmpty();
        assertThat(Move.fromString("")).isEmpty();
        assertThat(Move.fromString(" ")).isEmpty();
        assertThat(Move.fromString(null)).isEmpty();
    }
}
