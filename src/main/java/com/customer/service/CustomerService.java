package com.customer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.bean.CustomerBean;
<<<<<<< HEAD
import com.customer.mapper.CustomerMapper;

/*
 * Mapperクラスを起動するサービスクラスです。
 *
 *
=======
import com.customer.controller.CustomerForm;
import com.customer.mapper.CustomerMapper;

/*
 * Mapperクラスを起動するサービスクラスです。 取り出したデータをCustomerBeanクラスに格納します
 * 
>>>>>>> create
 */

@Service

public class CustomerService {

  @Autowired
  CustomerMapper customerMapper;

  public List<CustomerBean> selectIndex() {
    List<CustomerBean> customerList = customerMapper.selectIndexAll();
    return customerList;
  }

<<<<<<< HEAD
=======
  public void insertNewCustomer(CustomerForm customerForm) {
    customerMapper.create(customerForm);
  }



>>>>>>> create
}
