package com.awi.coronatracker.notification.retrofit;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.awi.coronatracker.R;
import com.awi.coronatracker.home.HomeFragment;
import com.awi.coronatracker.home.HorizontalAdapter;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {

//    private ApiService apiService;
    private RecyclerView recyclerView;
    private NotificationFragmentDataModel recyclerviewAdapter;
    private List<NotificationFragmentDataModel> movieList;
    NotificationFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(
                R.layout.fragment_noti, container, false);

        recyclerView = v.findViewById(R.id.recycler_viewnoti);

        adapter = new NotificationFragmentAdapter(getActivity());

        RecyclerView.LayoutManager horizontalManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(horizontalManager);




        return v;
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


    public NotificationFragment() {
        // Required empty public constructor
    }

    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }




}
