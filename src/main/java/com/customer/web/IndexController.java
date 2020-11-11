package com.customer.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 現状使わない
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
