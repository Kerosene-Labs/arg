package io.kerosenelabs.arg.exception;

public class DuplicateCommandException extends Exception{
    public DuplicateCommandException() {
        super("Duplicate commands are not allowed");
    }
}
