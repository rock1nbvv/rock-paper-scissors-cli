package org.vbaklaiev.model;

import org.vbaklaiev.view.CommandInterface;

import java.util.Optional;

public class HumanPlayer implements Player {
    private final CommandInterface io;

    public HumanPlayer(CommandInterface io) {
        this.io = io;
    }

    @Override
    public Move makeMove() {
        while (true) {
            String input = io.readInput("Choose your move (rock/paper/scissors): ");
            Optional<Move> move = Move.fromString(input);
            if (move.isPresent()) {
                return move.get();
            } else {
                io.print("Invalid move. Try again.");
            }
        }
    }

    @Override
    public String getName() {
        return "You";
    }
}
