package com.example.teamupboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.DrawableUtils;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamupboard.R;
import com.example.teamupboard.model.TeamupBoard;
import com.example.teamupboard.register.data.model.User;
import com.example.teamupboard.util.RoundImageView;

import java.util.ArrayList;

/**
 * 主页卡片recyclerview的adapter
 */
public class CardMasterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<TeamupBoard> data;


    public class MasterViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final CardView cardView;
        private final TextView title;
        private final RoundImageView picture;
        private final RecyclerView recyclerView;

        public MasterViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.card_master_text);
            cardView = itemView.findViewById(R.id.card_master);
            title = itemView.findViewById(R.id.card_master_title);
            picture = itemView.findViewById(R.id.card_master_image);
            recyclerView = itemView.findViewById(R.id.card_master_type_list);

            //设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"click",Toast.LENGTH_SHORT).show();
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }

        public CardView getCardView() {
            return cardView;
        }

        public TextView getTitle() {
            return title;
        }

        public RoundImageView getPicture() {
            return picture;
        }

        public RecyclerView getRecyclerView() {
            return recyclerView;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.card_master,parent,false);

        return new MasterViewHolder(view);
    }

    //绑定数据
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MasterViewHolder) holder).getTextView().setText(data.get(position).getTbDetail());
        ((MasterViewHolder) holder).getTitle().setText(data.get(position).getTbTitle());
        ((MasterViewHolder) holder).getPicture().setImageBitmap(data.get(position).getTbMasterPicture());
        CardMasterTypeAdapter cardMasterTypeAdapter = new CardMasterTypeAdapter(context, data.get(position).getTbType());
        ((MasterViewHolder) holder).getRecyclerView().setAdapter(cardMasterTypeAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        ((MasterViewHolder) holder).getRecyclerView().setLayoutManager(gridLayoutManager);
//        cardMasterTypeAdapter.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public CardMasterAdapter(Context context, ArrayList<TeamupBoard> data){
        //数据源、布局填充器
        this.data = data;
        this.context = context;
    }
}
