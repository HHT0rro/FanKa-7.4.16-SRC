package com.wangmai.common.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CustomWebView extends WebView {
    public TouchCallback touchCallback;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface TouchCallback {
        void touchBack();
    }

    public CustomWebView(Context context) {
        super(context);
    }

    public static Context getFixedContext(Context context) {
        return context.createConfigurationContext(new Configuration());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.touchCallback == null) {
            return false;
        }
        this.touchCallback.touchBack();
        return false;
    }

    public void setTouchCallback(TouchCallback touchCallback) {
        this.touchCallback = touchCallback;
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
