package org.example;

import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTest {

    // Custom exception for invalid email
    public static class InvalidEmailException extends RuntimeException {
        public InvalidEmailException(String message) {
            super(message);
        }
    }

    // Custom exception for invalid first name
    public static class InvalidFirstNameException extends RuntimeException {
        public InvalidFirstNameException(String message) {
            super(message);
        }
    }

    // Custom exception for invalid password
    public static class InvalidPasswordException extends RuntimeException {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }

    // Custom exception for invalid phone number
    public static class InvalidPhoneNumberException extends RuntimeException {
        public InvalidPhoneNumberException(String message) {
            super(message);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc-100@yahoo.com",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc-100@abc.net",
            "abc.100@abc.com.au",
            "abc@1.com",
            "abc@gmail.com.com",
            "abc+100@gmail.com",
            "abc",
            "abc@.com.my",
            "abc123@gmail.a",
            "abc123@.com",
            "abc123@.com.com",
            ".abc@abc.com",
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com",
            "abc.@gmail.com",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au"
    })
    public void testEmails(String email) {
        try {
            validateEmail(email);
        } catch (InvalidEmailException exception) {
            fail("Expected InvalidEmailException");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "Anurag", "Kumar", "Dubey" })
    public void testFirstName(String name) {
        try {
            validateFirstName(name);
        } catch (InvalidFirstNameException exception) {
            fail("Expected InvalidFirstNameException");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {

            "123@Pass",
            "Or456@345"
    })
    public void testPassword(String password) {
        try {
            validatePassword(password);
        } catch (InvalidPasswordException exception) {
            fail("Expected InvalidPasswordException");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {

            "12 345678898",
            "91 9262509652"
    })
    public void checkPhone(String phone) {
        try {
            validatePhoneNumber(phone);
        } catch (InvalidPhoneNumberException exception) {
            fail("Expected InvalidPhoneNumberException");
        }
    }

    private void validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9.$&%_+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidEmailException("Email is invalid");
        }
    }

    private void validateFirstName(String name) {
        String nameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new InvalidFirstNameException("First name is invalid");
        }
    }

    private void validatePassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidPasswordException("Password is invalid");
        }
    }

    private void validatePhoneNumber(String phone) {
        String phoneRegex = "^[0-9]{1,4} [0-9]{5,15}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches()) {
            throw new InvalidPhoneNumberException("Phone number is invalid");
        }
    }
}
