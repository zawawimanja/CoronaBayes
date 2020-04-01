package com.awi.coronatracker.profile.retrofit;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.awi.coronatracker.R;


import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

//    private ApiService apiService;
    private RecyclerView shopsRecyclerview;
    private ProfileFragmentDataModel recyclerviewAdapter;
    private List<ProfileFragmentDataModel> movieList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.latest_layout,container,false);
        movieList = new ArrayList<>();
        shopsRecyclerview = (RecyclerView)view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        shopsRecyclerview.setLayoutManager(layoutManager);
//        apiService = RetrofitClient.getInstance().create(ApiService.class);
//        recyclerviewAdapter = new NotificationFragmentDataModel(getContext(), movieList);
//        shopsRecyclerview.setAdapter(recyclerviewAdapter);
        //loadshopData();
        return view;
    }
//
//    private void loadshopData() {
//
//        Call<List<NotificationFragmentDataModel>> listCall = apiService.getshops();
//
//        listCall.enqueue(new Callback<List<NotificationFragmentDataModel>>() {
//            @Override
//            public void onResponse(Call<List<NotificationFragmentDataModel>> call, Response<List<NotificationFragmentDataModel>> response) {
//                movieList = response.body();
//                recyclerviewAdapter.loadShops(movieList);
//                Log.d("Response",response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<NotificationFragmentDataModel>> call, Throwable t) {
//                Log.d("Response",t.toString());
//
//            }
//        });
//    }
}
