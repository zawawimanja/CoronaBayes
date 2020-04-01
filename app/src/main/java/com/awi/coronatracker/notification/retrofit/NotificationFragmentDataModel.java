package com.awi.coronatracker.notification.retrofit;

import com.google.gson.annotations.SerializedName;

public class NotificationFragmentDataModel {

    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("image")
    public String image;

    @Override
    public String toString() {
        return "GridModelData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
