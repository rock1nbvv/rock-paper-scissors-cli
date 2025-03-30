package org.vbaklaiev.command.exit;

import org.vbaklaiev.command.Command;
import org.vbaklaiev.view.CommandInterface;

public class ExitCommand implements Command {
    private final CommandInterface io;
    private final ExitHandler handler;

    public ExitCommand(CommandInterface io, ExitHandler handler) {
        this.io = io;
        this.handler = handler;
    }

    @Override
    public void execute() {
        io.print("Goodbye");
        handler.exit();
    }

    @Override
    public String name() {
        return "exit";
    }
}
