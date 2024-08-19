package io.kerosenelabs.arg.exception;

public class CommandNotFoundException extends Exception{
    public CommandNotFoundException(String command) {
        super("No commands or subcommands could be found with the name '%s'".formatted(command));
    }
}
