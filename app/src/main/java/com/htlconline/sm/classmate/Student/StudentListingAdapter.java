package com.htlconline.sm.classmate.Student;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htlconline.sm.classmate.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shikhar Garg on 28-12-2016.
 */
public class StudentListingAdapter extends RecyclerView.Adapter<StudentListingViewHolder> {
    List<StudentListingModel.Results> studentlist;
    Context context;
    public StudentListingAdapter(List<StudentListingModel.Results> studentlist,Context context) {
        this.studentlist = studentlist;
        this.context=context;
    }

    @Override
    public StudentListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_listing_item_flat_list,null);
       StudentListingViewHolder slvh=new StudentListingViewHolder(v,context);
       return slvh;
    }

    @Override
    public void onBindViewHolder(StudentListingViewHolder holder, int position) {
        //Log.i("sizze",studentlist.get(position).getName()+" "+ studentlist.get(position).getId() +" "+ studentlist.get(position).getCentre());
        holder.username.setText(studentlist.get(position).getName());
        holder.userid.setText(studentlist.get(position).getId());
        holder.usercenter.setText(studentlist.get(position).getCentre());
        //holder.user_att_present.setText(studentlist.get(position).getGet_attendance_percentage().getPresent()+"");
    }

    @Override
    public int getItemCount() {
        Log.i("sizze",studentlist.size()+"");
        return studentlist.size();
    }
}
