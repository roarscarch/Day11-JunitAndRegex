package org.example.Exceptions;



public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("Email is invalid");
    }
}
