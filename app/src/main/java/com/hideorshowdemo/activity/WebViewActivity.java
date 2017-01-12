package com.hideorshowdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hideorshowdemo.R;
import com.hideorshowdemo.utils.HideAnimationUtils;
import com.hideorshowdemo.widget.ObservableWebView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * TODO<WebView示例>
 *
 * @author: 小嵩
 * @date: 2017/1/9 11:24
 * @version: V1.0
 */

public class WebViewActivity extends AppCompatActivity {

    @Bind(R.id.webview)
    ObservableWebView webview;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lv_bottom)
    LinearLayout lv_bottom;

    private boolean isShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        webview.loadUrl("http://map.baidu.com/");
        webview.setOnScrollListener(new ObservableWebView.OnScrollListener() {
            @Override
            public void onScroll(int dx, int dy) {
                if (dy>0&&isShowing){//手指往上滑,并且标题栏已经显示，则隐藏底部栏
                    isShowing = false;
                 /*   Animation(false);*/
                    new HideAnimationUtils(false,toolbar,lv_bottom);
                }else if (dy<=0&&!isShowing){//往下滑，已隐藏，则显示
                    isShowing = true;
                    new HideAnimationUtils(true,toolbar,lv_bottom);
                  /*  Animation(true);*/
                }
            }
        });
        //webView点击链接 使网页用WebView打开
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }


      /* private void Animation(Boolean Show) {// 显隐动画效果,已统一封装到TitleAnimationUtils，减少代码冗余
        isShowing = Show;
        int fromY;//0表示控件Y轴起点
        int toY;//正值表示下移，负值上移

            if (Show) {//显示
                fromY = lv_bottom.getHeight();
                toY = 0;
            } else {//隐藏
                fromY = 0;
                toY = lv_bottom.getHeight();
            }
            final TranslateAnimation animation;//平移动画
            animation = new TranslateAnimation(0, 0, fromY, toY);
            animation.setDuration(400);//设置动画持续毫秒
            animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
           lv_bottom.startAnimation(animation);
    }*/

    @OnClick(R.id.iv_back)
    public void OnClick(View v) {
        switch (v.getId()){
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
