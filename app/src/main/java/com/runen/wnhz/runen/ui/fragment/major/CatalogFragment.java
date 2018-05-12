package com.runen.wnhz.runen.ui.fragment.major;

import android.view.View;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.fragment.BaseFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;

/**
 * Created by Administrator on 2018-04-13.
 */

public class CatalogFragment extends BaseFragment {

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        
    }

    @Override
    protected int getLayoutView() {
        return R.layout.catalog_fragment_layout;
    }

    @Override
    public void initUiAndListener(View view) {

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
