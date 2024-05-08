package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: HoverGestureDetectorAbstract.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ap extends an {

    /* renamed from: n, reason: collision with root package name */
    private static final PointF f4959n = new PointF();

    /* renamed from: o, reason: collision with root package name */
    private final a f4960o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4961p;

    /* renamed from: q, reason: collision with root package name */
    private PointF f4962q;

    /* renamed from: r, reason: collision with root package name */
    private PointF f4963r;

    /* renamed from: s, reason: collision with root package name */
    private PointF f4964s;

    /* renamed from: t, reason: collision with root package name */
    private PointF f4965t;

    /* compiled from: HoverGestureDetectorAbstract.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        boolean a(ap apVar);

        boolean b(ap apVar);

        void c(ap apVar);
    }

    public ap(Context context, a aVar) {
        super(context);
        this.f4964s = new PointF();
        this.f4965t = new PointF();
        this.f4960o = aVar;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i10, MotionEvent motionEvent, int i11, int i12) {
        if (i10 == 2) {
            if (this.f4961p) {
                boolean a10 = a(motionEvent, i11, i12);
                this.f4961p = a10;
                if (a10) {
                    return;
                }
                this.f4951f = this.f4960o.b(this);
                return;
            }
            return;
        }
        if (i10 != 5) {
            return;
        }
        a();
        this.f4952g = MotionEvent.obtain(motionEvent);
        this.f4956k = 0L;
        a(motionEvent);
        boolean a11 = a(motionEvent, i11, i12);
        this.f4961p = a11;
        if (a11) {
            return;
        }
        this.f4951f = this.f4960o.b(this);
    }

    public final PointF d() {
        return this.f4965t;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i10, MotionEvent motionEvent) {
        if (i10 == 2) {
            a(motionEvent);
            if (this.f4954i / this.f4955j <= 0.67f || !this.f4960o.a(this)) {
                return;
            }
            this.f4952g.recycle();
            this.f4952g = MotionEvent.obtain(motionEvent);
            return;
        }
        if (i10 == 3) {
            if (!this.f4961p) {
                this.f4960o.c(this);
            }
            a();
        } else {
            if (i10 != 6) {
                return;
            }
            a(motionEvent);
            if (!this.f4961p) {
                this.f4960o.c(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a() {
        super.a();
        this.f4961p = false;
    }

    @Override // com.amap.api.col.p0003l.an, com.amap.api.col.p0003l.ao
    public final void a(MotionEvent motionEvent) {
        PointF pointF;
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.f4952g;
        this.f4962q = ao.b(motionEvent);
        this.f4963r = ao.b(motionEvent2);
        if (this.f4952g.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = f4959n;
        } else {
            PointF pointF2 = this.f4962q;
            float f10 = pointF2.x;
            PointF pointF3 = this.f4963r;
            pointF = new PointF(f10 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f4965t = pointF;
        PointF pointF4 = this.f4964s;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }
}
