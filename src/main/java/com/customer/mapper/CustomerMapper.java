package com.customer.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.customer.bean.CustomerBean;

/*
 * CustomerMapper.xmlに記述してあるSQL文を実行するMapperクラスです
 * 
 */

@Mapper
public interface CustomerMapper {

  @Select("SELECT * FROM m_customer")
  public List<CustomerBean> selectIndexAll();

  @Select("SERECT * FROM m_user")
  public List<CustomerBean> selectUserAll();

}
