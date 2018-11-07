package com.lq.life.activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lq.life.R;
import com.lq.life.UI.BaseToast;
import com.lq.life.adapter.FragmentAdapter;
import com.lq.life.adapter.SettingAdapter;
import com.lq.life.fragment.MainFragment;
import com.lq.life.model.Setting;
import com.lq.life.model.Katong;
import com.lq.life.utils.BaseActivity;
import com.lq.life.utils.ScreenUtils;
import com.lq.life.widget.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

import static com.lq.life.utils.Constants.TANSFER_DATA;


public class MainActivity extends BaseActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private RadioGroup radioGroup;
    private MainActivity context = this;
    private ImageView menuImg;
    private DrawerLayout drawerLayout;
    private List<Setting> settingList = new ArrayList<>();
    private Katong katong;
    private SettingAdapter settingAdapter;
    private ListView setListView;
    private LinearLayout powerLinear;
    private ImageView logoImg;
    private TextView nameTv;
    private RelativeLayout menu_rela;
    private ImageView backImg;
    private ViewPager pagerMain;
    private List<Fragment> fragmentList = new ArrayList<>();


    public static final int REQUEST_CODE_THEME = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initListener();
    }

    private void initData() {
        settingList.add(new Setting(R.mipmap.skin,"更换头像"));
        katong = new Katong(R.mipmap.d3,"闪电侠",14);
        fragmentList.add(new MainFragment());
    }

    private void initView() {
        backImg = findViewById(R.id.back_img);
        backImg.setOnClickListener(this);
        menu_rela = findViewById(R.id.ral_left_slide_menu);
        int screenHeight = ScreenUtils.getScreenAttr(context,0);
        //四舍五入。
        menu_rela.getLayoutParams().height = (int) Math.rint(screenHeight*0.328);

        nameTv = findViewById(R.id.user_name_logo_tv);
        logoImg = findViewById(R.id.user_logo_img);
        radioGroup = findViewById(R.id.main_rg);
        menuImg = findViewById(R.id.menu_img);
        menuImg.setOnClickListener(this);
        drawerLayout = findViewById(R.id.main_drawer);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        setListView = findViewById(R.id.function_listview);
        settingAdapter = new SettingAdapter(settingList);
        setListView.setAdapter(settingAdapter);
        setListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, ThemeActivity.class);
                startActivityForResult(intent,REQUEST_CODE_THEME);
            }
        });
        powerLinear = findViewById(R.id.power_linear);
        CountPower(katong);
        //加载电影recycler
        pagerMain = findViewById(R.id.pager_MainActivity);
        FragmentManager fm = getSupportFragmentManager();
        pagerMain.setAdapter(new FragmentAdapter(fm,fragmentList));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_img:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.back_img:
                drawerLayout.closeDrawers();
             default:
                 break;
        }
    }

    private void initListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_second_rb:
                        BaseToast.showToast(context,"蓝牙已断开，请重新连接");
                        break;
                    default:
                        break;
                }
            }
        });
    }



    private void CountPower(Katong kt){
        logoImg.setImageResource(kt.getLogo());
        nameTv.setText(kt.getName());
        int power = kt.getPower();
        //计算皇冠，太阳，月亮，星星个数
        int kingCount =(int) Math.floor (power/64);
        int sunCount = (int) Math.floor(power%64/16);
        int moonCount = (int) Math.floor(power%64%16/4);
        int starCount = power%64%16%4;


        powerLinear.removeAllViews();
        for(int i=0;i<kingCount;i++){
            //这里放在外面会报错。
            View kingItem = LayoutInflater.from(context).inflate(R.layout.king_item,null);
            powerLinear.addView(kingItem);
        }
        for (int i=0;i<sunCount;i++){
            View sunItem = LayoutInflater.from(context).inflate(R.layout.sun_item,null);
            powerLinear.addView(sunItem);
        }
        for (int i=0;i<moonCount;i++){
            View moonItem = LayoutInflater.from(context).inflate(R.layout.moon_item,null);
            powerLinear.addView(moonItem);
        }
        for (int i=0;i<starCount;i++){
            View starItem = LayoutInflater.from(context).inflate(R.layout.star_item,null);
            powerLinear.addView(starItem);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode ==REQUEST_CODE_THEME && resultCode==RESULT_OK){
            Katong kt = (Katong) data.getSerializableExtra(TANSFER_DATA);
            CountPower(kt);
        }
    }
}
