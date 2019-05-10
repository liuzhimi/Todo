package com.lzm.todo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lzm.todo.R;
import com.wx.wheelview.adapter.BaseWheelAdapter;

/**
 * Created by YH on 2019/5/9.
 */

public class TimeShowAdapter extends BaseWheelAdapter<String> {
    private Context mContext;

    public TimeShowAdapter(Context context) {
        mContext = context;
    }

    @Override
    protected View bindView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.time_item_list, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.item_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(mList.get(position));
        return convertView;
    }

    static class ViewHolder {
        TextView textView;
    }
}
