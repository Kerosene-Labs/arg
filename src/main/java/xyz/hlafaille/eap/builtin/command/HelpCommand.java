package xyz.hlafaille.eap.builtin.command;

import xyz.hlafaille.eap.Command;
import xyz.hlafaille.eap.CommandContainer;
import xyz.hlafaille.eap.CommandModifier;

import java.util.List;

/**
 * Built in command for top-level help. Prints help text with the name and description of this application.
 */
public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", "Prints this text");
    }

    /**
     * Call the programmer-defined actions.
     *
     * @param commandModifiers     A list of command modifiers provided by the user
     * @param commandList          List of commands for the current scope
     * @param commandContainerList List of command containers for the current scope
     */
    @Override
    public void execute(List<CommandModifier> commandModifiers, List<Command> commandList, List<CommandContainer> commandContainerList) {

    }
}
