package LabWork;

import java.util.concurrent.ExecutionException;

public class InvalidCatalogException extends Exception{
    public InvalidCatalogException(Exception exception) {
        super("Invalid catalog file.",exception);
    }
}
