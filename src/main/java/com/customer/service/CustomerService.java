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

  // index
  public List<CustomerBean> selectIndex() {
    List<CustomerBean> customerList = customerMapper.selectIndexAll();
    return customerList;
  }

  // create
  public void insertNewCustomer(CustomerForm customerForm) {
    customerMapper.create(customerForm);
  }

  // detail
  public List<CustomerBean> findByNumber(Integer cust_no) {
    List<CustomerBean> customerList = customerMapper.selectByNumber(cust_no);
    return customerList;
  }

  // delete
  public void deleteByNumber(Integer cust_no) {
    customerMapper.delete(cust_no);
  }

  // search-word
  public List<CustomerBean> searchByKeyword(CustomerForm customerForm) {
    List<CustomerBean> searchList = customerMapper.selectByWord(customerForm);
    return searchList;
  }

  // search-number
  public List<CustomerBean> searchByKeynumber(CustomerForm customerForm) {
    List<CustomerBean> searchList = customerMapper.searchByNumber(customerForm);
    return searchList;
  }



}
