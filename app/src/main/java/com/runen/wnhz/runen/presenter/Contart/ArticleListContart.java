package com.runen.wnhz.runen.presenter.Contart;

import com.runen.wnhz.runen.data.entity.ArticleListEntity;
import com.runen.wnhz.runen.ui.BaseView;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

public interface ArticleListContart {


    interface View extends BaseView {
        //获取图说列表信息
        void getArticleListRequest(ArticleListEntity artleListDatas);
    }
}
