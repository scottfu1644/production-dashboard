package com.scott.fu.dto;

import com.scott.fu.entity.oee.MachinesDaily;
import com.scott.fu.util.DateUtil;

import java.util.List;

/**
 * Created by ScottFu on 2015/12/28.
 */
public class EquipmentStatusDTO {

    private Integer interval;
    private String equipmentName;
    private Boolean isNightShift;
    private List<MachinesDaily> machinesDailyList;
    private Integer currentStatus;

    private Integer[] timeScale;

    private Integer durationMiliSec;

    private String beginTime;
    private String endTime;

    private Long beginTimeMilli;
    private Long endTimeMilli;

    public Integer[] getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(Integer[] timeScale) {
        this.timeScale = timeScale;
    }

    public Long getBeginTimeMilli() {
        return beginTimeMilli;
    }

    public Long getEndTimeMilli() {
        return endTimeMilli;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Boolean getIsNightShift() {
        return isNightShift;
    }

    public void setIsNightShift(Boolean isNightShift) {
        this.isNightShift = isNightShift;
    }

    public List<MachinesDaily> getMachinesDailyList() {
        return machinesDailyList;
    }

    public void setMachinesDailyList(List<MachinesDaily> machinesDailyList) {
        this.machinesDailyList = machinesDailyList;
    }

    public Integer getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Integer currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
        this.beginTimeMilli = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).parse(beginTime).getTime();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
        this.endTimeMilli = DateUtil.getInstance(DateUtil.DATE_TIME_SEC_CN).parse(endTime).getTime();
    }

    public Integer getDurationMiliSec() {
        return durationMiliSec;
    }

    public void setDurationMiliSec(Integer durationMiliSec) {
        this.durationMiliSec = durationMiliSec;
    }
}

