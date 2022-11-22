package com.example.imd4008_a3;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Task {
    public String title;
    public Date date;
    public List<String> collaborators;
    public String type;

    public Task(String title, Date date,  List<String> collaborators, String type) {
        this.title = title;
        this.date = date;
        this.collaborators = collaborators;
        this.type = type;
    }

    public int getTypeColour() {
        switch (this.type) {
            case "DUE_DATE":
                return R.color.due_date;
            case "CLASS":
                return R.color.bg_class;
            case "EVENT":
                return R.color.event;
            case "MEETING":
                return R.color.meeting;
            default:
                // other / non-assigned
                return R.color.purple_500;
        }
    }
}
