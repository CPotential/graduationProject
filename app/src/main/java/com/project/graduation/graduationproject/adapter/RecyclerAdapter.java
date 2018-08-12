package com.project.graduation.graduationproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.project.graduation.graduationproject.R;
import com.project.graduation.graduationproject.vo.Poster;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Poster> posterList;
    private  int itemLayout;

    public RecyclerAdapter(List<Poster> posters, int itemLayout){
        this.posterList = posters;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Poster poster = posterList.get(position);
        viewHolder.posterTitle.setText(poster.getPosterTitle());
        viewHolder.posterImage.setBackgroundResource(poster.getPosterImage());
    }

    @Override
    public int getItemCount() {
        return posterList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button posterImage;
        public TextView posterTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            posterImage = (Button) itemView.findViewById(R.id.posterImage);
            posterTitle = (TextView) itemView.findViewById(R.id.posterTitle);
        }
    }
}
