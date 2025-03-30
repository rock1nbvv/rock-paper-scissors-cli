package org.vbaklaiev.command;

import org.vbaklaiev.view.CommandInterface;

public class CommandShell {
    private final CommandRegistry registry;
    private final CommandInterface io;

    public CommandShell(CommandRegistry registry, CommandInterface io) {
        this.registry = registry;
        this.io = io;
    }

    public void run() {
        io.print("Welcome to Rock-Paper-Scissors.");
        while (true) {
            String input = io.readInput("\nEnter command (" + registry.availableCommands() + "): ");
            registry.get(input).ifPresentOrElse(
                    Command::execute,
                    () -> io.print("Unknown command. Try again.")
            );
        }
    }
}
