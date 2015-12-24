package com.yanjiusuo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yanjiusuo.dao.UserDao;
import com.yanjiusuo.model.UserBean;
import com.yanjiusuo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean userLogin(String userName, String password) {
		UserBean user =userDao.findUserByLogin(userName);
    	if (null == user) { 
    		return false;
		}else if (password.equals(user.getUser_pass())) {
			return true;
		}else{
			return false;
		}
	}

}
