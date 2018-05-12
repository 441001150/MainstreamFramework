package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.data.entity.AllDataEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-04-23.
 */

public class AllRecyclerViewAdapter extends RecyclerView.Adapter<AllRecyclerViewAdapter.ViewHodler> {
    private MyItemClickListener mItemClickListener;
    private List<AllDataEntity> mDatas;
    private Context mContext;
    private LayoutInflater inflater;
    
    public AllRecyclerViewAdapter(Context context, List<AllDataEntity> mDatas) {
        this.mDatas = mDatas;
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_recyclervew, null);
        ViewHodler hodler = new ViewHodler(view, mItemClickListener);
        return hodler;
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {

        AllDataEntity dataEntity = holder.AllDataEntity = mDatas.get(position);
        //销售
        holder.item_money.setText(dataEntity.getSaleMoney());
        //加载图片
        Glide.with(mContext).load(dataEntity.getImagePath()).into(holder.item_path);
        // 标题
        holder.item_title.setText(dataEntity.getTitle());

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder implements View.OnClickListener{
        private MyItemClickListener mListener;

        AllDataEntity AllDataEntity;

        @BindView(R.id.item__recycler)
        ImageView item_path;
        @BindView(R.id.item_title)
        TextView item_title;
        @BindView(R.id.item_money)
        TextView item_money;
        @BindView(R.id.recycler_item)
        RelativeLayout recycler_item;

        public ViewHodler(View itemView, MyItemClickListener OnItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mListener = OnItemClickListener;
            recycler_item.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(view,AllDataEntity);
            }
        }
    }
    /**
     * 创建一个回调接口
     */
    public interface MyItemClickListener {
        void onItemClick(View view, AllDataEntity AllDataEntity);
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

