package org.vbaklaiev.controller.command;

import org.vbaklaiev.controller.CommandRegistry;
import org.vbaklaiev.view.CommandInterface;

/**
 * Central input loop that dispatches user commands
 */
public class CommandShell {
    private CommandRegistry registry;
    private final CommandInterface io;

    public CommandShell(CommandRegistry registry, CommandInterface io) {
        this.registry = registry;
        this.io = io;
    }

    public void run() {
        io.print("Welcome to Rock-Paper-Scissors");
        while (true) {
            String input = io.readInput("\nEnter command (" + registry.availableCommands() + "): ");
            registry.get(input).ifPresentOrElse(
                    Command::execute,
                    () -> io.print("Unknown command. Try again")
            );
        }
    }

    public CommandRegistry getRegistry() {
        return registry;
    }

    public void setRegistry(CommandRegistry registry) {
        this.registry = registry;
    }
}
