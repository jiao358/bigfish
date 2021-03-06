package ext.datasource.inf;

import ext.datasource.entity.SDic;
import ext.datasource.entity.SDicExample;
import ext.datasource.entity.SDicKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SDicMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	long countByExample(SDicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int deleteByExample(SDicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int deleteByPrimaryKey(SDicKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int insert(SDic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int insertSelective(SDic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	List<SDic> selectByExample(SDicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	SDic selectByPrimaryKey(SDicKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByExampleSelective(@Param("record") SDic record, @Param("example") SDicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByExample(@Param("record") SDic record, @Param("example") SDicExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByPrimaryKeySelective(SDic record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S_DIC
	 * @mbg.generated  Tue Jun 27 11:19:33 GMT+08:00 2017
	 */
	int updateByPrimaryKey(SDic record);
}