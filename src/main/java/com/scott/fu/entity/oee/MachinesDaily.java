package com.scott.fu.entity.oee;

import com.scott.fu.util.DateUtil;

import java.util.Date;

public class MachinesDaily {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column OEE.MachinesDaily.ID
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column OEE.MachinesDaily.Date
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    private String date;


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column OEE.MachinesDaily.Resource
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    private String resource;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column OEE.MachinesDaily.State
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    private String state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column OEE.MachinesDaily.StateReason
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    private String statereason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column OEE.MachinesDaily.Duration
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    private Integer duration;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column OEE.MachinesDaily.createtime
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    private Date createtime;

    private String createTimeString;

    public String getCreateTimeString() {
        return createTimeString;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OEE.MachinesDaily.ID
     *
     * @return the value of OEE.MachinesDaily.ID
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OEE.MachinesDaily.ID
     *
     * @param id the value for OEE.MachinesDaily.ID
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OEE.MachinesDaily.Date
     *
     * @return the value of OEE.MachinesDaily.Date
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OEE.MachinesDaily.Date
     *
     * @param date the value for OEE.MachinesDaily.Date
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OEE.MachinesDaily.Resource
     *
     * @return the value of OEE.MachinesDaily.Resource
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public String getResource() {
        return resource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OEE.MachinesDaily.Resource
     *
     * @param resource the value for OEE.MachinesDaily.Resource
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OEE.MachinesDaily.State
     *
     * @return the value of OEE.MachinesDaily.State
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OEE.MachinesDaily.State
     *
     * @param state the value for OEE.MachinesDaily.State
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OEE.MachinesDaily.StateReason
     *
     * @return the value of OEE.MachinesDaily.StateReason
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public String getStatereason() {
        return statereason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OEE.MachinesDaily.StateReason
     *
     * @param statereason the value for OEE.MachinesDaily.StateReason
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public void setStatereason(String statereason) {
        this.statereason = statereason == null ? null : statereason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OEE.MachinesDaily.Duration
     *
     * @return the value of OEE.MachinesDaily.Duration
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OEE.MachinesDaily.Duration
     *
     * @param duration the value for OEE.MachinesDaily.Duration
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column OEE.MachinesDaily.createtime
     *
     * @return the value of OEE.MachinesDaily.createtime
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column OEE.MachinesDaily.createtime
     *
     * @param createtime the value for OEE.MachinesDaily.createtime
     *
     * @mbggenerated Tue Dec 29 10:52:03 CST 2015
     */
    public void setCreatetime(Date createtime) {
        this.createTimeString = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).format(createtime);
        this.createtime = createtime;
    }

    private Long durationMilli;

    public Long getDurationMilli() {
        return durationMilli;
    }

    public void setDurationMilli(Long durationMilli) {
        this.durationMilli = durationMilli;
    }
}