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
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.awi.coronatracker.R;

/**
 * Provides UI for the view with Tile.
 */



public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

    Activity activity;
    String[] mPlaces;
    String[] mPlaceDesc;
    Drawable[] mPlacePictures;

    public GridViewAdapter(Context context) {
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
    public GridViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GridViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.picture.setImageDrawable(mPlacePictures[position % mPlacePictures.length]);
        holder.name.setText(mPlaces[position % mPlaces.length]);
    }


    //return no of item in grid
    @Override
    public int getItemCount() {
        return 7;
    }

    /**
     * View holder to display each RecylerView item
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tile, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.tile_picture);
            name = (TextView) itemView.findViewById(R.id.tile_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, DetailActivity.class);
//                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
//                    context.startActivity(intent);
                }
            });
        }
    }}