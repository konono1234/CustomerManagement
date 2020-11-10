package com.customer.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.bean.CustomerBean;
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
	
	public ArrayList<CustomerBean> selectIndex(){
		ArrayList<CustomerBean> customerList = customerMapper.selectIndexAll();
		return customerList;
	}

}
