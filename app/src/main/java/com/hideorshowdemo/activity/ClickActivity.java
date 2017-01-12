package com.hideorshowdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hideorshowdemo.R;
import com.hideorshowdemo.utils.HideAnimationUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * TODO<点击屏幕 显示/隐藏>
 *
 * @author: 小嵩
 * @date: 2017/1/9 11:24
 * @version: V1.0
 */

public class ClickActivity extends AppCompatActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.lv_bottom)
    LinearLayout lvBottom;

    private boolean isShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        ButterKnife.bind(this);
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
    public boolean onTouchEvent(MotionEvent event) {//重载TouchEvent 监听事件
        if (event.getAction() == MotionEvent.ACTION_DOWN) {//手指按下
            if (isShowing) {//如果标题栏是显示状态，则隐藏
                isShowing = false;
                new HideAnimationUtils(false, toolbar, lvBottom);
                /*Animation(false);*/
            } else {
                isShowing = true;
                new HideAnimationUtils(true, toolbar, lvBottom);
            }
        }
        return super.onTouchEvent(event);
    }

      /*  private void Animation(Boolean Show) {// 显隐动画效果,已统一封装到TitleAnimationUtils，减少代码冗余
        isShowing = Show;
        int fromY;//0表示控件Y轴起点
        int toY;//正值表示下移，负值上移
        if (Show) {//显示
            fromY = -toolbar.getHeight();
            toY = 0;
        } else {//隐藏
            fromY = 0;
            toY = -toolbar.getHeight();
        }
        final TranslateAnimation animation;//平移动画
        animation = new TranslateAnimation(0, 0, fromY, toY);
        animation.setDuration(400);//设置动画持续毫秒
        animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        toolbar.startAnimation(animation);
    }*/

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
