package com.customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String init(Model model) {
		
		List<CustomerBean> list = customerService.selectIndex();
		model.addAttribute("list", list);
		
		return "customer/index";
	}
}
