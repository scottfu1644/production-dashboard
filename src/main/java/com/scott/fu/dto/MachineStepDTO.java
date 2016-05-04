package com.scott.fu.dto;

import java.util.List;

/**
 * Created by scottfu on 2016/3/9.
 */
public class MachineStepDTO {

    private String output;
    private String wip;
    private List<String> mCode;
    private List<String> machines;
    private Float target;

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getWip() {
        return wip;
    }

    public void setWip(String wip) {
        this.wip = wip;
    }

    public List<String> getmCode() {
        return mCode;
    }

    public void setmCode(List<String> mCode) {
        this.mCode = mCode;
    }

    public List<String> getMachines() {
        return machines;
    }

    public void setMachines(List<String> machines) {
        this.machines = machines;
    }

    public Float getTarget() {
        return target;
    }

    public void setTarget(Float target) {
        this.target = target;
    }
}
