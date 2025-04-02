package org.vbaklaiev.command;

import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Result;

public class PlayTurnCommand  implements Command {
    private final GameContext context;

    public PlayTurnCommand(GameContext context) {
        this.context = context;
    }

    @Override
    public String name() { return "play-turn"; }

    @Override
    public void execute() {
        context.currentRound++;
        context.io.print("\nRound " + context.currentRound + ":");
        Move m1 = context.player1.makeMove();
        Move m2 = context.player2.makeMove();

        context.io.print(context.player1.getName() + " chose: " + m1);
        context.io.print(context.player2.getName() + " chose: " + m2);

        Result result = context.outcomeEvaluator.evaluate(m1, m2);
        switch (result) {
            case WIN -> { context.io.print(context.player1.getName() + " wins the round."); context.wins1++; }
            case LOSE -> { context.io.print(context.player2.getName() + " wins the round."); context.wins2++; }
            case DRAW -> { context.io.print("This round is a draw."); context.draws++; }
        }
    }
}
