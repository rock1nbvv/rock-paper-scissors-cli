package org.vbaklaiev.command;

import org.junit.jupiter.api.Test;
import org.vbaklaiev.controller.command.StartGameCommand;
import org.vbaklaiev.model.GameContext;

import static org.assertj.core.api.Assertions.assertThat;

public class StartGameCommandTest {
    @Test
    void setsValidRoundCountInContext() {
        FakeCommandInterface io = new FakeCommandInterface();
        io.addInput("3");

        GameContext context = new GameContext(null, null, io);
        StartGameCommand cmd = new StartGameCommand(context);

        cmd.execute();

        assertThat(context.totalRounds).isEqualTo(3);
    }

    @Test
    void retriesUntilValidInput() {
        FakeCommandInterface io = new FakeCommandInterface();
        io.addInput("abc");
        io.addInput("-2");
        io.addInput("3");

        GameContext context = new GameContext(null, null, io);
        StartGameCommand cmd = new StartGameCommand(context);

        cmd.execute();

        assertThat(context.totalRounds).isEqualTo(3);
        assertThat(io.getOutputs()).filteredOn(line -> line.contains("Invalid input"))
                .hasSize(2);
        assertThat(io.getOutputs()).filteredOn(line -> line.contains("How many rounds"))
                .hasSize(3);
    }
}
