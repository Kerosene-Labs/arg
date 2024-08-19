package io.kerosenelabs.arg.exception;

/**
 * Represents a scenario in which the user provides a command modifier that was not expected or malformed
 */
public class MalformedCommandModifierException extends Exception {
    public MalformedCommandModifierException(String userInput) {
        super("Malformed command modifier, user provided input was: %s".formatted(userInput));
    }
}
