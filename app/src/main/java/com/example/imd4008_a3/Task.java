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

    public Task(String title, Date date,  List<String> collaborators) {
        this.title = title;
        this.date = date;
        this.collaborators = collaborators;
    }
}
