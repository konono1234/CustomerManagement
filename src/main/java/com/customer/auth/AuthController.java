package com.customer.auth;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.customer.bean.UserBean;
import com.customer.service.CustomerService;

/**
 * 認証画面を制御するコントローラクラスです
 * 
 * @author Comsize
 *
 */
@Controller
public class AuthController {

  final static Logger logger = LoggerFactory.getLogger(AuthController.class);

  /**
   * ログイン画面を表示する 「/login」を拾ってauthフォルダのlogin.htmlに飛ばす
   * 
   * @return String
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() {
    return "auth/login";
  }

  @Autowired
  CustomerService customerService;

  @RequestMapping(value = "/auth/login")
  public String initUser(Model model) {

    List<UserBean> password = customerService.selectUserInfo();
    model.addAttribute("password", password);

    return "auth/login";
  }

  /**
   * ログインエラーが面を表示する 「/login-error」を拾ってauthフォルダのlogin.htmlに飛ばす
   * 
   * @param model
   * @return String
   */
  @RequestMapping(value = "/login-error", method = RequestMethod.GET)
  public String loginError(Model model) {
    model.addAttribute("loginError", true);
    return "auth/login";
  }

}
