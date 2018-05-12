package com.runen.wnhz.runen.ui.fragment.publicm;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.data.entity.AllDataEntity;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.dataservice.DataSerciceDetails;
import com.runen.wnhz.runen.ui.adapter.puadapter.AllRecyclerViewAdapter;
import com.runen.wnhz.runen.ui.fragment.BaseFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-04-23.
 * 根据后台传回来的title，增加AllFragment
 */

public class AllFragment extends BaseFragment {
    
    
    private String TAG =  "AllFragment";
    
    RecyclerView recyclerView;
    
    AllRecyclerViewAdapter adapter;
    
    private List<AllDataEntity> allDatas = new ArrayList<>();
    

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        
    }

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_all_data;
    }

    @Override
    public void initUiAndListener(View view) {

        recyclerView = view.findViewById(R.id.all_recyclerview);
        
        
        initSetData();
        

    }

    private void initSetData() {
        //假数据
        for (int i = 0; i < 20 ; i++) {
            AllDataEntity allDataEntity = new AllDataEntity();
            allDataEntity.setCallPhone("12345678");
            allDataEntity.setContacts("周青青");
            allDataEntity.setEndData("2018.999");
            allDataEntity.setImagePath("http://img.zcool.cn/community/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png");
            allDataEntity.setSaleMoney("123232323");
            allDataEntity.setStoreSize(123232323);
            allDataEntity.setPassengerFlow(1232323);
            allDataEntity.setTitle("测试数据");
            allDatas.add(allDataEntity);

        }
        adapter = new AllRecyclerViewAdapter(getContext(),allDatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        
        adapter.setItemClickListener(new AllRecyclerViewAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, AllDataEntity data) {
                //跳转带数据服务详情界面
                Log.e(TAG,data.toString() );
                Intent intent = new Intent(getContext(), DataSerciceDetails.class);
                intent.putExtra("data",data);
                startActivity(intent);
                
            }
        });
        
        
        
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    @Override
    public void showLoadding() {
        
    }

    @Override
    public void dimissLoding() {

    }

    @Override
    public void showErrorMessage(String msg) {
        
    }
    

    @Override
    public void onTitleButtonClicked(TitleBuilder.TitleButton clicked) {

    }
}
