package com.scott.fu.entity.oee;

/**
 * Created by ScottFu on 2016/2/23.
 */
public class BaseTrackOutAndWIP {
    private Integer hourly;
    private Float target;

    public Float getTarget() {
        return target;
    }

    public void setTarget(Float target) {
        this.target = target;
    }

    public Integer getHourly() {

        return hourly;
    }

    public void setHourly(Integer hourly) {
        this.hourly = hourly;
    }
}
