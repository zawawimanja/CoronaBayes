package com.awi.coronatracker.QR;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import com.awi.coronatracker.R;
import com.awi.coronatracker.nestedtab.Nest1Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private QuestionAdapter recyclerviewAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String[] que = new String[]{"Have you recently traveled to an area with known local spread of COVID-19?",
            "Have you come into close contact (within 6 feet) with someone who has a laboratory confirmed COVID – 19 diagnosis in the past 14 days?",
            "Do you have a fever (greater than 100.4 F or 38.0 C) more then 1 day",
            "Do you have symptoms of lower respiratory illness such as cough, shortness of breath",
            "Do you have difficulty in breathing?"};
    private RecyclerView recyclerView;
    List<Question> questionList;
    private EditText etName, etId;

    public static QuestionFragment newInstance(int position) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_question,container,false);

         recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
       // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
      //  recyclerView.setLayoutManager(layoutManager);

        etId = v.findViewById(R.id.et_id);
        etName = v.findViewById(R.id.et_name);



        //QuestionAdapter questionAdapter = new QuestionAdapter();
        questionList = new ArrayList<>();

        // points means weight of symtns Max 5 and means 0
        // Color qr code generate using this point. If you add more questions then you need to changes in calculation for generate color qr code

        questionList.add(new Question(que[0], false, 5));
        questionList.add(new Question(que[1], false, 5));
        questionList.add(new Question(que[2], false, 1));
        questionList.add(new Question(que[3], false, 1));
        questionList.add(new Question(que[4], false, 4));
        recyclerviewAdapter= new QuestionAdapter(getContext(), questionList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerviewAdapter);
        recyclerviewAdapter.notifyDataSetChanged();
        //createQuetions();



        v.findViewById(R.id.btn_generate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etName.getText())) {
                    etName.setError("Enter your Name");
                    return;
                }

                if (TextUtils.isEmpty(etId.getText())) {
                    etId.setError("Enter your age");
                    return;
                }

                int mark = 0;
                int total = 0;

                for (int i = 0; i < questionList.size(); i++) {
                    total = total + questionList.get(i).getPoins();
                    if (questionList.get(i).isAnswer()) {
                        mark = mark + questionList.get(i).getPoins();
                    }
                }
                Intent i = new Intent(getActivity(), QrCreateActivity.class);
                i.putExtra("total", total);
                i.putExtra("mark", mark);
                i.putExtra("name", etName.getText().toString());
                i.putExtra("id", etId.getText().toString());
                startActivity(i);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }


    private void createQuetions() {



    }

}
