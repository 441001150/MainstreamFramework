package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.data.entity.UcenterEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-04-12.
 */

public class BalanceAdapter extends RecyclerView.Adapter<BalanceAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context mContext;
    private List<UcenterEntity> mDatas;

    public BalanceAdapter(Context mContext, List<UcenterEntity> mdatas) {
        this.inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.mDatas = mdatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.balance_activity_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_price.setText(mDatas.get(position).getValues());
        //前人写的
        /*if(mDatas.get(position).getValues()){
            price.setTextColor(ContextCompat.getColor(mContext, R.color.text_white));
            price.setBackgroundColor(ContextCompat.getColor(mContext, R.color.text_green));
        }else{
            price.setTextColor(ContextCompat.getColor(mContext, R.color.text_black));
            price.setBackground(ContextCompat.getDrawable(mContext, R.drawable.shape_grey_edittext_corners));
        }*/
        
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_price)
        TextView tv_price;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    
}
