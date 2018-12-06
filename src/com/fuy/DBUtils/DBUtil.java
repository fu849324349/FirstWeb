package com.fuy.DBUtils;

import java.sql.*;

/**
 * 工具类
 */
public class DBUtil {

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
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "989926");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //判断用户名和密码是否存在
    public boolean isExists(String user_id,String user_name)
    {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from signin where user_id = ?and user_name = ?");
            preparedStatement.setString(1,user_id);
            preparedStatement.setString(2,user_name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                return  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //关闭资源
    public static void closeResource(Connection connection,Statement statement,ResultSet rs)
    {
        if (null != rs)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ( null != statement)
        {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != connection)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
