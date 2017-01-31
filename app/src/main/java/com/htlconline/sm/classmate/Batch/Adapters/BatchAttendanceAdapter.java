package com.htlconline.sm.classmate.Batch.Adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.htlconline.sm.classmate.Batch.BatchFragments.BatchAttendenceFragment;
import com.htlconline.sm.classmate.R;
import com.yuncun.swipeableweekview.CircleView;
import com.yuncun.swipeableweekview.WeekViewAdapter;
import com.yuncun.swipeableweekview.WeekViewSwipeable;

import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

import static com.htlconline.sm.classmate.Batch.BatchActivity.context;


/**
 * Created by Anurag on 30-01-2017.
 */

public class BatchAttendanceAdapter extends RecyclerView.Adapter<BatchAttendanceAdapter.AttendanceViewHolder> {

    private LayoutInflater inflater;
    private View view;
    List<Boolean> data;


    public BatchAttendanceAdapter(FragmentActivity activity) {
        this.inflater = LayoutInflater.from(activity);
        this.data = Arrays.asList(true, false);
    }

    @Override
    public AttendanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.batch_attendance_content, parent, false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttendanceViewHolder holder, int position) {
        List<Boolean> record = Arrays.asList(true, false, true, false, true, true, true, false, true, false,
                true, false, true, false, true, true, true, false, true,
                false, true, false, true, false, true, true, true, false,
                true, false, true, true, true, false, true, false, true, true);


        WeekViewAdapter<Boolean> adapter = new WeekViewAdapter<Boolean>(record) {
            @Override
            public int getStrokeColor(final int index) {
                if ((Boolean) get(index) == true) {
                    return ContextCompat.getColor(context, R.color.greenA700);
                } else {
                    return ContextCompat.getColor(context, R.color.alternatered);
                }
            }

            @Override
            public int getFillColor(final int index) {
                if ((Boolean) get(index) == true) {
                    return ContextCompat.getColor(context, R.color.greenA700);
                } else {
                    return ContextCompat.getColor(context, R.color.alternatered);
                }
            }

            @Override
            public TextView getTextView(TextView tv, int index) {
                if ((Boolean) get(index) == true) {
                    tv.setText("Present");
                } else {
                    tv.setText("Absent");
                }
                return tv;
            }

            @Override
            public View getDayLayout(View dv, final int index) {
                dv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "Click! on index " + index, Toast.LENGTH_LONG).show();
                    }
                });
                return dv;
            }

        };

        holder.weekViewSwipeable.setAdapter(adapter);
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    class AttendanceViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView studentName;
        private TextView studentId;
        private Button Toggle;
        private WeekViewSwipeable weekViewSwipeable;

        AttendanceViewHolder(View itemView) {

            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.batch_attendance_card);
            studentName = (TextView) itemView.findViewById(R.id.batch_attendance_student_name);
            studentId = (TextView) itemView.findViewById(R.id.batch_attendance_student_id);
            weekViewSwipeable = (WeekViewSwipeable) itemView.findViewById(R.id.batch_attendance_swipeable_week);
            Toggle = (Button) itemView.findViewById(R.id.batch_attendance_toggle);
        }
    }


}
