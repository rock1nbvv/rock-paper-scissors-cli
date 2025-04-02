package org.vbaklaiev;

import org.vbaklaiev.command.CommandRegistry;
import org.vbaklaiev.command.CommandShell;
import org.vbaklaiev.command.GameContext;
import org.vbaklaiev.command.PlayGameCommand;
import org.vbaklaiev.command.exit.DefaultExitHandler;
import org.vbaklaiev.command.exit.ExitCommand;
import org.vbaklaiev.controller.OutcomeEvaluator;
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

        OutcomeEvaluator evaluator = new OutcomeEvaluator();
        GameContext context = new GameContext(human, computer, io, evaluator);

        CommandRegistry registry = new CommandRegistry();
        registry.register(new PlayGameCommand(context));
        registry.register(new ExitCommand(io, new DefaultExitHandler()));

        CommandShell shell = new CommandShell(registry, io);
        shell.run();
    }
}