package org.vbaklaiev;

import org.vbaklaiev.controller.CommandRegistry;
import org.vbaklaiev.model.player.PlayerFactory;
import org.vbaklaiev.controller.command.CommandShell;
import org.vbaklaiev.controller.command.PlayPveCommand;
import org.vbaklaiev.controller.command.exit.DefaultExitHandler;
import org.vbaklaiev.controller.command.exit.ExitCommand;
import org.vbaklaiev.model.GameContext;
import org.vbaklaiev.model.player.Player;
import org.vbaklaiev.view.CommandInterface;
import org.vbaklaiev.view.ConsoleCommandInterface;

public class Main {
    public static void main(String[] args) {
        CommandInterface io = new ConsoleCommandInterface();
        PlayerFactory factory = new PlayerFactory();

        String playerName = io.readInput("Enter your name: ");
        Player human = factory.createHumanPlayer(io, playerName);
        Player computer = factory.createComputerPlayer();

        GameContext context = new GameContext(human, computer, io);

        CommandRegistry registry = new CommandRegistry();
        registry.register(new PlayPveCommand(context));
        registry.register(new ExitCommand(io, new DefaultExitHandler()));

        CommandShell shell = new CommandShell(registry, io);
        shell.run();
    }
}
