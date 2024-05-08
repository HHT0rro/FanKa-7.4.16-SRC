package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: BaseGestureDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ao {

    /* renamed from: e, reason: collision with root package name */
    public final Context f4950e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4951f;

    /* renamed from: g, reason: collision with root package name */
    public MotionEvent f4952g;

    /* renamed from: h, reason: collision with root package name */
    public MotionEvent f4953h;

    /* renamed from: i, reason: collision with root package name */
    public float f4954i;

    /* renamed from: j, reason: collision with root package name */
    public float f4955j;

    /* renamed from: k, reason: collision with root package name */
    public long f4956k;

    /* renamed from: l, reason: collision with root package name */
    public int f4957l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f4958m = 0;

    public ao(Context context) {
        this.f4950e = context;
    }

    public final void a(int i10, int i11) {
        this.f4957l = i10;
        this.f4958m = i11;
    }

    public abstract void a(int i10, MotionEvent motionEvent);

    public abstract void a(int i10, MotionEvent motionEvent, int i11, int i12);

    public final boolean b(MotionEvent motionEvent, int i10, int i11) {
        int action = motionEvent.getAction() & 255;
        if (!this.f4951f) {
            a(action, motionEvent, i10, i11);
            return true;
        }
        a(action, motionEvent);
        return true;
    }

    public final MotionEvent c() {
        return this.f4953h;
    }

    public void a(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f4952g;
        MotionEvent motionEvent3 = this.f4953h;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.f4953h = null;
        }
        this.f4953h = MotionEvent.obtain(motionEvent);
        this.f4956k = motionEvent.getEventTime() - motionEvent2.getEventTime();
        this.f4954i = motionEvent.getPressure(motionEvent.getActionIndex());
        this.f4955j = motionEvent2.getPressure(motionEvent2.getActionIndex());
    }

    public final long b() {
        return this.f4956k;
    }

    public static PointF b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i10 = 0; i10 < pointerCount; i10++) {
            f10 += motionEvent.getX(i10);
            f11 += motionEvent.getY(i10);
        }
        float f12 = pointerCount;
        return new PointF(f10 / f12, f11 / f12);
    }

    public void a() {
        MotionEvent motionEvent = this.f4952g;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f4952g = null;
        }
        MotionEvent motionEvent2 = this.f4953h;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f4953h = null;
        }
        this.f4951f = false;
    }
}
