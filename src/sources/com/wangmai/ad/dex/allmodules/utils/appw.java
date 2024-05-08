package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: SwipeUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appw implements GestureDetector.OnGestureListener {
    public static int appc = 1;
    public static int appd = 2;
    public static int appe = 3;
    public static int appf = 4;

    /* renamed from: appa, reason: collision with root package name */
    appa f46867appa;
    GestureDetector appb;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: SwipeUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface appa {
        void appa(int i10, float f10, float f11, float f12);
    }

    public appw(Context context, appa appaVar) {
        this.f46867appa = appaVar;
        this.appb = new GestureDetector(context, this, new Handler(Looper.getMainLooper()));
    }

    public void appa(MotionEvent motionEvent) {
        this.appb.onTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        int i10;
        float x10 = motionEvent.getX();
        float x11 = motionEvent2.getX();
        float y10 = motionEvent.getY();
        float y11 = motionEvent2.getY();
        float f12 = x10 - x11;
        if (f12 > 0.0f && Math.abs(f10) > 0.0f) {
            i10 = appe;
        } else if (x11 - x10 > 0.0f && Math.abs(f10) > 0.0f) {
            i10 = appf;
        } else if (y10 - y11 > 0.0f && Math.abs(f11) > 0.0f) {
            i10 = appc;
        } else {
            i10 = (y11 - y10 <= 0.0f || Math.abs(f11) <= 0.0f) ? 0 : appd;
        }
        float abs = Math.abs(f12);
        float abs2 = Math.abs(y10 - y11);
        float sqrt = (float) Math.sqrt((abs * abs) + (abs2 * abs2));
        Log.d("SwipeUtils", "distanceP2P:" + sqrt);
        this.f46867appa.appa(i10, abs, abs2, sqrt);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void appa() {
        this.f46867appa = null;
        this.appb = null;
    }
}
