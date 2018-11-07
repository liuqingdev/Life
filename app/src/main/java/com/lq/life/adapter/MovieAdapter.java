package com.lq.life.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lq.life.R;
import com.lq.life.model.Movie;

import java.util.List;

/**
 * Created by lq on 2018/11/7.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.imgMovie.setImageResource(movie.getPictureId());
        holder.tvLines.setText(movie.getLines());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView imgMovie;
        TextView tvLines;
        public MovieViewHolder(View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.img_movie_MainFragment);
            tvLines = itemView.findViewById(R.id.tv_lines_MainFragment);
        }
    }
}
