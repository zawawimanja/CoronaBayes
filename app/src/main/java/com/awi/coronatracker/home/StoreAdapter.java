//package com.awi.coronatracker.home;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.res.Resources;
//import android.content.res.TypedArray;
//import android.graphics.drawable.Drawable;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.awi.coronatracker.R;
//import com.bumptech.glide.Glide;
//
//import java.util.List;
//
//public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
//    private Context context;
//    private List<GridModelData> movieList;
//
//    Activity activity;
//    String[] mPlaces;
//    String[] mPlaceDesc;
//    Drawable[] mPlacePictures;
//
//
//
//    public StoreAdapter(Context context) {
//        Resources resources = context.getResources();
//        mPlaces = resources.getStringArray(R.array.places);
//        mPlaceDesc = resources.getStringArray(R.array.place_desc);
//        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
//        mPlacePictures = new Drawable[a.length()];
//        for (int i = 0; i < mPlacePictures.length; i++) {
//            mPlacePictures[i] = a.getDrawable(i);
//        }
//        a.recycle();
//    }
//
//
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        public TextView name, price;
//        public ImageView thumbnail;
//
//        public MyViewHolder(View view) {
//            super(view);
//            name = view.findViewById(R.id.title);
//            price = view.findViewById(R.id.price);
//            thumbnail = view.findViewById(R.id.thumbnail);
//        }
//    }
//
//
//    public StoreAdapter(Context context, List<GridModelData> movieList) {
//        this.context = context;
//        this.movieList = movieList;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.store_item_row, parent, false);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, final int position) {
//        final GridModelData movie = movieList.get(position);
//        holder.name.setText(movie.getTitle());
//        holder.price.setText(movie.getPrice());
//
//        Glide.with(context)
//                .load(movie.getImage())
//                .into(holder.thumbnail);
//    }
//
//    @Override
//    public int getItemCount() {
//        return movieList.size();
//    }
//}
