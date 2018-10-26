package com.lq.life.UI;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lq.life.R;
import com.lq.life.activity.StartActivity;
import com.lq.life.utils.BaseActivity;

import org.w3c.dom.Text;

/**
 * Created by lq on 2018/10/25.
 */

public class BaseToast {
    private static Toast toast;
    public static void showToast(BaseActivity activity, String msg){
        //第二个参数必须是viewgroup。第二个参数本应该当第一个参数生成view的父布局的，可是它竟然是第一个布局的一个子view
        //！！1；第3个省略的参数为true，表示将第二个view将作为第一个view的父布局。
        View view = LayoutInflater.from(activity).inflate(R.layout.ui_toast,
                (ViewGroup) activity.findViewById(R.id.toast_linear));
        TextView tv = view.findViewById(R.id.toast_tv);
        tv.setText(msg);
        toast = new Toast(activity);
        toast.setGravity(Gravity.BOTTOM,0,100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();
    }

}
