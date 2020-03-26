package com.awi.coronatracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScreeningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScreeningFragment extends Fragment {

    private WebView webView;
    private  String Load_url="https://corona.health-check.in/index";
    private String default_url = "https://www.mohfw.gov.in/";
    //"""//https://bnonews.com/index.php/2020/02/the-latest-coronavirus-cases/";
    private final static long threshold = 150000;

    private static final String FILENAME = "screening.pdf";
    PDFView ReadTxt;


    public ScreeningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment India_State_wise_Graphical_View_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScreeningFragment newInstance(String param1, String param2) {
        ScreeningFragment fragment = new ScreeningFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_checkup_, container, false);

        ReadTxt=(PDFView)v.findViewById(R.id.pdfView);

        ReadTxt.fromAsset(FILENAME).load();

    // Inflate the layout for this fragment
        return v;
    }



}
