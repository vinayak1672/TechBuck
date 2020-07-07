package com.example.dev.techbuck.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dev.techbuck.Adapters.RvQuestionDesignAdapter;
import com.example.dev.techbuck.AddQuestion;
import com.example.dev.techbuck.Bean.CategoryBean;
import com.example.dev.techbuck.Bean.QuestionBean;
import com.example.dev.techbuck.CallServices;
import com.example.dev.techbuck.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentTabLayout extends Fragment {
    FloatingActionButton flotingbtn;
    RecyclerView rv;
    View view;
    ArrayList<String> key, value;
    CategoryBean categoryBean;
    String METHOD = "add";
    ArrayList<QuestionBean> bean = new ArrayList<>();
    String URL = com.example.dev.techbuck.URL.url + "/question.php";
    RvQuestionDesignAdapter ac;
    String cat;
    CallServices cs;

    public FragmentTabLayout() {
        // Required empty public constructor
    }

    public static FragmentTabLayout getInstance(CategoryBean categoryBean, int position) {
        FragmentTabLayout fragmentTabLayout = new FragmentTabLayout();
        Bundle bundle = new Bundle();
        bundle.putSerializable("categoryBean", categoryBean);
        bundle.putInt("position", position);
        fragmentTabLayout.setArguments(bundle);

        return fragmentTabLayout;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_fragment_tab_layout, container, false);
        init();

        flotingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddQuestion.class);
                startActivity(intent);

            }
        });

        key.add("cat");
        value.add(cat);
        String res = cs.CallServices(getContext(), URL, METHOD, key, value);
        Log.e("error-------", res);
        try {
            JSONObject jsonObject = new JSONObject(res);
            JSONArray jsonArray = jsonObject.optJSONArray("data");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String id = jsonObject1.getString("id");
                String unm = jsonObject1.getString("unm");
                String email = jsonObject1.getString("email");
                String date = jsonObject1.getString("date");
                String question = jsonObject1.getString("question");
                String image = jsonObject1.getString("image");
                String cat = jsonObject1.getString("cat");
                String userimage = jsonObject1.getString("userimage");
                QuestionBean questionBean = new QuestionBean(id, unm, email, date, question, image, cat, userimage);
                bean.add(questionBean);
            }


        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("Errrorrr=>", e.getLocalizedMessage());
        }
        Log.d("Sizee===>",bean.size()+"");
        ac = new RvQuestionDesignAdapter(bean, getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(ac);
        return view;
    }

    private void init() {

        categoryBean = new CategoryBean();
        categoryBean = (CategoryBean) getArguments().getSerializable("categoryBean");
        final int position = getArguments().getInt("position", 0);
        cat = categoryBean.c_name;
        cs = new CallServices();
        key = new ArrayList<>();
        value = new ArrayList<>();

        flotingbtn = view.findViewById(R.id.flotingbtn);
        rv = view.findViewById(R.id.rv);
    }

}
