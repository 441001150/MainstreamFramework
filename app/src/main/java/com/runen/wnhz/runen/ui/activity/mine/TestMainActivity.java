package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.Anticlockwise;
import com.runen.wnhz.runen.widget.TitleBuilder;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-04-13.
 */

public class TestMainActivity extends BaseActivity implements Anticlockwise.OnTimeCompleteListener, View.OnClickListener {

    Anticlockwise chronometer;
    ListView test_list_view;
    private TextView tv_last;
    private TextView tv_next;
    ArrayList<String>  subjects = new ArrayList<>();
    @Override
    protected int getLayoutView() {
        return R.layout.test_main_activity_layout;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {
        switch (clicked) {
            case LEFT:
                finish();
                break;
            case MIDDLE:
                break;
            case RIGHT:
                break;
            default:
                break;
        }
    }

    @Override
    protected void initStart() {

    }
    

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("单元测试")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }


    @Override
    public void onClick(View view) {
        
    }

    @Override
    public void onTimeComplete() {

    }
/*

    @Override
    public void initUiAndListener() {
        initView();
        initData();
        initAdapter();
        test_list_view.setAdapter(testMainAdapter);

        test_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(test_list_view.getChoiceMode()==ListView.CHOICE_MODE_SINGLE){
                    int checkedItemPosition = test_list_view.getCheckedItemPosition();
                    Toast.makeText(mContext, "you chose item " + checkedItemPosition, Toast.LENGTH_SHORT).show();
                }else if(test_list_view.getChoiceMode()==ListView.CHOICE_MODE_MULTIPLE){
                    SparseBooleanArray checkedItemPositions = test_list_view.getCheckedItemPositions();
                    boolean isChecked = checkedItemPositions.get(position);
                    Toast.makeText(mContext, "item " + position + " isChecked=" + isChecked, Toast.LENGTH_SHORT).show();
                }
                
               

               
            }
        });
        chronometer.setTimeFormat("HH:mm:ss");
        chronometer.setLabel("倒计时 ");
        chronometer.setOnTimeCompleteListener(this);
        chronometer.initTime(60*120);//秒钟
        chronometer.start();
    }
    
    private void initView(){
        chronometer = findViewById(R.id.test_chronometer);
        test_list_view = findViewById(R.id.test_list_view);
        tv_last = findViewById(R.id.tv_last);
        tv_next = findViewById(R.id.tv_next);

        tv_last.setOnClickListener(this);
        tv_next.setOnClickListener(this);
        
        
        test_list_view.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onTimeComplete() {
        ToastUtil.showToast("时间到");
    }
    
    private void initAdapter(){
        testMainAdapter = new TestMainAdapter(mContext,subjects);
    }
    
    private void initData(){
        subjects.add("vjhh");
        subjects.add("wqer");
        subjects.add("hfgh");
        subjects.add("qwea");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_next:
                subjects.clear();
                subjects.add("123");
                subjects.add("456");
                subjects.add("789");
                test_list_view.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                test_list_view.clearChoices();
                testMainAdapter.notifyDataSetChanged();
                break;
            case R.id.tv_last:
                subjects.clear();
                subjects.add("vjhh");
                subjects.add("wqer");
                subjects.add("hfgh");
                test_list_view.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                test_list_view.clearChoices();
                testMainAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    @Override
    public void showPageLoading() {
        
    }

    @Override
    public void hidePageLoading() {

    }
*/
}
