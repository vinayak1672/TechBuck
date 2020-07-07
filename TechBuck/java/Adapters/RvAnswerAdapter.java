package com.example.dev.techbuck.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dev.techbuck.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class RvAnswerAdapter extends RecyclerView.Adapter<RvAnswerAdapter.Holder>{

    public RvAnswerAdapter() {
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder
    {
        CircleImageView anscirimage;
        TextView ansusername,ansDate,useranswer;
        Button ansreport;
        ImageView ansimage;

        public Holder(View itemView) {
            super(itemView);
            anscirimage=itemView.findViewById(R.id.anscirimage);
            ansusername=itemView.findViewById(R.id.ansusername);
            ansDate=itemView.findViewById(R.id.ansDate);
            ansreport=itemView.findViewById(R.id.ansreport);
            useranswer=itemView.findViewById(R.id.useranswer);
            ansimage=itemView.findViewById(R.id.ansimage);
            ansreport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
