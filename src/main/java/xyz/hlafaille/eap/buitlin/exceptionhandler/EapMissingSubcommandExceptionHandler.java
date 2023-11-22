package xyz.hlafaille.eap.buitlin.exceptionhandler;

import xyz.hlafaille.eap.ExceptionHandler;
import xyz.hlafaille.eap.exception.EapMalformedCommandModifierException;
import xyz.hlafaille.eap.exception.EapMissingSubcommandException;
import xyz.hlafaille.eap.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapMissingSubcommandException
 */
public class EapMissingSubcommandExceptionHandler extends ExceptionHandler<EapMissingSubcommandException> {
    public EapMissingSubcommandExceptionHandler() {
        super(EapMissingSubcommandException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}
