package com.hideorshowdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hideorshowdemo.R;
import com.hideorshowdemo.adapter.RecyclerAdapter;
import com.hideorshowdemo.utils.HideAnimationUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * TODO<RecyclerView示例>
 *
 * @author: 小嵩
 * @date: 2017/1/9 11:24
 * @version: V1.0
 */

public class RecyclerViewActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.lv_bottom)
    LinearLayout lvBottom;
    private RecyclerAdapter adapter;
    private boolean isShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        InitView();
    }

    private void InitView() {

        ArrayList mData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {//测试数据
            mData.add("Item" + i);
        }
        View HeadView = LayoutInflater.from(this).inflate(R.layout.empty_layout, null);

        adapter = new RecyclerAdapter(mData);
        adapter.setHeaderView(HeadView);//添加一个高度为标题栏的空头部

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);

        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {//滑动监听回调
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 15 && isShowing) {//手指往上滑,并且标题栏已经显示，则隐藏底部栏
                    isShowing = false;
                    new HideAnimationUtils(false, toolbar,lvBottom);
                } else if (dy <= -15 && !isShowing) {//往下滑，已隐藏，则显示
                    isShowing = true;
                    new HideAnimationUtils(true, toolbar,lvBottom);
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
