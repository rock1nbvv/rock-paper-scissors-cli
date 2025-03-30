package org.vbaklaiev.command;

import org.vbaklaiev.controller.GameEngine;
import org.vbaklaiev.view.CommandInterface;

public class PlayCommand implements Command {
    private final GameEngine gameEngine;
    private final CommandInterface io;

    public PlayCommand(GameEngine gameEngine, CommandInterface io) {
        this.gameEngine = gameEngine;
        this.io = io;
    }

    @Override
    public void execute() {
        try {
            String input = io.readInput("How many rounds would you like to play? ");
            int rounds = Integer.parseInt(input);
            if (rounds <= 0) throw new NumberFormatException();
            gameEngine.playRounds(rounds);
        } catch (NumberFormatException ex) {
            io.print("Invalid number. Please enter a positive integer");
        }
    }

    @Override
    public String name() {
        return "play";
    }
}
