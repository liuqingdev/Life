package com.lq.life.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.lq.life.R;

/**
 * Created by lq on 2018/10/16.
 */

public class CommonDialog extends Dialog {
//    private EditText edit;
//    private Button sureBtn;
//    private Button cancelBtn;
//    private MyClickListener listener;

    public CommonDialog(@NonNull Context context) {
        super(context,R.style.EditDialong);
//        this.listener = listener;
//        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_edit, null);
//        setContentView(contentView);
//        Window dialongWindow = getWindow();
//        WindowManager.LayoutParams lp = dialongWindow.getAttributes();
//        DisplayMetrics d = context.getResources().getDisplayMetrics();
//        lp.width = (int) (d.widthPixels*0.8);
//        dialongWindow.setAttributes(lp);
//        initView();
//        initListener();
    }

//    private void initView(){
//        edit = findViewById(R.id.edittext);
//        sureBtn = findViewById(R.id.sure_btn);
//        cancelBtn = findViewById(R.id.cancel_btn);
//    }
//
//    private void initListener(){
//        sureBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text = edit.getText().toString();
//                listener.clickSure(text);
//                dismiss();
//            }
//        });
//        cancelBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dismiss();
//            }
//        });
//    }
//
//    public interface MyClickListener{
//        void clickSure(String s);
//    }
}
