package ext.datasource.inf;

import ext.datasource.entity.Contract;
import ext.datasource.entity.ContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	long countByExample(ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int deleteByExample(ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int insert(Contract record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int insertSelective(Contract record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	List<Contract> selectByExample(ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	Contract selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByPrimaryKeySelective(Contract record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CONTRACT
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByPrimaryKey(Contract record);
}