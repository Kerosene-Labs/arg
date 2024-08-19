package io.kerosenelabs.arg;

import io.kerosenelabs.arg.exception.CommandModifierNotFoundException;
import io.kerosenelabs.arg.exception.MalformedCommandModifierException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Argument Parser Command</h2>
 */
public abstract class Command {
    @Getter
    private String name;

    @Getter
    private String helpText;

    @Getter
    private List<CommandModifier> commandModifierList = new ArrayList<>();

    public Command(String name, String helpText) {
        this.name = name;
        this.helpText = helpText;
    }

    /**
     * Add a Command Modifier to this command. An example of a Command Modifier would be --tail 30. Command modifiers
     * can be marked as required or not.
     *
     * @param commandModifier CommandModifier instance
     */
    public void addCommandModifier(CommandModifier commandModifier) {
        commandModifierList.add(commandModifier);
    }

    /**
     * Automatically called by the ArgumentParser, this method primarily does parsing and type checking on
     * any potential command modifiers passed.
     *
     * @param remainingArgs Array of remaining args
     */
    public void preExecute(String[] remainingArgs) throws MalformedCommandModifierException, CommandModifierNotFoundException {
        List<CommandModifier> commandModifiers = new ArrayList<>();
        for (String arg : remainingArgs) {
            // if this command modifier doesn't include "--"
            if (!arg.contains("--")) {
                throw new MalformedCommandModifierException(arg);
            }

            // strip out the "--"
            String baseCommandModifierName = arg.replace("--", "");

            // iterate over the registered command modifiers, find one matching the users input
            Boolean commandModifierMatchFound = false;
            for (CommandModifier commandModifier : commandModifierList) {
                if (commandModifier.getName().equals(baseCommandModifierName)) {
                    commandModifiers.add(commandModifier);
                    commandModifierMatchFound = true;
                }
            }

            // if the requested command modifier could not be found
            if (!commandModifierMatchFound) {
                throw new CommandModifierNotFoundException(arg);
            }
        }
        execute(commandModifiers);
    }

    /**
     * Call the programmer-defined actions.
     *
     * @param commandModifiers A list of command modifiers provided by the user
     */
    public abstract void execute(List<CommandModifier> commandModifiers);
}
