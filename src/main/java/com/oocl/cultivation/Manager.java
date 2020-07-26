package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class Manager{

    public List<Boy> getManagementList() {
        return managementList;
    }

    public Manager() {

    }

    public void setManagementList(List<Boy> managementList) {
        this.managementList = managementList;
    }

    private List<Boy> managementList = new ArrayList<Boy>();

    public void addMember(Boy memeber) {
        managementList.add(memeber);
    }
}
