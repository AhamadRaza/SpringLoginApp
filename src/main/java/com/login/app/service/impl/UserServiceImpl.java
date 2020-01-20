package com.login.app.service.impl;

import com.login.app.model.UserInfo;
import com.login.app.repository.UserRepository;
import com.login.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired private UserRepository userRepository;

    @Override
    public UserInfo findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }
}