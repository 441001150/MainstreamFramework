package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.data.entity.ReceivingAddressEntity;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-04-28.
 */

public class ReceivingAdapter extends RecyclerView.Adapter<ReceivingAdapter.ViewHodler>  {
    
    private Context mContext;
    private LayoutInflater inflater;
    private List<ReceivingAddressEntity> mDatas;

    public ReceivingAdapter(Context mContext, List<ReceivingAddressEntity> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHodler(inflater.inflate(R.layout.receiving_address_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {

        holder.tv_user_name.setText(mDatas.get(position).getConsignee());
        holder.tv_user_address.setText(mDatas.get(position).getProvince() + mDatas.get(position).getCity() +  mDatas.get(position).getCounty() + mDatas.get(position).getPlace());
        holder.tv_user_phone.setText(mDatas.get(position).getTelephone());
        
        switch (mDatas.get(position).getMoren()){
            case "1":   //不是
                Drawable drawable = ContextCompat.getDrawable(mContext, R.mipmap.icon_rb_unsele);
                holder.tv_default.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                break;
            case "2":    //是
                Drawable drawable1 = ContextCompat.getDrawable(mContext, R.mipmap.icon_rb_sele);
                holder.tv_default.setCompoundDrawablesWithIntrinsicBounds(drawable1, null, null, null);
                break;
        }
    }
    
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder{
        
        @BindView(R.id.tv_user_name)     //用户名
        TextView tv_user_name;      
        
        @BindView(R.id.tv_user_phone)    //手机号
        TextView tv_user_phone;   
        
        @BindView(R.id.tv_user_address)   //地址
        TextView tv_user_address;    
        
        @BindView(R.id.tv_default)   //默认图标
        TextView tv_default;  
        
        @BindView(R.id.tv_edit)   //修改
        TextView tv_edit;      
        
        @BindView(R.id.tv_delete)  //删除
        TextView tv_delete;
        
        public ViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
