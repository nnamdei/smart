package com.kunle.smartair.model;

import java.io.Serializable;

/**
 * Created by Habeex on 9/17/2017.
 */

public class BookingCheckOut implements Serializable{
    public static final String EXTRA = "com.kunle.smartair.BOOKING_CHECK_OUT_EXTRA";
    String departure;
    String destination;
    String adult;
    String children;
    String infant;
    String oneWayRB;
    String returnRB;
    String onDate;
    String offDate;
    String EditValueName;
    String EditValueAddress;

    public String getEditValueName() {
        return EditValueName;
    }

    public void setEditValueName(String editValueName) {
        EditValueName = editValueName;
    }

    public String getEditValueAddress() {
        return EditValueAddress;
    }

    public void setEditValueAddress(String editValueAddress) {
        EditValueAddress = editValueAddress;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getInfant() {
        return infant;
    }

    public void setInfant(String infant) {
        this.infant = infant;
    }

    public String getOneWayRB() {
        return oneWayRB;
    }

    public void setOneWayRB(String oneWayRB) {
        this.oneWayRB = oneWayRB;
    }

    public String getReturnRB() {
        return returnRB;
    }

    public void setReturnRB(String returnRB) {
        this.returnRB = returnRB;
    }

    public String getOnDate() {
        return onDate;
    }

    public void setOnDate(String onDate) {
        this.onDate = onDate;
    }

    public String getOffDate() {
        return offDate;
    }

    public void setOffDate(String offDate) {
        this.offDate = offDate;
    }
}
