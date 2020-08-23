package com.vastika.dao;

import com.vastika.model.User;

public interface UserDao {

    int openAccount(User user);

    int deposit(User user);

    int withdraw();

    User checkBalance(String name);
}
