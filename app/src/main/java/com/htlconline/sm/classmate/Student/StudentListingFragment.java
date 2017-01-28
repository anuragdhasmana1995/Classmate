package com.htlconline.sm.classmate.Student;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.htlconline.sm.classmate.AppController;
import com.htlconline.sm.classmate.CustomRequests.CustomGetRequest;
import com.htlconline.sm.classmate.Decorators.DividerItemDecoration;
import com.htlconline.sm.classmate.R;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shikhar Garg on 28-12-2016.
 */
public class StudentListingFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private StudentListingAdapter mAdapter;
    private List<StudentListingModel.Results> studentlist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        studentlist=new ArrayList<StudentListingModel.Results>();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.student_listing,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("student", "Student1");
        mRecyclerView=(RecyclerView)view.findViewById(R.id.student_listing_rv);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));

        //GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
        //mRecyclerView.setLayoutManager(gridLayoutManager);


        request();
    }

    private void request() {
        String url = "http://www.htlconline.com/api/student_listing/";
        //RequestQueue mRequestQueue = Volley.newRequestQueue(getActivity());
        CustomGetRequest customGetRequest=new CustomGetRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                    Log.i("Student",response.toString());
                    Gson gson=new Gson();
                    StudentListingModel slm=gson.fromJson(String.valueOf(response),StudentListingModel.class);
                    studentlist= Arrays.asList(slm.getResults());
                    mAdapter=new StudentListingAdapter(studentlist,getActivity());
                    mRecyclerView.setAdapter(mAdapter);
            }

            
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Student","Student7");
                        error.printStackTrace();
                    }
                });
        //mRequestQueue.add(customGetRequest);
        AppController.getInstance(getActivity()).getRequestQueue().add(customGetRequest);

    }

}
