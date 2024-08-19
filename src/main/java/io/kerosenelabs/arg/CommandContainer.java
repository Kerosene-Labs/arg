package io.kerosenelabs.arg;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * A command container is kind of like a directory in a filesystem. A directory itself does not provide any
 * functionality, but it serves as a container for "files". In this case, a "command container" is a container
 * for "functional commands".
 */
@Getter
public class CommandContainer {
    private final String name;
    private final String description;
    private List<CommandContainer> childCommandContainers = new ArrayList<>();
    private List<Command> commands = new ArrayList<>();

    public CommandContainer(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addChildCommandContainer(CommandContainer commandContainer) {
        childCommandContainers.add(commandContainer);
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

}
