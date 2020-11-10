package com.customer.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.customer.bean.CustomerBean;
import com.customer.service.CustomerService;


/*
 * Beanにデータを受け渡したりServiceを起動するコントローラークラスです
 * 
 */

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	/*
	 * 「/customer」を拾ってlistにデータを格納してcustomerフォルダのindex.htmlに飛ばす
	 * 2020/11/10　格納の際にエラー発生中
	 * 
	 */
	@RequestMapping(value = "/customer")
	public ModelAndView init(ModelAndView modelAndView) {
		
		
		ArrayList<CustomerBean> list = customerService.selectIndex();
		modelAndView.addObject("list",list);
		modelAndView.setViewName("customer/index");
		return modelAndView;
	}
}
