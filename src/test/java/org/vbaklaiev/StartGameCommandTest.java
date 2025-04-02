package org.vbaklaiev;

import org.junit.jupiter.api.Test;
import org.vbaklaiev.command.GameContext;
import org.vbaklaiev.command.StartGameCommand;
import org.vbaklaiev.controller.OutcomeEvaluator;

import static org.assertj.core.api.Assertions.assertThat;

public class StartGameCommandTest {
    @Test
    void setsValidRoundCountInContext() {
        FakeCommandInterface io = new FakeCommandInterface();
        io.addInput("3");

        GameContext context = new GameContext(null, null, io, new OutcomeEvaluator());
        StartGameCommand cmd = new StartGameCommand(context);

        cmd.execute();

        assertThat(context.totalRounds).isEqualTo(3);
    }

    @Test
    void defaultsToOneRoundForInvalidInput() {
        FakeCommandInterface io = new FakeCommandInterface();
        io.addInput("invalid");

        GameContext context = new GameContext(null, null, io, new OutcomeEvaluator());
        StartGameCommand cmd = new StartGameCommand(context);

        cmd.execute();

        assertThat(context.totalRounds).isEqualTo(1);
        assertThat(io.getOutputs()).anyMatch(out -> out.contains("Invalid input"));
    }

}
