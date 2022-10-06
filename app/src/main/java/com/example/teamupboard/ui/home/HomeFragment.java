package com.example.teamupboard.ui.home;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.teamupboard.R;
import com.example.teamupboard.adapter.CardMasterAdapter;
import com.example.teamupboard.model.TeamupBoard;
import com.example.teamupboard.register.data.model.User;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


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

//    /**
//     * 对RecyclerView进行配置
//     */
//    @SuppressLint("NotifyDataSetChanged")
//    private void initRecyclerView(){
//        recyclerView = view.findViewById(R.id.card_master_list);
//        String[] strings = {"食物","美食","测试"};
//
//        for (int i = 0; i < 10; i++) {
//            TeamupBoard teamupBoard = new TeamupBoard(
//                    String.valueOf(i+10000),
//                    String.valueOf(i+10000),
//                    "甜食是人类最简单最初始的美食体验，蜂蜜的主要成分是果糖和葡萄糖，作为早期人类唯一的甜食，蜂蜜能快速产生热量，补充体力" +
//                            "这对我们的祖先至关重要，和人工提炼的蔗糖不同，蜂蜜中的糖，不经过水解，就可以直接被人体吸收。在中国的厨房，无论制作菜肴还是甜点，" +
//                            "蜂蜜都是其他糖类无法替代的。当然，白马甲最喜欢的是酥油蜂蜜。\n",
//                    strings,
//                    BitmapFactory.decodeResource(getResources(),R.drawable.cat)
//            );
//            boards.add(teamupBoard);
//        }
//        cardMasterAdapter = new CardMasterAdapter(this.getActivity(),boards);
//        recyclerView.setAdapter(cardMasterAdapter);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(),2);
//        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        cardMasterAdapter.notifyDataSetChanged();
//
//    }

    private void initTabLayout(){
        List<CardFragment> cardFragmentList = new ArrayList<>();
        TabLayout tabLayout = view.findViewById(R.id.home_tab);
        ViewPager viewPager = view.findViewById(R.id.home_view);
        tabLayout.addTab(tabLayout.newTab().setText("本地"));
        cardFragmentList.add(CardFragment.newInstance("本地"));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.home_tabs_online));
        cardFragmentList.add(CardFragment.newInstance("线上"));
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return cardFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return cardFragmentList.size();
            }

        };
        viewPager.setAdapter(fragmentPagerAdapter);
        fragmentPagerAdapter.notifyDataSetChanged();

        tabLayout.setupWithViewPager(viewPager,false);
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