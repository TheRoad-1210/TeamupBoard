package com.example.teamupboard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamupboard.R;

/**
 * 主页card的adapter，Data为卡片上显示数据
 */
public class CardMasterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] data;

    public static class MasterViewHolder extends RecyclerView.ViewHolder{

//        private final CardView cardView;
        private final TextView textView;

        public MasterViewHolder(@NonNull View itemView) {
            super(itemView);
//            cardView = itemView.findViewById(R.id.card_master);
            textView = itemView.findViewById(R.id.card_master_test);
        }

//        public CardView getCardView(){
//            return cardView;
//        }

        public TextView getTextView() {
            return textView;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_master,parent,false);
        return new MasterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MasterViewHolder) holder).getTextView().setText(data[position]);
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public CardMasterAdapter(String[] data){
        this.data = data;
    }
}
