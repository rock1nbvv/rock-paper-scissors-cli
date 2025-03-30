package org.vbaklaiev;

import org.vbaklaiev.command.CommandRegistry;
import org.vbaklaiev.command.CommandShell;
import org.vbaklaiev.command.exit.DefaultExitHandler;
import org.vbaklaiev.command.exit.ExitCommand;
import org.vbaklaiev.command.PlayCommand;
import org.vbaklaiev.controller.GameEngine;
import org.vbaklaiev.factory.PlayerFactory;
import org.vbaklaiev.model.Player;
import org.vbaklaiev.view.CommandInterface;
import org.vbaklaiev.view.ConsoleCommandInterface;

public class Main {
    public static void main(String[] args) {
        CommandInterface io = new ConsoleCommandInterface();

        PlayerFactory factory = new PlayerFactory();
        Player human = factory.createHumanPlayer(io);
        Player computer = factory.createComputerPlayer();

        GameEngine engine = new GameEngine(human, computer, io);

        CommandRegistry registry = new CommandRegistry();
        registry.register(new PlayCommand(engine, io));
        registry.register(new ExitCommand(io, new DefaultExitHandler()));

        CommandShell shell = new CommandShell(registry, io);
        shell.run();
    }
}