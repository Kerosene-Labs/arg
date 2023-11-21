package xyz.hlafaille.eap;

import lombok.Getter;

/**
 * Tells the Espresso Argument Parser how to deal with a specific exception
 */
abstract class ExceptionHandler <T extends Class<Exception>> {
    @Getter
    private T exceptionClass;

    public ExceptionHandler(T exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    public abstract void execute(Exception exception);
}
