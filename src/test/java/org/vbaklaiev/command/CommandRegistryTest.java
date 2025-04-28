package org.vbaklaiev.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vbaklaiev.controller.command.Command;
import org.vbaklaiev.controller.CommandRegistry;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandRegistryTest {
    private CommandRegistry registry;

    @BeforeEach
    void setUp() {
        registry = new CommandRegistry();
    }

    static class TestCommand implements Command {
        private final String name;

        TestCommand(String name) {
            this.name = name;
        }

        @Override
        public void execute() {
        }

        @Override
        public String name() {
            return name;
        }
    }

    @Test
    void registersAndResolvesCommandByExactName() {
        Command cmd = new TestCommand("test-play");
        registry.register(cmd);

        Optional<Command> resolved = registry.get("test-play");

        assertThat(resolved).isPresent();
        assertThat(resolved.get().name()).isEqualTo("test-play");
    }

    @Test
    void resolvesCommandCaseInsensitive() {
        registry.register(new TestCommand("play"));

        Optional<Command> resolved = registry.get("PLAY");

        assertThat(resolved).isPresent();
        assertThat(resolved.get().name()).isEqualTo("play");
    }

    @Test
    void returnsEmptyForUnknownCommand() {
        Optional<Command> result = registry.get("unknown");

        assertThat(result).isEmpty();
    }

    @Test
    void listsAllAvailableCommandNames() {
        registry.register(new TestCommand("play"));
        registry.register(new TestCommand("exit"));

        String available = registry.availableCommands();

        assertThat(available).contains("play", "exit");
    }
}
