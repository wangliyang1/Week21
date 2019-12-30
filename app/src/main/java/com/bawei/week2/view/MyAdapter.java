package com.bawei.week2.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week2.R;
import com.bawei.week2.model.bean.ShopBean;
import com.bawei.week2.util.NetUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<ShopBean.ResultBean> result;

    public MyAdapter(List<ShopBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.child, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ShopBean.ResultBean resultBean = result.get(position);
        holder.childOne.setText(resultBean.getCommodityName());
        holder.childTwo.setText(resultBean.getPrice()+"");
        NetUtil.getInstance().getPhono(resultBean.getMasterPic(),holder.childImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(resultBean.getCommodityName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.child_image)
        ImageView childImage;
        @BindView(R.id.child_one)
        TextView childOne;
        @BindView(R.id.child_two)
        TextView childTwo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(String s);
    }

}
