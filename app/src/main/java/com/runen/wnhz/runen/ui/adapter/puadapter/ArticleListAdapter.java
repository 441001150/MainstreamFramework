package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.data.entity.ArticleListEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {

    private MyItemClickListener mItemClickListener;
    private Context mContext;
    private ArticleListEntity mDatas;
    private LayoutInflater inflater;

    public ArticleListAdapter(Context mContext, ArticleListEntity mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ArticleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_article, null);
        return new ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ArticleListEntity.ListBean article = holder.article = mDatas.getList().get(position);
        //加载图片
        Glide.with(mContext).load(article.getTimg()).into(holder.ivTushuo);
        //设置标题
        holder.tvShuoTitle.setText(article.getTitle());
        //设置阅读人数
        holder.tvShuoView.setText(article.getViews() + "人阅读");
    }

    @Override
    public int getItemCount() {
        return mDatas.getList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MyItemClickListener mListener;
        private ArticleListEntity.ListBean article;

        @BindView(R.id.recycler_item)
        RelativeLayout recycler_item;
        @BindView(R.id.iv_tushuo)
        ImageView ivTushuo;
        @BindView(R.id.tv_shuo_title)
        TextView tvShuoTitle;
        @BindView(R.id.tv_shuo_view)
        TextView tvShuoView;

        public ViewHolder(View itemView, MyItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mListener = onItemClickListener;
            recycler_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(view, article);
            }
        }
    }

    /**
     * 创建一个回调接口
     */
    public interface MyItemClickListener {
        void onItemClick(View view, ArticleListEntity.ListBean article);
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
