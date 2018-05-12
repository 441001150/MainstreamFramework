package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.data.entity.ShopTypeEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

public class ShopTypeAdapter extends RecyclerView.Adapter<ShopTypeAdapter.ViewHolder> {

    private MyItemClickListener mItemClickListener;
    private LayoutInflater inflater;
    private Context mContext;
    private List<ShopTypeEntity> mDatas;

    public ShopTypeAdapter(Context mContext, List<ShopTypeEntity> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ShopTypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_shop_type, null);
        return new ShopTypeAdapter.ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ShopTypeAdapter.ViewHolder holder, int position) {
        ShopTypeEntity shopTypeEntity = holder.shopTypeEntity = mDatas.get(position);
        //加载图片
        Glide.with(mContext).load(shopTypeEntity.getPic()).into(holder.ivShopType);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MyItemClickListener mListener;
        private ShopTypeEntity shopTypeEntity;

        @BindView(R.id.recycler_item)
        LinearLayout recycler_item;
        @BindView(R.id.iv_shop_type)
        ImageView ivShopType;

        public ViewHolder(View itemView, MyItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mListener = onItemClickListener;
            recycler_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(view, shopTypeEntity);
            }
        }
    }

    /**
     * 创建一个回调接口
     */
    public interface MyItemClickListener {
        void onItemClick(View view, ShopTypeEntity shopTypeEntity);
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
