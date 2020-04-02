package com.awi.coronatracker.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.awi.coronatracker.R;
import com.bumptech.glide.Glide;


public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    Activity activity;
 String[] mPlaces;
    String[] mPlaceDesc;
     Drawable[] mPlacePictures;

    public HorizontalAdapter(Context context) {
        Resources resources = context.getResources();
        mPlaces = resources.getStringArray(R.array.places);
        mPlaceDesc = resources.getStringArray(R.array.place_desc);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        mPlacePictures = new Drawable[a.length()];
        for (int i = 0; i < mPlacePictures.length; i++) {
            mPlacePictures[i] = a.getDrawable(i);
        }
        a.recycle();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
        holder.name.setText(mPlaces[position % mPlaces.length]);
        holder.description.setText(mPlaceDesc[position % mPlaceDesc.length]);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    /**
     * View holder to display each RecylerView item
     */
    protected class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView picture;
        public TextView name;
        public TextView description;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_horizontal_list, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.card_title);
            description = (TextView) itemView.findViewById(R.id.card_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, DetailActivity.class);
//                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
//                    context.startActivity(intent);
                }
            });

            // Adding Snackbar to Action Button inside card
         //   Button button = (Button)itemView.findViewById(R.id.action_button);
//            button.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Snackbar.make(v, "Action is pressed",
//                            Snackbar.LENGTH_LONG).show();
//                }
//            });

//            ImageButton favoriteImageButton =
//                    (ImageButton) itemView.findViewById(R.id.favorite_button);
//            favoriteImageButton.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Snackbar.make(v, "Added to Favorite",
//                            Snackbar.LENGTH_LONG).show();
//                }
//            });

//            ImageButton shareImageButton = (ImageButton) itemView.findViewById(R.id.share_button);
//            shareImageButton.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    Snackbar.make(v, "Share article",
//                            Snackbar.LENGTH_LONG).show();
//                }
//            });

//            void bindTo(Sport currentSport){
//                // Populate the textviews with data.
//                mTitleText.setText(currentSport.getTitle());
//                mInfoText.setText(currentSport.getInfo());
//
//                // Load the images into the ImageView using the Glide library.
//                Glide.with(mContext).load(
//                        currentSport.getImageResource()).into(mSportsImage);
//
//            }
//
//            /**
//             * Handle click to show DetailActivity.
//             *
//             * @param view View that is clicked.
//             */
//            @Override
//            public void onClick(View view) {
//                Sport currentSport = mSportsData.get(getAdapterPosition());
//                Intent detailIntent = new Intent(mContext, DetailActivity.class);
//                detailIntent.putExtra("title", currentSport.getTitle());
//                detailIntent.putExtra("image_resource",
//                        currentSport.getImageResource());
//                mContext.startActivity(detailIntent);
//            }


        }
    }
}
