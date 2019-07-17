package com.lq.life.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lq.life.R;
import com.lq.life.model.Katong;
import com.lq.life.utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import static com.lq.life.utils.Constants.TANSFER_DATA;

/**
 * 用瀑布流加载人物
 */
public class ThemeActivity extends BaseActivity {
    private List<Katong> ktList = new ArrayList<>();
    private ThemeActivity context = this;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        initData();
        initView();
    }

    private void initData(){
        ktList.add(new Katong(R.mipmap.bfx,"蝙蝠侠",15));
        ktList.add(new Katong(R.mipmap.d1,"超人",18));
        ktList.add(new Katong(R.mipmap.d2,"闪电侠",11));
        ktList.add(new Katong(R.mipmap.d3,"蝙蝠侠",15));
        ktList.add(new Katong(R.mipmap.d4,"幻视",64));
        ktList.add(new Katong(R.mipmap.d5,"X超人",19));
        ktList.add(new Katong(R.mipmap.d6,"雷神",6));
        ktList.add(new Katong(R.mipmap.d8,"路灯侠",35));
    }

    private void initView(){
        recyclerView = findViewById(R.id.katong_recyclerview);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new KatongAdapter(ktList));
    }


    public class KatongAdapter extends RecyclerView.Adapter<MyHolder>{
        private List<Katong> list = new ArrayList<>();

        public KatongAdapter(List<Katong> list) {
            this.list = list;
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.katong_item, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            final Katong kt = list.get(position);
            holder.imageView.setImageResource(kt.getLogo());
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra(TANSFER_DATA,kt);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.katong_img);
        }
    }


}
