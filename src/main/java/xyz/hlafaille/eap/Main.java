package xyz.hlafaille.eap;

import xyz.hlafaille.eap.buitlin.exceptionhandler.EapCommandModifierNotFoundExceptionHandler;
import xyz.hlafaille.eap.exception.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws EapCommandNotFoundException, EapMissingSubcommandException, EapDuplicateCommandContainerException, EapMalformedCommandModifierException, EapSubcommandNotFoundException, EapCommandModifierNotFoundException, EapCommandNotSpecifiedException, EapDuplicateCommandException {
        EspressoArgumentParser espressoArgumentParser = new EspressoArgumentParser("EAP Application", "Test");

        // build our command
        Command command = new Command("test", "test") {
            @Override
            public void execute(List<CommandModifier> commandModifiers) {
                System.out.println(commandModifiers);
            }
        };
        espressoArgumentParser.addCommand(command);

        // entrypoint
        espressoArgumentParser.parse(args);
    }
}
