package org.vbaklaiev.model.player;

import org.vbaklaiev.model.Move;

import java.util.Random;

public class ComputerPlayer implements Player {
    private final Random random = new Random();

    @Override
    public Move makeMove() {
        Move[] values = Move.values();
        return values[random.nextInt(values.length)];
    }

    @Override
    public String getName() {
        return "Computer";
    }
}
