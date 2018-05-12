package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.DisplayUtil;
import com.runen.wnhz.runen.data.entity.LessonListEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class LessonHomeAdapter extends RecyclerView.Adapter<LessonHomeAdapter.ViewHolder> {

    private MyItemClickListener mItemClickListener;
    private LayoutInflater inflater;
    private Context mContext;
    private LessonListEntity mDatas;

    public LessonHomeAdapter(Context mContext, LessonListEntity mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public LessonHomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_lessonhome, null);
        return new ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(LessonHomeAdapter.ViewHolder holder, int position) {
        LessonListEntity.ListBean dataEntity = holder.lessonEntity = mDatas.getList().get(position);
        //价格
        holder.tvPrice.setText("￥" + dataEntity.getPrice());
        //加载图片
        Glide.with(mContext).load(dataEntity.getPic()).into(holder.ivPic);
        // 标题
        holder.tvTitle.setText(dataEntity.getTitle());
        //在学人数
        holder.tvViews.setText(dataEntity.getViews() + "人在学");
    }

    @Override
    public int getItemCount() {
        return mDatas.getList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private MyItemClickListener mListener;
        LessonListEntity.ListBean lessonEntity;

        @BindView(R.id.recycler_item)
        LinearLayout recycler_item;
        @BindView(R.id.iv_pic)
        ImageView ivPic;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_star)
        TextView tvStar;
        @BindView(R.id.tv_views)
        TextView tvViews;
        @BindView(R.id.tv_price)
        TextView tvPrice;

        public ViewHolder(View itemView, MyItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mListener = onItemClickListener;
            recycler_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(view, lessonEntity);
            }
        }
    }

    /**
     * 创建一个回调接口
     */
    public interface MyItemClickListener {
        void onItemClick(View view, LessonListEntity.ListBean lessonEntity);
    }

    /**
     * 在activity里面adapter就是调用的这个方法,将点击事件监听传递过来,并赋值给全局的监听
     *
     * @param myItemClickListener
     */
    public void setItemClickListener(MyItemClickListener myItemClickListener) {
        this.mItemClickListener = myItemClickListener;
    }
}
