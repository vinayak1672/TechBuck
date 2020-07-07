package com.example.dev.techbuck.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dev.techbuck.Answer;
import com.example.dev.techbuck.Bean.QuestionBean;
import com.example.dev.techbuck.R;

import java.util.List;


public class RvQuestionDesignAdapter extends RecyclerView.Adapter<RvQuestionDesignAdapter.Holder> {

    private Context context;
    private LayoutInflater inflater;
    private List<QuestionBean> beans;

    public RvQuestionDesignAdapter(List<QuestionBean> beans,Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);
        this.beans=beans;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new RvQuestionDesignAdapter.Holder(inflater.inflate(R.layout.rv_question_design, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Log.d("Sixee===>",beans.size()+"");
        holder.userquestion.setText(beans.get(holder.getAdapterPosition()).question);
        holder.username.setText(beans.get(holder.getAdapterPosition()).unm);
        holder.Date.setText(beans.get(holder.getAdapterPosition()).date);
        Glide.with(context).load(beans.get(holder.getAdapterPosition()).userimage).into(holder.cirimage);
        if (beans.get(holder.getAdapterPosition()).image !=null)
        {
            Glide.with(context).load(beans.get(holder.getAdapterPosition()).image).into(holder.queimage);
        }

    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView username,Date,userquestion;
        Button answers,report;
        ImageView queimage,cirimage;
        public Holder(View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            userquestion=itemView.findViewById(R.id.userquestion);
            Date=itemView.findViewById(R.id.Date);
            report=itemView.findViewById(R.id.report);
            answers=itemView.findViewById(R.id.answers);
            cirimage=itemView.findViewById(R.id.cirimage);
            queimage=itemView.findViewById(R.id.queimage);

            answers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context,Answer.class));
                }
            });
        }
    }
}
