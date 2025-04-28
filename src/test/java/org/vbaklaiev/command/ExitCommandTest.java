package org.vbaklaiev.command;

import org.junit.jupiter.api.Test;
import org.vbaklaiev.controller.command.exit.ExitCommand;
import org.vbaklaiev.controller.command.exit.ExitHandler;

import static org.assertj.core.api.Assertions.assertThat;

public class ExitCommandTest {
    static class TestExitHandler implements ExitHandler {
        boolean exited = false;

        @Override
        public void exit() {
            exited = true;
        }
    }

    @Test
    void printsGoodbyeAndCallsExit() {
        FakeCommandInterface io = new FakeCommandInterface();
        TestExitHandler handler = new TestExitHandler();
        ExitCommand cmd = new ExitCommand(io, handler);

        cmd.execute();

        assertThat(io.getOutputs()).contains("Goodbye");
        assertThat(handler.exited).isTrue();
    }
}
