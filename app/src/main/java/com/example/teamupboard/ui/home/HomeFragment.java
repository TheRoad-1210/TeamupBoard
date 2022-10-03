package com.example.teamupboard.ui.home;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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


public class HomeFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private CardMasterAdapter cardMasterAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home,container,false);
        initRecyclerView();
        return view;

    }

    /**
     * 对RecyclerView进行配置
     */
    @SuppressLint("NotifyDataSetChanged")
    private void initRecyclerView(){
        recyclerView = view.findViewById(R.id.card_master_list);
        String[] data = {"1","1","hao","2","o","o"};

        cardMasterAdapter = new CardMasterAdapter(this.getActivity(),data);
        recyclerView.setAdapter(cardMasterAdapter);


//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        System.out.println(cardMasterAdapter.getItemCount());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        cardMasterAdapter.notifyDataSetChanged();

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.top_home_menu,menu);
    }

    //    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//
//        //顶部应用栏+标签
//        NavController navController = Navigation.findNavController(view);
//        AppBarConfiguration appBarConfiguration =
//                new AppBarConfiguration.Builder(R.id.navigation_home).build();
//        Toolbar toolbar = view.findViewById(R.id.toolbar_home);
//
//        NavigationUI.setupWithNavController(
//                toolbar,navController,appBarConfiguration
//
//        );
//
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}