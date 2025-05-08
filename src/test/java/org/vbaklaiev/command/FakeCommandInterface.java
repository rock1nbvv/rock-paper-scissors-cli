package org.vbaklaiev.command;

import org.vbaklaiev.view.CommandInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Fake implementation of CommandInterface used for testing.
 * Mocks for user input/output.
 * <p>
 * TODO can be rewritten with mockito
 */
public class FakeCommandInterface implements CommandInterface {
    private final Queue<String> inputs = new LinkedList<>();
    private final List<String> outputs = new ArrayList<>();

    public void addInput(String input) {
        inputs.add(input);
    }

    public List<String> getOutputs() {
        return outputs;
    }

    @Override
    public String readInput(String prompt) {
        outputs.add(prompt);
        return inputs.poll();
    }

    @Override
    public void print(String message) {
        outputs.add(message);
    }
}
