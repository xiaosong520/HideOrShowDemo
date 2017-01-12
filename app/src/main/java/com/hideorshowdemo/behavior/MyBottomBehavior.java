package com.hideorshowdemo.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO<自定义Behavior>
 *
 * @author: 小嵩
 * @date: 2017/1/12 09:43
 * @version: V1.0
 */


public class MyBottomBehavior extends CoordinatorLayout.Behavior<View> {


    public MyBottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        //这个方法是说明这个子控件是依赖AppBarLayout的
        return dependency instanceof AppBarLayout;
    }


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        float translationY = Math.abs(dependency.getTop());//获取更随布局的顶部位置
        child.setTranslationY(translationY);
        return true;
    }

}
