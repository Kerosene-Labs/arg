package xyz.hlafaille.eap.buitlin.exceptionhandler;

import xyz.hlafaille.eap.ExceptionHandler;
import xyz.hlafaille.eap.exception.EapDuplicateCommandContainerException;
import xyz.hlafaille.eap.exception.EapMalformedCommandModifierException;
import xyz.hlafaille.eap.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapMalformedCommandModifierException
 */
public class EapMalformedCommandModifierExceptionHandler extends ExceptionHandler<EapMalformedCommandModifierException> {
    public EapMalformedCommandModifierExceptionHandler() {
        super(EapMalformedCommandModifierException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}
