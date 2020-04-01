package com.awi.coronatracker.notification.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.awi.coronatracker.R;

import java.util.List;

public class NotificationFragmentAdapter extends RecyclerView.Adapter<NotificationFragmentAdapter.MyViewHolder> {

    private List<NotificationFragmentDataModel> movieList;
    private Context context;

    NotificationFragmentAdapter (Context context, List<NotificationFragmentDataModel> movieList){
        this.context = context;
        this.movieList = movieList;
    }

    public void loadShops(List<NotificationFragmentDataModel> movieList){
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public NotificationFragmentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_adapter_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationFragmentAdapter.MyViewHolder holder, int position) {
        holder.shopName.setText(movieList.get(position).name);
       // Glide.with(context).load(movieList.get(position).image).into(holder.shopImage);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView shopName;
        private ImageView shopImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            shopName = (TextView) itemView.findViewById(R.id.shopName);
            shopImage = (ImageView)itemView.findViewById(R.id.shopImage);

        }
    }
}
