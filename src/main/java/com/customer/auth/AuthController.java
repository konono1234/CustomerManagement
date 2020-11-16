package com.customer.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
  @RequestMapping(value = "/login")
  public String login(Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userName = auth.getName();
    model.addAttribute("userName", userName);
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
