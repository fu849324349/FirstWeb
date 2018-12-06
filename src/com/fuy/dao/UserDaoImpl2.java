package com.fuy.dao;


import com.fuy.DBUtils.DBUtil;
import com.fuy.entity.User;

import java.sql.*;

public class UserDaoImpl2 implements UserDao {

    //判断用户名是否存在
    @Override
    public boolean isExists(User user) {
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User where User_name=?and User_psw=?");
            preparedStatement.setString(1,user.getUser_name());
            preparedStatement.setString(2,user.getUser_psw());
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
