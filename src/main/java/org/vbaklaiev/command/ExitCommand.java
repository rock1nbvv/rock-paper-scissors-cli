package org.vbaklaiev.command;

import org.vbaklaiev.view.CommandInterface;

public class ExitCommand implements Command {
    private final CommandInterface io;

    public ExitCommand(CommandInterface io) {
        this.io = io;
    }

    @Override
    public void execute() {
        io.print("Goodbye.");
        System.exit(0);
    }

    @Override
    public String name() {
        return "exit";
    }
}
