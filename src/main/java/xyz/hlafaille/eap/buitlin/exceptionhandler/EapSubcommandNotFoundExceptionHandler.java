package xyz.hlafaille.eap.buitlin.exceptionhandler;

import xyz.hlafaille.eap.ExceptionHandler;
import xyz.hlafaille.eap.exception.EapMissingSubcommandException;
import xyz.hlafaille.eap.exception.EapSubcommandNotFoundException;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapSubcommandNotFoundException
 */
public class EapSubcommandNotFoundExceptionHandler extends ExceptionHandler<EapSubcommandNotFoundException> {
    public EapSubcommandNotFoundExceptionHandler() {
        super(EapSubcommandNotFoundException.class);
    }

    @Override
    public void execute(Exception exception) {
        System.out.println("HANDLED %s".formatted(exception.getClass().getName()));
    }
}
