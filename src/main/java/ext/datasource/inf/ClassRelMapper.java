package ext.datasource.inf;

import ext.datasource.entity.ClassRel;
import ext.datasource.entity.ClassRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassRelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	long countByExample(ClassRelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	int deleteByExample(ClassRelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	int insert(ClassRel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	int insertSelective(ClassRel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	List<ClassRel> selectByExample(ClassRelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	ClassRel selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	int updateByExampleSelective(@Param("record") ClassRel record, @Param("example") ClassRelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	int updateByExample(@Param("record") ClassRel record, @Param("example") ClassRelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	int updateByPrimaryKeySelective(ClassRel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table TRX_CLASS_REL
	 * @mbg.generated  Tue Jun 27 20:57:54 GMT+08:00 2017
	 */
	int updateByPrimaryKey(ClassRel record);
}