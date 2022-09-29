package com.example.teamupboard.ui.trend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamupboard.R;
import com.example.teamupboard.databinding.FragmentTrendBinding;

public class TrendFragment extends Fragment {

    private FragmentTrendBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTrendBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}