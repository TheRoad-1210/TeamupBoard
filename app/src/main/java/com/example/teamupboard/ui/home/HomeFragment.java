package com.example.teamupboard.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.teamupboard.R;
import com.example.teamupboard.adapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {
    private View view;
//    private RecyclerView recyclerView;
//    private CardMasterAdapter cardMasterAdapter;
//    private ArrayList<TeamupBoard> boards = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
//        initRecyclerView();
        initTabLayout();
        return view;

    }


    private void initTabLayout(){
        TabLayout tabLayout = view.findViewById(R.id.home_tab);
        ViewPager viewPager = view.findViewById(R.id.home_view);
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
        tabAdapter.addFragment(CardFragment.newInstance("本地",false));
        tabAdapter.addFragment(CardFragment.newInstance("线上",true));
        String[] strings = {"本地","线上"};
        tabAdapter.setTitleArray(strings);
        viewPager.setAdapter(tabAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.top_home_menu,menu);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}