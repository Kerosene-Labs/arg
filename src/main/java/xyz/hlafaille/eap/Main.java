package xyz.hlafaille.eap;

import xyz.hlafaille.eap.exception.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws EapCommandNotFoundException, EapMissingSubcommandException, EapDuplicateCommandContainerException, EapMalformedCommandModifierException, EapSubcommandNotFoundException, EapCommandModifierNotFoundException, EapCommandNotSpecifiedException {
        EspressoArgumentParser espressoArgumentParser = new EspressoArgumentParser("EAP Application", "Test");

        // build our command
        Command command = new Command("test", "test") {
            @Override
            public void execute(List<CommandModifier> commandModifiers) {
                System.out.println(commandModifiers);
            }
        };

        // add a command modifier
        CommandModifier commandModifier = new CommandModifier("test", "test");
        command.addCommandModifier(commandModifier);

        // build our command container
        CommandContainer commandContainer = new CommandContainer("project", "Create, read, update and delete project information");
        commandContainer.addCommand(command);
        espressoArgumentParser.addCommandContainer(commandContainer);

        // entrypoint
        espressoArgumentParser.parse(args);
    }
}
