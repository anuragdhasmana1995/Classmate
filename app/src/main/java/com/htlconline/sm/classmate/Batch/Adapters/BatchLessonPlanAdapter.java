package com.htlconline.sm.classmate.Batch.Adapters;

import android.content.Context;
import android.support.transition.TransitionManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.htlconline.sm.classmate.Batch.BatchFragments.BatchLessonPlanFragment;
import com.htlconline.sm.classmate.Batch.Data.BatchLessonPlanData;
import com.htlconline.sm.classmate.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Anurag on 27-01-2017.
 */

public class BatchLessonPlanAdapter extends RecyclerView.Adapter<BatchLessonPlanAdapter.LessonViewHolder> {

    private final BatchLessonPlanFragment context;
    private List<BatchLessonPlanData> data;
    private LayoutInflater inflater;
    private View view;
    private int mExpandedPosition = -1;
    private RecyclerView recyclerView;


    public BatchLessonPlanAdapter(FragmentActivity activity, List<BatchLessonPlanData> batchLessonPlanDatas, RecyclerView recyclerView, BatchLessonPlanFragment context) {
        this.data = batchLessonPlanDatas;
        this.recyclerView = recyclerView;
        this.inflater = LayoutInflater.from(activity);
        this.context = context;
    }


    @Override
    public LessonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.batch_lesson_plan_content, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LessonViewHolder holder, int position) {

        final boolean isExpanded = holder.getAdapterPosition() == mExpandedPosition;
        holder.listView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.cardView.setActivated(isExpanded);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExpandedPosition = isExpanded ? -1 : holder.getAdapterPosition();
                TransitionManager.beginDelayedTransition(recyclerView);
                notifyDataSetChanged();
            }
        });
        BatchLessonPlanData result = data.get(position);
        holder.ChapterName.setText(result.getChapterName());
        holder.ChapterNo.setText(String.valueOf(result.getChapterNo()));
        holder.listView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, result.getLectureNo().size() * 325));
        holder.listView.setDividerHeight(10);
        holder.listView.setAdapter(new BatchLessonPlanCustomListAdapter(inflater.getContext(), result.getLectureNo(),
                result.getLectureTopic(),context));


    }


    @Override
    public int getItemCount() {
        return data.size();
    }



    class LessonViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView ChapterNo;
        private TextView ChapterName;
        private Button Toggle;
        private ListView listView;

        LessonViewHolder(View itemView) {

            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.batch_lesson_plan_card);
            ChapterNo = (TextView) itemView.findViewById(R.id.batch_lesson_plan_chapter);
            ChapterName = (TextView) itemView.findViewById(R.id.batch_lesson_plan_chap_name);
            listView = (ListView) itemView.findViewById(R.id.batch_lesson_plan_list);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                }
            });
        }
    }
}
