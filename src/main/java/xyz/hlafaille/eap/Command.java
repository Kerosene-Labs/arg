package xyz.hlafaille.eap;

import lombok.Getter;
import xyz.hlafaille.eap.exception.EapCommandModifierNotFoundException;
import xyz.hlafaille.eap.exception.EapMalformedCommandModifierException;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Espresso Argument Parser Command</h2>
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
     * Automatically called by the EspressoArgumentParser, this method primarily does parsing and type checking on
     * any potential command modifiers passed.
     *
     * @param remainingArgs Array of remaining args
     */
    public void preExecute(String[] remainingArgs) throws EapMalformedCommandModifierException, EapCommandModifierNotFoundException {
        List<CommandModifier> commandModifiers = new ArrayList<>();
        for (String arg : remainingArgs) {
            // if this command modifier doesn't include "--"
            if (!arg.contains("--")) {
                throw new EapMalformedCommandModifierException(arg);
            }

            // iterate over the registered command modifiers, find one matching the users input
            Boolean commandModifierMatchFound = false;
            for (CommandModifier commandModifier : commandModifierList) {
                if (commandModifier.getName().equals(arg)) {
                    commandModifiers.add(commandModifier);
                    commandModifierMatchFound = true;
                }
            }

            // if the requested command modifier could not be found
            if (!commandModifierMatchFound) {
                throw new EapCommandModifierNotFoundException(arg);
            }
        }
        execute(commandModifiers);
    }

    /**
     * Call the programmer-defined actions.
     *
     * @param commandModifiers A list of command modifiers provided by the user
     */
    abstract void execute(List<CommandModifier> commandModifiers);
}
