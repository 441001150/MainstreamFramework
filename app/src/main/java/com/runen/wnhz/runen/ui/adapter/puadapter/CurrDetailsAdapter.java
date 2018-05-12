package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.data.entity.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2018-04-26.
 */

public class CurrDetailsAdapter extends RecyclerView.Adapter<CurrDetailsAdapter.ViewHodler> {

    
    private LayoutInflater inflater;
    private Context mContext;
    private List<BaseEntity> mDatas;

    public CurrDetailsAdapter(Context mContext, List<BaseEntity> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHodler(inflater.inflate(R.layout.item_currdetails,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHodler extends RecyclerView.ViewHolder{

        public ViewHodler(View itemView) {
            super(itemView);
        }
    }
}
