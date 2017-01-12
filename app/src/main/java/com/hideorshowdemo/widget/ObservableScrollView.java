package com.hideorshowdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * TODO<自定义监听滑动的ScrollView>
 *
 * @author: 小嵩
 * @date: 2017/1/9 11:37
 */

public class ObservableScrollView extends ScrollView {

    private ScrollViewListener scrollViewListener = null;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnScrollListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {

            if (oldy < y && ((y - oldy) > 15)) {// 滑动距离超过15像素，翻向底部，控件向上滑动
                scrollViewListener.onScroll(y - oldy);

            } else if (oldy > y && (oldy - y) > 15) {// 滑动距离超过15像素，向下滑动，翻向顶部
                scrollViewListener.onScroll(y - oldy);
            }

        }
    }

    public  interface ScrollViewListener{//dy Y轴滑动距离
         void onScroll(int dy);
    }
}