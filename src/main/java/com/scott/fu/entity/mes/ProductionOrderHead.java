package com.scott.fu.entity.mes;

import java.util.Date;
import java.util.List;

public class ProductionOrderHead {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Lot_Num_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String lotNumMes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Lot_Num_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String lotNumSap;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Lot_Type_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String lotTypeMes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Lot_Type_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String lotTypeSap;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Part_Num
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String partNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Project
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String project;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Plant
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String plant;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Lot_UpdateTime
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private Date lotUpdatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.SystemStatus
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String systemstatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.UniversalState
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String universalstate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Update_Time
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderHead.Update_Status
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String updateStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Lot_Num_MES
     *
     * @return the value of MES.T_ProductionOrderHead.Lot_Num_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getLotNumMes() {
        return lotNumMes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Lot_Num_MES
     *
     * @param lotNumMes the value for MES.T_ProductionOrderHead.Lot_Num_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setLotNumMes(String lotNumMes) {
        this.lotNumMes = lotNumMes == null ? null : lotNumMes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Lot_Num_SAP
     *
     * @return the value of MES.T_ProductionOrderHead.Lot_Num_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getLotNumSap() {
        return lotNumSap;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Lot_Num_SAP
     *
     * @param lotNumSap the value for MES.T_ProductionOrderHead.Lot_Num_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setLotNumSap(String lotNumSap) {
        this.lotNumSap = lotNumSap == null ? null : lotNumSap.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Lot_Type_MES
     *
     * @return the value of MES.T_ProductionOrderHead.Lot_Type_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getLotTypeMes() {
        return lotTypeMes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Lot_Type_MES
     *
     * @param lotTypeMes the value for MES.T_ProductionOrderHead.Lot_Type_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setLotTypeMes(String lotTypeMes) {
        this.lotTypeMes = lotTypeMes == null ? null : lotTypeMes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Lot_Type_SAP
     *
     * @return the value of MES.T_ProductionOrderHead.Lot_Type_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getLotTypeSap() {
        return lotTypeSap;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Lot_Type_SAP
     *
     * @param lotTypeSap the value for MES.T_ProductionOrderHead.Lot_Type_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setLotTypeSap(String lotTypeSap) {
        this.lotTypeSap = lotTypeSap == null ? null : lotTypeSap.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Part_Num
     *
     * @return the value of MES.T_ProductionOrderHead.Part_Num
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getPartNum() {
        return partNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Part_Num
     *
     * @param partNum the value for MES.T_ProductionOrderHead.Part_Num
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setPartNum(String partNum) {
        this.partNum = partNum == null ? null : partNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Project
     *
     * @return the value of MES.T_ProductionOrderHead.Project
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getProject() {
        return project;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Project
     *
     * @param project the value for MES.T_ProductionOrderHead.Project
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Plant
     *
     * @return the value of MES.T_ProductionOrderHead.Plant
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getPlant() {
        return plant;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Plant
     *
     * @param plant the value for MES.T_ProductionOrderHead.Plant
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setPlant(String plant) {
        this.plant = plant == null ? null : plant.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Lot_UpdateTime
     *
     * @return the value of MES.T_ProductionOrderHead.Lot_UpdateTime
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public Date getLotUpdatetime() {
        return lotUpdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Lot_UpdateTime
     *
     * @param lotUpdatetime the value for MES.T_ProductionOrderHead.Lot_UpdateTime
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setLotUpdatetime(Date lotUpdatetime) {
        this.lotUpdatetime = lotUpdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.SystemStatus
     *
     * @return the value of MES.T_ProductionOrderHead.SystemStatus
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getSystemstatus() {
        return systemstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.SystemStatus
     *
     * @param systemstatus the value for MES.T_ProductionOrderHead.SystemStatus
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setSystemstatus(String systemstatus) {
        this.systemstatus = systemstatus == null ? null : systemstatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.UniversalState
     *
     * @return the value of MES.T_ProductionOrderHead.UniversalState
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getUniversalstate() {
        return universalstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.UniversalState
     *
     * @param universalstate the value for MES.T_ProductionOrderHead.UniversalState
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setUniversalstate(String universalstate) {
        this.universalstate = universalstate == null ? null : universalstate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Update_Time
     *
     * @return the value of MES.T_ProductionOrderHead.Update_Time
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Update_Time
     *
     * @param updateTime the value for MES.T_ProductionOrderHead.Update_Time
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderHead.Update_Status
     *
     * @return the value of MES.T_ProductionOrderHead.Update_Status
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getUpdateStatus() {
        return updateStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderHead.Update_Status
     *
     * @param updateStatus the value for MES.T_ProductionOrderHead.Update_Status
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus == null ? null : updateStatus.trim();
    }

    private List<ProductionOrderStep> stepList;

    public List<ProductionOrderStep> getStepList() {
        return stepList;
    }

    public void setStepList(List<ProductionOrderStep> stepList) {
        this.stepList = stepList;
    }
}