package com.example.teamupboard.ui.home;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamupboard.R;
import com.example.teamupboard.adapter.CardMasterAdapter;
import com.example.teamupboard.model.TeamupBoard;
import com.example.teamupboard.model.TeamupBoardDAO;

import java.util.ArrayList;

public class CardFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private CardMasterAdapter cardMasterAdapter;
    private ArrayList<TeamupBoard> boards;
    private ArrayList<TeamupBoard> boards2;
    private Boolean online;


    public CardFragment(Boolean online) {
        this.online = online;
    }

    public static CardFragment newInstance(String label, Boolean online){
        Bundle args = new Bundle();
        args.putString("label",label);
        CardFragment cardFragment = new CardFragment(online);
        cardFragment.setArguments(args);
        return cardFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_card,container,false);
        initRecyclerView();
        return view;
    }


    /**
     * 对RecyclerView进行配置
     */
    @SuppressLint("NotifyDataSetChanged")
    private void initRecyclerView(){
        recyclerView = view.findViewById(R.id.card_master_list);
        recyclerView2 = view.findViewById(R.id.card_master_listpro);

        boards = new TeamupBoardDAO(this).getTeamupBoards(false,online);
        recyclerView.setAdapter(new CardMasterAdapter(this.getActivity(),boards));

        boards2 = new TeamupBoardDAO(this).getTeamupBoards(true,online);
        recyclerView2.setAdapter(new CardMasterAdapter(this.getActivity(),boards2));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(),1);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this.getActivity(),1);
        gridLayoutManager2.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView2.setLayoutManager(gridLayoutManager2);
    }
}