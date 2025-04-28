package org.vbaklaiev.model.player;

import org.vbaklaiev.model.Move;
import org.vbaklaiev.view.CommandInterface;

import java.util.Optional;

public class HumanPlayer implements Player {
    private final CommandInterface io;
    private final String name;

    public HumanPlayer(CommandInterface io, String name) {
        this.io = io;
        this.name = name;
    }

    @Override
    public Move makeMove() {
        while (true) {
            String input = io.readInput("Choose your move (rock/paper/scissors): ");
            Optional<Move> move = Move.fromString(input);
            if (move.isPresent()) {
                return move.get();
            } else {
                io.print("Invalid move. Try again");
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
