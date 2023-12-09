package org.example;

import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTest{


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
            "abc+100@gmail.com"
    })
    public void testEmails(String email) {
        String emailRegex = "^[a-zA-Z0-9.$&%_+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        assertTrue(matcher.matches());
    }

    @ParameterizedTest
    @ValueSource(strings = { "Anu", "An", "aNu", "Anurag", "anurag" })// anu fail, Anu pass, aNu fail , anurag fail, an fail
    public void testFirstName(String name) {
        String nameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        assertTrue(matcher.matches());
    }
    // if this passes last name will also pass
    @ParameterizedTest

    @ValueSource(strings = {
             "Password",
             "123@Pass",
             "passWord",
             "pamela ^^^^^",
              "meow@Passs",
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
            "91 9262509652",
            "abcdedfcg",
            "+91 78767676777777",
            "+98 767367363err"
    })


    public void checkPhone(String phone) {
        String phoneRegex = "^[0-9]{1,4} [0-9]{5,15}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        assertTrue(matcher.matches());

    }

}