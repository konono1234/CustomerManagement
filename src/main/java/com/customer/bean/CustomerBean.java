package com.customer.bean;

/*
 * 顧客情報のBeanクラスです。Repository,entityともいう
 */

public class CustomerBean {

  private int cust_no;

  private String last_nm;

  private String first_nm;

  private String last_nm_kana;

  private String first_nm_kana;

  private byte gender_cd;

  private String mail_address;

  private String tel_no;

  private String birth_date;

  private String home_address;

  private String post_number;

  private String reg_date;

  public int getCust_no() {
    return cust_no;
  }

  public void setCust_no(int cust_no) {
    this.cust_no = cust_no;
  }

  public String getLast_nm() {
    return last_nm;
  }

  public void setLast_nm(String last_nm) {
    this.last_nm = last_nm;
  }

  public String getFirst_nm() {
    return first_nm;
  }

  public void setFirst_nm(String first_nm) {
    this.first_nm = first_nm;
  }

  public String getLast_nm_kana() {
    return last_nm_kana;
  }

  public void setLast_nm_kana(String last_nm_kana) {
    this.last_nm_kana = last_nm_kana;
  }

  public String getFirst_nm_kana() {
    return first_nm_kana;
  }

  public void setFirst_nm_kana(String first_nm_kana) {
    this.first_nm_kana = first_nm_kana;
  }

  public byte getGender_cd() {
    return gender_cd;
  }

  public void setGender_cd(byte gender_cd) {
    this.gender_cd = gender_cd;
  }

  public String getMail_address() {
    return mail_address;
  }

  public void setMail_address(String mail_address) {
    this.mail_address = mail_address;
  }

  public String getTel_no() {
    return tel_no;
  }

  public void setTel_no(String tel_no) {
    this.tel_no = tel_no;
  }

  public String getBirth_date() {
    return birth_date;
  }

  public void setBirth_date(String birth_date) {
    this.birth_date = birth_date;
  }

  public String getHome_address() {
    return home_address;
  }

  public void setHome_address(String home_address) {
    this.home_address = home_address;
  }

  public String getPost_number() {
    return post_number;
  }

  public void setPost_number(String post_number) {
    this.post_number = post_number;
  }

  public String getReg_date() {
    return reg_date;
  }

  public void setReg_date(String reg_date) {
    this.reg_date = reg_date;
  }
}
