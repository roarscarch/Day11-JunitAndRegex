package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ^? what is this and what is $?
        String firstNameRegex = "^[A-Z]{1,1}[a-z]{2,}$";

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        while (!firstName.matches(firstNameRegex)) {
            System.out.println("Invalid first name. Please enter a valid first name.");
            System.out.print("Enter your first name: ");
            firstName = scanner.nextLine();
        }

        System.out.println("Valid first name: " + firstName);

        scanner.close();
    }
}