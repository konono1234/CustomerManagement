package com.customer.controller;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


// フォームで入力されたデータを一時的に格納するクラス。
// CustomerBeanはDBから受け取ったデータを格納するリポジトリで、このクラスはDBに格納するためのリポジトリです。
// 必要ならシリアルIDを後に定義する
@SuppressWarnings("serial")
public class CustomerForm implements Serializable {

  private Integer cust_no;

  private String last_nm;

  private String first_nm;

  private String last_nm_kana;

  private String first_nm_kana;

  private byte gender_cd;

  private String mail_address;

  private String tel_no;

  private String birth_date;

  private Date sql_birth_date;

  private String home_address;

  private String post_number;

  private String key;

  // 検索用に入力されたデータをセッターでStringかIntegerのどちらかに入れます。Stirngで顧客番号などのIntegerを検索するとエラーになるため。
  // private String keyword;
  // private Integer keynumber;
  // 1つにまとめました
  private String keyword;

  // 登録日の日付をStringとDate型で取得します。String->フォーム用。Date->DB用

  Calendar calender = Calendar.getInstance();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  private String reg_date = sdf.format(calender.getTime());

  private Date sql_reg_date = Date.valueOf(reg_date);;

  public Integer getCust_no() {
    return cust_no;
  }

  public void setCust_no(Integer cust_no) {
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

  public Date getSql_birth_date() {
    return sql_birth_date;
  }

  public void setBirth_date(String birth_date) {
    this.birth_date = birth_date;
    this.sql_birth_date = Date.valueOf(birth_date);
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

  public Date getSql_reg_date() {
    return sql_reg_date;
  }

  public void setReg_date(String reg_date) {
    this.reg_date = reg_date;
    this.sql_reg_date = Date.valueOf(reg_date);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getKeyword() {
    return keyword;
  }


  public void setKeyword(String keyword) {
    this.keyword = keyword;
    if (this.getKey().equals("gender_cd") && keyword.equals("男")) {
      this.keyword = "1";
    } else if (this.getKey().equals("gender_cd") && keyword.equals("女")) {
      this.keyword = "2";
    } else if (this.getKey().equals("gender_cd") && keyword.equals("未定義")) {
      this.keyword = "3";
    } else {
      this.keyword = keyword;
    }
    // 没になりました
    /*
     * 数字が入力されたら数字としてキーワードを保存します. if (this.getKey().equals("cust_no") ||
     * this.getKey().equals("birth_date") || this.getKey().equals("reg_date")) { this.keynumber =
     * Integer.parseInt(keyword); } else if (this.getKey().equals("gender_cd") &&
     * keyword.equals("男")) { this.keynumber = 1; } else if (this.getKey().equals("gender_cd") &&
     * keyword.equals("女")) { this.keynumber = 2; } else if (this.getKey().equals("gender_cd") &&
     * keyword.equals("未定義")) { this.keynumber = 3; } else { this.keyword = keyword; }
     */

  }
  /*
   * public Integer getKeynumber() { return keynumber; }
   */


}
