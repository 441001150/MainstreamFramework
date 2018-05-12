package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;
import java.util.List;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class MyCollection implements Serializable {


    /**
     * re : 1
     * info : 获取成功
     * data : {"list":[{"id":"2","lid":"2","title":"VR+可视化学习的未来","pic":"http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72e046bdf0.png","learn_mans":"0","price":"600"}],"sum_page":"1","page":"0","is_page":"0"}
     */

    private String re;
    private String info;
    private DataBean data;

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"id":"2","lid":"2","title":"VR+可视化学习的未来","pic":"http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72e046bdf0.png","learn_mans":"0","price":"600"}]
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
             * id : 2
             * lid : 2
             * title : VR+可视化学习的未来
             * pic : http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72e046bdf0.png
             * learn_mans : 0
             * price : 600
             */

            private String id;
            private String lid;
            private String title;
            private String pic;
            private String learn_mans;
            private String price;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

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

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getLearn_mans() {
                return learn_mans;
            }

            public void setLearn_mans(String learn_mans) {
                this.learn_mans = learn_mans;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }
    }
}
