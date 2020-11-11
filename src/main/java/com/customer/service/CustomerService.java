package com.customer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.bean.CustomerBean;
import com.customer.bean.UserBean;
import com.customer.mapper.CustomerMapper;

/*
 * Mapperクラスを起動するサービスクラスです。
 * 
 * 
 */

@Service

public class CustomerService {

  @Autowired
  CustomerMapper customerMapper;

  public List<CustomerBean> selectIndex() {
    List<CustomerBean> customerList = customerMapper.selectIndexAll();
    return customerList;
  }

  public List<UserBean> selectUserInfo() {
    List<UserBean> userList = customerMapper.selectUserPassword();
    return userList;
  }

}
