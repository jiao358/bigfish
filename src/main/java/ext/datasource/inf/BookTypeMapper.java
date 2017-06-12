package ext.datasource.inf;

import ext.datasource.entity.BookType;
import ext.datasource.entity.BookTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    long countByExample(BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int deleteByExample(BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int insert(BookType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int insertSelective(BookType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    List<BookType> selectByExample(BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    BookType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int updateByExampleSelective(@Param("record") BookType record, @Param("example") BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int updateByExample(@Param("record") BookType record, @Param("example") BookTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int updateByPrimaryKeySelective(BookType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table booktypes
     *
     * @mbg.generated Thu Jun 01 01:40:55 GMT+08:00 2017
     */
    int updateByPrimaryKey(BookType record);
}