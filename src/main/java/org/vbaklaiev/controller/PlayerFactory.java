package org.vbaklaiev.controller;

import org.vbaklaiev.model.ComputerPlayer;
import org.vbaklaiev.model.HumanPlayer;
import org.vbaklaiev.model.Player;
import org.vbaklaiev.view.CommandInterface;

//TODO should be tested(including Player implementations), it's just not interesting in this case
public class PlayerFactory {

    public Player createHumanPlayer(CommandInterface io) {
        return new HumanPlayer(io);
    }

    public Player createComputerPlayer() {
        return new ComputerPlayer();
    }
}
