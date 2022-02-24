package com.alm.onlinereservation.model;

import javax.persistence.*;

@Embeddable
public class Side {

    private String name;
    private int teamID;
    private String status;

    public Side(String name, int teamID, String status) {
        this.name = name;
        this.teamID = teamID;
        this.status = status;
    }

    public Side() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
