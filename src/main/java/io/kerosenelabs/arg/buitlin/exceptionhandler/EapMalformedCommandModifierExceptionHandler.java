package io.kerosenelabs.arg.buitlin.exceptionhandler;

import io.kerosenelabs.arg.ExceptionHandler;
import io.kerosenelabs.arg.exception.MalformedCommandModifierException;
import io.kerosenelabs.arg.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapMalformedCommandModifierException
 */
public class EapMalformedCommandModifierExceptionHandler extends ExceptionHandler<MalformedCommandModifierException> {
    public EapMalformedCommandModifierExceptionHandler() {
        super(MalformedCommandModifierException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}
