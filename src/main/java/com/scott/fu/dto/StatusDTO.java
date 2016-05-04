package com.scott.fu.dto;

/**
 * Created by scottfu on 2016/3/30.
 */
public class StatusDTO {
    private String systemState;
    private Integer lotCount;
    private Integer holdLots;

    public String getSystemState() {
        return systemState;
    }

    public void setSystemState(String systemState) {
        this.systemState = systemState;
    }

    public Integer getLotCount() {
        return lotCount;
    }

    public void setLotCount(Integer lotCount) {
        this.lotCount = lotCount;
    }

    public Integer getHoldLots() {
        return holdLots;
    }

    public void setHoldLots(Integer holdLots) {
        this.holdLots = holdLots;
    }
}
