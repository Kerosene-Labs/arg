package io.kerosenelabs.arg;

import io.kerosenelabs.arg.exception.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws CommandNotFoundException, EapMissingSubcommandException, DuplicateCommandContainerException, MalformedCommandModifierException, EapSubcommandNotFoundException, CommandModifierNotFoundException, CommandNotSpecifiedException, DuplicateCommandException {
        ArgumentParser argumentParser = new ArgumentParser("EAP Application", "Test");

        // build our command
        Command command = new Command("test", "test") {
            @Override
            public void execute(List<CommandModifier> commandModifiers) {
                System.out.println(commandModifiers);
            }
        };
        argumentParser.addCommand(command);

        // entrypoint
        argumentParser.parse(args);
    }
}
