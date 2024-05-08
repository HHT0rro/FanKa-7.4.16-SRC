package com.wangmai.ad.dex.allmodules.pot.banner;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import appa.appa.appf.appd;
import com.wangmai.ad.dex.allmodules.appf.appb;
import com.wangmai.common.utils.ConstantInfo;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class BannerDestoryView extends LinearLayout {
    private static final String appb = BannerDestoryView.class.getSimpleName();

    /* renamed from: appa, reason: collision with root package name */
    private appb f46811appa;

    public BannerDestoryView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ConstantInfo.downX = motionEvent.getX();
            ConstantInfo.downY = motionEvent.getY();
            appd.appa(appb, "SDK 横幅广告点击", Double.valueOf(ConstantInfo.downX), Double.valueOf(ConstantInfo.downY));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public appb getBannerDestroyListener() {
        return this.f46811appa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        appb appbVar = this.f46811appa;
        if (appbVar != null) {
            appbVar.appa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        appb appbVar = this.f46811appa;
        if (appbVar != null) {
            appbVar.appb();
        }
    }

    public void setBannerDestroyListener(appb appbVar) {
        this.f46811appa = appbVar;
    }
}
