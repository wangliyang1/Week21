package com.bawei.week2;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week2.base.BaseActivity;
import com.bawei.week2.contract.ShopContract;
import com.bawei.week2.model.bean.ShopBean;
import com.bawei.week2.presenter.ShopPresenter;
import com.bawei.week2.view.MyAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<ShopPresenter> implements ShopContract.IView {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    @Override
    protected void initData() {
        mPresenter.onGetData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected ShopPresenter provitePresenter() {
        return new ShopPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(ShopBean shopBean) {
        List<ShopBean.ResultBean> result = shopBean.getResult();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(result);
        recycler.setAdapter(myAdapter);
        myAdapter.setOnClickListener(new MyAdapter.OnClickListener() {
            @Override
            public void onClick(String s) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFailure(Throwable throwable) {

    }

}
