package com.scott.fu.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by ScottFu on 2016/1/11.
 */
public class EquipmentTMDTO{

    private String date;
    private String target;
    private List<EquipmentTM> equipmentTMList;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<EquipmentTM> getEquipmentTMList() {
        return equipmentTMList;
    }

    public void setEquipmentTMList(List<EquipmentTM> equipmentTMList) {
        this.equipmentTMList = equipmentTMList;
    }
}

