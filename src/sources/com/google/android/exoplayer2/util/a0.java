package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: SlidingPercentile.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a0 {

    /* renamed from: h, reason: collision with root package name */
    public static final Comparator<b> f22937h = new Comparator() { // from class: com.google.android.exoplayer2.util.y
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g3;
            g3 = a0.g((a0.b) obj, (a0.b) obj2);
            return g3;
        }
    };

    /* renamed from: i, reason: collision with root package name */
    public static final Comparator<b> f22938i = new Comparator() { // from class: com.google.android.exoplayer2.util.z
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h10;
            h10 = a0.h((a0.b) obj, (a0.b) obj2);
            return h10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f22939a;

    /* renamed from: e, reason: collision with root package name */
    public int f22943e;

    /* renamed from: f, reason: collision with root package name */
    public int f22944f;

    /* renamed from: g, reason: collision with root package name */
    public int f22945g;

    /* renamed from: c, reason: collision with root package name */
    public final b[] f22941c = new b[5];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f22940b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public int f22942d = -1;

    /* compiled from: SlidingPercentile.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f22946a;

        /* renamed from: b, reason: collision with root package name */
        public int f22947b;

        /* renamed from: c, reason: collision with root package name */
        public float f22948c;

        public b() {
        }
    }

    public a0(int i10) {
        this.f22939a = i10;
    }

    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f22946a - bVar2.f22946a;
    }

    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f22948c, bVar2.f22948c);
    }

    public void c(int i10, float f10) {
        b bVar;
        d();
        int i11 = this.f22945g;
        if (i11 > 0) {
            b[] bVarArr = this.f22941c;
            int i12 = i11 - 1;
            this.f22945g = i12;
            bVar = bVarArr[i12];
        } else {
            bVar = new b();
        }
        int i13 = this.f22943e;
        this.f22943e = i13 + 1;
        bVar.f22946a = i13;
        bVar.f22947b = i10;
        bVar.f22948c = f10;
        this.f22940b.add(bVar);
        this.f22944f += i10;
        while (true) {
            int i14 = this.f22944f;
            int i15 = this.f22939a;
            if (i14 <= i15) {
                return;
            }
            int i16 = i14 - i15;
            b bVar2 = this.f22940b.get(0);
            int i17 = bVar2.f22947b;
            if (i17 <= i16) {
                this.f22944f -= i17;
                this.f22940b.remove(0);
                int i18 = this.f22945g;
                if (i18 < 5) {
                    b[] bVarArr2 = this.f22941c;
                    this.f22945g = i18 + 1;
                    bVarArr2[i18] = bVar2;
                }
            } else {
                bVar2.f22947b = i17 - i16;
                this.f22944f -= i16;
            }
        }
    }

    public final void d() {
        if (this.f22942d != 1) {
            Collections.sort(this.f22940b, f22937h);
            this.f22942d = 1;
        }
    }

    public final void e() {
        if (this.f22942d != 0) {
            Collections.sort(this.f22940b, f22938i);
            this.f22942d = 0;
        }
    }

    public float f(float f10) {
        e();
        float f11 = f10 * this.f22944f;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f22940b.size(); i11++) {
            b bVar = this.f22940b.get(i11);
            i10 += bVar.f22947b;
            if (i10 >= f11) {
                return bVar.f22948c;
            }
        }
        if (this.f22940b.isEmpty()) {
            return Float.NaN;
        }
        return this.f22940b.get(r5.size() - 1).f22948c;
    }

    public void i() {
        this.f22940b.clear();
        this.f22942d = -1;
        this.f22943e = 0;
        this.f22944f = 0;
    }
}
