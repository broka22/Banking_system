package com.vastika.service;

import com.vastika.dao.UserDao;
import com.vastika.dao.UserDaoImpl;
import com.vastika.model.User;

public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDaoImpl();

    @Override
    public int openAccount(User user) {
        return userDao.openAccount(user);
    }

    @Override
    public int deposit(User user) {
        return userDao.deposit(user);
    }

    @Override
    public int withdraw() {
        return 0;
    }

    @Override
    public User checkBalance(String name) {
        return userDao.checkBalance(name);
    }
}
