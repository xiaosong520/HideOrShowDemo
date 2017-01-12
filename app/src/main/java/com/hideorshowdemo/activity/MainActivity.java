package com.hideorshowdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hideorshowdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * TODO<显示/隐藏标题栏 demo 主页面 >
 *
 * @author: 小嵩
 * @date: 2017/1/9 11:24
 * @version: V1.0
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_chick)
    TextView tvChick;
    @Bind(R.id.tv_scrollview)
    TextView tvScrollview;
    @Bind(R.id.tv_recyclerview)
    TextView tvRecyclerview;
    @Bind(R.id.tv_webview)
    TextView tvWebview;
    @Bind(R.id.tv_behavior)
    TextView tv_behavior;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ivBack.setVisibility(View.GONE);
        tvTitle.setText("主界面");
    }

    @OnClick({R.id.tv_chick, R.id.tv_scrollview, R.id.tv_recyclerview, R.id.tv_webview, R.id.tv_behavior})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.tv_chick:
                startActivity(new Intent(this, ClickActivity.class));
                break;
            case R.id.tv_scrollview:
                startActivity(new Intent(this, ScrollViewActivity.class));
                break;
            case R.id.tv_recyclerview:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.tv_webview:
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.tv_behavior:
                startActivity(new Intent(this, BehaviorActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
