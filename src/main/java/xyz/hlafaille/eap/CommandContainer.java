package xyz.hlafaille.eap;

import java.util.List;

/**
 * A command container is kind of like a directory in a filesystem. A directory itself does not provide any
 * functionality, but it serves as a container for "files". In this case, a "command container" is a container
 * for "functional commands".
 */
public abstract class CommandContainer {
    private final String name;
    private final String description;
    private List<Command> commandList;

    public CommandContainer(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Get the name of this command container
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of this command container
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get a list of all commands under this container
     *
     * @return List object containing commands
     */
    public List<Command> getCommandList() {
        return commandList;
    }

    /**
     * Add a command to this container
     *
     * @param command Command instance
     */
    public void addCommand(Command command) {
        commandList.add(command);
    }
}
