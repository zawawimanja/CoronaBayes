package com.awi.coronatracker.QR;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.awi.coronatracker.R;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionHolder> {


    private List<Question> questionList;
    private Context context;

    QuestionAdapter(Context context, List<Question> questionList){
        this.context = context;
        this.questionList = questionList;
    }
        /*public QuestionAdapter(Context context){

        }*/

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_question, parent, false);
        return new QuestionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionHolder holder, final int position) {
        holder.txtQue.setText("Q. " + questionList.get(position).getQue());
        if (questionList.get(position).isAnswer()) {
            holder.rbGroup.check(R.id.rb_true);
        } else {
            holder.rbGroup.check(R.id.rb_false);
        }
        holder.rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_true:
                        questionList.get(position).setAnswer(true);
                        break;
                    case R.id.rb_false:
                        questionList.get(position).setAnswer(false);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class QuestionHolder extends RecyclerView.ViewHolder {

        private TextView txtQue;
        private RadioGroup rbGroup;

        public QuestionHolder(@NonNull View itemView) {
            super(itemView);
            txtQue = itemView.findViewById(R.id.txt_row_question);
            rbGroup = itemView.findViewById(R.id.rb_group);
        }
    }
}
