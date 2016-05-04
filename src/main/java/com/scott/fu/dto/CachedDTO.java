package com.scott.fu.dto;

import java.io.Serializable;

/**
 * Created by ScottFu on 2016/1/20.
 */
public class CachedDTO implements Serializable{

    private Integer hour;
    private String machineType;
    private Float WIPHourly;
    private Float trackOutHourly;
    private Float measuredHourly;

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public Float getWIPHourly() {
        return WIPHourly;
    }

    public void setWIPHourly(Float WIPHourly) {
        this.WIPHourly = WIPHourly;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Float getTrackOutHourly() {
        return trackOutHourly;
    }

    public void setTrackOutHourly(Float trackOutHourly) {
        this.trackOutHourly = trackOutHourly;
    }

    public Float getMeasuredHourly() {
        return measuredHourly;
    }

    public void setMeasuredHourly(Float measuredHourly) {
        this.measuredHourly = measuredHourly;
    }
}
