package ext.datasource.inf;

import ext.datasource.entity.User;
import ext.datasource.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    User selectByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table langcom
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int updateByPrimaryKey(User record);
}