package com.vastika.service;

import com.vastika.model.User;

public interface UserService {

    int openAccount(User user);

    int deposit(User user);

    int withdraw();

    User checkBalance(String name);
}
