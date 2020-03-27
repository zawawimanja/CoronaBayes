package com.awi.coronatracker.api;



import com.awi.coronatracker.retrofit.MovieDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

//    @GET("movies_2017.json")
//    Call<List<MovieDataModel>> getshops();


    @GET("v1/healthcare-institution")
    Call<List<MovieDataModel>> getshops();

}
