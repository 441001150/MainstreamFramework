package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.runen.wnhz.runen.R;

import java.util.List;

import butterknife.BindView;

/**
 * NAME：薛世杰
 * DATE：2018/5/3
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class MyEvaluationAdapter extends RecyclerView.Adapter<MyEvaluationAdapter.ViewHodler> {



    private List<String> mlist;
    private LayoutInflater inflater;
    private Context mContext;

    public MyEvaluationAdapter(List<String> mlist, LayoutInflater inflater, Context mContext) {
        this.mlist = mlist;
        this.inflater = inflater;
        this.mContext = mContext;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHodler(inflater.inflate(R.layout.my_evaluation_item,null));
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHodler extends RecyclerView.ViewHolder{

        @BindView(R.id.ry_evaluation)
        RecyclerView recyclerView;

        @BindView(R.id.tv_type)
        TextView tv_type;

        public ViewHodler(View itemView) {
            super(itemView);
        }
    }
}
