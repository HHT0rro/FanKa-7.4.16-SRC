package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.BinderThread;
import com.google.android.exoplayer2.video.spherical.d;

/* compiled from: TouchTracker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, d.a {

    /* renamed from: d, reason: collision with root package name */
    public final a f23155d;

    /* renamed from: e, reason: collision with root package name */
    public final float f23156e;

    /* renamed from: f, reason: collision with root package name */
    public final GestureDetector f23157f;

    /* renamed from: b, reason: collision with root package name */
    public final PointF f23153b = new PointF();

    /* renamed from: c, reason: collision with root package name */
    public final PointF f23154c = new PointF();

    /* renamed from: g, reason: collision with root package name */
    public volatile float f23158g = 3.1415927f;

    /* compiled from: TouchTracker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public j(Context context, a aVar, float f10) {
        this.f23155d = aVar;
        this.f23156e = f10;
        this.f23157f = new GestureDetector(context, this);
    }

    @Override // com.google.android.exoplayer2.video.spherical.d.a
    @BinderThread
    public void a(float[] fArr, float f10) {
        this.f23158g = -f10;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f23153b.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float x10 = (motionEvent2.getX() - this.f23153b.x) / this.f23156e;
        float y10 = motionEvent2.getY();
        PointF pointF = this.f23153b;
        float f12 = (y10 - pointF.y) / this.f23156e;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d10 = this.f23158g;
        float cos = (float) Math.cos(d10);
        float sin = (float) Math.sin(d10);
        PointF pointF2 = this.f23154c;
        pointF2.x -= (cos * x10) - (sin * f12);
        float f13 = pointF2.y + (sin * x10) + (cos * f12);
        pointF2.y = f13;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f13));
        this.f23155d.b(this.f23154c);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f23155d.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f23157f.onTouchEvent(motionEvent);
    }
}
