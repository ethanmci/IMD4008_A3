package com.example.imd4008_a3.ui.createTask;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.imd4008_a3.MainActivity;
import com.example.imd4008_a3.R;
import com.example.imd4008_a3.Task;
import com.example.imd4008_a3.ui.home.HomeFragment;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CreateTaskFragment extends Fragment {
    Button cancelBtn;
    Button saveBtn;
    Spinner typeSp;

    public CreateTaskFragment() {
        super(R.layout.add_event_layout);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_event_layout, container, false);
        cancelBtn = root.findViewById(R.id.cancelButton);
        saveBtn = root.findViewById(R.id.saveButton);
        typeSp = root.findViewById(R.id.eventType);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).changeFragment(HomeFragment.class);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (true) {
                    Date d = new Date();
                    Task newTask = new Task("Created Task",
                            d,
                            new ArrayList<String>(),
                            typeSp.getSelectedItem().toString());
                    Log.d("TASK", newTask.toString());

                    ((MainActivity) getActivity()).addTask(newTask);
                    ((MainActivity) getActivity()).changeFragment(HomeFragment.class);
                }
            }
        });

        return root;
    }
}
