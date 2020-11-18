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
<<<<<<< HEAD
>>>>>>> create
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> create
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
   * create.htmlでデータが格納されたインスタンスをDBにinsertします
   */
  @RequestMapping(value = "/customer/save")
  public String saveForm(CustomerForm customerForm) {
    customerService.insertNewCustomer(customerForm);
    return "customer/save";
  }

  @RequestMapping(value = "/customer/{cust_no}", method = RequestMethod.GET)
  public ModelAndView detail(@PathVariable Integer cust_no) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("customer/detail");

    List<CustomerBean> list = customerService.findByNumber(cust_no);
    mv.addObject("list", list);

    return mv;
  }

  /*
   * 没コード save.htmlで間違いが無いか確認したデータが入ったインスタンスをDBにinsertして
   * 
   * @RequestMapping(value = "customer/save-create") public String saveCreate(CustomerForm
   * customerForm, Model model) {
   * 
   * 
   * List<CustomerBean> list = customerService.selectIndex(); model.addAttribute("list", list);
   * return "customer/index"; }
   */

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
