package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.x;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FeedNativeView extends RelativeLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public FeedNativeView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        Object[] objArr = {context};
        ClassLoader a10 = br.a(context);
        this.mLoader = a10;
        View view = (View) as.a(x.f10420e, a10, (Class<?>[]) new Class[]{Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void changeViewLayoutParams(Object obj) {
        View view = this.mAdView;
        if (view != null) {
            as.a(x.f10420e, view, this.mLoader, "changeLayoutParams", new Class[]{Object.class}, obj);
        }
    }

    public int getAdContainerHeight() {
        View view = this.mAdView;
        if (view != null) {
            Object a10 = as.a(x.f10420e, view, this.mLoader, "getAdContainerHeight", new Class[0], new Object[0]);
            if (a10 instanceof Number) {
                return ((Integer) a10).intValue();
            }
        }
        return 0;
    }

    public int getAdContainerWidth() {
        View view = this.mAdView;
        if (view != null) {
            Object a10 = as.a(x.f10420e, view, this.mLoader, "getAdContainerWidth", new Class[0], new Object[0]);
            if (a10 instanceof Number) {
                return ((Integer) a10).intValue();
            }
        }
        return 0;
    }

    public RelativeLayout getContainerView() {
        View view = this.mAdView;
        if (view != null) {
            return (RelativeLayout) as.a(x.f10420e, view, this.mLoader, "getAdView", new Class[0], new Object[0]);
        }
        return null;
    }

    public void setAdData(XAdNativeResponse xAdNativeResponse) {
        View view = this.mAdView;
        if (view != null) {
            as.a(x.f10420e, view, this.mLoader, "setAdResponse", new Class[]{Object.class}, xAdNativeResponse);
        }
    }

    public FeedNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FeedNativeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context);
    }
}
