package com.customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
=======
>>>>>>> create
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.customer.bean.CustomerBean;
import com.customer.service.CustomerService;

<<<<<<< HEAD
@Controller
=======
// 現状機能していない

>>>>>>> create
public class AdminCustomerController {
  // final static Logger logger = LoggerFactory.getLogger(AdminCustomerController.class);

  @Autowired
  CustomerService customerService;

  @Autowired
  MessageSource msg;

  @RequestMapping(value = "/admin/customer", method = RequestMethod.GET)
  public String index(Model model) {
    List<CustomerBean> list = customerService.selectIndex();

    /*
     * if(CollectionUtils.isEmpty(list)) { String message = msg.getMessage("customer.list.empty",
     * null, Locale.JAPANESE); model.addAttribute("emptyMessage", message); }
     */
    model.addAttribute("list", list);

    return "admin/customer/index";
  }

}
