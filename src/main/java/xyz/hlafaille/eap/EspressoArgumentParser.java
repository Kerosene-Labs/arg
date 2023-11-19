package xyz.hlafaille.eap;

import lombok.Getter;
import xyz.hlafaille.eap.exception.EapMissingSubcommandException;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Espresso Argument Parser (EAP)</h2>
 * Instantiate this singleton once in your entrypoint method. the Espresso Argument Parser is effectively the main class
 * of your command line application.
 */
public class EspressoArgumentParser {
    private static EspressoArgumentParser instance;

    @Getter
    private final String applicationName;

    @Getter
    private final String applicationDescription;

    private final List<CommandContainer> commandContainerList = new ArrayList<>();

    /**
     * Constructor
     *
     * @param applicationName        The name of your EAP application
     * @param applicationDescription A short description of your EAP application
     */
    public EspressoArgumentParser(String applicationName, String applicationDescription) {
        if (instance != null) {
            throw new RuntimeException("An EspressoArgumentParser has already been instantiated (application name=%s)".formatted(applicationName));
        }
        this.applicationName = applicationName;
        this.applicationDescription = applicationDescription;
        instance = this;
    }

    /**
     * Get the singleton instance
     *
     * @return Singleton of EspressoArgumentParser
     */
    private static EspressoArgumentParser getInstance() {
        if (instance == null) {
            throw new RuntimeException("An EspressoArgumentParser was never instantiated, therefore there is no instance to retrieve");
        }
        return instance;
    }

    /**
     * Add a Command Container
     *
     * @param commandContainer CommandContainer instance
     */
    public void addCommandContainer(CommandContainer commandContainer) {
        commandContainerList.add(commandContainer);
    }

    /**
     * Intended to be called recursively, parseInCommandContainer will work its way down the args until it discovers a
     * valid Command under a CommandContainer. If a Command was found, it will call .execute() on the Command.
     * @param commandContainer Command Container to search under
     */
    private void parseInCommandContainer(CommandContainer commandContainer, String[] remainingArgs) {

    }

    /**
     * @param arguments Arg array from main method
     */
    public void parse(String[] arguments) throws EapMissingSubcommandException {
        // if no arguments were provided
        if (arguments.length == 0) {
            throw new EapMissingSubcommandException();
        }

        // iterate over the command containers
        for (CommandContainer commandContainer : commandContainerList) {
            commandContainer.
        }
    }
}
