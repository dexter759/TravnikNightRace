package com.example.incubator3.travniknightrace.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.incubator3.travniknightrace.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.MyViewHolder> {

    private Context mContext;
    private List<String> stringList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }

    public AdapterMain(Context mContext, List<String> stringList) {
        this.mContext = mContext;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public AdapterMain.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMain.MyViewHolder holder, int position) {
//        String string = stringList.get(position);
        holder.title.setText("Pinja");
        holder.count.setText("Pinja");

        // loading album cover using Glide library


    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
