package com.login.app.service;

import com.login.app.model.UserInfo;

public interface UserService {
   public UserInfo findByEmailAndPassword(String email, String password);
   public UserInfo save(UserInfo userInfo);
}