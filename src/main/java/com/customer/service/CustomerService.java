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

  // index
  public List<CustomerBean> selectIndex() {
    List<CustomerBean> customerList = customerMapper.selectIndexAll();
    return customerList;
  }

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
  // create
>>>>>>> create
  public void insertNewCustomer(CustomerForm customerForm) {
    customerMapper.create(customerForm);
  }

  // detail
  public List<CustomerBean> findByNumber(Integer cust_no) {
    List<CustomerBean> customerList = customerMapper.selectByNumber(cust_no);
    return customerList;
  }



>>>>>>> create
}
