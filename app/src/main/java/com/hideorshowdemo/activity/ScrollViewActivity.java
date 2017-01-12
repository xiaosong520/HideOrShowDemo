package com.hideorshowdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hideorshowdemo.R;
import com.hideorshowdemo.utils.HideAnimationUtils;
import com.hideorshowdemo.widget.ObservableScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * TODO<ScrollView示例>
 *
 * @author: 小嵩
 * @date: 2017/1/9 11:24
 * @version: V1.0
 */

public class ScrollViewActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.scrollView)
    ObservableScrollView scrollView;
    @Bind(R.id.lv_bottom)
    LinearLayout lvBottom;

    private boolean isShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        scrollView.setOnScrollListener(new ObservableScrollView.ScrollViewListener() {//滑动事件回调监听
            @Override
            public void onScroll(int dy) {
                if (dy > 0 && isShowing) {//手指往上滑,并且标题栏已经显示，则隐藏底部栏
                    isShowing = false;
                    new HideAnimationUtils(false, toolbar,lvBottom);
                } else if (dy <= 0 && !isShowing) {//往下滑，已隐藏，则显示
                    isShowing = true;
                    new HideAnimationUtils(true, toolbar,lvBottom);
                }
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
