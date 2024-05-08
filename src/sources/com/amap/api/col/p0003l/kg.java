package com.amap.api.col.p0003l;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.List;

/* compiled from: RssiInfoManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class kg {

    /* renamed from: g, reason: collision with root package name */
    private static volatile kg f6626g;

    /* renamed from: h, reason: collision with root package name */
    private static Object f6627h = new Object();

    /* renamed from: e, reason: collision with root package name */
    private Object f6632e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private Object f6633f = new Object();

    /* renamed from: a, reason: collision with root package name */
    private LongSparseArray<a> f6628a = new LongSparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private LongSparseArray<a> f6629b = new LongSparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private LongSparseArray<a> f6630c = new LongSparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private LongSparseArray<a> f6631d = new LongSparseArray<>();

    /* compiled from: RssiInfoManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f6634a;

        /* renamed from: b, reason: collision with root package name */
        public long f6635b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6636c;

        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    private kg() {
    }

    public static kg a() {
        if (f6626g == null) {
            synchronized (f6627h) {
                if (f6626g == null) {
                    f6626g = new kg();
                }
            }
        }
        return f6626g;
    }

    public final void b(List<kf> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f6633f) {
            a(list, this.f6630c, this.f6631d);
            LongSparseArray<a> longSparseArray = this.f6630c;
            this.f6630c = this.f6631d;
            this.f6631d = longSparseArray;
            longSparseArray.clear();
        }
    }

    public final void a(List<kf> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f6632e) {
            a(list, this.f6628a, this.f6629b);
            LongSparseArray<a> longSparseArray = this.f6628a;
            this.f6628a = this.f6629b;
            this.f6629b = longSparseArray;
            longSparseArray.clear();
        }
    }

    public final short b(long j10) {
        return a(this.f6630c, j10);
    }

    private static long b() {
        return SystemClock.elapsedRealtime();
    }

    public final short a(long j10) {
        return a(this.f6628a, j10);
    }

    private static void a(List<kf> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long b4 = b();
        byte b10 = 0;
        if (longSparseArray.size() == 0) {
            for (kf kfVar : list) {
                a aVar = new a(b10);
                aVar.f6634a = kfVar.b();
                aVar.f6635b = b4;
                aVar.f6636c = false;
                longSparseArray2.put(kfVar.a(), aVar);
            }
            return;
        }
        for (kf kfVar2 : list) {
            long a10 = kfVar2.a();
            a aVar2 = longSparseArray.get(a10);
            if (aVar2 == null) {
                aVar2 = new a(b10);
                aVar2.f6634a = kfVar2.b();
                aVar2.f6635b = b4;
                aVar2.f6636c = true;
            } else if (aVar2.f6634a != kfVar2.b()) {
                aVar2.f6634a = kfVar2.b();
                aVar2.f6635b = b4;
                aVar2.f6636c = true;
            }
            longSparseArray2.put(a10, aVar2);
        }
    }

    private static short a(LongSparseArray<a> longSparseArray, long j10) {
        synchronized (longSparseArray) {
            a aVar = longSparseArray.get(j10);
            if (aVar == null) {
                return (short) 0;
            }
            short max = (short) Math.max(1L, Math.min(32767L, (b() - aVar.f6635b) / 1000));
            if (!aVar.f6636c) {
                max = (short) (-max);
            }
            return max;
        }
    }
}
