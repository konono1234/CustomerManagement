package com.customer.controller;

<<<<<<< HEAD

=======
>>>>>>> create
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.ModelAttribute;
>>>>>>> create
import org.springframework.web.bind.annotation.RequestMapping;
import com.customer.bean.CustomerBean;
import com.customer.service.CustomerService;


/*
 * Beanにデータを受け渡したりServiceを起動するコントローラークラスです
<<<<<<< HEAD
 *
=======
 * 
>>>>>>> create
 */

@Controller
public class CustomerController {
  @ModelAttribute
  CustomerForm setUpform() {
    return new CustomerForm();
  }

  @Autowired
  CustomerService customerService;

  /*
   * 「/customer」を拾ってlistにデータを格納してcustomerフォルダのindex.htmlに飛ばす
   * 
   */


  @RequestMapping(value = "/customer")
  public String initIndex(Model model) {

    List<CustomerBean> list = customerService.selectIndex();
    model.addAttribute("list", list);

    return "customer/index";
  }

  /*
   * create.htmlにFormで入力されたデータを格納するインスタンスを渡す
   */
  @RequestMapping(value = "/customer/create")
  public String create(@ModelAttribute("customerForm") CustomerForm customerForm) {
    return "customer/create";
  }

  /*
   * create.htmlでデータが格納されたインスタンスを表示用に渡します
   */
  @RequestMapping(value = "/customer/save")
  public String saveForm(CustomerForm customerForm) {
    customerService.insertNewCustomer(customerForm);
    return "customer/save";
  }

  /*
   * save.htmlで間違いが無いか確認したデータが入ったインスタンスをDBにinsertして
   */
  @RequestMapping(value = "customer/save-create")
  public String saveCreate(CustomerForm customerForm, Model model) {


    List<CustomerBean> list = customerService.selectIndex();
    model.addAttribute("list", list);
    return "customer/index";
  }


  @Autowired
  CustomerService customerService;

  /*
   * 「/customer」を拾ってlistにデータを格納してcustomerフォルダのindex.htmlに飛ばす 2020/11/10 格納の際にエラー発生中
   *
   */
  @RequestMapping(value = "/customer")
  public String init(Model model) {

    List<CustomerBean> list = customerService.selectIndex();
    model.addAttribute("list", list);

    return "customer/index";
  }

}
