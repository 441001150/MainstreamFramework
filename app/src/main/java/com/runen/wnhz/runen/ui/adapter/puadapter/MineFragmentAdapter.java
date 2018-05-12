package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.DisplayUtil;
import com.runen.wnhz.runen.data.entity.MineFragmentBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-04-09.
 */

public class MineFragmentAdapter extends BaseAdapter {

    Context mContext;
    
    ArrayList<MineFragmentBean> mDatas;

    public MineFragmentAdapter(Context context, ArrayList<MineFragmentBean> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.mine_fragment_item, null);
        TextView tv_mien_item = convertView.findViewById(R.id.tv_mien_item);
        View view_line = convertView.findViewById(R.id.view_line);
        if (position == 1 || position == 6) {
            ViewGroup.LayoutParams params = view_line.getLayoutParams();
            params.height = DisplayUtil.dp2px(mContext, 10);
            view_line.setLayoutParams(params);
        }
        tv_mien_item.setText(mDatas.get(position).getLabel());
        Drawable drawable = ContextCompat.getDrawable(mContext, mDatas.get(position).getResId());
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv_mien_item.setCompoundDrawables(drawable, null, null, null);
        return convertView;
    }
}
