package xyz.hlafaille.eap.exception;

public class EapCommandModifierNotFoundException extends Exception{
    public EapCommandModifierNotFoundException(String userInput) {
        super("Command modifier not found: %s".formatted(userInput));
    }
}
