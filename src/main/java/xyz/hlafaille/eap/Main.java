package xyz.hlafaille.eap;

import xyz.hlafaille.eap.exception.EapCommandNotFoundException;
import xyz.hlafaille.eap.exception.EapDuplicateCommandContainerException;
import xyz.hlafaille.eap.exception.EapMalformedCommandModifierException;
import xyz.hlafaille.eap.exception.EapMissingSubcommandException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws EapCommandNotFoundException, EapMissingSubcommandException, EapDuplicateCommandContainerException, EapMalformedCommandModifierException {
        EspressoArgumentParser espressoArgumentParser = new EspressoArgumentParser("EAP Application", "Test");

        // build our command
        Command command = new Command("test", "test") {
            @Override
            void execute(List<CommandModifier> commandModifiers) {
                System.out.println("Test");
            }
        };

        // build our command container
        CommandContainer commandContainer = new CommandContainer("project", "Create, read, update and delete project information");
        commandContainer.addCommand(command);
        espressoArgumentParser.addCommandContainer(commandContainer);

        // entrypoint
        espressoArgumentParser.parse(args);
    }
}
