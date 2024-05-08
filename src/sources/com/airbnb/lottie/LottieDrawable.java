package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public final Matrix A;
    public Bitmap B;
    public Canvas C;
    public Rect D;
    public RectF E;
    public Paint F;
    public Rect G;
    public Rect H;
    public RectF I;
    public RectF J;
    public Matrix K;
    public Matrix L;
    public boolean M;

    /* renamed from: b, reason: collision with root package name */
    public LottieComposition f1847b;

    /* renamed from: c, reason: collision with root package name */
    public final n.e f1848c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1849d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1850e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1851f;

    /* renamed from: g, reason: collision with root package name */
    public OnVisibleAction f1852g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<b> f1853h;

    /* renamed from: i, reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f1854i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public g.b f1855j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public String f1856k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public com.airbnb.lottie.b f1857l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public g.a f1858m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public Map<String, Typeface> f1859n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public String f1860o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public o0 f1861p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1862q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1863r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1864s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public com.airbnb.lottie.model.layer.a f1865t;

    /* renamed from: u, reason: collision with root package name */
    public int f1866u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1867v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1868w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1869x;

    /* renamed from: y, reason: collision with root package name */
    public RenderMode f1870y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1871z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (LottieDrawable.this.f1865t != null) {
                LottieDrawable.this.f1865t.L(LottieDrawable.this.f1848c.l());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface b {
        void a(LottieComposition lottieComposition);
    }

    public LottieDrawable() {
        n.e eVar = new n.e();
        this.f1848c = eVar;
        this.f1849d = true;
        this.f1850e = false;
        this.f1851f = false;
        this.f1852g = OnVisibleAction.NONE;
        this.f1853h = new ArrayList<>();
        a aVar = new a();
        this.f1854i = aVar;
        this.f1863r = false;
        this.f1864s = true;
        this.f1866u = 255;
        this.f1870y = RenderMode.AUTOMATIC;
        this.f1871z = false;
        this.A = new Matrix();
        this.M = false;
        eVar.addUpdateListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(h.c cVar, Object obj, o.c cVar2, LottieComposition lottieComposition) {
        t(cVar, obj, cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(LottieComposition lottieComposition) {
        v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(LottieComposition lottieComposition) {
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(int i10, LottieComposition lottieComposition) {
        I0(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(int i10, LottieComposition lottieComposition) {
        N0(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(String str, LottieComposition lottieComposition) {
        O0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(float f10, LottieComposition lottieComposition) {
        P0(f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(int i10, int i11, LottieComposition lottieComposition) {
        Q0(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(String str, LottieComposition lottieComposition) {
        R0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(String str, String str2, boolean z10, LottieComposition lottieComposition) {
        S0(str, str2, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(float f10, float f11, LottieComposition lottieComposition) {
        T0(f10, f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(int i10, LottieComposition lottieComposition) {
        U0(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(String str, LottieComposition lottieComposition) {
        V0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(float f10, LottieComposition lottieComposition) {
        W0(f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(float f10, LottieComposition lottieComposition) {
        Z0(f10);
    }

    public final void A(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    @MainThread
    public void A0() {
        if (this.f1865t == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.p
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.h0(lottieComposition);
                }
            });
            return;
        }
        y();
        if (u() || W() == 0) {
            if (isVisible()) {
                this.f1848c.x();
                this.f1852g = OnVisibleAction.NONE;
            } else {
                this.f1852g = OnVisibleAction.RESUME;
            }
        }
        if (u()) {
            return;
        }
        I0((int) (Y() < 0.0f ? S() : R()));
        this.f1848c.k();
        if (isVisible()) {
            return;
        }
        this.f1852g = OnVisibleAction.NONE;
    }

    public final void B(Canvas canvas) {
        com.airbnb.lottie.model.layer.a aVar = this.f1865t;
        LottieComposition lottieComposition = this.f1847b;
        if (aVar == null || lottieComposition == null) {
            return;
        }
        this.A.reset();
        if (!getBounds().isEmpty()) {
            this.A.preScale(r2.width() / lottieComposition.b().width(), r2.height() / lottieComposition.b().height());
            this.A.preTranslate(r2.left, r2.top);
        }
        aVar.d(canvas, this.A, this.f1866u);
    }

    public final void B0(RectF rectF, float f10, float f11) {
        rectF.set(rectF.left * f10, rectF.top * f11, rectF.right * f10, rectF.bottom * f11);
    }

    public void C(boolean z10) {
        if (this.f1862q == z10) {
            return;
        }
        this.f1862q = z10;
        if (this.f1847b != null) {
            v();
        }
    }

    public void C0(boolean z10) {
        this.f1869x = z10;
    }

    public boolean D() {
        return this.f1862q;
    }

    public void D0(boolean z10) {
        if (z10 != this.f1864s) {
            this.f1864s = z10;
            com.airbnb.lottie.model.layer.a aVar = this.f1865t;
            if (aVar != null) {
                aVar.O(z10);
            }
            invalidateSelf();
        }
    }

    @MainThread
    public void E() {
        this.f1853h.clear();
        this.f1848c.k();
        if (isVisible()) {
            return;
        }
        this.f1852g = OnVisibleAction.NONE;
    }

    public boolean E0(LottieComposition lottieComposition) {
        if (this.f1847b == lottieComposition) {
            return false;
        }
        this.M = true;
        x();
        this.f1847b = lottieComposition;
        v();
        this.f1848c.z(lottieComposition);
        Z0(this.f1848c.getAnimatedFraction());
        Iterator iterator2 = new ArrayList(this.f1853h).iterator2();
        while (iterator2.hasNext()) {
            b bVar = (b) iterator2.next();
            if (bVar != null) {
                bVar.a(lottieComposition);
            }
            iterator2.remove();
        }
        this.f1853h.clear();
        lottieComposition.v(this.f1867v);
        y();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public final void F(int i10, int i11) {
        Bitmap bitmap = this.B;
        if (bitmap != null && bitmap.getWidth() >= i10 && this.B.getHeight() >= i11) {
            if (this.B.getWidth() > i10 || this.B.getHeight() > i11) {
                Bitmap createBitmap = Bitmap.createBitmap(this.B, 0, 0, i10, i11);
                this.B = createBitmap;
                this.C.setBitmap(createBitmap);
                this.M = true;
                return;
            }
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        this.B = createBitmap2;
        this.C.setBitmap(createBitmap2);
        this.M = true;
    }

    public void F0(String str) {
        this.f1860o = str;
        g.a L = L();
        if (L != null) {
            L.c(str);
        }
    }

    public final void G() {
        if (this.C != null) {
            return;
        }
        this.C = new Canvas();
        this.J = new RectF();
        this.K = new Matrix();
        this.L = new Matrix();
        this.D = new Rect();
        this.E = new RectF();
        this.F = new d.a();
        this.G = new Rect();
        this.H = new Rect();
        this.I = new RectF();
    }

    public void G0(com.airbnb.lottie.a aVar) {
        g.a aVar2 = this.f1858m;
        if (aVar2 != null) {
            aVar2.d(aVar);
        }
    }

    @Nullable
    public Bitmap H(String str) {
        g.b N = N();
        if (N != null) {
            return N.a(str);
        }
        return null;
    }

    public void H0(@Nullable Map<String, Typeface> map) {
        if (map == this.f1859n) {
            return;
        }
        this.f1859n = map;
        invalidateSelf();
    }

    public boolean I() {
        return this.f1864s;
    }

    public void I0(final int i10) {
        if (this.f1847b == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.b0
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.i0(i10, lottieComposition);
                }
            });
        } else {
            this.f1848c.A(i10);
        }
    }

    public LottieComposition J() {
        return this.f1847b;
    }

    public void J0(boolean z10) {
        this.f1850e = z10;
    }

    @Nullable
    public final Context K() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void K0(com.airbnb.lottie.b bVar) {
        this.f1857l = bVar;
        g.b bVar2 = this.f1855j;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    public final g.a L() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f1858m == null) {
            g.a aVar = new g.a(getCallback(), null);
            this.f1858m = aVar;
            String str = this.f1860o;
            if (str != null) {
                aVar.c(str);
            }
        }
        return this.f1858m;
    }

    public void L0(@Nullable String str) {
        this.f1856k = str;
    }

    public int M() {
        return (int) this.f1848c.m();
    }

    public void M0(boolean z10) {
        this.f1863r = z10;
    }

    public final g.b N() {
        g.b bVar = this.f1855j;
        if (bVar != null && !bVar.b(K())) {
            this.f1855j = null;
        }
        if (this.f1855j == null) {
            this.f1855j = new g.b(getCallback(), this.f1856k, this.f1857l, this.f1847b.j());
        }
        return this.f1855j;
    }

    public void N0(final int i10) {
        if (this.f1847b == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.c0
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.j0(i10, lottieComposition);
                }
            });
        } else {
            this.f1848c.B(i10 + 0.99f);
        }
    }

    @Nullable
    public String O() {
        return this.f1856k;
    }

    public void O0(final String str) {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.s
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.k0(str, lottieComposition2);
                }
            });
            return;
        }
        h.f l10 = lottieComposition.l(str);
        if (l10 != null) {
            N0((int) (l10.f49484b + l10.f49485c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Nullable
    public e0 P(String str) {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            return null;
        }
        return lottieComposition.j().get(str);
    }

    public void P0(@FloatRange(from = 0.0d, to = 1.0d) final float f10) {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.w
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.l0(f10, lottieComposition2);
                }
            });
        } else {
            this.f1848c.B(n.g.i(lottieComposition.p(), this.f1847b.f(), f10));
        }
    }

    public boolean Q() {
        return this.f1863r;
    }

    public void Q0(final int i10, final int i11) {
        if (this.f1847b == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.d0
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.m0(i10, i11, lottieComposition);
                }
            });
        } else {
            this.f1848c.D(i10, i11 + 0.99f);
        }
    }

    public float R() {
        return this.f1848c.o();
    }

    public void R0(final String str) {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.t
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.n0(str, lottieComposition2);
                }
            });
            return;
        }
        h.f l10 = lottieComposition.l(str);
        if (l10 != null) {
            int i10 = (int) l10.f49484b;
            Q0(i10, ((int) l10.f49485c) + i10);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public float S() {
        return this.f1848c.p();
    }

    public void S0(final String str, final String str2, final boolean z10) {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.u
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.o0(str, str2, z10, lottieComposition2);
                }
            });
            return;
        }
        h.f l10 = lottieComposition.l(str);
        if (l10 != null) {
            int i10 = (int) l10.f49484b;
            h.f l11 = this.f1847b.l(str2);
            if (l11 != null) {
                Q0(i10, (int) (l11.f49484b + (z10 ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Nullable
    public m0 T() {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition != null) {
            return lottieComposition.n();
        }
        return null;
    }

    public void T0(@FloatRange(from = 0.0d, to = 1.0d) final float f10, @FloatRange(from = 0.0d, to = 1.0d) final float f11) {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.z
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.p0(f10, f11, lottieComposition2);
                }
            });
        } else {
            Q0((int) n.g.i(lottieComposition.p(), this.f1847b.f(), f10), (int) n.g.i(this.f1847b.p(), this.f1847b.f(), f11));
        }
    }

    @FloatRange(from = ShadowDrawableWrapper.COS_45, to = 1.0d)
    public float U() {
        return this.f1848c.l();
    }

    public void U0(final int i10) {
        if (this.f1847b == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.a0
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.q0(i10, lottieComposition);
                }
            });
        } else {
            this.f1848c.F(i10);
        }
    }

    public RenderMode V() {
        return this.f1871z ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public void V0(final String str) {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.r
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.r0(str, lottieComposition2);
                }
            });
            return;
        }
        h.f l10 = lottieComposition.l(str);
        if (l10 != null) {
            U0((int) l10.f49484b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public int W() {
        return this.f1848c.getRepeatCount();
    }

    public void W0(final float f10) {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.x
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.s0(f10, lottieComposition2);
                }
            });
        } else {
            U0((int) n.g.i(lottieComposition.p(), this.f1847b.f(), f10));
        }
    }

    public int X() {
        return this.f1848c.getRepeatMode();
    }

    public void X0(boolean z10) {
        if (this.f1868w == z10) {
            return;
        }
        this.f1868w = z10;
        com.airbnb.lottie.model.layer.a aVar = this.f1865t;
        if (aVar != null) {
            aVar.J(z10);
        }
    }

    public float Y() {
        return this.f1848c.q();
    }

    public void Y0(boolean z10) {
        this.f1867v = z10;
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition != null) {
            lottieComposition.v(z10);
        }
    }

    @Nullable
    public o0 Z() {
        return this.f1861p;
    }

    public void Z0(@FloatRange(from = 0.0d, to = 1.0d) final float f10) {
        if (this.f1847b == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.y
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.t0(f10, lottieComposition);
                }
            });
            return;
        }
        c.a("Drawable#setProgress");
        this.f1848c.A(this.f1847b.h(f10));
        c.b("Drawable#setProgress");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface a0(h.a aVar) {
        Map<String, Typeface> map = this.f1859n;
        if (map != null) {
            String a10 = aVar.a();
            if (map.containsKey(a10)) {
                return map.get(a10);
            }
            String b4 = aVar.b();
            if (map.containsKey(b4)) {
                return map.get(b4);
            }
            String str = aVar.a() + "-" + aVar.c();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        g.a L = L();
        if (L != null) {
            return L.b(aVar);
        }
        return null;
    }

    public void a1(RenderMode renderMode) {
        this.f1870y = renderMode;
        y();
    }

    public final boolean b0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (((View) callback).getParent() instanceof ViewGroup) {
            return !((ViewGroup) r0).getClipChildren();
        }
        return false;
    }

    public void b1(int i10) {
        this.f1848c.setRepeatCount(i10);
    }

    public boolean c0() {
        n.e eVar = this.f1848c;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public void c1(int i10) {
        this.f1848c.setRepeatMode(i10);
    }

    public boolean d0() {
        if (isVisible()) {
            return this.f1848c.isRunning();
        }
        OnVisibleAction onVisibleAction = this.f1852g;
        return onVisibleAction == OnVisibleAction.PLAY || onVisibleAction == OnVisibleAction.RESUME;
    }

    public void d1(boolean z10) {
        this.f1851f = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        c.a("Drawable#draw");
        if (this.f1851f) {
            try {
                if (this.f1871z) {
                    y0(canvas, this.f1865t);
                } else {
                    B(canvas);
                }
            } catch (Throwable th) {
                n.d.b("Lottie crashed in draw!", th);
            }
        } else if (this.f1871z) {
            y0(canvas, this.f1865t);
        } else {
            B(canvas);
        }
        this.M = false;
        c.b("Drawable#draw");
    }

    public boolean e0() {
        return this.f1869x;
    }

    public void e1(float f10) {
        this.f1848c.I(f10);
    }

    public void f1(Boolean bool) {
        this.f1849d = bool.booleanValue();
    }

    public void g1(o0 o0Var) {
        this.f1861p = o0Var;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1866u;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h1(boolean z10) {
        this.f1848c.J(z10);
    }

    @Nullable
    public Bitmap i1(String str, @Nullable Bitmap bitmap) {
        g.b N = N();
        if (N == null) {
            n.d.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap e2 = N.e(str, bitmap);
        invalidateSelf();
        return e2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.M) {
            return;
        }
        this.M = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return c0();
    }

    public boolean j1() {
        return this.f1859n == null && this.f1861p == null && this.f1847b.c().size() > 0;
    }

    public void r(Animator.AnimatorListener animatorListener) {
        this.f1848c.addListener(animatorListener);
    }

    public void s(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f1848c.addUpdateListener(animatorUpdateListener);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i10) {
        this.f1866u = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        n.d.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean z12 = !isVisible();
        boolean visible = super.setVisible(z10, z11);
        if (z10) {
            OnVisibleAction onVisibleAction = this.f1852g;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                v0();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                A0();
            }
        } else if (this.f1848c.isRunning()) {
            u0();
            this.f1852g = OnVisibleAction.RESUME;
        } else if (!z12) {
            this.f1852g = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        v0();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        E();
    }

    public <T> void t(final h.c cVar, final T t2, @Nullable final o.c<T> cVar2) {
        com.airbnb.lottie.model.layer.a aVar = this.f1865t;
        if (aVar == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.q
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.f0(cVar, t2, cVar2, lottieComposition);
                }
            });
            return;
        }
        boolean z10 = true;
        if (cVar == h.c.f49478c) {
            aVar.a(t2, cVar2);
        } else if (cVar.d() != null) {
            cVar.d().a(t2, cVar2);
        } else {
            List<h.c> z02 = z0(cVar);
            for (int i10 = 0; i10 < z02.size(); i10++) {
                z02.get(i10).d().a(t2, cVar2);
            }
            z10 = true ^ z02.isEmpty();
        }
        if (z10) {
            invalidateSelf();
            if (t2 == i0.E) {
                Z0(U());
            }
        }
    }

    public final boolean u() {
        return this.f1849d || this.f1850e;
    }

    public void u0() {
        this.f1853h.clear();
        this.f1848c.s();
        if (isVisible()) {
            return;
        }
        this.f1852g = OnVisibleAction.NONE;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final void v() {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            return;
        }
        com.airbnb.lottie.model.layer.a aVar = new com.airbnb.lottie.model.layer.a(this, m.v.a(lottieComposition), lottieComposition.k(), lottieComposition);
        this.f1865t = aVar;
        if (this.f1868w) {
            aVar.J(true);
        }
        this.f1865t.O(this.f1864s);
    }

    @MainThread
    public void v0() {
        if (this.f1865t == null) {
            this.f1853h.add(new b() { // from class: com.airbnb.lottie.v
                @Override // com.airbnb.lottie.LottieDrawable.b
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.g0(lottieComposition);
                }
            });
            return;
        }
        y();
        if (u() || W() == 0) {
            if (isVisible()) {
                this.f1848c.t();
                this.f1852g = OnVisibleAction.NONE;
            } else {
                this.f1852g = OnVisibleAction.PLAY;
            }
        }
        if (u()) {
            return;
        }
        I0((int) (Y() < 0.0f ? S() : R()));
        this.f1848c.k();
        if (isVisible()) {
            return;
        }
        this.f1852g = OnVisibleAction.NONE;
    }

    public void w() {
        this.f1853h.clear();
        this.f1848c.cancel();
        if (isVisible()) {
            return;
        }
        this.f1852g = OnVisibleAction.NONE;
    }

    public void w0() {
        this.f1848c.removeAllListeners();
    }

    public void x() {
        if (this.f1848c.isRunning()) {
            this.f1848c.cancel();
            if (!isVisible()) {
                this.f1852g = OnVisibleAction.NONE;
            }
        }
        this.f1847b = null;
        this.f1865t = null;
        this.f1855j = null;
        this.f1848c.j();
        invalidateSelf();
    }

    public void x0() {
        this.f1848c.removeAllUpdateListeners();
        this.f1848c.addUpdateListener(this.f1854i);
    }

    public final void y() {
        LottieComposition lottieComposition = this.f1847b;
        if (lottieComposition == null) {
            return;
        }
        this.f1871z = this.f1870y.useSoftwareRendering(Build.VERSION.SDK_INT, lottieComposition.q(), lottieComposition.m());
    }

    public final void y0(Canvas canvas, com.airbnb.lottie.model.layer.a aVar) {
        if (this.f1847b == null || aVar == null) {
            return;
        }
        G();
        canvas.getMatrix(this.K);
        canvas.getClipBounds(this.D);
        z(this.D, this.E);
        this.K.mapRect(this.E);
        A(this.E, this.D);
        if (this.f1864s) {
            this.J.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            aVar.b(this.J, null, false);
        }
        this.K.mapRect(this.J);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        B0(this.J, width, height);
        if (!b0()) {
            RectF rectF = this.J;
            Rect rect = this.D;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int ceil = (int) Math.ceil(this.J.width());
        int ceil2 = (int) Math.ceil(this.J.height());
        if (ceil == 0 || ceil2 == 0) {
            return;
        }
        F(ceil, ceil2);
        if (this.M) {
            this.A.set(this.K);
            this.A.preScale(width, height);
            Matrix matrix = this.A;
            RectF rectF2 = this.J;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.B.eraseColor(0);
            aVar.d(this.C, this.A, this.f1866u);
            this.K.invert(this.L);
            this.L.mapRect(this.I, this.J);
            A(this.I, this.H);
        }
        this.G.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.B, this.G, this.H, this.F);
    }

    public final void z(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public List<h.c> z0(h.c cVar) {
        if (this.f1865t == null) {
            n.d.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f1865t.h(cVar, 0, arrayList, new h.c(new String[0]));
        return arrayList;
    }
}
