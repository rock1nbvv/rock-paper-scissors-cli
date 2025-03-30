package org.vbaklaiev.factory;

import org.vbaklaiev.model.ComputerPlayer;
import org.vbaklaiev.model.HumanPlayer;
import org.vbaklaiev.model.Player;
import org.vbaklaiev.view.CommandInterface;

public class PlayerFactory {

    public Player createHumanPlayer(CommandInterface io) {
        return new HumanPlayer(io);
    }

    public Player createComputerPlayer() {
        return new ComputerPlayer();
    }
}
