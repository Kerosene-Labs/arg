package xyz.hlafaille.eap.exception;

public class EapMissingSubcommandException extends Exception{
    public EapMissingSubcommandException() {
        super("Please provide a subcommand");
    }
}
