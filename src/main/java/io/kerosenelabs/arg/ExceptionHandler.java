package io.kerosenelabs.arg;

/**
 * Tells the Argument Parser how to deal with a specific exception
 */
public abstract class ExceptionHandler<T extends Exception> {
    private final Class<T> exceptionClass;

    public ExceptionHandler(Class<T> exceptionClass) {
        this.exceptionClass = exceptionClass;
    }
    public Boolean doesExceptionMatch(Exception exception) {
        if (exceptionClass.equals(exception.getClass())) {
            return true;
        }
        return false;
    }

    public abstract void execute(Exception exception);
}
