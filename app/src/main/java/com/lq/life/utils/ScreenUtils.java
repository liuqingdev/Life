package com.lq.life.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by lq on 2018/10/24.
 * 获取手机屏幕相关参数
 */

public class ScreenUtils {
    private static int mScreenWidth;
    private static int mScreenHeigh;

    //单位:px  高 0 or 宽1
    public static int getScreenAttr(Context context,int flag){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        if (flag == 0){
          mScreenHeigh = metrics.heightPixels;
          return mScreenHeigh;
        }else if (flag == 1){
            mScreenWidth = metrics.widthPixels;
            return mScreenWidth;
        }
        return 0;
    }



}
