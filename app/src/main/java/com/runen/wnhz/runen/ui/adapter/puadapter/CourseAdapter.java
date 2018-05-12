package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.data.entity.MyCourseEntity;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHodler> {


    private List<MyCourseEntity.DataBean.ListBean> mlist;
    private Context mContext;
    private LayoutInflater inflater;


    public CourseAdapter(List<MyCourseEntity.DataBean.ListBean> mlist, Context mContext) {
        this.mlist = mlist;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHodler(inflater.inflate(R.layout.my_curriculum_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {

        Glide.with(mContext).load(mlist.get(position).getPic()).into(holder.iv_collection_img);
        holder.tv_collection_title.setText(mlist.get(position).getTitle() +  "标题");
        holder.tv_collection_data.setText("课程有限期：" + mlist.get(position).getExpirytime());
        holder.tv_yikan.setText("已看:" + mlist.get(position).getVcount() + "/" + mlist.get(position).getTcount());
        holder.tv_yidown.setText("已下载:" + mlist.get(position).getDcount() + "/" + mlist.get(position).getTcount());



    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_collection_img)
        ImageView iv_collection_img;

        @BindView(R.id.tv_collection_title)
        TextView tv_collection_title;

        @BindView(R.id.tv_collection_data)
        TextView tv_collection_data;

        @BindView(R.id.tv_yikan)
        TextView tv_yikan;

        @BindView(R.id.tv_yidown)
        TextView tv_yidown;

        public ViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
