package io.kerosenelabs.arg.exception;

public class CommandModifierNotFoundException extends Exception{
    public CommandModifierNotFoundException(String userInput) {
        super("Command modifier not found: %s".formatted(userInput));
    }
}
