package com.runen.wnhz.runen.ui.fragment.minem;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.data.entity.ArticleEntity;
import com.runen.wnhz.runen.data.entity.ArticleListEntity;
import com.runen.wnhz.runen.data.entity.HomeBannerBean;
import com.runen.wnhz.runen.data.entity.LessonListEntity;
import com.runen.wnhz.runen.data.entity.ShopTypeEntity;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerHomeComponent;
import com.runen.wnhz.runen.di.module.HomeMdule;
import com.runen.wnhz.runen.presenter.Contart.HomeContart;
import com.runen.wnhz.runen.presenter.iPresenter.IhomePersenter;
import com.runen.wnhz.runen.ui.activity.ArticleListActivity;
import com.runen.wnhz.runen.ui.activity.main.MainActivity;
import com.runen.wnhz.runen.ui.adapter.puadapter.LessonHomeAdapter;
import com.runen.wnhz.runen.ui.adapter.puadapter.ShopTypeAdapter;
import com.runen.wnhz.runen.ui.adapter.puadapter.ZiliaoHomeAdapter;
import com.runen.wnhz.runen.ui.fragment.BaseFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-08.
 */

public class HomeFragment extends BaseFragment<IhomePersenter> implements View.OnClickListener, HomeContart.View {

    @BindView(R.id.convenientBanner)
    Banner banner;
    @BindView(R.id.tv_shuo_title)
    TextView tv_shuo_title;

    @BindView(R.id.tv_shuo_view)
    TextView tv_shuo_view;

    @BindView(R.id.tv_tushuo)
    TextView tv_tushuo;

    @BindView(R.id.iv_tushuo)
    ImageView iv_tushuo;

    @BindView(R.id.ry_tushuo)
    RelativeLayout relativeLayout;

    @BindView(R.id.ry_Forum)
    RecyclerView rvLesson;

    @BindView(R.id.ry_ziliaojingxuan)
    RecyclerView rvZiliao;

    @BindView(R.id.ry_data_service)
    RecyclerView rvDataService;


    private ArrayList<String> list_path = new ArrayList<>();
    private ArrayList<String> list_title = new ArrayList<>();

    private FragmentManager fm;
    private FragmentTransaction ft;

