package com.htlconline.sm.classmate.Batch.BatchFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import com.htlconline.sm.classmate.Batch.Adapters.BatchLessonPlanAdapter;
import com.htlconline.sm.classmate.Batch.Adapters.BatchLessonPlanCustomListAdapter;
import com.htlconline.sm.classmate.Batch.BatchActivity;
import com.htlconline.sm.classmate.Batch.Data.BatchLessonPlanData;
import com.htlconline.sm.classmate.R;
import com.htlconline.sm.classmate.Schedule.Fragment.MainFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BatchLessonPlanFragment extends Fragment implements BatchLessonPlanCustomListAdapter.onClickList {


    private CheckedTextView mToolbarToggle;
    private List<BatchLessonPlanData> batchLessonPlanDatas;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private BatchLessonPlanAdapter lessonPlanAdapter;
    public BatchLessonPlanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("views", "onActivitycreated 1");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(BatchActivity.title
        );
        mToolbarToggle = (CheckedTextView) (getActivity()).findViewById(R.id.toolbar_toggle);
        mToolbarToggle.setVisibility(View.INVISIBLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("views", "onCreateView 1");
        return inflater.inflate(R.layout.fragment_batch_lesson_plan, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("views", "onCreate 1");
        batchLessonPlanDatas=BatchLessonPlanData.CreateDummyData();

    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("views",batchLessonPlanDatas.size()+"");
        recyclerView = (RecyclerView) view.findViewById(R.id.batch_lesson_plan_recycler);
        lessonPlanAdapter = new BatchLessonPlanAdapter(getActivity(),batchLessonPlanDatas,recyclerView, BatchLessonPlanFragment.this);
        recyclerView.setAdapter(lessonPlanAdapter);
        layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void onClick(View view, String s) {


    }
}
