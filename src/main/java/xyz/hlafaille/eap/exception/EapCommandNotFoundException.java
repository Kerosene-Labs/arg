package xyz.hlafaille.eap.exception;

public class EapCommandNotFoundException extends Exception{
    public EapCommandNotFoundException(String command) {
        super("No commands or subcommands could be found with the name '%s'".formatted(command));
    }
}
