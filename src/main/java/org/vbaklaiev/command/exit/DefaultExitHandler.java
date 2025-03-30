package org.vbaklaiev.command.exit;

public class DefaultExitHandler implements ExitHandler {
    @Override
    public void exit() {
        System.exit(0);
    }
}
