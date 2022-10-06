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

import java.util.ArrayList;

public class CardFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private CardMasterAdapter cardMasterAdapter;
    private ArrayList<TeamupBoard> boards = new ArrayList<>();

    public CardFragment() {
        // Required empty public constructor
    }

    public static CardFragment newInstance(String label){
        Bundle args = new Bundle();
        args.putString("label",label);
        CardFragment cardFragment = new CardFragment();
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
        String[] strings = {"食物","美食","测试"};

        for (int i = 0; i < 10; i++) {
            TeamupBoard teamupBoard = new TeamupBoard(
                    String.valueOf(i+10000),
                    String.valueOf(i+10000),
                    "甜食是人类最简单最初始的美食体验，蜂蜜的主要成分是果糖和葡萄糖，作为早期人类唯一的甜食，蜂蜜能快速产生热量，补充体力" +
                            "这对我们的祖先至关重要，和人工提炼的蔗糖不同，蜂蜜中的糖，不经过水解，就可以直接被人体吸收。在中国的厨房，无论制作菜肴还是甜点，" +
                            "蜂蜜都是其他糖类无法替代的。当然，白马甲最喜欢的是酥油蜂蜜。\n",
                    strings,
                    BitmapFactory.decodeResource(getResources(),R.drawable.cat)
            );
            boards.add(teamupBoard);
        }
        cardMasterAdapter = new CardMasterAdapter(this.getActivity(),boards);
        recyclerView.setAdapter(cardMasterAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        cardMasterAdapter.notifyDataSetChanged();

    }
}