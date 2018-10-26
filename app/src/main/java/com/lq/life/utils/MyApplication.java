package com.lq.life.utils;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by lq on 2018/10/23.
 * 这个类有待深究
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static void toast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
