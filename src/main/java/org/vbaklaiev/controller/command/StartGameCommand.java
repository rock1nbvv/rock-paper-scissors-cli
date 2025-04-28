package org.vbaklaiev.controller.command;

import org.vbaklaiev.model.GameContext;

public class StartGameCommand implements Command {
    private final GameContext context;

    public StartGameCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public String name() {
        return "start-game";
    }

    @Override
    public void execute() {
        while (true) {
            String input = context.io.readInput("How many rounds would you like to play? ");
            int rounds;
            try {
                rounds = Integer.parseInt(input);
                if (rounds <= 0) {
                    context.io.print("Invalid input. Please enter a positive number");
                    continue;
                }
            } catch (NumberFormatException e) {
                context.io.print("Invalid input. Please enter a positive number");
                continue;
            }

            context.totalRounds = rounds;
            break;
        }
    }
}

