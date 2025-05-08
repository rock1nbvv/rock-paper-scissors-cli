package org.vbaklaiev.model.player;

import org.vbaklaiev.view.CommandInterface;

public class PlayerFactory {

    public static Player createHumanPlayer(CommandInterface io, String name) {
        return new HumanPlayer(io, name);
    }

    public static Player createComputerPlayer() {
        return new ComputerPlayer();
    }
}
