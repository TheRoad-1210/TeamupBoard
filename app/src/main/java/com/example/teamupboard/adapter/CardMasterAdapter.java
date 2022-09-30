package com.example.teamupboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamupboard.R;

/**
 * 主页卡片recyclerview的adapter
 */
public class CardMasterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private String[] data;


    public class MasterViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final CardView cardView;

        public MasterViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.card_master_test);
            cardView = itemView.findViewById(R.id.card_master);
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
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.card_master,parent,false);

        return new MasterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MasterViewHolder) holder).getTextView().setText(data[position]);
        System.out.println(data[position]);
    }


    @Override
    public int getItemCount() {
        return data.length;
    }


    public CardMasterAdapter(Context context, String[] data){
        //数据源、布局填充器
        this.data = data;
        this.context = context;
    }
}
