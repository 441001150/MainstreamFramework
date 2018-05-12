package com.runen.wnhz.runen.presenter.model;
import com.runen.wnhz.runen.data.entity.MyCollection;
import com.runen.wnhz.runen.data.entity.MyCourseEntity;
import com.runen.wnhz.runen.service.MyCourseApi;
import java.util.Map;
import rx.Observable;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */

public class CourseModel {


    MyCourseApi myCourseApi;

    public CourseModel(MyCourseApi myCourseApi) {
        this.myCourseApi = myCourseApi;
    }

    public  Observable<MyCourseEntity> getContent(Map<String,String> map){
        return myCourseApi.getCourse(map);
    }

    public   Observable<MyCollection> getUcenter(Map<String,String> map){
        return myCourseApi.getUcenter(map);
    }
}
