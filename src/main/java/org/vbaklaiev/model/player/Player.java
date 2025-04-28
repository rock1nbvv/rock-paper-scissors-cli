package org.vbaklaiev.model.player;

import org.vbaklaiev.model.Move;

public interface Player {
    Move makeMove();
    String getName();
}
