package org.vbaklaiev.model;

import org.vbaklaiev.controller.OutcomeEvaluator;
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
    public final OutcomeEvaluator outcomeEvaluator;

    public GameContext(Player p1, Player p2, CommandInterface io, OutcomeEvaluator service) {
        this.player1 = p1;
        this.player2 = p2;
        this.io = io;
        this.outcomeEvaluator = service;
    }
}
