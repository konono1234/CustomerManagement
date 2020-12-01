package com.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * 現状使わないクラスです
 *
 */
@Controller
public class IndexController {

  final static Logger logger = LoggerFactory.getLogger(IndexController.class);

  @RequestMapping(value = "/")
  public String index() {

    return "redirect:/customer";
  }

}
