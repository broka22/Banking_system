package com.vastika.main;

import com.vastika.controller.UserController;

import java.util.Scanner;

public class UserTest
{
    public static void main( String[] args ) {
        UserController controller = new UserController();
        Scanner input = new Scanner(System.in);

        String decision = "";

        do {
            System.out.println("Welcome to the Banking Management System!\nWhat would you like to do today?\n1. Open Account\n2. Deposit\n3. Withdraw\n4. Check Balance");
            String choice = input.next();

            switch (choice) {
                case "1":
                    controller.openAccount(input);
                    break;
                case "2":
                    controller.deposit(input);
                    break;
                case "3":
                    controller.openAccount(input);
                    break;
                case "4":
                    controller.checkBalance(input);
                    break;
                default:
                    System.out.println("Wrong option.");
                    break;
            }
            System.out.println("Would you like to continue? ");
            decision = input.next();
        } while (decision.equalsIgnoreCase("yes"));
        System.out.println("Thank you! See you again!");
    }
}
