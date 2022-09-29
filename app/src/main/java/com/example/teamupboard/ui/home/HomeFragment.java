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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamupboard.R;
import com.example.teamupboard.adapter.CardMasterAdapter;
import com.example.teamupboard.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

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

        //卡片
        RecyclerView recyclerView = view.findViewById(R.id.card_master_list);
        String[] data = {"ashkghfuaaghjkhfaishgauighlaghg","ioahoighhagghlahgulhadguagn","haogafgadgdfggiyhoha"};
        CardMasterAdapter cardMasterAdapter = new CardMasterAdapter(data);
        recyclerView.setAdapter(cardMasterAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}