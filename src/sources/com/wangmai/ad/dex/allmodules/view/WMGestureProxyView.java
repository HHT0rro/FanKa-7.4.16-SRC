package com.wangmai.ad.dex.allmodules.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import appa.appa.appf.appd;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class WMGestureProxyView extends FrameLayout {
    private static final String appb = WMGestureProxyView.class.getSimpleName();

    /* renamed from: appa, reason: collision with root package name */
    private GestureDetector f46873appa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements View.OnTouchListener {
        appa(WMGestureProxyView wMGestureProxyView) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            appd.appa(WMGestureProxyView.appb, "自定义容器，消费onTouch事件");
            return true;
        }
    }

    public WMGestureProxyView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f46873appa;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.f46873appa = gestureDetector;
        setOnTouchListener(new appa(this));
    }

    public WMGestureProxyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WMGestureProxyView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
