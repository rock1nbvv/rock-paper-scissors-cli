import org.junit.jupiter.api.Test;
import org.vbaklaiev.command.PlayCommand;
import org.vbaklaiev.controller.GameEngine;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayCommandTest {
    static class SpyGameEngine extends GameEngine {
        private boolean played = false;
        private int lastRounds = -1;

        public SpyGameEngine() {
            super(null, null, new FakeCommandInterface());
        }

        @Override
        public void playRounds(int rounds) {
            played = true;
            lastRounds = rounds;
        }

        public boolean wasPlayed() {
            return played;
        }

        public int getLastRounds() {
            return lastRounds;
        }
    }

    @Test
    void executesGameWithValidInput() {
        FakeCommandInterface io = new FakeCommandInterface();
        io.addInput("3");
        SpyGameEngine engine = new SpyGameEngine();
        PlayCommand cmd = new PlayCommand(engine, io);

        cmd.execute();

        assertThat(engine.wasPlayed()).isTrue();
        assertThat(engine.getLastRounds()).isEqualTo(3);
    }

    @Test
    void showsErrorOnInvalidInput() {
        FakeCommandInterface io = new FakeCommandInterface();
        io.addInput("abc");
        SpyGameEngine engine = new SpyGameEngine();
        PlayCommand cmd = new PlayCommand(engine, io);

        cmd.execute();

        assertThat(engine.wasPlayed()).isFalse();
        assertThat(io.getOutputs()).anyMatch(s -> s.contains("Invalid number"));
    }
}
