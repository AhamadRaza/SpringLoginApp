package com.login.app.repository;

import com.login.app.model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo,Long>{
    @Query(value = "select u from  UserInfo as u where u.email=?1 and u.password=?2")
    UserInfo findByEmailAndPassword(String username, String password);
}