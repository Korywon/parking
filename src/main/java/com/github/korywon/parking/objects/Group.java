package com.github.korywon.parking.objects;

import java.util.List;

public class Group {
    protected String groupName;
    protected float groupPrice;

    public Group() {
        this.groupName = "";
        this.groupPrice = 0.0f;
    }

    public Group(String name, float price) {
        this.groupName = name;
        this.groupPrice = price;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String name) {
        this.groupName = name;
    }

    public float getGroupPrice() {
        return this.groupPrice;
    }

    public void setGroupPrice(float price) {
        this.groupPrice = price;
    }

    public void printInfo() {
        System.out.println(
            "----- Group -----" + "\n" +
            "Group name: " + this.groupName + "\n" +
            "Group price: " + this.groupPrice
        );
    }

    public static int indexOfGroupList(List<Group> groupList, String groupName) {
        for (int i = 0 ; i < groupList.size(); i++) {
            if (groupList.get(i).getGroupName().equals(groupName)) {
                return i;
            }
        }
        return -1;
    }
}
