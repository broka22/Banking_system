package com.vastika.dao;

import com.mysql.cj.protocol.Resultset;
import com.vastika.model.User;
import com.vastika.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    public static final String INSERT_SQL = "insert into account_info_tbl(account_name, address, mobile_no, ssn) values(?,?,?,?)";
    public static final String DEPOSIT_SQL = "insert into account_balance_tbl(deposit, balance, account_info_id) values(?,?,?)";
    public static final String GET_USER_BY_ID = "select * from account_info_tbl where account_info_id = ?";

    @Override
    public int openAccount(User user) {
        int saved = 0;
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_SQL);) {

            ps.setString(1, user.getAccount_name());
            ps.setString(2, user.getAddress());
            ps.setLong(3, user.getMobile_no());
            ps.setInt(4, user.getSsn());
            saved = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return saved;
    }

    @Override
    public int deposit(User user) {
        int deposit = 0;
        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(DEPOSIT_SQL);) {

            ps.setInt(1, user.getDeposit());
            ps.setInt(2, user.getBalance());
            ps.setInt(3, user.getAccount_info_id());

            deposit = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return deposit;
    }

    @Override
    public int withdraw() {
        return 0;
    }

    @Override
    public User checkBalance(String name) {
        User user = new User();

        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(GET_USER_BY_ID);) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setAccount_name(rs.getString("account_name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}