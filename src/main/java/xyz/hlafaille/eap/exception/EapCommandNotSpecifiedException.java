package xyz.hlafaille.eap.exception;

/**
 * Represents a scenario in which a user types the name of a command container, but not a command under that.
 * For example, calling `espresso project` will throw this exception
 */
public class EapCommandNotSpecifiedException extends Exception {
    public EapCommandNotSpecifiedException(String userInput) {
        super("A command must be specified when calling '%s'".formatted(userInput));
    }
}
