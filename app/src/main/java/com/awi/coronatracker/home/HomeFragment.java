package com.awi.coronatracker.home;




import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.awi.coronatracker.R;


import java.util.ArrayList;
import java.util.List;



public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getSimpleName();

    // url to fetch shopping items
    private static final String URL = "https://api.androidhive.info/json/movies_2017.json";

    private RecyclerView recyclerView;
    private List<GridModelData> itemsList;

    private RecyclerView horizontalList;

    private HorizontalAdapter horizontalAdapter;
    private GridViewAdapter horizontalAdapter1;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        horizontalList = view.findViewById(R.id.horizontal_recycler);
        recyclerView = view.findViewById(R.id.recycler_view);
        itemsList = new ArrayList<>();
      //  mAdapter = new StoreAdapter(getActivity(), itemsList);
        horizontalAdapter = new HorizontalAdapter(getActivity());
        horizontalAdapter1 = new GridViewAdapter(getActivity());

        //gridview
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
      //  recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(horizontalAdapter1);
        recyclerView.setNestedScrollingEnabled(false);


        //set horizontal LinearLayout as layout manager to creating horizontal list view
        LinearLayoutManager horizontalManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        horizontalList.setLayoutManager(horizontalManager);
        horizontalAdapter = new HorizontalAdapter(getActivity());
        horizontalList.setAdapter(horizontalAdapter);





       // fetchStoreItems();

        return view;
    }

    /**
//     * fetching shopping item by making http call
//     */
//    private void fetchStoreItems() {
//        JsonArrayRequest request = new JsonArrayRequest(URL,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        if (response == null) {
//                            Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
//                            return;
//                        }
//
//                        List<GridModelData> items = new Gson().fromJson(response.toString(), new TypeToken<List<GridModelData>>() {
//                        }.getType());
//
//                        itemsList.clear();
//                        itemsList.addAll(items);
//
//                        // refreshing recycler view
//                        mAdapter.notifyDataSetChanged();
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // error in getting json
//                Log.e(TAG, "Error: " + error.getMessage());
//                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        MyApplication.getInstance().addToRequestQueue(request);
//    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    /**
     * RecyclerView adapter class to render items
     * This class can go into another separate class, but for simplicity
     */
}
