package com.customer.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.customer.bean.LoginUser;
import com.customer.mapper.LoginMapper;

/*
 * マッパーを起動し取得したデータをLoginUserインスタンスに格納する
 */
@Repository
public class LoginUserDao {

  @Autowired
  LoginMapper mapper;

  public LoginUser findUser(String userName) {
    return mapper.findUser(userName);
  }

}
