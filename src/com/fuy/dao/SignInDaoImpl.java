package com.fuy.dao;

import com.fuy.DBUtils.DBUtil;
import com.fuy.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignInDaoImpl implements SignInDao1{

    public boolean addOneUser(User users)
    {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement("insert  into signin (User_id,User_name,User_psw,User_email,User_telPhone,User_regDate)value (?,?,?,?,?,?)");
            preparedStatement.setInt(1,users.getUser_id());
            preparedStatement.setString(2,users.getUser_name());
            preparedStatement.setString(3,users.getUser_psw());
            preparedStatement.setString(4,users.getUser_email());
            preparedStatement.setString(5,users.getUser_telPhone());
            preparedStatement.setString(6,users.getUser_regDate());
            int rs = preparedStatement.executeUpdate();
            if (rs != 0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeResource(connection,preparedStatement,null);
        }
        return false;
    }
}
