package org.vbaklaiev.command;

public class ShowResultsCommand implements Command {
    private final GameContext context;

    public ShowResultsCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public String name() { return "show-results"; }

    @Override
    public void execute() {
        context.io.print("\nFinal Results:");
        context.io.print(context.player1.getName() + ": " + context.wins1);
        context.io.print(context.player2.getName() + ": " + context.wins2);
        context.io.print("Draws: " + context.draws);
    }
}
