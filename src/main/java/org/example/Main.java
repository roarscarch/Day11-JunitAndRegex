package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ^? what is this and what is $?
        String firstNameRegex = "^[A-Z][a-z]{2,}$";

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        while (!firstName.matches(firstNameRegex)) {
            System.out.println("Invalid first name. Please enter a valid first name.");
            System.out.print("Enter your first name: ");
            firstName = scanner.nextLine();
        }

        // Valid Last Name
        System.out.print("Enter your Last name: ");
        String lastName = scanner.nextLine();
        String lastNameRegex = "^[A-Z][a-z]{2,}$";

        while (!lastName.matches(lastNameRegex)) {
            System.out.println("Invalid Last name. Please enter a valid last name.");
            System.out.print("Enter your Last name: ");
            lastName = scanner.nextLine();
        }
        System.out.println("Valid first name: " + firstName);
        System.out.println("Valid Last name: " + lastName);

        scanner.close();
    }
}
