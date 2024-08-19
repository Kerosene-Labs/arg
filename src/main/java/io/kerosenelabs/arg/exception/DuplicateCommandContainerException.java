package io.kerosenelabs.arg.exception;

public class DuplicateCommandContainerException extends Exception{
    public DuplicateCommandContainerException() {
        super("Duplicates under command containers are not allowed");
    }
}
