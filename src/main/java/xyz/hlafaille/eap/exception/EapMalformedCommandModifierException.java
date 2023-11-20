package xyz.hlafaille.eap.exception;

/**
 * Represents a scenario in which the user provides a command modifier that was not expected or malformed
 */
public class EapMalformedCommandModifierException extends Exception {
    public EapMalformedCommandModifierException(String userInput) {
        super("Malformed command modifier, user provided input was: %s".formatted(userInput));
    }
}
