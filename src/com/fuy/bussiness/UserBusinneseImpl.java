package com.fuy.bussiness;

import com.fuy.dao.ShopDao;
import com.fuy.dao.ShopDaoImpl;
import com.fuy.dao.UserDao;
import com.fuy.dao.UserDaoImpl;
import com.fuy.entity.Shop;
import com.fuy.entity.User;

public class UserBusinneseImpl implements UserBusinese {

    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean userIsExist(User user)
    {
        return userDao.isExists(user);
    }


}
