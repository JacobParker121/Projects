package com.example.habittracker;

import android.icu.util.Calendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * Creates a current timestamp for keeping track of habit activities.
 *
 * @author Ryan Porter
 * @version 1.0
 * @since 2022-02-25
 */
public class TimeTracker {
    LocalDate rightNow = LocalDate.now();
    DateTimeFormatter f = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    String timestamp;
    long epochTime = System.currentTimeMillis();

    public TimeTracker() {
        timestamp = rightNow.format(f);
    }

    public String getTimeStamp() {
        return timestamp;
    }
    public long getEpochTime() { return epochTime; }

}