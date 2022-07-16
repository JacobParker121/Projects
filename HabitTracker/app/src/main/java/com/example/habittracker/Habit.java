package com.example.habittracker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;

public class Habit {

    String name;
    long startDate;
    String notificationTime;
    int count;
    HashMap<String, Boolean> stats = new HashMap<String, Boolean>();


    /**
     * Habit object
     * @param n habit name
     * @param s start date
     * @param nT notification time
     */
     Habit(String n, Integer s, String nT) {
        name = n;
        startDate = s;
        notificationTime = nT;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartDate() {
        return startDate;
    }

    public int getCount() {
        return count ;
    }

    public int setCount(int count) {
        this.count = count;
        return count;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public String getReadableStartDate() {
         Instant instant = Instant.ofEpochMilli(startDate);
         LocalDate date = Instant.ofEpochMilli(startDate).atZone(ZoneId.of("UTC"))
                 .toLocalDate();
         return date.toString();
    }

}
