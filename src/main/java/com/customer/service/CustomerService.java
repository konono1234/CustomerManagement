package com.customer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.bean.CustomerBean;
import com.customer.controller.CustomerForm;
import com.customer.mapper.CustomerMapper;

/*
 * Mapperクラスを起動するサービスクラスです。 取り出したデータをCustomerBeanクラスに格納します
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

  public void insertNewCustomer(CustomerForm customerForm) {
    customerMapper.create(customerForm);
  }



}
