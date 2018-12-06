package com.fuy.dao;

import com.fuy.entity.User;

/**
 * 用户接口
 */
public interface UserDao {

    //判断用户是否存在
    boolean isExists(User user);

}
