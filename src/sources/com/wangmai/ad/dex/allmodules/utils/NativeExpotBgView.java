package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.wangmai.common.utils.ConstantInfo;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class NativeExpotBgView extends RelativeLayout {
    private static final String appb = NativeExpotBgView.class.getSimpleName();

    /* renamed from: appa, reason: collision with root package name */
    private appa.appa.appc.appa f46820appa;

    public NativeExpotBgView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ConstantInfo.downX = motionEvent.getX();
            ConstantInfo.downY = motionEvent.getY();
            appa.appa.appf.appd.appa(appb, "SDK 信息流模板广告点击", Double.valueOf(ConstantInfo.downX), Double.valueOf(ConstantInfo.downY));
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.f46820appa != null && this.f46820appa.appa(motionEvent)) {
                    setTag(true);
                    return true;
                }
                setTag(false);
            }
        } catch (Throwable unused) {
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setProcessor(appa.appa.appc.appa appaVar) {
        this.f46820appa = appaVar;
    }
}
