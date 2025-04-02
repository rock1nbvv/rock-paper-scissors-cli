package org.vbaklaiev;

import org.junit.jupiter.api.Test;
import org.vbaklaiev.command.exit.ExitCommand;
import org.vbaklaiev.command.exit.ExitHandler;

import static org.assertj.core.api.Assertions.assertThat;

public class ExitCommandTest {
    static class StubExitHandler implements ExitHandler {
        boolean exited = false;

        @Override
        public void exit() {
            exited = true;
        }
    }

    @Test
    void printsGoodbyeAndCallsExit() {
        FakeCommandInterface io = new FakeCommandInterface();
        StubExitHandler handler = new StubExitHandler();
        ExitCommand cmd = new ExitCommand(io, handler);

        cmd.execute();

        assertThat(io.getOutputs()).contains("Goodbye");
        assertThat(handler.exited).isTrue();
    }
}
