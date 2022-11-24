package com.example.imd4008_a3;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Task implements Parcelable {
    public String title;
    public Date date;
    public List<String> collaborators;
    public String type;

    public Task(String title, Date date, List<String> collaborators, String type) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
        dest.writeStringList(this.collaborators);
        dest.writeString(this.type);
    }

    public void readFromParcel(Parcel source) {
        this.title = source.readString();
        long tmpDate = source.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.collaborators = source.createStringArrayList();
        this.type = source.readString();
    }

    protected Task(Parcel in) {
        this.title = in.readString();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
        this.collaborators = in.createStringArrayList();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
