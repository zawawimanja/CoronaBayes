package com.awi.coronatracker.retrofit;

import com.google.gson.annotations.SerializedName;

public class MovieDataModel {

    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("image")
    public String image;

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
