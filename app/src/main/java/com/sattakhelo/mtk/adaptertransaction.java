package com.sattakhelo.mtk;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class adaptertransaction extends RecyclerView.Adapter<adaptertransaction.ViewHolder> {

    Context context;
    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> remark = new ArrayList<>();
    ArrayList<String> amount = new ArrayList<>();
    ArrayList<String> type = new ArrayList<>();
    ArrayList<String> remark1 = new ArrayList<>();

    public adaptertransaction(Context context,ArrayList<String> date,ArrayList<String> remark,ArrayList<String> amount,ArrayList<String> type,ArrayList<String> remark1) {
        this.context = context;
        this.date = date;
        this.remark = remark;
        this.amount = amount;
        this.type = type;
        this.remark1 = remark1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.date.setText(date.get(position));
        holder.remark.setText(remark.get(position));
        holder.amount.setText(amount.get(position));
        holder.remark1.setText("Digit "+remark1.get(position));

        if (type.get(position).equals("1")){
            holder.amount.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
        } else {
            holder.amount.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));
        }

    }

    @Override
    public int getItemCount() {
        return date.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView date,amount,remark,remark1;

        public ViewHolder(View view) {
            super(view);

            date = view.findViewById(R.id.date);
            amount = view.findViewById(R.id.amount);
            remark = view.findViewById(R.id.remark);
            remark1 = view.findViewById(R.id.remark1);
        }
    }



}
