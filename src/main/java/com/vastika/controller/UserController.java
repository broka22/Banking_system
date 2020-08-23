package com.vastika.controller;

import com.vastika.model.User;
import com.vastika.service.UserService;
import com.vastika.service.UserServiceImpl;

import java.util.Scanner;

public class UserController {

    UserService userService = new UserServiceImpl();

    public void openAccount(Scanner input){
        User user = getUser(input);
        int saved = userService.openAccount(user);
        if (saved >= 1){
            System.out.println("Account has been created.");
        }else {
            System.out.println("Failed to create an account.");
        }
    }

    public void deposit(Scanner input){
        User user = new User();

        System.out.println("Enter your account number:");
        int id = input.nextInt();
        System.out.println("Enter the amount you would like to deposit:");
        int deposit = input.nextInt();
        user.setAccount_info_id(id);
        user.setDeposit(deposit);
        user.setBalance(deposit);

        int deposited = userService.deposit(user);
        if (deposited >= 1){
            System.out.println("Amount has been deposited.");
        }else {
            System.out.println("Failed to deposit the amount.");
        }
    }

    public void checkBalance(Scanner input){
        System.out.println("Please enter the account name to view your account:");
        //int id = input.nextInt();
        String name = input.next();
        User user = userService.checkBalance(name);
        //System.out.println("Account name is: " +user.getAccount_name());
        System.out.println("Your account name is: "+user.getAccount_name());
    }

    private User getUser(Scanner input){
        User user = new User();

        System.out.println("Please enter your name:");
        String account_name = input.next();
        System.out.println("Enter your address:");
        String address = input.next();
        System.out.println("Enter your social number:");
        int ssn = input.nextInt();
        System.out.println("Enter your mobile no:");
        long mobile_no = input.nextLong();


        user.setAccount_name(account_name);
        user.setAddress(address);
        user.setSsn(ssn);
        user.setMobile_no(mobile_no);

        return user;
    }
}
