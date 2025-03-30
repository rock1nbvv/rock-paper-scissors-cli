package org.vbaklaiev;

import org.vbaklaiev.command.CommandRegistry;
import org.vbaklaiev.command.CommandShell;
import org.vbaklaiev.command.ExitCommand;
import org.vbaklaiev.command.PlayCommand;
import org.vbaklaiev.controller.GameEngine;
import org.vbaklaiev.factory.PlayerFactory;
import org.vbaklaiev.model.Player;
import org.vbaklaiev.view.CommandInterface;
import org.vbaklaiev.view.ConsoleCommandInterface;

public class Main {
    public static void main(String[] args) {
        CommandInterface io = new ConsoleCommandInterface();

        // Create players
        PlayerFactory factory = new PlayerFactory();
        Player human = factory.createHumanPlayer(io);
        Player computer = factory.createComputerPlayer();

        // Game engine
        GameEngine engine = new GameEngine(human, computer, io);

        // Register commands
        CommandRegistry registry = new CommandRegistry();
        registry.register(new PlayCommand(engine, io));
        registry.register(new ExitCommand(io));

        // Run shell
        CommandShell shell = new CommandShell(registry, io);
        shell.run();
    }
}