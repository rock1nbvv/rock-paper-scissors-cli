package org.vbaklaiev.controller;

import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Result;

public class OutcomeEvaluator {

    public Result evaluate(Move playerMove, Move opponentMove) {
        if (playerMove == opponentMove) {
            return Result.DRAW;
        } else if (playerMove.beats(opponentMove)) {
            return Result.WIN;
        } else {
            return Result.LOSE;
        }
    }
}
