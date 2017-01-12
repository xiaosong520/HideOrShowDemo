package com.hideorshowdemo.utils;

import android.view.View;
import android.view.animation.TranslateAnimation;


/**
 * TODO<标题栏动画显示隐藏的工具类>
 *
 * @author: 小嵩
 * @date: 2017/1/9 11:16
 * @version: V1.0
 */

public class HideAnimationUtils {

    private Boolean Show;
    private View view_title;
    private View view_bottom;

    public HideAnimationUtils(Boolean show, View title, View bottom) {
        this.Show = show;
        this.view_title = title;
        this.view_bottom = bottom;
        ShowOrHideTitle();
        ShowOrHideBottom();
    }

    private void ShowOrHideTitle(){//标题栏
        int fromY;//0表示控件Y轴起点
        int toY;//正值表示下移，负值上移
        if (Show) {//显示
            fromY = -view_title.getHeight();
            toY = 0;
        } else {//隐藏
            fromY = 0;
            toY = -view_title.getHeight();
        }
        final TranslateAnimation animation;//平移动画
        animation = new TranslateAnimation(0, 0, fromY, toY);
        animation.setDuration(400);//设置动画持续毫秒
        animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        view_title.startAnimation(animation);
    }

    private void ShowOrHideBottom(){//底部栏
        int fromY;//0表示控件Y轴起点
        int toY;//正值表示下移，负值上移
        if (Show) {//显示
            fromY = view_bottom.getHeight();
            toY = 0;
        } else {//隐藏
            fromY = 0;
            toY = view_bottom.getHeight();
        }
        final TranslateAnimation animation;//平移动画
        animation = new TranslateAnimation(0, 0, fromY, toY);
        animation.setDuration(400);//设置动画持续毫秒
        animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        view_bottom.startAnimation(animation);
    }
}
