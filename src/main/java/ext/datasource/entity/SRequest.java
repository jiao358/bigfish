package ext.datasource.entity;

import java.util.Date;

public class SRequest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column S_REQUEST.ID
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column S_REQUEST.USER_ID
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column S_REQUEST.SERVICE_URL
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    private String serviceUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column S_REQUEST.CREATE_DATE
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column S_REQUEST.PARAMS
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    private String params;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_REQUEST.ID
     *
     * @return the value of S_REQUEST.ID
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_REQUEST.ID
     *
     * @param id the value for S_REQUEST.ID
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_REQUEST.USER_ID
     *
     * @return the value of S_REQUEST.USER_ID
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_REQUEST.USER_ID
     *
     * @param userId the value for S_REQUEST.USER_ID
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_REQUEST.SERVICE_URL
     *
     * @return the value of S_REQUEST.SERVICE_URL
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public String getServiceUrl() {
        return serviceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_REQUEST.SERVICE_URL
     *
     * @param serviceUrl the value for S_REQUEST.SERVICE_URL
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_REQUEST.CREATE_DATE
     *
     * @return the value of S_REQUEST.CREATE_DATE
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_REQUEST.CREATE_DATE
     *
     * @param createDate the value for S_REQUEST.CREATE_DATE
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column S_REQUEST.PARAMS
     *
     * @return the value of S_REQUEST.PARAMS
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public String getParams() {
        return params;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column S_REQUEST.PARAMS
     *
     * @param params the value for S_REQUEST.PARAMS
     *
     * @mbg.generated Thu Jun 29 13:43:32 GMT+08:00 2017
     */
    public void setParams(String params) {
        this.params = params;
    }
}