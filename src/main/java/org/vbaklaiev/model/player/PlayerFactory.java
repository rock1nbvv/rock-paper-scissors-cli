package org.vbaklaiev.model.player;

import org.vbaklaiev.view.CommandInterface;

//TODO should be tested(including Player implementations), it's just not interesting in this case
public class PlayerFactory {

    public Player createHumanPlayer(CommandInterface io, String name) {
        return new HumanPlayer(io, name);
    }

    public Player createComputerPlayer() {
        return new ComputerPlayer();
    }
}
