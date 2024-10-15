package com.example.tugas5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> name_id, quantity_id, price_id;
    private View view;

    public MyAdapter(Context context, ArrayList<String> name_id, ArrayList<String> quantity_id, ArrayList<String> price_id) {
        this.context = context;
        this.name_id = name_id;
        this.quantity_id = quantity_id;
        this.price_id = price_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(name_id.get(position));
        holder.quantity_id.setText(quantity_id.get(position));
        holder.price_id.setText(price_id.get(position));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id, quantity_id, price_id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.textname);
            quantity_id = itemView.findViewById(R.id.textquantity);
            price_id = itemView.findViewById(R.id.textprice);
        }
    }
}