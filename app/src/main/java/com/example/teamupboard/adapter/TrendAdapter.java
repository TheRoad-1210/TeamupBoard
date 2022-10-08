package com.example.teamupboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamupboard.R;

import java.util.ArrayList;

public class TrendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private String[] data;

    public class TrendViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;
        public TrendViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tag_list_text);
        }

        public TextView getTextView() {
            return textView;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_item,parent,false);
        return new TrendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TrendViewHolder)holder).getTextView().setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public TrendAdapter(Context context, String[] data){
        this.context = context;
        this.data = data;
    }
}
