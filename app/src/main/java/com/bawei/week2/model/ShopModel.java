package com.bawei.week2.model;

import com.bawei.week2.contract.ShopContract;
import com.bawei.week2.model.bean.ShopBean;
import com.bawei.week2.util.NetUtil;
import com.google.gson.Gson;

public class ShopModel implements ShopContract.IModel {
    @Override
    public void onGetData(IModelCallback iModelCallback) {
        NetUtil.getInstance().getDataGet("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=5&keyword=手机", new NetUtil.MyCallback() {
            @Override
            public void onGetJson(String json) {
                ShopBean shopBean = new Gson().fromJson(json, ShopBean.class);
                iModelCallback.onSuccess(shopBean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallback.onFailure(throwable);
            }
        });
    }
}
