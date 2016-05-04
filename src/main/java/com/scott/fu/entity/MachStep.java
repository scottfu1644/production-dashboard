package com.scott.fu.entity;

/**
 * Created by scottfu on 2016/3/9.
 */
public class MachStep {
    private String tITLE;
    private String tARGET;
    private String wIP_FORM;
    private String oUTPUT_FORM;
    private String machines;
    private String mCode;
    private String department;

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

    public String getwIP_FORM() {
        return wIP_FORM;
    }

    public void setwIP_FORM(String wIP_FORM) {
        this.wIP_FORM = wIP_FORM;
    }

    public String getoUTPUT_FORM() {
        return oUTPUT_FORM;
    }

    public void setoUTPUT_FORM(String oUTPUT_FORM) {
        this.oUTPUT_FORM = oUTPUT_FORM;
    }

    public String getMachines() {
        return machines;
    }

    public void setMachines(String machines) {
        this.machines = machines;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
