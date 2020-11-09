package com.customer.service;

import java.util.List;
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
	private CustomerMapper customerMapper;
	
	public List<CustomerBean> selectIndex(){
		return customerMapper.selectIndexAll();
	}

}
