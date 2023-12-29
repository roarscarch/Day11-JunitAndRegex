package org.example.Exceptions;


public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException() {
        super("Phone number is invalid");
    }
}
