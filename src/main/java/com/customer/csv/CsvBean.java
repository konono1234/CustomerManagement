package com.customer.csv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"顧客番号", "氏", "名", "氏(フリガナ)", "名(フリガナ)", "性別", "メールアドレス", "電話番号", "生年月日", "住所",
    "郵便番号", "登録日"})
public class CsvBean {
  @JsonProperty("顧客番号")
  private Integer cust_no;

  @JsonProperty("氏")
  private String last_nm;

  @JsonProperty("名")
  private String first_nm;

  @JsonProperty("氏(フリガナ)")
  private String last_nm_kana;

  @JsonProperty("名(フリガナ)")
  private String first_nm_kana;

  @JsonProperty("性別")
  private byte gender_cd;

  @JsonProperty("メールアドレス")
  private String mail_address;

  @JsonProperty("電話番号")
  private String tel_no;

  @JsonProperty("生年月日")
  private String birth_date;

  @JsonProperty("住所")
  private String home_address;

  @JsonProperty("郵便番号")
  private String post_number;

  @JsonProperty("登録日")
  private String reg_date;

  public CsvBean() {}

  public CsvBean(Integer cust_no, String last_nm, String first_nm, String last_nm_kana,
      String first_nm_kana, byte gender_cd, String mail_address, String tel_no, String birth_date,
      String home_address, String post_number, String reg_date) {

    this.cust_no = cust_no;
    this.last_nm = last_nm;
    this.first_nm = first_nm;
    this.last_nm_kana = last_nm_kana;
    this.first_nm_kana = first_nm_kana;
    this.gender_cd = gender_cd;
    this.tel_no = tel_no;
    this.birth_date = birth_date;
    this.mail_address = mail_address;
    this.tel_no = tel_no;
    this.birth_date = birth_date;
    this.home_address = home_address;
    this.post_number = post_number;
    this.reg_date = reg_date;
  }
}
