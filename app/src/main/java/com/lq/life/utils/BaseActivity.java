package com.lq.life.utils;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lq on 2018/10/22.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    //这里不用静态相当于每一个新activity都重置这个list
    private static List<Activity> activityList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityList.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityList.remove(this);
    }

    public void exitApp(){
       for (Activity activity:activityList){
           if (!activity.isFinishing()){
               activity.finish();
           }
       }
       activityList.clear();
        //斩草除根
        int pid = Process.myPid();
        Process.killProcess(pid);
    }

    public Drawable getResourcesDrawable(int id){
        return getResources().getDrawable(id);
    }


}
