package org.vbaklaiev.command;

public class StartGameCommand implements Command {
    private final GameContext context;

    public StartGameCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public String name() { return "start-game"; }

    @Override
    public void execute() {
        String input = context.io.readInput("How many rounds would you like to play? ");
        try {
            int rounds = Integer.parseInt(input);
            if (rounds <= 0) throw new NumberFormatException();
            context.totalRounds = rounds;
        } catch (NumberFormatException e) {
            context.io.print("Invalid input. Defaulting to 1 round.");
            context.totalRounds = 1;
        }
    }
}
