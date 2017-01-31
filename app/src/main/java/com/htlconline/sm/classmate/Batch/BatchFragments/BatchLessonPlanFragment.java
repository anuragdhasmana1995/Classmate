package com.htlconline.sm.classmate.Batch.BatchFragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.htlconline.sm.classmate.Batch.Adapters.BatchFilterListAdapter;
import com.htlconline.sm.classmate.Batch.Adapters.BatchLessonPlanAdapter;
import com.htlconline.sm.classmate.Batch.Adapters.BatchLessonPlanCustomListAdapter;
import com.htlconline.sm.classmate.Batch.BatchActivity;
import com.htlconline.sm.classmate.Batch.Data.BatchFilterData;
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
    private PopupWindow pw;

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
        mToolbarToggle.setVisibility(View.GONE);
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
        batchLessonPlanDatas = BatchLessonPlanData.CreateDummyData();

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("views", batchLessonPlanDatas.size() + "");
        recyclerView = (RecyclerView) view.findViewById(R.id.batch_lesson_plan_recycler);
        lessonPlanAdapter = new BatchLessonPlanAdapter(getActivity(), batchLessonPlanDatas, recyclerView, BatchLessonPlanFragment.this);
        recyclerView.setAdapter(lessonPlanAdapter);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void onClick(View view, String s) {
        //no need to show details
        // not required


       //initiatePopupWindow(view,s);

    }

//    private void initiatePopupWindow(View view,final String title) {
//      //  Log.d("Test pop", batchFilterData.length + "");
//        TextView lecture_name,status,completed_date;
//        try {
//            //We need to get the instance of the LayoutInflater, use the context of this activity
//            LayoutInflater inflater = (LayoutInflater) getActivity()
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            //Inflate the view from a predefined XML layout
//            View layout = inflater.inflate(R.layout.batch_lesson_plan_details,
//                    (ViewGroup) view.findViewById(R.id.pop_up));
//            // create a 300px width and 470px height PopupWindow
//            pw = new PopupWindow(layout, LinearLayout.LayoutParams.MATCH_PARENT,
//                    LinearLayout.LayoutParams.MATCH_PARENT);
//            // display the popup in the center
//            pw.showAtLocation(view, Gravity.CENTER, 0, 0);
//            pw.setFocusable(true);
//            pw.update();
//            lecture_name = (TextView) layout.findViewById(R.id.detail_lecture_name);
//            status = (TextView) layout.findViewById(R.id.detail_lesson_status);
//            completed_date = (TextView) layout.findViewById(R.id.detail_lesson_plan_completed);
//            lecture_name.setText(title);
//
//        } catch (Exception e) {
//            // Log.d("Test", "Exception Raised");
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    if (pw != null)
                        if (pw.isShowing())
                            pw.dismiss();
                        else getActivity().finish();
                    else {
                        getActivity().finish();
                    }


                    return true;
                }
                return false;
            }
        });

    }
}
