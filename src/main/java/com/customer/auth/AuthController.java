package com.customer.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.customer.bean.LoginUser;
import com.customer.service.UserService;

/**
 * 認証画面を制御するコントローラクラスです
 * 
 * @author Comsize
 *
 */
@Controller
public class AuthController {

  final static Logger logger = LoggerFactory.getLogger(AuthController.class);

  @Autowired
  UserService userService;

  /**
   * ログイン画面を表示する 「/login」を拾ってauthフォルダのlogin.htmlに飛ばす。 入力されたuseridでデータベースに検索をしつつidとpasswordが一緒かどうか調べる
   * WebSecurityConfigクラスで詳細を定義
   * 
   * @return String
   */
  @RequestMapping(value = "/login")
  public String login(Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userName = auth.getName();
    // System.out.println(userName);

    if (userName.equals("anonymousUser")) {
      userName = "true";
      model.addAttribute("userName", userName);
      return "auth/login";
    } else {
      model.addAttribute("userName", userName);
      return "auth/login";
    }
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

  @RequestMapping(value = "/login-edit")
  public String loginEdit(Model model, LoginUser loginUser) {
    model.addAttribute("editUsername", true);
    model.addAttribute("loginUser", loginUser);
    return "auth/login-edit";
  }

  @RequestMapping(value = "/login-create")
  public String loginCreate(Model model, LoginUser loginUser) {
    model.addAttribute("createUser", true);
    model.addAttribute("loginUser", loginUser);
    return "auth/login-edit";
  }

  @RequestMapping(value = "/login-editPs")
  public String loginEditPs(Model model, LoginUser loginUser) {

    model.addAttribute("loginUser", loginUser);
    try {
      UserDetails userDetails = userService.loadUserByUsername(loginUser.getUser_id());
      model.addAttribute("editPassword", true);
      return "auth/login-edit";
    } catch (Exception e) {
      model.addAttribute("emptyMessage", true);
      model.addAttribute("editUsername", true);
      return "auth/login-edit";
    }
  }

  @RequestMapping(value = "/login-edit-save")
  public String loginEditSave(Model model, LoginUser loginUser) {
    model.addAttribute("saveMessage", true);

    userService.updateUserByUserid(loginUser);
    return "auth/login";
  }

  @RequestMapping(value = "/login-create-save")
  public String loginCreatesave(Model model, LoginUser loginUser) {
    model.addAttribute("saveMessage", true);
    try {
      userService.insertUserInfo(loginUser);
      return "auth/login";
    } catch (Exception e) {
      model.addAttribute("errorMessage", true);
      model.addAttribute("createUser", true);
      return "auth/login-edit";
    }
  }


}
