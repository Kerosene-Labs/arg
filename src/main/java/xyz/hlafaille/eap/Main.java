package xyz.hlafaille.eap;

import xyz.hlafaille.eap.exception.EapCommandNotFoundException;
import xyz.hlafaille.eap.exception.EapMissingSubcommandException;

public class Main {
    public static void main(String[] args) throws EapCommandNotFoundException, EapMissingSubcommandException {
        EspressoArgumentParser espressoArgumentParser = new EspressoArgumentParser("EAP Application", "Test");

        // build our command container
        CommandContainer commandContainer = new CommandContainer("project", "Create, read, update and delete project information");
        commandContainer.addCommand(new Command("init", "Create a new project") {
            @Override
            void execute() {
                System.out.println("INIT PROJECT");
            }
        });
        espressoArgumentParser.addCommandContainer(commandContainer);

        espressoArgumentParser.parse(args);
    }
}
