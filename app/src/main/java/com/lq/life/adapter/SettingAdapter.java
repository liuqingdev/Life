package com.lq.life.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lq.life.R;
import com.lq.life.model.Setting;
import com.lq.life.widget.CommonViewHolder;

import java.util.List;

/**
 * Created by lq on 2018/11/7.
 */

public class SettingAdapter extends BaseAdapter {
    private List<Setting> settingList;

    public SettingAdapter(List<Setting> settingList) {
        this.settingList = settingList;
    }

    @Override
    public int getCount() {
        return settingList.size();
    }

    @Override
    public Object getItem(int position) {
        return settingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.slide_menu_item, parent, false);
        }
        ImageView leftImg = CommonViewHolder.get(convertView, R.id.left_img);
        TextView rightTxt = CommonViewHolder.get(convertView, R.id.right_text);
        Setting setting = settingList.get(position);
        leftImg.setImageResource(setting.getImgId());
        rightTxt.setText(setting.getDescrition());
        return convertView;
    }
}
