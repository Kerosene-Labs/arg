package io.kerosenelabs.arg.exception;

public class EapMissingSubcommandException extends Exception{
    public EapMissingSubcommandException() {
        super("Please provide a subcommand");
    }
}
