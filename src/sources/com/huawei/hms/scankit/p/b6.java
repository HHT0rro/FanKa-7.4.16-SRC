package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ParticleSystem.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b6 {

    /* renamed from: r, reason: collision with root package name */
    private static final Object f30740r = new Object();

    /* renamed from: c, reason: collision with root package name */
    private int f30743c;

    /* renamed from: d, reason: collision with root package name */
    private long f30744d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f30745e;

    /* renamed from: f, reason: collision with root package name */
    private float f30746f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f30747g;

    /* renamed from: h, reason: collision with root package name */
    private int f30748h;

    /* renamed from: i, reason: collision with root package name */
    private int f30749i;

    /* renamed from: j, reason: collision with root package name */
    private int f30750j;

    /* renamed from: k, reason: collision with root package name */
    private int f30751k;

    /* renamed from: l, reason: collision with root package name */
    private int f30752l;

    /* renamed from: n, reason: collision with root package name */
    private Path f30754n;

    /* renamed from: o, reason: collision with root package name */
    private PathMeasure f30755o;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<w5> f30741a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<w5> f30742b = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    private boolean f30753m = false;

    /* renamed from: p, reason: collision with root package name */
    private x5 f30756p = new x5();

    /* renamed from: q, reason: collision with root package name */
    private z5 f30757q = new z5();

    public b6(int i10, long j10) {
        a(i10, j10);
        a((Bitmap) null);
    }

    private void a(@NonNull g4 g4Var) {
        if (this.f30757q == null) {
            this.f30757q = new z5();
        }
        this.f30757q.a(g4Var);
    }

    public b6 b(float f10, float f11) {
        a(new a6(f10, f11));
        return this;
    }

    public List<w5> c() {
        List<w5> unmodifiableList;
        synchronized (f30740r) {
            unmodifiableList = Collections.unmodifiableList(this.f30742b);
        }
        return unmodifiableList;
    }

    public void b(long j10) {
        boolean z10 = this.f30745e;
        float f10 = this.f30746f * ((float) j10);
        ArrayList arrayList = new ArrayList();
        synchronized (f30740r) {
            while (z10) {
                if (this.f30741a.isEmpty() || this.f30748h >= f10) {
                    break;
                } else {
                    a(j10);
                }
            }
            Iterator<w5> iterator2 = this.f30742b.iterator2();
            while (iterator2.hasNext()) {
                w5 next = iterator2.next();
                if (!next.a(j10)) {
                    iterator2.remove();
                    arrayList.add(next);
                }
            }
        }
        this.f30741a.addAll(arrayList);
    }

    public b6 a(int i10, int i11, long j10, long j11, @NonNull Interpolator interpolator) {
        a(new j5(i10, i11, j10, j11, interpolator));
        return this;
    }

    private void a(@NonNull f4 f4Var) {
        if (this.f30756p == null) {
            this.f30756p = new x5();
        }
        this.f30756p.a(f4Var);
    }

    private void a(int i10, long j10) {
        this.f30747g = new int[2];
        this.f30743c = i10;
        this.f30744d = j10;
    }

    private void a(Bitmap bitmap) {
        for (int i10 = 0; i10 < this.f30743c; i10++) {
            this.f30741a.add(new w5(bitmap));
        }
    }

    public void a(@NonNull Rect rect, int i10) {
        a(rect);
        a(i10);
    }

    private void a(int i10) {
        synchronized (f30740r) {
            this.f30748h = 0;
        }
        this.f30746f = i10 / 1000.0f;
        this.f30745e = true;
    }

    private void b() {
        ArrayList arrayList;
        synchronized (f30740r) {
            arrayList = new ArrayList(this.f30742b);
        }
        this.f30741a.addAll(arrayList);
    }

    private void a(@NonNull Rect rect) {
        int i10 = rect.left - this.f30747g[0];
        this.f30750j = i10;
        this.f30749i = i10 + rect.width();
        int i11 = rect.top - this.f30747g[1];
        this.f30752l = i11;
        this.f30751k = i11 + rect.height();
    }

    private void a(long j10) {
        PathMeasure pathMeasure;
        w5 remove = this.f30741a.remove(0);
        this.f30757q.a(remove);
        if (this.f30753m && (pathMeasure = this.f30755o) != null) {
            float[] a10 = a(0.0f, pathMeasure.getLength());
            remove.a(this.f30744d, (int) a10[0], (int) a10[1], j10, this.f30756p);
        } else {
            remove.a(this.f30744d, a(this.f30750j, this.f30749i), a(this.f30752l, this.f30751k), j10, this.f30756p);
        }
        synchronized (f30740r) {
            this.f30742b.add(remove);
            this.f30748h++;
        }
    }

    private int a(int i10, int i11) {
        if (i10 == i11) {
            return i10;
        }
        if (i10 < i11) {
            return n6.a(i11 - i10) + i10;
        }
        return n6.a(i10 - i11) + i11;
    }

    private float[] a(float f10, float f11) {
        float a10;
        if (Float.compare(f10, f11) <= 0) {
            a10 = n6.a(f11 - f10) + f10;
        } else {
            a10 = f11 + n6.a(f10 - f11);
        }
        if (this.f30755o == null) {
            this.f30755o = new PathMeasure(this.f30754n, true);
        }
        this.f30755o.getPosTan(a10, r5, null);
        float f12 = r5[0];
        int[] iArr = this.f30747g;
        float[] fArr = {f12 - iArr[0], fArr[1] - iArr[1]};
        return fArr;
    }

    public void a() {
        b();
    }
}