    public static final String TAG = "HomeFragment";


    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        DaggerHomeComponent.builder()
                .applicationComponent(appComponent)
                .homeMdule(new HomeMdule(this))
                .build().initject(this);

    }

    @Override
    protected int getLayoutView() {
        return R.layout.home_fragment_layout;
    }

    @Override
    public void initUiAndListener(View view) {

    }

    @Override
    protected void init() {
        UserBean reqeustUser = ACacheUtlis.getInstance().getReqeustUser(getContext());
        Log.e(TAG, "init: " + reqeustUser.toString());
        mPresenter.getBannerData();
        mPresenter.getImageSay();
        mPresenter.getLessonList(1, 0, 10);
        mPresenter.getZiliaoList(3, 0, 10);
        mPresenter.getShopTypeList();
        initLinClick();
        initView();
        fm = getFragmentManager();
    }

    private void initView() {

    }


    @Override
    protected void baseInit() {
        super.baseInit();

    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    private void initLinClick() {

        relativeLayout.setOnClickListener(this);

    }

    /**
     * 初始化banner
     */


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            //跳转到详情界面
            case R.id.ry_tushuo:
                JumpUtlis.getInstance().jumpActivity(getActivity(), ArticleListActivity.class);
                break;

        }
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

    /*跳转类型  1.article 文章 2.lesson 课程
     *         .url => 跳转地址  1.文章tid  2.课程lid
     *         0.img        => 展示图片*/
    @Override
    public void getBannerRequest(List<HomeBannerBean> bannerDatas) {
        Log.e("----1111", bannerDatas.size() + "");
        for (int i = 0; i < bannerDatas.size(); i++) {
            list_path.add(bannerDatas.get(i).getImg());
            list_title.add(bannerDatas.get(i).getUrl());

            //设置内置样式，共有六种可以点入方法内逐一体验使用。
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //设置图片加载器，图片加载器在下方
            banner.setImageLoader(new MyLoader());
            //设置图片网址或地址的集合
            banner.setImages(list_path);
            //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
            banner.setBannerAnimation(Transformer.Default);
            //设置轮播图的标题集合
            banner.setBannerTitles(list_title);
            //设置轮播间隔时间
            banner.setDelayTime(3000);
            //设置是否为自动轮播，默认是“是”。
            banner.isAutoPlay(true);
            //设置指示器的位置，小点点，左中右。
            banner.setIndicatorGravity(BannerConfig.CENTER)
                    //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                    .setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                        }
                    });
        }
        //必须最后调用的方法，启动轮播图。
        banner.start();
    }


    /**
     * return string re    =>1
     *
     * @return string data.des  =>描述
     */
    @Override
    public void getArticleRequest(ArticleEntity artleDatas) {
        String Fid = artleDatas.getFid();
        Glide.with(getContext()).load(artleDatas.getForm_img()).into(iv_tushuo);
        tv_shuo_view.setText(artleDatas.getViews() + "人阅读");
        tv_tushuo.setText(artleDatas.getForm_title());
        tv_shuo_title.setText(artleDatas.getDes());
    }

    @Override
    public void getArticleListRequest(ArticleListEntity articleListDatas) {
        Log.e("----artleList.get(0)", articleListDatas.getList().get(0).toString());

    }

    @Override
    public void getLessonListRequest(LessonListEntity lessonList) {
        Log.e("----LessonList.get(0)", lessonList.getList().get(0).toString());

        LessonListEntity.ListBean listBean = lessonList.getList().get(0);
        lessonList.getList().add(listBean);
        lessonList.getList().add(listBean);
        lessonList.getList().add(listBean);
        lessonList.getList().add(listBean);
        lessonList.getList().add(listBean);

        LessonHomeAdapter adapter = new LessonHomeAdapter(getContext(), lessonList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        rvLesson.setLayoutManager(manager);
        rvLesson.setAdapter(adapter);

        adapter.setItemClickListener(new LessonHomeAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, LessonListEntity.ListBean lessonEntity) {
                Log.e("----onItemClick", lessonEntity.toString());
            }
        });
    }

    @Override
    public void getZiliaoListRequest(LessonListEntity lessonList) {
        Log.e("----ZiliaoList.get(0)", lessonList.getList().get(0).toString());
        LessonListEntity.ListBean listBean = lessonList.getList().get(0);
        lessonList.getList().add(listBean);
        lessonList.getList().add(listBean);
        lessonList.getList().add(listBean);
        lessonList.getList().add(listBean);
        lessonList.getList().add(listBean);
        lessonList.getList().add(listBean);
        ZiliaoHomeAdapter adapter = new ZiliaoHomeAdapter(getContext(), lessonList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        rvZiliao.setLayoutManager(manager);
        rvZiliao.setAdapter(adapter);

        adapter.setItemClickListener(new ZiliaoHomeAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, LessonListEntity.ListBean lessonEntity) {
                Log.e("----onItemClick", lessonEntity.toString());
            }
        });
    }

    @Override
    public void getShopTypeRequest(List<ShopTypeEntity> shopTypeEntityList) {
        Log.e("----getShopTypeRequest", shopTypeEntityList.get(0).toString());

        ShopTypeAdapter adapter = new ShopTypeAdapter(getContext(), shopTypeEntityList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        rvDataService.setLayoutManager(manager);
        rvDataService.setAdapter(adapter);

        adapter.setItemClickListener(new ShopTypeAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, ShopTypeEntity shopTypeEntity) {
                Log.e("----onItemClick", shopTypeEntity.toString());

                EventBus.getDefault().post(shopTypeEntity.getId(), "shopType");
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.goToPublicFragment();
            }
        });
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
