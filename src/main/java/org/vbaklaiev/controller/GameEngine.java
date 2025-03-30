package org.vbaklaiev.controller;

import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Player;
import org.vbaklaiev.model.Result;
import org.vbaklaiev.view.CommandInterface;

/**
 * Main game orchestrator that executes game rounds between two players.
 * Handles result tracking and user interaction.
 */
public class GameEngine {
    private final Player player1;
    private final Player player2;
    private final OutcomeEvaluator evaluator;
    private final CommandInterface io;

    private int player1Wins = 0;
    private int player2Wins = 0;
    private int draws = 0;

    public GameEngine(Player player1, Player player2, CommandInterface io) {
        this.player1 = player1;
        this.player2 = player2;
        this.io = io;
        this.evaluator = new OutcomeEvaluator();
    }

    public void playRounds(int rounds) {
        for (int i = 1; i <= rounds; i++) {
            io.print("\nRound " + i + ":");
            Move move1 = player1.makeMove();
            Move move2 = player2.makeMove();

            io.print(player1.getName() + " chose: " + move1);
            io.print(player2.getName() + " chose: " + move2);

            Result result = evaluator.evaluate(move1, move2);
            switch (result) {
                case WIN -> {
                    io.print(player1.getName() + " wins this round");
                    player1Wins++;
                }
                case LOSE -> {
                    io.print(player2.getName() + " wins this round");
                    player2Wins++;
                }
                case DRAW -> {
                    io.print("it's a draw");
                    draws++;
                }
            }
        }
        printFinalResults();
    }

    private void printFinalResults() {
        io.print("\nGame over. Final score:");
        io.print(player1.getName() + ": " + player1Wins);
        io.print(player2.getName() + ": " + player2Wins);
        io.print("Draws: " + draws);
    }
}
