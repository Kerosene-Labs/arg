package xyz.hlafaille.eap.exception;

public class EapSubcommandNotFoundException extends Exception{
    public EapSubcommandNotFoundException(String command) {
        super("No subcommand could be found with the name '%s'".formatted(command));
    }
}
