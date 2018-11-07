package com.lq.life.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lq.life.R;
import com.lq.life.adapter.MovieAdapter;
import com.lq.life.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lq on 2018/11/7.
 */

public class MainFragment extends Fragment {
    private View mRootView;
    private RecyclerView mRecyclerMovie;
    private List<Movie> movieList = new ArrayList<>();
    private MovieAdapter movieAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main, container, false);
        initData();
        initView();
        return mRootView;
    }
    private void initData(){
        movieList.add(new Movie(R.mipmap.icon_godfather,"不要憎恨你的敌人，那会影响你的判断力"));
        movieList.add(new Movie(R.mipmap.icon_redemption,"有些鸟儿时注定不会被关在牢笼里的，它们的每一片羽毛都闪耀着自由的光辉"));
        movieList.add(new Movie(R.mipmap.icon_ruien,"我每一天都在回想你对我说过的话，我一直在努力做一个正直的好人，" +
                "我没辜负你们，就像你们对我那样去对待他人"));
        movieList.add(new Movie(R.mipmap.icon_hunter,"当一个男人口袋里有了钱，他就开始欣赏和平"));
        movieList.add(new Movie(R.mipmap.icon_joker,"疯狂就像地心引力，你需要做的只是轻轻一推"));
        movieList.add(new Movie(R.mipmap.icon_mozate,"我每天花8小时练琴，人们却用天才两字埋没我的努力"));
    }

    private void initView(){
        mRecyclerMovie = mRootView.findViewById(R.id.recycler_movie_MainFragment);
        movieAdapter = new MovieAdapter(movieList);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerMovie.setLayoutManager(manager);
        mRecyclerMovie.setAdapter(movieAdapter);
    }

}
