package com.scott.fu.entity.mes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductionOrderStepScrapExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public ProductionOrderStepScrapExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLotNumMesIsNull() {
            addCriterion("Lot_Num_MES is null");
            return (Criteria) this;
        }

        public Criteria andLotNumMesIsNotNull() {
            addCriterion("Lot_Num_MES is not null");
            return (Criteria) this;
        }

        public Criteria andLotNumMesEqualTo(String value) {
            addCriterion("Lot_Num_MES =", value, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesNotEqualTo(String value) {
            addCriterion("Lot_Num_MES <>", value, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesGreaterThan(String value) {
            addCriterion("Lot_Num_MES >", value, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesGreaterThanOrEqualTo(String value) {
            addCriterion("Lot_Num_MES >=", value, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesLessThan(String value) {
            addCriterion("Lot_Num_MES <", value, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesLessThanOrEqualTo(String value) {
            addCriterion("Lot_Num_MES <=", value, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesLike(String value) {
            addCriterion("Lot_Num_MES like", value, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesNotLike(String value) {
            addCriterion("Lot_Num_MES not like", value, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesIn(List<String> values) {
            addCriterion("Lot_Num_MES in", values, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesNotIn(List<String> values) {
            addCriterion("Lot_Num_MES not in", values, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesBetween(String value1, String value2) {
            addCriterion("Lot_Num_MES between", value1, value2, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumMesNotBetween(String value1, String value2) {
            addCriterion("Lot_Num_MES not between", value1, value2, "lotNumMes");
            return (Criteria) this;
        }

        public Criteria andLotNumSapIsNull() {
            addCriterion("Lot_Num_SAP is null");
            return (Criteria) this;
        }

        public Criteria andLotNumSapIsNotNull() {
            addCriterion("Lot_Num_SAP is not null");
            return (Criteria) this;
        }

        public Criteria andLotNumSapEqualTo(String value) {
            addCriterion("Lot_Num_SAP =", value, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapNotEqualTo(String value) {
            addCriterion("Lot_Num_SAP <>", value, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapGreaterThan(String value) {
            addCriterion("Lot_Num_SAP >", value, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapGreaterThanOrEqualTo(String value) {
            addCriterion("Lot_Num_SAP >=", value, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapLessThan(String value) {
            addCriterion("Lot_Num_SAP <", value, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapLessThanOrEqualTo(String value) {
            addCriterion("Lot_Num_SAP <=", value, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapLike(String value) {
            addCriterion("Lot_Num_SAP like", value, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapNotLike(String value) {
            addCriterion("Lot_Num_SAP not like", value, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapIn(List<String> values) {
            addCriterion("Lot_Num_SAP in", values, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapNotIn(List<String> values) {
            addCriterion("Lot_Num_SAP not in", values, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapBetween(String value1, String value2) {
            addCriterion("Lot_Num_SAP between", value1, value2, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andLotNumSapNotBetween(String value1, String value2) {
            addCriterion("Lot_Num_SAP not between", value1, value2, "lotNumSap");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("Step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("Step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(String value) {
            addCriterion("Step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(String value) {
            addCriterion("Step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(String value) {
            addCriterion("Step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(String value) {
            addCriterion("Step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(String value) {
            addCriterion("Step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(String value) {
            addCriterion("Step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLike(String value) {
            addCriterion("Step like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotLike(String value) {
            addCriterion("Step not like", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<String> values) {
            addCriterion("Step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<String> values) {
            addCriterion("Step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(String value1, String value2) {
            addCriterion("Step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(String value1, String value2) {
            addCriterion("Step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesIsNull() {
            addCriterion("Lot_Type_MES is null");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesIsNotNull() {
            addCriterion("Lot_Type_MES is not null");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesEqualTo(String value) {
            addCriterion("Lot_Type_MES =", value, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesNotEqualTo(String value) {
            addCriterion("Lot_Type_MES <>", value, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesGreaterThan(String value) {
            addCriterion("Lot_Type_MES >", value, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesGreaterThanOrEqualTo(String value) {
            addCriterion("Lot_Type_MES >=", value, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesLessThan(String value) {
            addCriterion("Lot_Type_MES <", value, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesLessThanOrEqualTo(String value) {
            addCriterion("Lot_Type_MES <=", value, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesLike(String value) {
            addCriterion("Lot_Type_MES like", value, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesNotLike(String value) {
            addCriterion("Lot_Type_MES not like", value, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesIn(List<String> values) {
            addCriterion("Lot_Type_MES in", values, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesNotIn(List<String> values) {
            addCriterion("Lot_Type_MES not in", values, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesBetween(String value1, String value2) {
            addCriterion("Lot_Type_MES between", value1, value2, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeMesNotBetween(String value1, String value2) {
            addCriterion("Lot_Type_MES not between", value1, value2, "lotTypeMes");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapIsNull() {
            addCriterion("Lot_Type_SAP is null");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapIsNotNull() {
            addCriterion("Lot_Type_SAP is not null");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapEqualTo(String value) {
            addCriterion("Lot_Type_SAP =", value, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapNotEqualTo(String value) {
            addCriterion("Lot_Type_SAP <>", value, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapGreaterThan(String value) {
            addCriterion("Lot_Type_SAP >", value, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapGreaterThanOrEqualTo(String value) {
            addCriterion("Lot_Type_SAP >=", value, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapLessThan(String value) {
            addCriterion("Lot_Type_SAP <", value, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapLessThanOrEqualTo(String value) {
            addCriterion("Lot_Type_SAP <=", value, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapLike(String value) {
            addCriterion("Lot_Type_SAP like", value, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapNotLike(String value) {
            addCriterion("Lot_Type_SAP not like", value, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapIn(List<String> values) {
            addCriterion("Lot_Type_SAP in", values, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapNotIn(List<String> values) {
            addCriterion("Lot_Type_SAP not in", values, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapBetween(String value1, String value2) {
            addCriterion("Lot_Type_SAP between", value1, value2, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andLotTypeSapNotBetween(String value1, String value2) {
            addCriterion("Lot_Type_SAP not between", value1, value2, "lotTypeSap");
            return (Criteria) this;
        }

        public Criteria andDefectcodeIsNull() {
            addCriterion("DefectCode is null");
            return (Criteria) this;
        }

        public Criteria andDefectcodeIsNotNull() {
            addCriterion("DefectCode is not null");
            return (Criteria) this;
        }

        public Criteria andDefectcodeEqualTo(String value) {
            addCriterion("DefectCode =", value, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeNotEqualTo(String value) {
            addCriterion("DefectCode <>", value, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeGreaterThan(String value) {
            addCriterion("DefectCode >", value, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeGreaterThanOrEqualTo(String value) {
            addCriterion("DefectCode >=", value, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeLessThan(String value) {
            addCriterion("DefectCode <", value, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeLessThanOrEqualTo(String value) {
            addCriterion("DefectCode <=", value, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeLike(String value) {
            addCriterion("DefectCode like", value, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeNotLike(String value) {
            addCriterion("DefectCode not like", value, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeIn(List<String> values) {
            addCriterion("DefectCode in", values, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeNotIn(List<String> values) {
            addCriterion("DefectCode not in", values, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeBetween(String value1, String value2) {
            addCriterion("DefectCode between", value1, value2, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodeNotBetween(String value1, String value2) {
            addCriterion("DefectCode not between", value1, value2, "defectcode");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescIsNull() {
            addCriterion("DefectCodeDesc is null");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescIsNotNull() {
            addCriterion("DefectCodeDesc is not null");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescEqualTo(Object value) {
            addCriterion("DefectCodeDesc =", value, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescNotEqualTo(Object value) {
            addCriterion("DefectCodeDesc <>", value, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescGreaterThan(Object value) {
            addCriterion("DefectCodeDesc >", value, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescGreaterThanOrEqualTo(Object value) {
            addCriterion("DefectCodeDesc >=", value, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescLessThan(Object value) {
            addCriterion("DefectCodeDesc <", value, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescLessThanOrEqualTo(Object value) {
            addCriterion("DefectCodeDesc <=", value, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescIn(List<Object> values) {
            addCriterion("DefectCodeDesc in", values, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescNotIn(List<Object> values) {
            addCriterion("DefectCodeDesc not in", values, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescBetween(Object value1, Object value2) {
            addCriterion("DefectCodeDesc between", value1, value2, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andDefectcodedescNotBetween(Object value1, Object value2) {
            addCriterion("DefectCodeDesc not between", value1, value2, "defectcodedesc");
            return (Criteria) this;
        }

        public Criteria andYieldgrpIsNull() {
            addCriterion("YieldGRP is null");
            return (Criteria) this;
        }

        public Criteria andYieldgrpIsNotNull() {
            addCriterion("YieldGRP is not null");
            return (Criteria) this;
        }

        public Criteria andYieldgrpEqualTo(String value) {
            addCriterion("YieldGRP =", value, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpNotEqualTo(String value) {
            addCriterion("YieldGRP <>", value, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpGreaterThan(String value) {
            addCriterion("YieldGRP >", value, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpGreaterThanOrEqualTo(String value) {
            addCriterion("YieldGRP >=", value, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpLessThan(String value) {
            addCriterion("YieldGRP <", value, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpLessThanOrEqualTo(String value) {
            addCriterion("YieldGRP <=", value, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpLike(String value) {
            addCriterion("YieldGRP like", value, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpNotLike(String value) {
            addCriterion("YieldGRP not like", value, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpIn(List<String> values) {
            addCriterion("YieldGRP in", values, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpNotIn(List<String> values) {
            addCriterion("YieldGRP not in", values, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpBetween(String value1, String value2) {
            addCriterion("YieldGRP between", value1, value2, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andYieldgrpNotBetween(String value1, String value2) {
            addCriterion("YieldGRP not between", value1, value2, "yieldgrp");
            return (Criteria) this;
        }

        public Criteria andRootcauseIsNull() {
            addCriterion("RootCause is null");
            return (Criteria) this;
        }

        public Criteria andRootcauseIsNotNull() {
            addCriterion("RootCause is not null");
            return (Criteria) this;
        }

        public Criteria andRootcauseEqualTo(String value) {
            addCriterion("RootCause =", value, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseNotEqualTo(String value) {
            addCriterion("RootCause <>", value, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseGreaterThan(String value) {
            addCriterion("RootCause >", value, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseGreaterThanOrEqualTo(String value) {
            addCriterion("RootCause >=", value, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseLessThan(String value) {
            addCriterion("RootCause <", value, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseLessThanOrEqualTo(String value) {
            addCriterion("RootCause <=", value, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseLike(String value) {
            addCriterion("RootCause like", value, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseNotLike(String value) {
            addCriterion("RootCause not like", value, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseIn(List<String> values) {
            addCriterion("RootCause in", values, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseNotIn(List<String> values) {
            addCriterion("RootCause not in", values, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseBetween(String value1, String value2) {
            addCriterion("RootCause between", value1, value2, "rootcause");
            return (Criteria) this;
        }

        public Criteria andRootcauseNotBetween(String value1, String value2) {
            addCriterion("RootCause not between", value1, value2, "rootcause");
            return (Criteria) this;
        }

        public Criteria andDefectqtyIsNull() {
            addCriterion("DefectQty is null");
            return (Criteria) this;
        }

        public Criteria andDefectqtyIsNotNull() {
            addCriterion("DefectQty is not null");
            return (Criteria) this;
        }

        public Criteria andDefectqtyEqualTo(BigDecimal value) {
            addCriterion("DefectQty =", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyNotEqualTo(BigDecimal value) {
            addCriterion("DefectQty <>", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyGreaterThan(BigDecimal value) {
            addCriterion("DefectQty >", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DefectQty >=", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyLessThan(BigDecimal value) {
            addCriterion("DefectQty <", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DefectQty <=", value, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyIn(List<BigDecimal> values) {
            addCriterion("DefectQty in", values, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyNotIn(List<BigDecimal> values) {
            addCriterion("DefectQty not in", values, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DefectQty between", value1, value2, "defectqty");
            return (Criteria) this;
        }

        public Criteria andDefectqtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DefectQty not between", value1, value2, "defectqty");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated do_not_delete_during_merge Mon Dec 28 09:59:22 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table MES.T_ProductionOrderStepScrap
     *
     * @mbggenerated Mon Dec 28 09:59:22 CST 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}