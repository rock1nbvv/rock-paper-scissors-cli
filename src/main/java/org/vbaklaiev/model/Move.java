package org.vbaklaiev.model;

import java.util.Optional;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public static Optional<Move> fromString(String input) {
        if (input == null || input.isBlank()) return Optional.empty();
        String normalized = input.trim().toLowerCase();
        return switch (normalized) {
            case "rock" -> Optional.of(ROCK);
            case "paper" -> Optional.of(PAPER);
            case "scissors" -> Optional.of(SCISSORS);
            default -> Optional.empty();
        };
    }

    public boolean beats(Move other) {
        return switch (this) {
            case ROCK -> other == SCISSORS;
            case PAPER -> other == ROCK;
            case SCISSORS -> other == PAPER;
        };
    }
}
