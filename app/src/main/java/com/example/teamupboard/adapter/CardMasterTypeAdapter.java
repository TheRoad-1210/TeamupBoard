package com.example.teamupboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamupboard.R;

public class CardMasterTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private String[] data;

    public class TypeHolder extends RecyclerView.ViewHolder{
        private final TextView textView;

        public TypeHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.type_text);
        }

        public TextView getTextView() {
            return textView;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.card_master_type,parent,false);

        return new TypeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TypeHolder)holder).getTextView().setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public CardMasterTypeAdapter(Context context, String[] data){
        this.data = data;
        this.context = context;
    }
}
