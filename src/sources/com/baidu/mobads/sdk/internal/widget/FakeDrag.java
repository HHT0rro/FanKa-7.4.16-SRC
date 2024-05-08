package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FakeDrag {

    /* renamed from: a, reason: collision with root package name */
    private final ViewPager2 f10315a;

    /* renamed from: b, reason: collision with root package name */
    private final ScrollEventAdapter f10316b;

    /* renamed from: c, reason: collision with root package name */
    private final RecyclerView f10317c;

    /* renamed from: d, reason: collision with root package name */
    private VelocityTracker f10318d;

    /* renamed from: e, reason: collision with root package name */
    private int f10319e;

    /* renamed from: f, reason: collision with root package name */
    private float f10320f;

    /* renamed from: g, reason: collision with root package name */
    private int f10321g;

    /* renamed from: h, reason: collision with root package name */
    private long f10322h;

    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f10315a = viewPager2;
        this.f10316b = scrollEventAdapter;
        this.f10317c = recyclerView;
    }

    private void d() {
        VelocityTracker velocityTracker = this.f10318d;
        if (velocityTracker == null) {
            this.f10318d = VelocityTracker.obtain();
            this.f10319e = ViewConfiguration.get(this.f10315a.getContext()).getScaledMaximumFlingVelocity();
        } else {
            velocityTracker.clear();
        }
    }

    public boolean a() {
        return this.f10316b.g();
    }

    @UiThread
    public boolean b() {
        if (this.f10316b.f()) {
            return false;
        }
        this.f10321g = 0;
        this.f10320f = 0;
        this.f10322h = SystemClock.uptimeMillis();
        d();
        this.f10316b.b();
        if (!this.f10316b.e()) {
            this.f10317c.stopScroll();
        }
        a(this.f10322h, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    public boolean c() {
        if (!this.f10316b.g()) {
            return false;
        }
        this.f10316b.c();
        VelocityTracker velocityTracker = this.f10318d;
        velocityTracker.computeCurrentVelocity(1000, this.f10319e);
        if (this.f10317c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f10315a.d();
        return true;
    }

    @UiThread
    public boolean a(float f10) {
        if (!this.f10316b.g()) {
            return false;
        }
        float f11 = this.f10320f - f10;
        this.f10320f = f11;
        int round = Math.round(f11 - this.f10321g);
        this.f10321g += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z10 = this.f10315a.getOrientation() == 0;
        int i10 = z10 ? round : 0;
        int i11 = z10 ? 0 : round;
        float f12 = z10 ? this.f10320f : 0.0f;
        float f13 = z10 ? 0.0f : this.f10320f;
        this.f10317c.scrollBy(i10, i11);
        a(uptimeMillis, 2, f12, f13);
        return true;
    }

    private void a(long j10, int i10, float f10, float f11) {
        MotionEvent obtain = MotionEvent.obtain(this.f10322h, j10, i10, f10, f11, 0);
        this.f10318d.addMovement(obtain);
        obtain.recycle();
    }
}
