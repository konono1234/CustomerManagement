package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<CustomerBean> selectIndex(){
		List<CustomerBean> customerList = customerMapper.selectIndexAll();
		return customerList;
	}

}
