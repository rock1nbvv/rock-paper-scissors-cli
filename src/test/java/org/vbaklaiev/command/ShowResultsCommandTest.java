package org.vbaklaiev.command;

import org.junit.jupiter.api.Test;
import org.vbaklaiev.controller.command.ShowResultsCommand;
import org.vbaklaiev.model.GameContext;
import org.vbaklaiev.controller.OutcomeEvaluator;
import org.vbaklaiev.model.Move;
import org.vbaklaiev.model.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class ShowResultsCommandTest {

    @Test
    void printsFinalScoreCorrectly() {
        Player dummyPlayer = new Player() {
            @Override
            public Move makeMove() {
                return null;
            }

            @Override
            public String getName() {
                return "dummy";
            }
        };
        FakeCommandInterface io = new FakeCommandInterface();

        GameContext context = new GameContext(dummyPlayer, dummyPlayer, io, new OutcomeEvaluator());
        context.wins1 = 2;
        context.wins2 = 1;
        context.draws = 3;

        ShowResultsCommand cmd = new ShowResultsCommand(context);
        cmd.execute();

        assertThat(io.getOutputs()).anySatisfy(out -> assertThat(out).contains("2"));
        assertThat(io.getOutputs()).anySatisfy(out -> assertThat(out).contains("3"));
    }
}
