package com.yanjiusuo.service;

public interface UserService
{
    
    /**
     * 检查用户名与密码是否匹配
     * @param userName
     * @param password
     * @return
     */
    public boolean userLogin(String userName, String password);
}
