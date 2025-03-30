import org.junit.jupiter.api.Test;
import org.vbaklaiev.model.Move;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveTest {
    @Test
    void rockBeatsScissors() {
        assertThat(Move.ROCK.beats(Move.SCISSORS)).isTrue();
    }

    @Test
    void paperBeatsRock() {
        assertThat(Move.PAPER.beats(Move.ROCK)).isTrue();
    }

    @Test
    void scissorsBeatsPaper() {
        assertThat(Move.SCISSORS.beats(Move.PAPER)).isTrue();
    }

    @Test
    void sameMoveDoesNotBeatItself() {
        for (Move move : Move.values()) {
            assertThat(move.beats(move)).isFalse();
        }
    }
}
