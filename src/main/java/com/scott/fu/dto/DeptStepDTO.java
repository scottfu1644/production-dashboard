package com.scott.fu.dto;

import java.util.List;

/**
 * Created by scottfu on 2016/4/7.
 */
public class DeptStepDTO {
    String deptName;
    private List<MachineStepDTO> stepMachines;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<MachineStepDTO> getStepMachines() {
        return stepMachines;
    }

    public void setStepMachines(List<MachineStepDTO> stepMachines) {
        this.stepMachines = stepMachines;
    }
}
