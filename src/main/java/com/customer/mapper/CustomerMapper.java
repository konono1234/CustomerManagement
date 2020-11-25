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
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.customer.bean.CustomerBean;
import com.customer.bean.CustomerForm;

/*
<<<<<<< HEAD
 * m_customerテーブルへSQL文を実行するMapperクラスです
 * 
>>>>>>> create
=======
 * m_customerテーブルへSQL文を実行するMapperクラスです データを受け取ったり受け渡したりします あまり似すぎるメソッド名だとエラーが生じるらしい。
>>>>>>> edit
 */

@Mapper
public interface CustomerMapper {

  @Select("SELECT * FROM m_customer")
<<<<<<< HEAD
  public ArrayList<CustomerBean> selectIndexAll();
=======
  public List<CustomerBean> selectIndexAll();

  // sort用。データベースでできることはなるべくDB上でやった方がいいと言われている？
  @Select("select * from m_customer order by ${key} ${sort}")
  public List<CustomerBean> sortIndexAll(CustomerForm customerForm);

  // 誕生日と更新日はCustomerFormでSQLのDATE型に変換しています
  @Insert("INSERT INTO m_customer (cust_no, last_nm, first_nm, last_nm_kana, first_nm_kana, gender_cd, mail_address, tel_no, birth_date, home_address, post_number, reg_date)  values (#{cust_no}, #{last_nm}, #{first_nm}, #{last_nm_kana}, #{first_nm_kana}, #{gender_cd}, #{mail_address}, #{tel_no}, #{sql_birth_date}, #{home_address}, #{post_number}, #{sql_reg_date})")
<<<<<<< HEAD
  public void create(CustomerForm customerForm);
>>>>>>> create
=======
  public void insertInto(CustomerForm customerForm);
>>>>>>> sort

  @Select("SELECT * FROM m_customer where cust_no = #{cust_no}")
  public List<CustomerBean> selectByNumber(Integer cust_no);

  @Delete("DELETE FROM m_customer where cust_no = #{cust_no}")
  public void delete(Integer cust_no);

  // あいまい検索の為に%を結合させます
  // @Select("SELECT * FROM m_customer where ${key} like CONCAT('%', #{keyword}, '%')")
  // public List<CustomerBean> selectByWord(CustomerForm customerForm);

  // 型が違う同士での検索はエラーになるのでキャスト変換を行います
  // @Select("SELECT * FROM m_customer where CAST(${key} AS TEXT) like CONCAT('%', ${keynumber},
  // '%')")
  // public List<CustomerBean> searchByNumber(CustomerForm customerForm);

  @Select("SELECT * FROM m_customer where CAST(${key} AS TEXT) like CONCAT('%', '${keyword}', '%')")
  public List<CustomerBean> searchByWord(CustomerForm customerForm);

  @Update("update m_customer set last_nm = #{last_nm}, first_nm = #{first_nm}, last_nm_kana = #{last_nm_kana}, first_nm_kana = #{first_nm_kana}, gender_cd = #{gender_cd}, mail_address = #{mail_address}, tel_no = #{tel_no}, birth_date = #{sql_birth_date} , home_address = #{home_address}, post_number = #{post_number} where cust_no = #{cust_no}")
  public void update(CustomerForm customerForm);

  @Select("SELECT * FROM m_customer where cust_no = #{cust_no}")
  public CustomerForm customerFormCreate(Integer cust_no);
}
