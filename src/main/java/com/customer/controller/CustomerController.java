package com.customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.customer.bean.CustomerBean;
import com.customer.service.CustomerService;


/*
 * Serviceを起動したりViewにデータを渡すコントローラークラスです
 * 
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
   * 「/customer」を拾ってlistにサービスから渡されたデータを格納してindex.htmlに飛ばす。
   * cusomer/indexは、customerフォルダのindex.htmlというこｐと
   */


  @RequestMapping(value = "/customer")
  public String initIndex(Model model) {

    List<CustomerBean> list = customerService.selectIndex();
    model.addAttribute("list", list);

    return "customer/index";
  }

  /*
   * index.htmlからcreate.htmlにFormで入力されたデータを格納予定のインスタンスを渡す（各フィールドは空っぽ）
   */
  @RequestMapping(value = "/customer/create")
  public String create(@ModelAttribute("customerForm") CustomerForm customerForm) {
    return "customer/create";
  }

  /*
   * create.htmlから渡されるデータが格納されたインスタンスをDBにinsertします
   */
  @RequestMapping(value = "/customer/save")
  public String saveForm(CustomerForm customerForm) {
    customerService.insertNewCustomer(customerForm);
    return "customer/save";
  }
  /*
   * index.htmlでリンクを踏むと顧客番号のデータも同時に取得しDBに検索をかける。 将来的にチェックボックス使いたい
   */

  @RequestMapping(value = "/customer/{cust_no}", method = RequestMethod.GET)
  public ModelAndView detail(@PathVariable Integer cust_no) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("customer/detail");

    List<CustomerBean> list = customerService.findByNumber(cust_no);
    mv.addObject("list", list);

    return mv;
  }
  /*
   * 削除機能です。削除画面は用意せずにdeleteしたら削除メッセージを渡しつつ一覧画面に戻ります。 将来的にJavaScriptで「本当に削除しますか？」とポップアップを出したい
   */

  @RequestMapping(value = "/customer/delete/{cust_no}", method = RequestMethod.GET)
  public String delete(@PathVariable Integer cust_no, RedirectAttributes attributes, Model model) {
    customerService.deleteByNumber(cust_no);

    attributes.addFlashAttribute("deleteMessage", "顧客番号:" + cust_no + "を削除しました");

    return "redirect:/customer";

  }
}
