package com.scott.fu.entity.test;

/**
 * Created by scottfu on 2015/12/23.
 */
public class Shop {
    private String name;
    private String staffName[];

    public String[] getStaffName() {
        return staffName;
    }

    public void setStaffName(String[] staffName) {
        this.staffName = staffName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
