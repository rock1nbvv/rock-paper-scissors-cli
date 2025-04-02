package org.vbaklaiev.command;

import java.util.List;

public class GameSessionCommand implements Command {
    private final List<Command> steps;

    public GameSessionCommand(List<Command> steps) {
        this.steps = steps;
    }

    @Override
    public String name() {
        return "play";
    }

    @Override
    public void execute() {
        for (Command step : steps) {
            step.execute();
        }
    }
}
