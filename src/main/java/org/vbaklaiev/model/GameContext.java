package org.vbaklaiev.model;

import org.vbaklaiev.model.player.Player;
import org.vbaklaiev.view.CommandInterface;

public class GameContext {
    public Player player1;
    public Player player2;
    public int totalRounds;
    public int currentRound;
    public int wins1 = 0;
    public int wins2 = 0;
    public int draws = 0;
    public final CommandInterface io;

    public GameContext(Player p1, CommandInterface io) {
        this.player1 = p1;
        this.io = io;
    }

    public GameContext(Player p1, Player p2, CommandInterface io) {
        this.player1 = p1;
        this.player2 = p2;
        this.io = io;
    }

    public void resetStatistics() {
        this.wins1 = 0;
        this.wins2 = 0;
        this.draws = 0;
        this.currentRound = 0;
    }

    public static Result evaluateTurn(Move player1, Move player2) {
        if (player1 == player2) return Result.DRAW;
        return player1.beats(player2) ? Result.WIN : Result.LOSE;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
