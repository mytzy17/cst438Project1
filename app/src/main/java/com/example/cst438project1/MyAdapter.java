package com.example.cst438project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.cst438project1.DB.AssignmentDAO;
import com.example.cst438project1.DB.AssignmentDatabase;
import com.example.cst438project1.DB.CourseDAO;
import com.example.cst438project1.DB.CourseDatabase;
import com.example.cst438project1.DB.GradeDAO;
import com.example.cst438project1.DB.GradeDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static final String TAG = "MyAdapter";
    private ArrayList<String> mCategoryTitle = new ArrayList<>();
    private ArrayList<String> mAssignmentTitle = new ArrayList<>();
    private ArrayList<String> mScores = new ArrayList<>();
    private Context mContext;

    public MyAdapter(Context context, ArrayList<String> categoryTitle, ArrayList<String> assignmentTitle, ArrayList<String> scores) {
        mCategoryTitle = categoryTitle;
        mAssignmentTitle = assignmentTitle;
        mScores = scores;
        mContext = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.gradeCategory.setText(mCategoryTitle.get(position));
        holder.assignment.setText(mAssignmentTitle.get(position));
        holder.score.setText(mScores.get(position));


    }

    @Override
    public int getItemCount() {
        return mCategoryTitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gradeCategory;
        TextView assignment;
        TextView score;
        RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            gradeCategory = itemView.findViewById(R.id.courseCategoryText);
            assignment = itemView.findViewById(R.id.assignmentText);
            score = itemView.findViewById(R.id.score);
            parentLayout = itemView.findViewById(R.id.parentLayout);


        }
    }
}
