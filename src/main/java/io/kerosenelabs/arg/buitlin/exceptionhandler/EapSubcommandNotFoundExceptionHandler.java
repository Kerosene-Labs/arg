package io.kerosenelabs.arg.buitlin.exceptionhandler;

import io.kerosenelabs.arg.ExceptionHandler;
import io.kerosenelabs.arg.exception.EapSubcommandNotFoundException;
import io.kerosenelabs.arg.util.ColorLogger;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapSubcommandNotFoundException
 */
public class EapSubcommandNotFoundExceptionHandler extends ExceptionHandler<EapSubcommandNotFoundException> {
    public EapSubcommandNotFoundExceptionHandler() {
        super(EapSubcommandNotFoundException.class);
    }

    @Override
    public void execute(Exception exception) {
        ColorLogger.severe(exception.getMessage());
    }
}
