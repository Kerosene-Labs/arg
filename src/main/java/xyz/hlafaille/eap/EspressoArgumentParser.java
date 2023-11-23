package xyz.hlafaille.eap;

import lombok.Getter;
import xyz.hlafaille.eap.buitlin.exceptionhandler.*;
import xyz.hlafaille.eap.exception.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    private final List<ExceptionHandler> exceptionHandlerList = new ArrayList<>();
    private final List<Command> commandList = new ArrayList<>();
    private final List<CommandContainer> commandContainerList = new ArrayList<>();

    /**
     * Constructor
     *
     * @param applicationName        The name of your EAP application
     * @param applicationDescription A short description of your EAP application
     */
    public EspressoArgumentParser(String applicationName, String applicationDescription) {
        if (instance != null) {
            throw new RuntimeException("An EspressoArgumentParser has already been instantiated (application name=\"%s\")".formatted(applicationName));
        }
        this.applicationName = applicationName;
        this.applicationDescription = applicationDescription;
        instance = this;

        addExceptionHandler(new EapCommandModifierNotFoundExceptionHandler());
        addExceptionHandler(new EapCommandNotFoundExceptionHandler());
        addExceptionHandler(new EapCommandNotSpecifiedExceptionHandler());
        addExceptionHandler(new EapDuplicateCommandContainerExceptionHandler());
        addExceptionHandler(new EapMalformedCommandModifierExceptionHandler());
        addExceptionHandler(new EapMissingSubcommandExceptionHandler());
        addExceptionHandler(new EapSubcommandNotFoundExceptionHandler());
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
    public void addCommandContainer(CommandContainer commandContainer) throws EapDuplicateCommandContainerException {
        for (CommandContainer iterCommandContainer : commandContainerList) {
            if (iterCommandContainer.getName().equals(commandContainer.getName())) {
                throw new EapDuplicateCommandContainerException();
            }
        }
        commandContainerList.add(commandContainer);
    }

    /**
     * Add a Command
     *
     * @param command Command instance
     */
    public void addCommand(Command command) throws EapDuplicateCommandException {
        for (Command iterCommand : commandList) {
            if (iterCommand.getName().equals(command.getName())) {
                throw new EapDuplicateCommandException();
            }
        }
        commandList.add(command);
    }

    /**
     * Intended to be called recursively, parseInCommandContainer will work its way down the args until it discovers a
     * valid Command under a CommandContainer. If a Command was found, it will call .execute() on the Command.
     *
     * @param commandContainer Command Container to search under
     */
    private void parseInCommandContainer(CommandContainer commandContainer, String[] remainingArgs) throws EapCommandNotFoundException, EapMalformedCommandModifierException, EapCommandModifierNotFoundException, EapCommandNotSpecifiedException {
        // check if the user specified a command after their subcommand
        if (remainingArgs.length == 0) {
            throw new EapCommandNotSpecifiedException(commandContainer.getName());
        }

        // separate out our next-in-line command
        String commandName = remainingArgs[0];

        // iterate over any commands, find a match
        for (Command command : commandContainer.getCommands()) {
            if (command.getName().equals(commandName)) {
                command.preExecute(Arrays.copyOfRange(remainingArgs, 1, remainingArgs.length), commandList, null);
                return;
            }
        }

        // if we didn't return out, iterate over command containers and find a match
        for (CommandContainer innerCommandContainer : commandContainer.getChildCommandContainers()) {
            if (innerCommandContainer.getName().equals(commandName)) {
                parseInCommandContainer(innerCommandContainer, Arrays.copyOfRange(remainingArgs, 1, remainingArgs.length));
                return;
            }
        }
        throw new EapCommandNotFoundException(commandName);
    }

    /**
     * Add an exception handler
     */
    public void addExceptionHandler(ExceptionHandler exceptionHandler) {
        exceptionHandlerList.add(exceptionHandler);
    }

    /**
     * Parse arguments, working our way down the chain until we eventually execute a command
     *
     * @param arguments Arg array from main method
     */
    public void parse(String[] arguments) throws EapMissingSubcommandException, EapCommandNotFoundException, EapMalformedCommandModifierException, EapSubcommandNotFoundException, EapCommandModifierNotFoundException, EapCommandNotSpecifiedException {
        try {
            // if no arguments were provided
            if (arguments.length == 0) {
                throw new EapMissingSubcommandException();
            }

            // establish the name of a command container to parse through (should be first argument in the chain)
            String baseCommandContainerName = arguments[0];

            // iterate over the top level commands, check if we have any that match
            for (Command command : commandList) {
                if (command.getName().equals(baseCommandContainerName)) {
                    command.preExecute(Arrays.copyOfRange(arguments, 1, arguments.length), commandList, commandContainerList);
                    return;
                }
            }

            // iterate over the command containers
            Boolean commandContainerFound = false;
            for (CommandContainer commandContainer : commandContainerList) {
                if (commandContainer.getName().equals(baseCommandContainerName)) {
                    parseInCommandContainer(commandContainer, Arrays.copyOfRange(arguments, 1, arguments.length));
                    commandContainerFound = true;
                }
            }

            // if a command container could not be found
            if (!commandContainerFound) {
                throw new EapSubcommandNotFoundException(baseCommandContainerName);
            }

        } catch (Exception e) {
            // iterate over exception handlers, find a match
            for (ExceptionHandler exceptionHandler : exceptionHandlerList) {
                if (exceptionHandler.doesExceptionMatch(e)) {
                    exceptionHandler.execute(e);
                    return;
                }
            }
            throw e;
        }
    }
}
