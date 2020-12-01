package com.customer.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
/*
 * m_userテーブルへSQL文を実行するマッパークラスです。 将来的にCustomerMapperクラスと統合するかも
 */
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.customer.bean.LoginUser;

@Mapper
public interface LoginMapper {

  @Select("SELECT * FROM m_user WHERE user_id = #{user_id}")
  LoginUser findUser(String user_id);

  @Update("update m_user set password = #{password} where user_id = #{user_id}")
  void updateUser(LoginUser loginUser);

  @Insert("insert into m_user (user_id, password) values (#{user_id}, #{password})")
  void insertUser(LoginUser loginUser);

}
