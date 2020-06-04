package com.example.donationapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecvAdapter extends RecyclerView.Adapter<RecvAdapter.RecvViewHolder> {

    public ArrayList<recversItem> list ;
    public Context context;
    public User user;


    public class RecvViewHolder extends RecyclerView.ViewHolder {

        public TextView recvID , shortBio ,itemsRequest;
        public Button donate;
        public ImageView inc , dec;
        public TextView amount;


        public RecvViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.tvNumOfItems);
            inc = itemView.findViewById(R.id.ivIncrease);
            dec = itemView.findViewById(R.id.ivDecrease);
            recvID = itemView.findViewById(R.id.tvRecvID);
            shortBio = itemView.findViewById(R.id.tvShortBio);
            itemsRequest = itemView.findViewById(R.id.tvItemsReq); // to be a number
            donate = itemView.findViewById(R.id.btnRecvDonate);

        }
    }

    public RecvAdapter(ArrayList<recversItem> list , Context context , User user){
        this.list = list;
        this.context = context;
        this.user= user;
    }

    @NonNull
    @Override
    public RecvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_recv_don,parent,false);
        return new RecvViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecvViewHolder holder, int position) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final RecvViewHolder holder, int position, @NonNull List<Object> payloads) {
        final recversItem item = new recversItem(list.get(position).getRecvID(),list.get(position).getShortBio(),list.get(position).getItemRequest());

        holder.recvID.setText("Receiver's ID: " + list.get(position).getRecvID());
        holder.shortBio.setText(list.get(position).getShortBio());
        holder.itemsRequest.setText(Integer.toString(list.get(position).getItemRequest()));
        holder.amount.setText(Integer.toString(item.getAmount()));

        holder.inc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                item.incAmount();
                holder.amount.setText(Integer.toString(item.getAmount()));
            }
        });

        holder.dec.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                item.decAmount();
                holder.amount.setText(Integer.toString(item.getAmount()));
            }
        });

        holder.donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


}
