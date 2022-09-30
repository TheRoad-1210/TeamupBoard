package com.example.teamupboard.ui.trend;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamupboard.R;
import com.example.teamupboard.databinding.FragmentTrendBinding;

public class TrendFragment extends Fragment {

    private View view;
    private Toolbar toolbar;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_trend,container,false);
        toolbar = view.findViewById(R.id.toolbar_trend);
        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }
}