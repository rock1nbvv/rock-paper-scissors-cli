package org.vbaklaiev.controller.command;

import org.vbaklaiev.model.GameContext;
import org.vbaklaiev.model.player.PlayerFactory;

public class PlayPveCommand implements Command {
    private final GameContext context;

    public PlayPveCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public String name() {
        return "pve";
    }

    @Override
    public void execute() {
        context.setPlayer2(PlayerFactory.createComputerPlayer());
        new StartGameCommand(context).execute();
        for (int i = 0; i < context.totalRounds; i++) {
            new PlayTurnCommand(context).execute();
        }
        new ShowResultsCommand(context).execute();
    }
}
