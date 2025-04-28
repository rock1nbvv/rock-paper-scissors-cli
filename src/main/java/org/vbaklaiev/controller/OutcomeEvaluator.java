package org.vbaklaiev.controller;

import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Result;

public class OutcomeEvaluator {

    public Result evaluate(Move player1, Move player2) {
        if (player1 == player2) return Result.DRAW;
        return player1.beats(player2) ? Result.WIN : Result.LOSE;
    }
}
