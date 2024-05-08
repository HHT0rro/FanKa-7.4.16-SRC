package com.alibaba.security.tools.flexible;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.security.tools.flexible.component.IFlexibleComp;
import java.math.BigDecimal;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FlexibleContext<T> {
    private static final String TAG = "FlexibleContext";
    private Context mContext;
    private T mOwner;
    private View mView;
    private boolean setContentView = true;

    public FlexibleContext(T t2, Context context) {
        this.mOwner = t2;
        this.mContext = context;
    }

    private View adaptiveView(Context context, View view) {
        FlexibleComponent flexibleComponent = FlexibleComponent.INSTANCE;
        BigDecimal zoomRate = flexibleComponent.getZoomRate(context);
        Iterator<IFlexibleComp> iterator2 = flexibleComponent.getAllComponents().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().adaptive(view, zoomRate);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                adaptiveView(context, viewGroup.getChildAt(i10));
            }
        }
        return view;
    }

    private void doAddView(Context context, View view) {
        if (context instanceof Activity) {
            ((Activity) context).setContentView(doAdaptive(context, view));
        } else {
            if (context instanceof ContextWrapper) {
                doAddView(((ContextWrapper) context).getBaseContext(), view);
                return;
            }
            throw new IllegalStateException("Context is not an Activity, can't set content view");
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("addView: view -- ");
        sb2.append((Object) view);
        sb2.append(" ; params -- ");
        sb2.append((Object) layoutParams);
        this.mView = view;
        if (this.setContentView) {
            doAddView(this.mContext, view);
        }
    }

    public View doAdaptive(Context context, View view) {
        return adaptiveView(context, view);
    }

    public Context getContext() {
        return this.mContext;
    }

    public View getView() {
        return this.mView;
    }

    public void setContentView(int i10) {
        View inflate = LayoutInflater.from(this.mContext).inflate(i10, (ViewGroup) null);
        this.mView = inflate;
        if (inflate != null) {
            doAddView(this.mContext, inflate);
            return;
        }
        throw new IllegalStateException("layoutId is not Illegal");
    }

    public void setContentView(View view) {
        if (view != null) {
            doAddView(this.mContext, view);
            return;
        }
        throw new IllegalStateException("layoutId is not Illegal");
    }
}
