package com.customer.mapper;

<<<<<<< HEAD
import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.customer.bean.CustomerBean;


/*
 * CustomerMapper.xmlに記述してあるSQL文を実行するMapperクラスです
 *
=======
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.customer.bean.CustomerBean;
import com.customer.controller.CustomerForm;

/*
 * m_customerテーブルへSQL文を実行するMapperクラスです
 * 
>>>>>>> create
 */

@Mapper
public interface CustomerMapper {

  @Select("SELECT * FROM m_customer")
<<<<<<< HEAD
  public ArrayList<CustomerBean> selectIndexAll();
=======
  public List<CustomerBean> selectIndexAll();

  // 誕生日と更新日はCustomerFormでSQLのDATE型に変換しています
  @Insert("INSERT INTO m_customer (cust_no, last_nm, first_nm, last_nm_kana, first_nm_kana, gender_cd, mail_address, tel_no, birth_date, home_address, post_number, reg_date)  values (#{cust_no}, #{last_nm}, #{first_nm}, #{last_nm_kana}, #{first_nm_kana}, #{gender_cd}, #{mail_address}, #{tel_no}, #{sql_birth_date}, #{home_address}, #{post_number}, #{sql_reg_date})")
  public void create(CustomerForm customerForm);
>>>>>>> create

  @Select("SELECT * FROM m_customer where cust_no = #{cust_no}")
  public List<CustomerBean> selectByNumber(Integer cust_no);

}
