package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: AbstractTwoFingerGestureDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class an extends ao {

    /* renamed from: a, reason: collision with root package name */
    public float f4937a;

    /* renamed from: b, reason: collision with root package name */
    public float f4938b;

    /* renamed from: c, reason: collision with root package name */
    public float f4939c;

    /* renamed from: d, reason: collision with root package name */
    public float f4940d;

    /* renamed from: n, reason: collision with root package name */
    private final float f4941n;

    /* renamed from: o, reason: collision with root package name */
    private float f4942o;

    /* renamed from: p, reason: collision with root package name */
    private float f4943p;

    /* renamed from: q, reason: collision with root package name */
    private float f4944q;

    /* renamed from: r, reason: collision with root package name */
    private float f4945r;

    /* renamed from: s, reason: collision with root package name */
    private float f4946s;

    /* renamed from: t, reason: collision with root package name */
    private float f4947t;

    /* renamed from: u, reason: collision with root package name */
    private float f4948u;

    /* renamed from: v, reason: collision with root package name */
    private float f4949v;

    public an(Context context) {
        super(context);
        this.f4946s = 0.0f;
        this.f4947t = 0.0f;
        this.f4948u = 0.0f;
        this.f4949v = 0.0f;
        this.f4941n = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    private static float b(MotionEvent motionEvent, int i10) {
        float y10 = (i10 + motionEvent.getY()) - motionEvent.getRawY();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getY(1) + y10;
        }
        return 0.0f;
    }

    @Override // com.amap.api.col.p0003l.ao
    public void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.f4952g;
        int pointerCount = motionEvent2.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.f4944q = -1.0f;
            this.f4945r = -1.0f;
            float x10 = motionEvent2.getX(0);
            float y10 = motionEvent2.getY(0);
            float x11 = motionEvent2.getX(1);
            float y11 = motionEvent2.getY(1);
            this.f4937a = x11 - x10;
            this.f4938b = y11 - y10;
            float x12 = motionEvent.getX(0);
            float y12 = motionEvent.getY(0);
            float x13 = motionEvent.getX(1);
            float y13 = motionEvent.getY(1);
            this.f4939c = x13 - x12;
            this.f4940d = y13 - y12;
            this.f4946s = x12 - x10;
            this.f4947t = y12 - y10;
            this.f4948u = x13 - x11;
            this.f4949v = y13 - y11;
        }
    }

    public final PointF a(int i10) {
        if (i10 == 0) {
            return new PointF(this.f4946s, this.f4947t);
        }
        return new PointF(this.f4948u, this.f4949v);
    }

    private static float a(MotionEvent motionEvent, int i10) {
        float x10 = (i10 + motionEvent.getX()) - motionEvent.getRawX();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getX(1) + x10;
        }
        return 0.0f;
    }

    public final boolean a(MotionEvent motionEvent, int i10, int i11) {
        int i12;
        int i13 = this.f4957l;
        if (i13 != 0 && (i12 = this.f4958m) != 0) {
            float f10 = this.f4941n;
            this.f4942o = i13 - f10;
            this.f4943p = i12 - f10;
        } else {
            float f11 = this.f4950e.getResources().getDisplayMetrics().widthPixels;
            float f12 = this.f4941n;
            this.f4942o = f11 - f12;
            this.f4943p = r0.heightPixels - f12;
        }
        float f13 = this.f4941n;
        float f14 = this.f4942o;
        float f15 = this.f4943p;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a10 = a(motionEvent, i10);
        float b4 = b(motionEvent, i11);
        boolean z10 = rawX < f13 || rawY < f13 || rawX > f14 || rawY > f15;
        boolean z11 = a10 < f13 || b4 < f13 || a10 > f14 || b4 > f15;
        return (z10 && z11) || z10 || z11;
    }
}
