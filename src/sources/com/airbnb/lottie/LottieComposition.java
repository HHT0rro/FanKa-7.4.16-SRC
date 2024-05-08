package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LottieComposition {

    /* renamed from: c, reason: collision with root package name */
    public Map<String, List<Layer>> f1834c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, e0> f1835d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, h.a> f1836e;

    /* renamed from: f, reason: collision with root package name */
    public List<h.f> f1837f;

    /* renamed from: g, reason: collision with root package name */
    public SparseArrayCompat<h.b> f1838g;

    /* renamed from: h, reason: collision with root package name */
    public LongSparseArray<Layer> f1839h;

    /* renamed from: i, reason: collision with root package name */
    public List<Layer> f1840i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f1841j;

    /* renamed from: k, reason: collision with root package name */
    public float f1842k;

    /* renamed from: l, reason: collision with root package name */
    public float f1843l;

    /* renamed from: m, reason: collision with root package name */
    public float f1844m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1845n;

    /* renamed from: a, reason: collision with root package name */
    public final m0 f1832a = new m0();

    /* renamed from: b, reason: collision with root package name */
    public final HashSet<String> f1833b = new HashSet<>();

    /* renamed from: o, reason: collision with root package name */
    public int f1846o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        n.d.c(str);
        this.f1833b.add(str);
    }

    public Rect b() {
        return this.f1841j;
    }

    public SparseArrayCompat<h.b> c() {
        return this.f1838g;
    }

    public float d() {
        return (e() / this.f1844m) * 1000.0f;
    }

    public float e() {
        return this.f1843l - this.f1842k;
    }

    public float f() {
        return this.f1843l;
    }

    public Map<String, h.a> g() {
        return this.f1836e;
    }

    public float h(float f10) {
        return n.g.i(this.f1842k, this.f1843l, f10);
    }

    public float i() {
        return this.f1844m;
    }

    public Map<String, e0> j() {
        return this.f1835d;
    }

    public List<Layer> k() {
        return this.f1840i;
    }

    @Nullable
    public h.f l(String str) {
        int size = this.f1837f.size();
        for (int i10 = 0; i10 < size; i10++) {
            h.f fVar = this.f1837f.get(i10);
            if (fVar.a(str)) {
                return fVar;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int m() {
        return this.f1846o;
    }

    public m0 n() {
        return this.f1832a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> o(String str) {
        return this.f1834c.get(str);
    }

    public float p() {
        return this.f1842k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean q() {
        return this.f1845n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void r(int i10) {
        this.f1846o += i10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void s(Rect rect, float f10, float f11, float f12, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, e0> map2, SparseArrayCompat<h.b> sparseArrayCompat, Map<String, h.a> map3, List<h.f> list2) {
        this.f1841j = rect;
        this.f1842k = f10;
        this.f1843l = f11;
        this.f1844m = f12;
        this.f1840i = list;
        this.f1839h = longSparseArray;
        this.f1834c = map;
        this.f1835d = map2;
        this.f1838g = sparseArrayCompat;
        this.f1836e = map3;
        this.f1837f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer t(long j10) {
        return this.f1839h.get(j10);
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> iterator2 = this.f1840i.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().y("\t"));
        }
        return sb2.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void u(boolean z10) {
        this.f1845n = z10;
    }

    public void v(boolean z10) {
        this.f1832a.b(z10);
    }
}
