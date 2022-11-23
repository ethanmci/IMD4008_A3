package com.example.imd4008_a3.ui.createTask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.imd4008_a3.R;
import com.example.imd4008_a3.Task;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateTaskFragment extends Fragment {
    public CreateTaskFragment() {
        super(R.layout.add_event_layout);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_event_layout, container, false);
        return root;
    }
}
