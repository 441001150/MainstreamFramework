package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-04-24.
 */

public class ArticleListEntity implements Serializable {
    
    /**
     * * @return string re    =>0
     * @return string info  =>暂无文章
     * @return object data  =>返回信息集
     * @return string data.sum_page  =>总页数
     * @return string data.page  =>当前页面
     * @return string data.is_page  =>是否有下一页 1有 0无
     * @return string re    =>1
     * @return string info  =>获取成功
     * @return object data  =>返回信息集
     * @return object data.list  =>文章列表信息集
     * @return string data.list.0.form_id  =>文章fid
     * @return string data.list.0.form_title  =>标题
     * @return string data.list.0.form_img  =>图片
     * @return string data.list.0.views  =>阅读量
     * @return string data.list.0.des  =>描述
     * @return string data.sum_page  =>总页数
     * @return string data.page  =>当前页面
     * @return string data.is_page  =>是否有下一页 1有 0无
     * */

    /**
     * list : [{"tid":"2","title":"描写梅花的美文","views":"1","timg":"https://www.meiwen.com.cn/uploads/1803/20180324113919646.jpg"},{"tid":"1","title":"惊扰了桃花，掠去了芳华","views":"1","timg":"https://www.meiwen.com.cn/uploads/1804/20180405000313483.jpg"}]
     * sum_page : 1
     * page : 0
     * is_page : 0
     */

    private String sum_page;
    private String page;
    private String is_page;
    private List<ListBean> list;

    public String getSum_page() {
        return sum_page;
    }

    public void setSum_page(String sum_page) {
        this.sum_page = sum_page;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getIs_page() {
        return is_page;
    }

    public void setIs_page(String is_page) {
        this.is_page = is_page;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * tid : 2
         * title : 描写梅花的美文
         * views : 1
         * timg : https://www.meiwen.com.cn/uploads/1803/20180324113919646.jpg
         */

        private String tid;
        private String title;
        private String views;
        private String timg;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getTimg() {
            return timg;
        }

        public void setTimg(String timg) {
            this.timg = timg;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "tid='" + tid + '\'' +
                    ", title='" + title + '\'' +
                    ", views='" + views + '\'' +
                    ", timg='" + timg + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ArticleListEntity{" +
                "sum_page='" + sum_page + '\'' +
                ", page='" + page + '\'' +
                ", is_page='" + is_page + '\'' +
                ", list=" + list +
                '}';
    }
}
