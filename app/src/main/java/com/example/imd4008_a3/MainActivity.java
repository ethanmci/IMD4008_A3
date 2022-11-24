package com.example.imd4008_a3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.example.imd4008_a3.ui.createTask.CreateTaskFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> taskList;
    FloatingActionButton addFab;
    FragmentContainerView fcv;
    FragmentManager fm;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = new Bundle();
        setContentView(R.layout.main_activity);
        fcv = findViewById(R.id.nav_fragment_host);
        fm = getSupportFragmentManager();
        taskList = new ArrayList<Task>();

        addFab = findViewById(R.id.addFab);
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("FAB", "fab clicked!");
                changeFragment(CreateTaskFragment.class);
            }
        });
    }

    public void addTask(Task newTask) {
        taskList.add(newTask);
        bundle.putParcelableArrayList("taskList", taskList);
        Log.d("TASKLIST", taskList.toString());
    }

    public Bundle getData() {
        return bundle;
    }

    public void changeFragment(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.nav_fragment_host, fragment, null);
        ft.commit();
    }


}