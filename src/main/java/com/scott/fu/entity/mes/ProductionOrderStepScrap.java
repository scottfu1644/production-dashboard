package com.scott.fu.entity.mes;

import java.math.BigDecimal;
import java.util.Date;

public class ProductionOrderStepScrap {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.Lot_Num_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String lotNumMes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.Lot_Num_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String lotNumSap;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.Step
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String step;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.Lot_Type_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String lotTypeMes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.Lot_Type_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String lotTypeSap;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.DefectCode
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String defectcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.DefectCodeDesc
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private Object defectcodedesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.YieldGRP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String yieldgrp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.RootCause
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private String rootcause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.DefectQty
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private BigDecimal defectqty;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MES.T_ProductionOrderStepScrap.UpdateTime
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.Lot_Num_MES
     *
     * @return the value of MES.T_ProductionOrderStepScrap.Lot_Num_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getLotNumMes() {
        return lotNumMes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.Lot_Num_MES
     *
     * @param lotNumMes the value for MES.T_ProductionOrderStepScrap.Lot_Num_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setLotNumMes(String lotNumMes) {
        this.lotNumMes = lotNumMes == null ? null : lotNumMes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.Lot_Num_SAP
     *
     * @return the value of MES.T_ProductionOrderStepScrap.Lot_Num_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getLotNumSap() {
        return lotNumSap;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.Lot_Num_SAP
     *
     * @param lotNumSap the value for MES.T_ProductionOrderStepScrap.Lot_Num_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setLotNumSap(String lotNumSap) {
        this.lotNumSap = lotNumSap == null ? null : lotNumSap.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.Step
     *
     * @return the value of MES.T_ProductionOrderStepScrap.Step
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getStep() {
        return step;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.Step
     *
     * @param step the value for MES.T_ProductionOrderStepScrap.Step
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.Lot_Type_MES
     *
     * @return the value of MES.T_ProductionOrderStepScrap.Lot_Type_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getLotTypeMes() {
        return lotTypeMes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.Lot_Type_MES
     *
     * @param lotTypeMes the value for MES.T_ProductionOrderStepScrap.Lot_Type_MES
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setLotTypeMes(String lotTypeMes) {
        this.lotTypeMes = lotTypeMes == null ? null : lotTypeMes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.Lot_Type_SAP
     *
     * @return the value of MES.T_ProductionOrderStepScrap.Lot_Type_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getLotTypeSap() {
        return lotTypeSap;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.Lot_Type_SAP
     *
     * @param lotTypeSap the value for MES.T_ProductionOrderStepScrap.Lot_Type_SAP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setLotTypeSap(String lotTypeSap) {
        this.lotTypeSap = lotTypeSap == null ? null : lotTypeSap.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.DefectCode
     *
     * @return the value of MES.T_ProductionOrderStepScrap.DefectCode
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getDefectcode() {
        return defectcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.DefectCode
     *
     * @param defectcode the value for MES.T_ProductionOrderStepScrap.DefectCode
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setDefectcode(String defectcode) {
        this.defectcode = defectcode == null ? null : defectcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.DefectCodeDesc
     *
     * @return the value of MES.T_ProductionOrderStepScrap.DefectCodeDesc
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public Object getDefectcodedesc() {
        return defectcodedesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.DefectCodeDesc
     *
     * @param defectcodedesc the value for MES.T_ProductionOrderStepScrap.DefectCodeDesc
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setDefectcodedesc(Object defectcodedesc) {
        this.defectcodedesc = defectcodedesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.YieldGRP
     *
     * @return the value of MES.T_ProductionOrderStepScrap.YieldGRP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getYieldgrp() {
        return yieldgrp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.YieldGRP
     *
     * @param yieldgrp the value for MES.T_ProductionOrderStepScrap.YieldGRP
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setYieldgrp(String yieldgrp) {
        this.yieldgrp = yieldgrp == null ? null : yieldgrp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.RootCause
     *
     * @return the value of MES.T_ProductionOrderStepScrap.RootCause
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getRootcause() {
        return rootcause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.RootCause
     *
     * @param rootcause the value for MES.T_ProductionOrderStepScrap.RootCause
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setRootcause(String rootcause) {
        this.rootcause = rootcause == null ? null : rootcause.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.DefectQty
     *
     * @return the value of MES.T_ProductionOrderStepScrap.DefectQty
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public BigDecimal getDefectqty() {
        return defectqty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.DefectQty
     *
     * @param defectqty the value for MES.T_ProductionOrderStepScrap.DefectQty
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setDefectqty(BigDecimal defectqty) {
        this.defectqty = defectqty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MES.T_ProductionOrderStepScrap.UpdateTime
     *
     * @return the value of MES.T_ProductionOrderStepScrap.UpdateTime
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MES.T_ProductionOrderStepScrap.UpdateTime
     *
     * @param updatetime the value for MES.T_ProductionOrderStepScrap.UpdateTime
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}