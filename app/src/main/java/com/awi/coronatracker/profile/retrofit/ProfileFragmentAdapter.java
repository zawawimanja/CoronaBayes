package com.awi.coronatracker.profile.retrofit;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.awi.coronatracker.R;

import java.util.List;

public class ProfileFragmentAdapter extends RecyclerView.Adapter<ProfileFragmentAdapter.MyViewHolder> {

    private List<ProfileFragmentDataModel> movieList;
    private Context context;

    ProfileFragmentAdapter(Context context, List<ProfileFragmentDataModel> movieList){
        this.context = context;
        this.movieList = movieList;
    }

    public void loadShops(List<ProfileFragmentDataModel> movieList){
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public ProfileFragmentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_adapter_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileFragmentAdapter.MyViewHolder holder, int position) {
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
