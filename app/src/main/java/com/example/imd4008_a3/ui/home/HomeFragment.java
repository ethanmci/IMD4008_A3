package com.example.imd4008_a3.ui.home;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.imd4008_a3.MainActivity;
import com.example.imd4008_a3.R;
import com.example.imd4008_a3.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class HomeFragment extends Fragment {
    LinearLayout todoView;
    List<Task> taskList;

    public HomeFragment() {
        super(R.layout.home_layout);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.home_layout, container, false);
        Bundle bundle = ((MainActivity) getActivity()).getData();
        //TODO: PICK UP FROM HERE!
        //Log.d("BUNDLE", bundle.getParcelableArrayList("taskList").toString());
        taskList = new ArrayList<>();

        //taskList =
        /*
        todoView = root.findViewById(R.id.todoViewLayout);
        for(int i = 0; i <= 10; i++) {
            Calendar c = Calendar.getInstance();
            taskList.add(new Task(
                    "Title: " + i, c.getTime(), new ArrayList<>(), "EVENT"
            ));
        }
        */
        buildTodoList(todoView, taskList);
        return root;
    }

    void buildTodoList(LinearLayout tv, List<Task> tasks) {
        tv.removeAllViews();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            View eventCard = getLayoutInflater().inflate(R.layout.event_template, null);
            Space sp = new Space(getContext());
            TextView tt = eventCard.findViewById(R.id.taskTitle);
            CardView card = eventCard.findViewById(R.id.taskCard);
            tt.setText(task.title);

            TextView ttime = eventCard.findViewById(R.id.taskTime);
            SimpleDateFormat df = new SimpleDateFormat("h:mm a");
            ttime.setText(df.format(task.date));
            card.setCardBackgroundColor(getResources().getColor(task.getTypeColour()));

            tv.addView(eventCard);
            tv.addView(sp);
            // adding extra padding if we've reached the end
            if(i + 1 == tasks.size())
                sp.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.todoSpacerDp) * 5;
            else
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
                                        (com.google.android.material.R.color.material_dynamic_neutral10));
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
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
