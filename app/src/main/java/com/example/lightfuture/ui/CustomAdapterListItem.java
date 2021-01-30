package com.example.lightfuture.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.lightfuture.R;

import java.util.ArrayList;

public class CustomAdapterListItem extends RecyclerView.Adapter<CustomAdapterListItem.MyViewHolder>{



    private ArrayList<DataModelListItem> dataSet;

    public CustomAdapterListItem(ArrayList<DataModelListItem> dataSet){
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView name = holder.name;
        name.setText(dataSet.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = dataSet.get(position).getId();
                Intent intent = new Intent(holder.itemView.getContext(), ListItemActivity.class);
                intent.putExtra("id", id);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.namber_list_item_text_view);
        }
    }

}
