package com.htlconline.sm.classmate.Batch.BatchFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import com.htlconline.sm.classmate.Batch.Adapters.BatchAttendanceAdapter;
import com.htlconline.sm.classmate.Batch.BatchActivity;
import com.htlconline.sm.classmate.R;


public class BatchAttendenceFragment extends Fragment {
     private RecyclerView recyclerView;
     private BatchAttendanceAdapter batchAttendanceAdapter;
    private LinearLayoutManager manager;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_batch_attendence, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

   }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);
        recyclerView = (RecyclerView) view.findViewById(R.id.batch_attendance_summary);
        batchAttendanceAdapter = new BatchAttendanceAdapter(getActivity());
        recyclerView.setAdapter(batchAttendanceAdapter);
        manager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(BatchActivity.title);
        CheckedTextView mToolbarToggle = (CheckedTextView) getActivity().findViewById(R.id.toolbar_toggle);
        mToolbarToggle.setVisibility(View.GONE);

    }
}
