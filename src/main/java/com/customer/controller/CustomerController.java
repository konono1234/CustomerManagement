package com.customer.controller;

<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> create
=======
import java.util.ArrayList;
>>>>>>> edit
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
>>>>>>> edit
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.customer.bean.CustomerBean;
import com.customer.service.CustomerService;


/*
<<<<<<< HEAD
 * Beanにデータを受け渡したりServiceを起動するコントローラークラスです
<<<<<<< HEAD
 *
=======
=======
 * Serviceを起動したりViewにデータを渡すコントローラークラスです
>>>>>>> edit
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
   * 「/customer」を拾ってlistにサービスから渡されたデータを格納してindex.htmlに飛ばす。
   * cusomer/indexは、customerフォルダのindex.htmlというこｐと
   */


  @RequestMapping(value = "/customer")
  public String initIndex(Model model) {

    List<CustomerBean> list = customerService.selectIndex();
    model.addAttribute("list", list);
    model.addAttribute("customerForm", new CustomerForm());

    return "customer/index";
  }

  /*
   * 新規登録機能です。index.htmlからcreate.htmlにFormで入力されたデータを格納予定のインスタンスを渡す（各フィールドは空っぽ）
   */
  @RequestMapping(value = "/customer/create")
  public String create(@ModelAttribute("customerForm") CustomerForm customerForm) {
    return "customer/create";
  }

  /*
   * 保存機能です。create.htmlから渡されるデータが格納されたインスタンスをDBにinsertします
   */
  @RequestMapping(value = "/customer/save-create")
  public String saveForm(CustomerForm customerForm, Model model) {

    customerService.insertNewCustomer(customerForm);

    return "customer/save";
  }

  @RequestMapping(value = "/cusotmer/save")
  public String save(CustomerForm customerForm, Model model) {
    model.addAttribute("customerForm", customerForm);
    return "customer/save";
  }
  /*
   * 検索機能です。index.htmlでリンクを踏むと顧客番号のデータも同時に取得しDBに検索をかける。 将来的にチェックボックス使いたい
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

  /*
   * 検索機能です。CustomerFormの中のkeyとkeywordを使ってDBに検索をかけます。 数字で検索する場合にはselectBykeybumberを使います
   */
  @RequestMapping(value = "/customer/search", method = RequestMethod.POST)
  public String delete(CustomerForm customerForm, Model model) {

    List<CustomerBean> searchList = new ArrayList<CustomerBean>();

    // if (customerForm.getKey().equals("cust_no") || customerForm.getKey().equals("birth_date")
    // || customerForm.getKey().equals("reg_date") || customerForm.getKey().equals("gender_cd")) {
    // searchList = customerService.searchByKeynumber(customerForm);
    // } else {
    // searchList = customerService.searchByKeyword(customerForm);
    // }
    // 1つに統合しました
    model.addAttribute("searchList", searchList);

    return "customer/search";
  }

  /*
   * 更新画面に顧客情報が入ったデータを渡すメソッドです。
   */
  @RequestMapping(value = "/customer/edit/{cust_no}", method = RequestMethod.GET)
  public String update(@ModelAttribute CustomerForm customerForm, @PathVariable Integer cust_no,
      Model model) {

    customerForm = customerService.customerFormByNumber(cust_no);
    model.addAttribute("customerForm", customerForm);

    System.out.println(customerForm.getLast_nm());
    System.out.println(customerForm.getFirst_nm());

    return "customer/edit";
  }

  /*
   * 更新保存機能です。渡されたデータでupdateを行います
   */
  @RequestMapping(value = "/customer/save-edit", method = RequestMethod.POST)
  public String updateSave(CustomerForm customerForm) {

<<<<<<< HEAD
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

=======
    customerService.updatebyNumber(customerForm);

    return ("customer/save");
  }
>>>>>>> edit
}
