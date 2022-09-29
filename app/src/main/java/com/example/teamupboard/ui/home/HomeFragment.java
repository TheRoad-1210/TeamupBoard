package com.example.teamupboard.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.teamupboard.R;
import com.example.teamupboard.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //顶部应用栏+标签
        NavController navController = Navigation.findNavController(view);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.navigation_home).build();
        Toolbar toolbar = view.findViewById(R.id.toolbar_home);

        NavigationUI.setupWithNavController(
                toolbar,navController,appBarConfiguration
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}