package org.vbaklaiev.command;

public class PlayGameCommand implements Command {
    private final GameContext context;

    public PlayGameCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public String name() { return "play"; }

    @Override
    public void execute() {
        new StartGameCommand(context).execute();
        for (int i = 0; i < context.totalRounds; i++) {
            new PlayTurnCommand(context).execute();
        }
        new ShowResultsCommand(context).execute();
    }
}
