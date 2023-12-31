/*
Learnt about regex
Pattern class
Matcher class
Pattern.compile
Matcher.matches
 */

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Validating first name
        String firstNameRegex = "^[A-Z]{1,1}[a-z]{2,}$";// One Captial rest small  min 3 letters

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        while (!firstName.matches(firstNameRegex)) {
            System.out.println("Invalid first name. Please enter a valid first name.");
            System.out.print("Enter your first name: ");
            firstName = scanner.nextLine();
        }

        // Validating last name
        String lastNameRegex = "^[A-Z]{1,1}[a-z]{2,}$";

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        while (!lastName.matches(lastNameRegex)) {
            System.out.println("Invalid last name. Please enter a valid last name.");
            System.out.print("Enter your last name: ");
            lastName = scanner.nextLine();
        }

        // Validating email : Passes all cases
        String emailRegex = "^[a-zA-Z0-9.$&%_+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+$";

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        while (!email.matches(emailRegex)) {
            System.out.println("Invalid email. Please enter a valid email.");
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
        }

        String phoneRegex = "^[0-9]{1,4} [0-9]{5,15}$";
        System.out.print("\nEnter phone number: ");
        String phone = scanner.nextLine();

        while (!phone.matches(phoneRegex)) {
            System.out.println("Please enter a valid response.");
            System.out.print("\nEnter phone number: ");
            phone = scanner.nextLine();
        }

// Password min 8 chars and Uppercase and One numeric and one special char

        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$";
        System.out.print("\nEnter password: ");
        String password = scanner.nextLine();
        while (!password.matches(passwordRegex)) {
            System.out.println("Please enter a valid response.");
            System.out.print("\nEnter password: ");
            password = scanner.nextLine();
        }
        scanner.close();
    }
}
