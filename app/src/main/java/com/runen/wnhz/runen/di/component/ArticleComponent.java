package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.PerActivity;
import com.runen.wnhz.runen.di.module.ArticleMdule;
import com.runen.wnhz.runen.di.module.HomeMdule;
import com.runen.wnhz.runen.ui.activity.ArticleListActivity;
import com.runen.wnhz.runen.ui.fragment.minem.HomeFragment;

import dagger.Component;

/**
 * Created by Administrator on 2018-04-24.
 */
@PerActivity
@Component(modules = ArticleMdule.class,dependencies = ApplicationComponent.class)
public interface ArticleComponent {
    
    void initject(ArticleListActivity activity);
}
