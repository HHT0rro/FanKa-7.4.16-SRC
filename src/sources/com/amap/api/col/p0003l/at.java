package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* compiled from: ZoomOutGestureDetectorAbstract.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class at extends an {

    /* renamed from: p, reason: collision with root package name */
    private static final PointF f4998p = new PointF();

    /* renamed from: n, reason: collision with root package name */
    private final a f4999n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5000o;

    /* renamed from: q, reason: collision with root package name */
    private PointF f5001q;

    /* renamed from: r, reason: collision with root package name */
    private PointF f5002r;

    /* renamed from: s, reason: collision with root package name */
    private PointF f5003s;

    /* renamed from: t, reason: collision with root package name */
    private PointF f5004t;

    /* compiled from: ZoomOutGestureDetectorAbstract.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(at atVar);
    }

    /* compiled from: ZoomOutGestureDetectorAbstract.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b implements a {
        @Override // com.amap.api.col.3l.at.a
        public void a(at atVar) {
        }
    }

    public at(Context context, a aVar) {
        super(context);
        this.f5003s = new PointF();
        this.f5004t = new PointF();
        this.f4999n = aVar;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i10, MotionEvent motionEvent, int i11, int i12) {
        if (i10 != 5) {
            return;
        }
        a();
        this.f4952g = MotionEvent.obtain(motionEvent);
        this.f4956k = 0L;
        a(motionEvent);
        boolean a10 = a(motionEvent, i11, i12);
        this.f5000o = a10;
        if (a10) {
            return;
        }
        this.f4951f = true;
    }

    public final float d() {
        return this.f5003s.x;
    }

    public final float e() {
        return this.f5003s.y;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i10, MotionEvent motionEvent) {
        if (i10 == 3) {
            a();
        } else {
            if (i10 != 6) {
                return;
            }
            a(motionEvent);
            if (!this.f5000o) {
                this.f4999n.a(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a() {
        super.a();
        this.f5000o = false;
        PointF pointF = this.f5003s;
        pointF.x = 0.0f;
        PointF pointF2 = this.f5004t;
        pointF2.x = 0.0f;
        pointF.y = 0.0f;
        pointF2.y = 0.0f;
    }

    @Override // com.amap.api.col.p0003l.an, com.amap.api.col.p0003l.ao
    public final void a(MotionEvent motionEvent) {
        PointF pointF;
        super.a(motionEvent);
        MotionEvent motionEvent2 = this.f4952g;
        this.f5001q = ao.b(motionEvent);
        this.f5002r = ao.b(motionEvent2);
        if (this.f4952g.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = f4998p;
        } else {
            PointF pointF2 = this.f5001q;
            float f10 = pointF2.x;
            PointF pointF3 = this.f5002r;
            pointF = new PointF(f10 - pointF3.x, pointF2.y - pointF3.y);
        }
        this.f5004t = pointF;
        PointF pointF4 = this.f5003s;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }
}
