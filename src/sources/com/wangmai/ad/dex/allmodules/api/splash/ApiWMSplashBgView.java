package com.wangmai.ad.dex.allmodules.api.splash;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import appa.appa.appf.appd;
import com.wangmai.common.utils.ConstantInfo;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class ApiWMSplashBgView extends FrameLayout {

    /* renamed from: appa, reason: collision with root package name */
    private String f46651appa;
    private appa.appa.appc.appa appb;

    public ApiWMSplashBgView(Context context) {
        super(context);
        this.f46651appa = "ApiWMSplashBgView";
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ConstantInfo.downX = motionEvent.getX();
            ConstantInfo.downY = motionEvent.getY();
            appd.appa(this.f46651appa, "SDK 开屏广告点击坐标", Double.valueOf(ConstantInfo.downX), Double.valueOf(ConstantInfo.downY));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                appd.appa(this.f46651appa, "onInterceptTouchEvent：");
                if (this.appb != null && this.appb.appa(motionEvent)) {
                    setTag(true);
                    return true;
                }
                setTag(false);
            }
        } catch (Throwable unused) {
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            try {
                if (this.appb == null || !((Boolean) getTag()).booleanValue()) {
                    return false;
                }
                this.appb.appb(motionEvent);
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public void setProcessor(appa.appa.appc.appa appaVar) {
        this.appb = appaVar;
    }
}
