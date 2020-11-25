package com.customer.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.customer.bean.CustomerBean;
import com.customer.bean.CustomerForm;
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
    model.addAttribute("customerForm", new CustomerForm());

    return "customer/index";
  }

  /*
   * ソート機能です。選択された項目で並び替えます
   */
  @RequestMapping(value = "/customer-sort", method = RequestMethod.POST)
  public String sortForm(CustomerForm customerForm, Model model) {
    List<CustomerBean> list = customerService.sortIndex(customerForm);
    model.addAttribute("list", list);
    return "customer/index";
  }

  /*
   * 新規登録機能です。index.htmlからcreate.htmlにFormで入力されたデータを格納予定のインスタンスを渡す（各フィールドは空っぽ）
   */
  @RequestMapping(value = "/customer/create")
  public String createForm(@ModelAttribute("customerForm") CustomerForm customerForm, Model model) {
    return "customer/create";
  }

  /*
   * 保存機能です。create.htmlから渡されるデータが格納されたインスタンスをDBにinsertします
   */
  @RequestMapping(value = "/customer/save-create")
  public String saveForm(@ModelAttribute @Validated CustomerForm customerForm,
      BindingResult bindingResult, Model model) {


    if (bindingResult.hasErrors()) {

      return "customer/create";
    } else {
      try {
        customerService.insertNewCustomer(customerForm);
        return "customer/save";
      } catch (Exception e) {

        model.addAttribute("errorMessage", "顧客番号が重複しています。別の番号を指定してください");
        return "customer/create";
      }
    }
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
  public ModelAndView detailForm(@PathVariable Integer cust_no) {
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
  public String deleteForm(@PathVariable Integer cust_no, RedirectAttributes attributes,
      Model model) {
    customerService.deleteByNumber(cust_no);

    attributes.addFlashAttribute("deleteMessage", "顧客番号:" + cust_no + "を削除しました");

    return "redirect:/customer";
  }

  /*
   * 検索機能です。CustomerFormの中のkeyとkeywordを使ってDBに検索をかけます。 数字で検索する場合にはselectBykeybumberを使います
   */
  @RequestMapping(value = "/customer/search", method = RequestMethod.POST)
  public String searchForm(CustomerForm customerForm, Model model) {

    if (customerForm.getKeyword().equals("")) {
      model.addAttribute("errorMessage", "キーワードを入力してください");
      return "customer/search";
    }
    List<CustomerBean> searchList = new ArrayList<CustomerBean>();

    // if (customerForm.getKey().equals("cust_no") || customerForm.getKey().equals("birth_date")
    // || customerForm.getKey().equals("reg_date") || customerForm.getKey().equals("gender_cd")) {
    // searchList = customerService.searchByKeynumber(customerForm);
    // } else {
    // searchList = customerService.searchByKeyword(customerForm);
    // }
    // 1つに統合しました
    searchList = customerService.searchByKeyword(customerForm);
    model.addAttribute("searchList", searchList);

    try {
      if (searchList.get(0) == null) {
      }
    } catch (Exception e) {
      model.addAttribute("emptyMessage", "検索結果は0件です");
      return "customer/search";
    }

    return "customer/search";
  }

  /*
   * 更新画面に顧客情報が入ったデータを渡すメソッドです。
   */
  @RequestMapping(value = "/customer/edit/{cust_no}", method = RequestMethod.GET)
  public String editForm(@ModelAttribute CustomerForm customerForm, @PathVariable Integer cust_no,
      Model model) {

    customerForm = customerService.customerFormByNumber(cust_no);
    model.addAttribute("customerForm", customerForm);

    return "customer/edit";
  }

  /*
   * 更新保存機能です。渡されたデータでupdateを行います
   */
  @RequestMapping(value = "/customer/save-edit", method = RequestMethod.POST)
  public String updateSave(@ModelAttribute @Validated CustomerForm customerForm,
      BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return ("customer/edit");
    } else {
      customerService.updateByNumber(customerForm);
      return ("customer/save");
    }

  }
}
