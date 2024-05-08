package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: MoveGestureDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aq extends ao {

    /* renamed from: a, reason: collision with root package name */
    private static final PointF f4966a = new PointF();

    /* renamed from: b, reason: collision with root package name */
    private final a f4967b;

    /* renamed from: c, reason: collision with root package name */
    private PointF f4968c;

    /* renamed from: d, reason: collision with root package name */
    private PointF f4969d;

    /* renamed from: n, reason: collision with root package name */
    private PointF f4970n;

    /* renamed from: o, reason: collision with root package name */
    private PointF f4971o;

    /* compiled from: MoveGestureDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        boolean a(aq aqVar);

        boolean b(aq aqVar);

        void c(aq aqVar);
    }

    public aq(Context context, a aVar) {
        super(context);
        this.f4970n = new PointF();
        this.f4971o = new PointF();
        this.f4967b = aVar;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i10, MotionEvent motionEvent, int i11, int i12) {
        if (i10 == 0) {
            a();
            this.f4952g = MotionEvent.obtain(motionEvent);
            this.f4956k = 0L;
            a(motionEvent);
            return;
        }
        if (i10 == 2) {
            this.f4951f = this.f4967b.b(this);
            return;
        }
        if (i10 != 5) {
            return;
        }
        MotionEvent motionEvent2 = this.f4952g;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f4952g = MotionEvent.obtain(motionEvent);
        a(motionEvent);
    }

    public final PointF d() {
        return this.f4971o;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i10, MotionEvent motionEvent) {
        if (i10 != 1) {
            if (i10 == 2) {
                a(motionEvent);
                if (this.f4954i / this.f4955j <= 0.67f || motionEvent.getPointerCount() > 1 || !this.f4967b.a(this)) {
                    return;
                }
                this.f4952g.recycle();
                this.f4952g = MotionEvent.obtain(motionEvent);
                return;
            }
            if (i10 != 3) {
                return;
            }
        }
        this.f4967b.c(this);
        a();
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(MotionEvent motionEvent) {
        PointF pointF;
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.f4952g;
        this.f4968c = ao.b(motionEvent);
        this.f4969d = ao.b(motionEvent2);
        boolean z10 = this.f4952g.getPointerCount() != motionEvent.getPointerCount();
        if (z10) {
            pointF = f4966a;
        } else {
            PointF pointF2 = this.f4968c;
            float f10 = pointF2.x;
            PointF pointF3 = this.f4969d;
            pointF = new PointF(f10 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f4971o = pointF;
        if (z10) {
            this.f4952g.recycle();
            this.f4952g = MotionEvent.obtain(motionEvent);
        }
        PointF pointF4 = this.f4970n;
        float f11 = pointF4.x;
        PointF pointF5 = this.f4971o;
        pointF4.x = f11 + pointF5.x;
        pointF4.y += pointF5.y;
    }
}
