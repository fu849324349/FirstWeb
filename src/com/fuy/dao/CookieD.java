package com.fuy.dao;

import java.sql.*;

public class CookieD {
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
    //判断用户名是否登录
    public  boolean isHave(String username,String password)
    {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where User_Name= ?and User_psw = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
