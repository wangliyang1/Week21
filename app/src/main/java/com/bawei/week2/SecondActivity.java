package com.bawei.week2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.week2.base.BaseActivity;
import com.bawei.week2.base.BasePresenter;
import com.bawei.week2.model.bean.ShopBean;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends BaseActivity {


    @BindView(R.id.second_tv)
    TextView secondTv;
    @BindView(R.id.second_image)
    ImageView secondImage;
    @BindView(R.id.second_bt1)
    Button secondBt1;
    @BindView(R.id.second_bt2)
    Button secondBt2;

    @Override
    protected void initData() {
        secondImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(secondImage, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(SecondActivity.this, "成功"+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(SecondActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
    }

    @Override
    protected void initView() {
        CodeUtils.init(this);
    }

    @Override
    protected BasePresenter provitePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_second;
    }


    @OnClick({R.id.second_tv, R.id.second_bt1, R.id.second_bt2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.second_tv:
                Bitmap one = CodeUtils.createImage("一二三四五六七", 400, 400, null);
                secondImage.setImageBitmap(one);
                break;
            case R.id.second_bt1:
                EventBus.getDefault().post("一二三四五六七");
                break;
            case R.id.second_bt2:
                EventBus.getDefault().post(new ShopBean());
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent1(String s){
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent2(ShopBean s){
        Toast.makeText(this, ""+s.toString(), Toast.LENGTH_SHORT).show();
    }
}
