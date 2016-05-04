package com.scott.fu.entity.oee;

import java.util.Date;

/**
 * Created by ScottFu on 2016/1/22.
 */

public class MaterialTAndMHistory {
    private String daily;
    private String hourly;
    private String m_CODE;
    private String tITLE;
    private String tARGET;
    private String oUTPUT_FORM;
    private String wIP_FORM;
    private String outputQuantity;
    private String measuredQuantity;
    private String wIPLots;
    private String wIPQuantity;

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getHourly() {
        return hourly;
    }

    public void setHourly(String hourly) {
        this.hourly = hourly;
    }

    public String getM_CODE() {
        return m_CODE;
    }

    public void setM_CODE(String m_CODE) {
        this.m_CODE = m_CODE;
    }

    public String gettITLE() {
        return tITLE;
    }

    public void settITLE(String tITLE) {
        this.tITLE = tITLE;
    }

    public String gettARGET() {
        return tARGET;
    }

    public void settARGET(String tARGET) {
        this.tARGET = tARGET;
    }

    public String getoUTPUT_FORM() {
        return oUTPUT_FORM;
    }

    public void setoUTPUT_FORM(String oUTPUT_FORM) {
        this.oUTPUT_FORM = oUTPUT_FORM;
    }

    public String getwIP_FORM() {
        return wIP_FORM;
    }

    public void setwIP_FORM(String wIP_FORM) {
        this.wIP_FORM = wIP_FORM;
    }

    public String getOutputQuantity() {
        return outputQuantity;
    }

    public void setOutputQuantity(String outputQuantity) {
        this.outputQuantity = outputQuantity;
    }

    public String getMeasuredQuantity() {
        return measuredQuantity;
    }

    public void setMeasuredQuantity(String measuredQuantity) {
        this.measuredQuantity = measuredQuantity;
    }

    public String getwIPLots() {
        return wIPLots;
    }

    public void setwIPLots(String wIPLots) {
        this.wIPLots = wIPLots;
    }

    public String getwIPQuantity() {
        return wIPQuantity;
    }

    public void setwIPQuantity(String wIPQuantity) {
        this.wIPQuantity = wIPQuantity;
    }
}
