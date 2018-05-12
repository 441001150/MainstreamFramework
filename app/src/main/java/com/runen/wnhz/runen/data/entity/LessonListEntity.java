package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-05-02.
 */

public class LessonListEntity implements Serializable {
    
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
     * @return object data.list  =>课程列表信息集
     * @return string data.list.0.lid  =>课程id
     * @return string data.list.0.title  =>标题
     * @return string data.list.0.pic  =>图片
     * @return string data.list.0.views  =>阅读量
     * @return string data.list.0.price  =>课程价格
     * @return string data.list.0.star  =>课程评分
     * @return string data.sum_page  =>总页数
     * @return string data.page  =>当前页面
     * @return string data.is_page  =>是否有下一页 1有 0无
     * */

    /**
     * list :  [{"lid": "2","title": "VR+可视化学习的未来","views": "0","pic": "http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72e046bdf0.png","price": "600.00","star": "0.0"}]
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
         * "lid": "2",
         * "title": "VR+可视化学习的未来",
         * "views": "0",
         * "pic": "http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72e046bdf0.png",
         * "price": "600.00",
         * "star": "0.0"
         */

        private String lid;
        private String title;
        private String views;
        private String pic;
        private String price;
        private String star;

        public String getLid() {
            return lid;
        }

        public void setLid(String lid) {
            this.lid = lid;
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

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getStar() {
            return star;
        }

        public void setStar(String star) {
            this.star = star;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "lid='" + lid + '\'' +
                    ", title='" + title + '\'' +
                    ", views='" + views + '\'' +
                    ", pic='" + pic + '\'' +
                    ", price='" + price + '\'' +
                    ", star='" + star + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LessonListEntity{" +
                "sum_page='" + sum_page + '\'' +
                ", page='" + page + '\'' +
                ", is_page='" + is_page + '\'' +
                ", list=" + list +
                '}';
    }
}
