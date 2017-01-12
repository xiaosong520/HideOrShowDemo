package com.hideorshowdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * TODO<自定义监听滑动的WebView>
 *
 * @author: 小嵩
 * @QQ: 1006013376
 * @date: 2017/1/9 11:36
 * @version: V1.0
 */

public class ObservableWebView extends WebView {
    private OnScrollListener onScrollListener;

    public ObservableWebView(final Context context) {
        super(context);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(final int l, final int t, final int oldl, final int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (onScrollListener != null) {
            onScrollListener.onScroll(l - oldl, t - oldt);
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    /**
     * Impliment in the activity/fragment/view that you want to listen to the webview(在需要的地方实现该接口)
     */
    public interface OnScrollListener {
         void onScroll(int dx, int dy);
    }
}
