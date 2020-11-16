package com.customer.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.customer.bean.LoginUser;
import com.customer.mapper.LoginMapper;

@Repository
public class LoginUserDao {

  @Autowired
  LoginMapper mapper;

  public LoginUser findUser(String userName) {
    return mapper.findUser(userName);
  }

}
