package com.lq.life.widget;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by lq on 2018/10/10.
 */
public class CommonViewHolder{
    public static <T extends View> T get(View view,int id){
        SparseArray<T> sparseArray = (SparseArray<T>) view.getTag();
        if (sparseArray==null){
            sparseArray = new SparseArray<>();
            view.setTag(sparseArray);
        }
        T itemView = sparseArray.get(id);
        if (itemView == null){
            itemView = view.findViewById(id);
            sparseArray.put(id,itemView);
        }
        return (T) itemView;
    }
}

