/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
import android.widget.Toast;

import com.awi.coronatracker.R;
import com.awi.coronatracker.notes.NotesActivity;
import com.awi.coronatracker.test.Main2Activity;

import java.util.ArrayList;

/**
 * Provides UI for the view with Tile.
 */



public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private Context mContext;
    Activity activity;
    String[] mPlaces;
    String[] mPlaceDesc;
    Drawable[] mPlacePictures;
    private ArrayList<GridModelData> mSportsData;

    public GridAdapter(Context context, ArrayList<GridModelData> mSportsData) {
        this.mSportsData = mSportsData;

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
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GridAdapter.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
        holder.name.setText(mPlaces[position % mPlaces.length]);




    }


    //return no of item in grid
    @Override
    public int getItemCount() {
        return 6;
    }

    /**
     * View holder to display each RecylerView item
     */
    class ViewHolder extends RecyclerView.ViewHolder   {
        public ImageView picture;
        public TextView name;


        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tile, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.tile_picture);
            name = (TextView) itemView.findViewById(R.id.tile_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();

                       Toast.makeText(context, "No "+getAdapterPosition(), Toast.LENGTH_SHORT).show();

                    if(getAdapterPosition()==3){
                    Intent intent = new Intent(context, NotesActivity.class);
                    intent.putExtra("Notes", getAdapterPosition());
                        intent.putExtra("FragmentChoose","Notes");

                    context.startActivity(intent);

                    }

//                    Intent intent = new Intent(context, MainActivity.class);
//                 //   intent.putExtra(MainActivity.EXTRA_POSITION, getAdapterPosition());
//                    context.startActivity(intent);

                 //   Toast.makeText(context, "No "+getAdapterPosition(), Toast.LENGTH_SHORT).show();

                }
            });
        }



    }}