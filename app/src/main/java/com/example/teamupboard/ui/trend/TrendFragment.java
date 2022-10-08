package com.example.teamupboard.ui.trend;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamupboard.R;
import com.example.teamupboard.adapter.CardMasterAdapter;
import com.example.teamupboard.adapter.TabAdapter;
import com.example.teamupboard.adapter.TrendAdapter;
import com.example.teamupboard.databinding.FragmentTrendBinding;
import com.example.teamupboard.model.TeamupBoardDAO;
import com.example.teamupboard.ui.home.CardFragment;
import com.google.android.material.tabs.TabLayout;

public class TrendFragment extends Fragment {

    private View view;
    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_trend,container,false);
        toolbar = view.findViewById(R.id.toolbar_trend);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView(){
        recyclerView = view.findViewById(R.id.tag_list);

        recyclerView.setAdapter(new TrendAdapter(this.getActivity(), new String[]{"1、kfc", "2、测试", "3、疯狂"}));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(),1);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }
}