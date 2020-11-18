package com.customer.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.customer.bean.CustomerBean;
import com.customer.controller.CustomerForm;

/*
 * m_customerテーブルへSQL文を実行するMapperクラスです
 * 
 */

@Mapper
public interface CustomerMapper {

  @Select("SELECT * FROM m_customer")
  public List<CustomerBean> selectIndexAll();

  @Insert("INSERT INTO m_customer (cust_no, last_nm, first_nm, last_nm_kana, first_nm_kana, gender_cd, mail_address, tel_no, birth_date, home_address, post_number, reg_date)  values (#{cust_no}, #{last_nm}, #{first_nm}, #{last_nm_kana}, #{first_nm_kana}, #{gender_cd}, #{mail_address}, #{tel_no}, #{sql_birth_date}, #{home_address}, #{post_number}, #{sql_reg_date})")
  public void create(CustomerForm customerForm);

}
