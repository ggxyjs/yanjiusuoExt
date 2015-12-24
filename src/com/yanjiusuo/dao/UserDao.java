package com.yanjiusuo.dao;

import org.springframework.dao.DataAccessException;

import com.yanjiusuo.model.UserBean;

public interface UserDao 
{
	
    /**
     * 列出某个用户名的所有用户信息
     * @param account
     * @return
     * @throws DataAccessException
     */
    public UserBean findUserByLogin(String Login) throws DataAccessException;
}

