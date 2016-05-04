package com.scott.fu.dto;

/**
 * Created by ScottFu on 2016/2/4.
 */
public class EquipmentTM {
    private String daily;
    private String hourly;
    private Integer output = 0;
    private Integer wipAmount = 0;

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

    public Integer getOutput() {
        return output;
    }

    public void setOutput(Integer output) {
        this.output = output;
    }

    public Integer getWipAmount() {
        return wipAmount;
    }

    public void setWipAmount(Integer wipAmount) {
        this.wipAmount = wipAmount;
    }
}