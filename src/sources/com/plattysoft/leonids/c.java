package com.plattysoft.leonids;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import vb.d;
import vb.e;

/* compiled from: ParticleSystem.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f38064a;

    /* renamed from: b, reason: collision with root package name */
    public int f38065b;

    /* renamed from: c, reason: collision with root package name */
    public Random f38066c;

    /* renamed from: d, reason: collision with root package name */
    public ParticleField f38067d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<com.plattysoft.leonids.b> f38068e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<com.plattysoft.leonids.b> f38069f;

    /* renamed from: g, reason: collision with root package name */
    public long f38070g;

    /* renamed from: h, reason: collision with root package name */
    public long f38071h;

    /* renamed from: i, reason: collision with root package name */
    public float f38072i;

    /* renamed from: j, reason: collision with root package name */
    public int f38073j;

    /* renamed from: k, reason: collision with root package name */
    public long f38074k;

    /* renamed from: l, reason: collision with root package name */
    public List<wb.b> f38075l;

    /* renamed from: m, reason: collision with root package name */
    public List<vb.b> f38076m;

    /* renamed from: n, reason: collision with root package name */
    public ValueAnimator f38077n;

    /* renamed from: o, reason: collision with root package name */
    public Timer f38078o;

    /* renamed from: p, reason: collision with root package name */
    public float f38079p;

    /* renamed from: q, reason: collision with root package name */
    public int[] f38080q;

    /* renamed from: r, reason: collision with root package name */
    public int f38081r;

    /* renamed from: s, reason: collision with root package name */
    public int f38082s;

    /* renamed from: t, reason: collision with root package name */
    public int f38083t;

    /* renamed from: u, reason: collision with root package name */
    public int f38084u;

    /* compiled from: ParticleSystem.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.k(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: ParticleSystem.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c.this.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.this.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public c(Activity activity, int i10, long j10, int i11) {
        this.f38069f = new ArrayList<>();
        this.f38071h = 0L;
        this.f38066c = new Random();
        this.f38064a = (ViewGroup) activity.findViewById(i11);
        this.f38075l = new ArrayList();
        this.f38076m = new ArrayList();
        this.f38065b = i10;
        this.f38068e = new ArrayList<>();
        this.f38070g = j10;
        int[] iArr = new int[2];
        this.f38080q = iArr;
        this.f38064a.getLocationInWindow(iArr);
        this.f38079p = activity.getResources().getDisplayMetrics().xdpi / 160.0f;
    }

    public final void c(long j10) {
        com.plattysoft.leonids.b remove = this.f38068e.remove(0);
        remove.d();
        for (int i10 = 0; i10 < this.f38076m.size(); i10++) {
            this.f38076m.get(i10).a(remove, this.f38066c);
        }
        remove.b(this.f38070g, i(this.f38081r, this.f38082s), i(this.f38083t, this.f38084u));
        remove.a(j10, this.f38075l);
        this.f38069f.add(remove);
        this.f38073j++;
    }

    public void d() {
        ValueAnimator valueAnimator = this.f38077n;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f38077n.cancel();
        }
        Timer timer = this.f38078o;
        if (timer != null) {
            timer.cancel();
            this.f38078o.purge();
            e();
        }
    }

    public final void e() {
        this.f38064a.removeView(this.f38067d);
        this.f38067d = null;
        this.f38064a.postInvalidate();
        this.f38068e.addAll(this.f38069f);
    }

    public final void f(View view, int i10) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (j(i10, 3)) {
            int i11 = iArr[0] - this.f38080q[0];
            this.f38081r = i11;
            this.f38082s = i11;
        } else if (j(i10, 5)) {
            int width = (iArr[0] + view.getWidth()) - this.f38080q[0];
            this.f38081r = width;
            this.f38082s = width;
        } else if (j(i10, 1)) {
            int width2 = (iArr[0] + (view.getWidth() / 2)) - this.f38080q[0];
            this.f38081r = width2;
            this.f38082s = width2;
        } else {
            this.f38081r = iArr[0] - this.f38080q[0];
            this.f38082s = (iArr[0] + view.getWidth()) - this.f38080q[0];
        }
        if (j(i10, 48)) {
            int i12 = iArr[1] - this.f38080q[1];
            this.f38083t = i12;
            this.f38084u = i12;
        } else if (j(i10, 80)) {
            int height = (iArr[1] + view.getHeight()) - this.f38080q[1];
            this.f38083t = height;
            this.f38084u = height;
        } else if (j(i10, 16)) {
            int height2 = (iArr[1] + (view.getHeight() / 2)) - this.f38080q[1];
            this.f38083t = height2;
            this.f38084u = height2;
        } else {
            this.f38083t = iArr[1] - this.f38080q[1];
            this.f38084u = (iArr[1] + view.getHeight()) - this.f38080q[1];
        }
    }

    public float g(float f10) {
        return f10 * this.f38079p;
    }

    public void h(View view, int i10, int i11, int i12) {
        f(view, i10);
        s(i11, i12);
    }

    public final int i(int i10, int i11) {
        return i10 == i11 ? i10 : this.f38066c.nextInt(i11 - i10) + i10;
    }

    public final boolean j(int i10, int i11) {
        return (i10 & i11) == i11;
    }

    public final void k(long j10) {
        while (true) {
            long j11 = this.f38074k;
            if (((j11 <= 0 || j10 >= j11) && j11 != -1) || this.f38068e.isEmpty() || this.f38073j >= this.f38072i * ((float) j10)) {
                break;
            } else {
                c(j10);
            }
        }
        synchronized (this.f38069f) {
            int i10 = 0;
            while (i10 < this.f38069f.size()) {
                if (!this.f38069f.get(i10).e(j10)) {
                    com.plattysoft.leonids.b remove = this.f38069f.remove(i10);
                    i10--;
                    this.f38068e.add(remove);
                }
                i10++;
            }
        }
        this.f38067d.postInvalidate();
    }

    public c l(float f10, int i10) {
        this.f38076m.add(new vb.a(f10, f10, i10, i10));
        return this;
    }

    public c m(long j10) {
        return n(j10, new LinearInterpolator());
    }

    public c n(long j10, Interpolator interpolator) {
        List<wb.b> list = this.f38075l;
        long j11 = this.f38070g;
        list.add(new wb.a(255, 0, j11 - j10, j11, interpolator));
        return this;
    }

    public c o(int i10, int i11) {
        this.f38076m.add(new vb.c(i10, i11));
        return this;
    }

    public c p(float f10, float f11) {
        this.f38076m.add(new d(f10, f11));
        return this;
    }

    public c q(float f10, float f11, float f12, float f13) {
        this.f38076m.add(new e(g(f10), g(f11), g(f12), g(f13)));
        return this;
    }

    public final void r(Interpolator interpolator, long j10) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) j10);
        this.f38077n = ofInt;
        ofInt.setDuration(j10);
        this.f38077n.addUpdateListener(new a());
        this.f38077n.addListener(new b());
        this.f38077n.setInterpolator(interpolator);
        this.f38077n.start();
    }

    public final void s(int i10, int i11) {
        this.f38073j = 0;
        this.f38072i = i10 / 1000.0f;
        ParticleField particleField = new ParticleField(this.f38064a.getContext());
        this.f38067d = particleField;
        this.f38064a.addView(particleField);
        this.f38067d.a(this.f38069f);
        t(i10);
        long j10 = i11;
        this.f38074k = j10;
        r(new LinearInterpolator(), j10 + this.f38070g);
    }

    public final void t(int i10) {
        if (i10 == 0) {
            return;
        }
        long j10 = this.f38071h;
        long j11 = (j10 / 1000) / i10;
        if (j11 == 0) {
            return;
        }
        long j12 = j10 / j11;
        int i11 = 1;
        while (true) {
            long j13 = i11;
            if (j13 > j11) {
                return;
            }
            k((j13 * j12) + 1);
            i11++;
        }
    }

    public c(Activity activity, int i10, int i11, long j10, int i12) {
        this(activity, i10, activity.getResources().getDrawable(i11), j10, i12);
    }

    public c(Activity activity, int i10, Drawable drawable, long j10, int i11) {
        this(activity, i10, j10, i11);
        int i12 = 0;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            while (i12 < this.f38065b) {
                this.f38068e.add(new com.plattysoft.leonids.b(bitmap));
                i12++;
            }
            return;
        }
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            while (i12 < this.f38065b) {
                this.f38068e.add(new com.plattysoft.leonids.a(animationDrawable));
                i12++;
            }
        }
    }
}
