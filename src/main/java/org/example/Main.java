package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Validating first name
        String firstNameRegex = "^[A-Z]{1,1}[a-z]{2,}$";

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

        // Validating email
        String emailRegex = "^[a-zA-Z0-9.$&%_+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+$";

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        while (!email.matches(emailRegex)) {
            System.out.println("Invalid email. Please enter a valid email.");
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
        }

        System.out.println("Valid first name: " + firstName);
        System.out.println("Valid last name: " + lastName);
        System.out.println("Valid email: " + email);

        scanner.close();
    }
}
