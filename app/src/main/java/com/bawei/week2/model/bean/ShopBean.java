package com.bawei.week2.model.bean;

import java.util.List;

public class ShopBean {



    /**
     * result : [{"commodityId":100,"commodityName":"【壳膜线套餐】 苹果 iPhone XS 256G 全网通手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/1/1.jpg","price":10069,"saleNum":0},{"commodityId":111,"commodityName":"三合一充电器数据线苹果二合一拖安卓手机多用功能多头车载苹果安卓一拖三数据线Type-C铝合金编织线 土豪金","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sjpj/5/1.jpg","price":39,"saleNum":0},{"commodityId":106,"commodityName":"三星Galaxy S9+ 6GB+128GB版曲屏手机/指纹识别手机/拍照手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/7/1.jpg","price":6199,"saleNum":0},{"commodityId":103,"commodityName":"【送自拍杆】魅族 魅蓝 E3 64G 全面屏 全网通手机","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/sj/4/1.jpg","price":1638,"saleNum":0},{"commodityId":114,"commodityName":"羽博 可悬挂无线蓝牙便携音响 布面工艺方形户外超重低音蓝牙音响车载手机迷你蓝牙音箱","masterPic":"http://172.17.8.100/images/small/commodity/sjsm/yyyl/1/1.jpg","price":49,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 100
         * commodityName : 【壳膜线套餐】 苹果 iPhone XS 256G 全网通手机
         * masterPic : http://172.17.8.100/images/small/commodity/sjsm/sj/1/1.jpg
         * price : 10069
         * saleNum : 0
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
    @Override
    public String toString() {
        return "ShopBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", result=" + result +
                '}';
    }
}
