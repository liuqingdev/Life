package com.lq.life.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lq.life.R;
import com.lq.life.utils.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends BaseActivity {
    private StartActivity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,2000);
    }
}
