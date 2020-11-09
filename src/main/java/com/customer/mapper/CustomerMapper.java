package com.customer.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.customer.bean.CustomerBean;

/*
 * CustomerMapper.xmlに記述してあるSQL文を実行するMapperクラスです
 * 
 */

@Mapper
public interface CustomerMapper {
	
	List<CustomerBean> selectIndexAll();

}
