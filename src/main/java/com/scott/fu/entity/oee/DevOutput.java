package com.scott.fu.entity.oee;

import java.util.Date;

/**
 * Created by ScottFu on 2016/1/11.
 */
public class DevOutput {
    private Integer hourly;
    private String date;
    private Integer output;
    private Integer dNVOutput;
    private Integer tNVOutput;
    private Integer dNVWIP;
    private Integer tNVWIP;

    public Integer getHourly() {
        return hourly;
    }

    public void setHourly(Integer hourly) {
        this.hourly = hourly;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getOutput() {
        return output;
    }

    public void setOutput(Integer output) {
        this.output = output;
    }

    public Integer getdNVOutput() {
        return dNVOutput;
    }

    public void setdNVOutput(Integer dNVOutput) {
        this.dNVOutput = dNVOutput;
    }

    public Integer gettNVOutput() {
        return tNVOutput;
    }

    public void settNVOutput(Integer tNVOutput) {
        this.tNVOutput = tNVOutput;
    }

    public Integer getdNVWIP() {
        return dNVWIP;
    }

    public void setdNVWIP(Integer dNVWIP) {
        this.dNVWIP = dNVWIP;
    }

    public Integer gettNVWIP() {
        return tNVWIP;
    }

    public void settNVWIP(Integer tNVWIP) {
        this.tNVWIP = tNVWIP;
    }
}
