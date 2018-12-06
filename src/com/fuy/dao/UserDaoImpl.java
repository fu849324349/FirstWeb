package com.fuy.dao;

import com.fuy.entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao{
    static
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //拿到连接
    public static Connection getConnection()
    {
        Connection connection =null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "989926");
            return  connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return connection;
    }

    //判断用户是否存在
    @Override
    public boolean isExists(User user) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from signaIn where User_name = ?and User_telPhone = ?");
            preparedStatement.setString(1,user.getUser_name());
            preparedStatement.setString(2,user.getUser_telPhone());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet != null)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
