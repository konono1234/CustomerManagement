package com.customer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customer.bean.CustomerBean;
<<<<<<< HEAD
<<<<<<< HEAD
import com.customer.mapper.CustomerMapper;

/*
 * Mapperクラスを起動するサービスクラスです。
 *
 *
=======
import com.customer.controller.CustomerForm;
=======
import com.customer.bean.CustomerForm;
>>>>>>> sort
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
=======
  // sort
  public List<CustomerBean> sortIndex(CustomerForm customerForm) {
    List<CustomerBean> customerList = customerMapper.sortIndexAll(customerForm);
    return customerList;
  }

>>>>>>> sort
  // create
>>>>>>> edit
=======
=======
=======
  // create
>>>>>>> create
>>>>>>> detail
  public void insertNewCustomer(CustomerForm customerForm) {
    customerMapper.insertInto(customerForm);
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
  /*
   * public List<CustomerBean> searchByKeyword(CustomerForm customerForm) { List<CustomerBean>
   * searchList = customerMapper.selectByWord(customerForm); return searchList; }
   * 
   * // search-number
   * 
   * public List<CustomerBean> searchByKeynumber(CustomerForm customerForm) { List<CustomerBean>
   * searchList = customerMapper.searchByNumber(customerForm); return searchList; }
   */
  // 検索機能は1つに統合しました
  public List<CustomerBean> searchByKeyword(CustomerForm customerForm) {
    List<CustomerBean> searchList = customerMapper.searchByWord(customerForm);
    return searchList;
  }

  // update
  public void updateByNumber(CustomerForm customerForm) {
    customerMapper.update(customerForm);
  }

  // createCustomerForm
  public CustomerForm customerFormByNumber(Integer cust_no) {

    return customerMapper.customerFormCreate(cust_no);
  }



>>>>>>> create
}
