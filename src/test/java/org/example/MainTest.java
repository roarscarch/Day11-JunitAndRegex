package org.example;

import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.Exceptions.InvalidEmailException;
import org.example.Exceptions.InvalidPhoneNumberException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import org.example.Validator;
import org.example.Exceptions.InvalidEmailException;
import org.example.Exceptions.InvalidFirstNameException;
import org.example.Exceptions.InvalidPasswordException;
import org.example.Exceptions.InvalidPhoneNumberException;
public class MainTest {

    // Custom exception for invalid email
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
            Validator.validateEmail(email);
        } catch (org.example.Exceptions.InvalidEmailException exception) {
            fail("Expected InvalidEmailException");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "Anur", "Dubey", "Ragnu", "Anurag", "Mnurag" })
    public void testFirstName(String name) {
        String nameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        assertTrue(matcher.matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123@Pass",
            "Or456@345"
    })
    public void testPassword(String password) {

        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        assertTrue(matcher.matches());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123456",
            "+12 345678898",

            "abcdedfcg",
            "+91 78767676777777",
            "+98 767367363err"
    })
    public void checkPhoneSad(String phone) {
        try {
            Validator.validatePhoneNumber(phone);
            fail("Expected InvalidPhoneNumberException");
        } catch (org.example.Exceptions.InvalidPhoneNumberException exception) {
            assertEquals("Phone number is invalid", exception.getMessage());
        }
    }


}
