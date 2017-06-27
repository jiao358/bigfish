package ext.datasource.inf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import ext.datasource.entity.Customer;
import ext.datasource.entity.CustomerExample;

public interface CustomerMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	long countByExample(CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int deleteByExample(CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int insert(Customer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int insertSelective(Customer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	List<Customer> selectByExample(CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	Customer selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByPrimaryKeySelective(Customer record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CUSTOMER
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByPrimaryKey(Customer record);

	List<Map> selectCasNormalCasPop(Map require);
}