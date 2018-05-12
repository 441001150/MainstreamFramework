package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;
import java.util.List;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class MyCourseEntity implements Serializable{

    /**
     * re : 1
     * info : 获取成功
     * data : {"list":[{"lid":"2","expirytime":"24天","title":"VR+可视化学习的未来","pic":"http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72e046bdf0.png","dcount":"2","vcount":"0","tcount":"4"},{"lid":"1","expirytime":"24天","title":"付费 会员配置 修改付费","pic":"http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72dde9ac11.jpg","dcount":"0","vcount":"0","tcount":"4"}],"sum_page":"1","page":"0","is_page":"0"}
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
         * list : [{"lid":"2","expirytime":"24天","title":"VR+可视化学习的未来","pic":"http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72e046bdf0.png","dcount":"2","vcount":"0","tcount":"4"},{"lid":"1","expirytime":"24天","title":"付费 会员配置 修改付费","pic":"http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72dde9ac11.jpg","dcount":"0","vcount":"0","tcount":"4"}]
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
             * lid : 2
             * expirytime : 24天
             * title : VR+可视化学习的未来
             * pic : http://runen.unohacha.com/Uploads/Picture/uploads/20180418/5ad72e046bdf0.png
             * dcount : 2
             * vcount : 0
             * tcount : 4
             */

            private String lid;
            private String expirytime;
            private String title;
            private String pic;
            private String dcount;
            private String vcount;
            private String tcount;

            public String getLid() {
                return lid;
            }

            public void setLid(String lid) {
                this.lid = lid;
            }

            public String getExpirytime() {
                return expirytime;
            }

            public void setExpirytime(String expirytime) {
                this.expirytime = expirytime;
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

            public String getDcount() {
                return dcount;
            }

            public void setDcount(String dcount) {
                this.dcount = dcount;
            }

            public String getVcount() {
                return vcount;
            }

            public void setVcount(String vcount) {
                this.vcount = vcount;
            }

            public String getTcount() {
                return tcount;
            }

            public void setTcount(String tcount) {
                this.tcount = tcount;
            }

            @Override
            public String toString() {
                return "ListBean{" +
                        "lid='" + lid + '\'' +
                        ", expirytime='" + expirytime + '\'' +
                        ", title='" + title + '\'' +
                        ", pic='" + pic + '\'' +
                        ", dcount='" + dcount + '\'' +
                        ", vcount='" + vcount + '\'' +
                        ", tcount='" + tcount + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "sum_page='" + sum_page + '\'' +
                    ", page='" + page + '\'' +
                    ", is_page='" + is_page + '\'' +
                    ", list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyCourseEntity{" +
                "re='" + re + '\'' +
                ", info='" + info + '\'' +
                ", data=" + data +
                '}';
    }
}