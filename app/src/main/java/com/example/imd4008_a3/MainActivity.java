package com.example.imd4008_a3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Build;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout todoView;
    List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskList = new ArrayList<>();

        todoView = findViewById(R.id.todoViewLayout);
        for(int i = 0; i <= 10; i++) {
            Calendar c = Calendar.getInstance();
            taskList.add(new Task(
                    "Title: " + i, c.getTime(), new ArrayList<>()
            ));
        }
        buildTodoList(todoView, taskList);
    }

    void buildTodoList(LinearLayout tv, List<Task> tasks) {
        tv.removeAllViews();
        for(Task task : tasks) {
            View eventCard = getLayoutInflater().inflate(R.layout.event_template, null);
            Space sp = new Space(this);
            TextView tt = eventCard.findViewById(R.id.taskTitle);
            tt.setText(task.title);

            TextView ttime = eventCard.findViewById(R.id.taskTime);
            SimpleDateFormat df = new SimpleDateFormat("h:mm a");
            ttime.setText(df.format(task.date));

            tv.addView(eventCard);
            tv.addView(sp);
            sp.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.todoSpacerDp);

            eventCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickCard(view);
                }
            });

            eventCard.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    CardView tc = view.findViewById(R.id.taskCard);
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        tc.setBackgroundTintList(getResources()
                                .getColorStateList
                                        (com.google.android.material.R.color.material_dynamic_neutral20));
                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        tc.setBackgroundTintList(null);
                    }
                    return false;
                }
            });
        }
    }

    public void clickCard(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            // using haptic feedback for every button press
            v.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS);
        }
    }
}