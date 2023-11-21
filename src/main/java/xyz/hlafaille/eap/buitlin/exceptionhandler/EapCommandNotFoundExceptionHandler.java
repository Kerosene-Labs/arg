package xyz.hlafaille.eap.buitlin.exceptionhandler;

import xyz.hlafaille.eap.ExceptionHandler;
import xyz.hlafaille.eap.exception.EapCommandNotFoundException;
import xyz.hlafaille.eap.exception.EapCommandNotSpecifiedException;

/**
 * Built in exception handler for: xyz.hlafaille.eap.exception.EapCommandNotFoundExceptionHandler
 */
public class EapCommandNotFoundExceptionHandler extends ExceptionHandler<EapCommandNotFoundException> {
    public EapCommandNotFoundExceptionHandler() {
        super(EapCommandNotFoundException.class);
    }

    @Override
    public void execute(Exception exception) {
        System.out.println("HANDLED %s".formatted(exception.getClass().getName()));
    }
}
