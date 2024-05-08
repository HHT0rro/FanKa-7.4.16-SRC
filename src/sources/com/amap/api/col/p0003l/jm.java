package com.amap.api.col.p0003l;

import android.os.SystemClock;
import com.amap.api.col.p0003l.jl;
import java.util.List;

/* compiled from: FpsCollector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jm {

    /* renamed from: g, reason: collision with root package name */
    private static volatile jm f6576g;

    /* renamed from: h, reason: collision with root package name */
    private static Object f6577h = new Object();

    /* renamed from: c, reason: collision with root package name */
    private long f6580c;

    /* renamed from: d, reason: collision with root package name */
    private kr f6581d;

    /* renamed from: f, reason: collision with root package name */
    private kr f6583f = new kr();

    /* renamed from: a, reason: collision with root package name */
    private jl f6578a = new jl();

    /* renamed from: b, reason: collision with root package name */
    private jn f6579b = new jn();

    /* renamed from: e, reason: collision with root package name */
    private ji f6582e = new ji();

    /* compiled from: FpsCollector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public kr f6584a;

        /* renamed from: b, reason: collision with root package name */
        public List<ks> f6585b;

        /* renamed from: c, reason: collision with root package name */
        public long f6586c;

        /* renamed from: d, reason: collision with root package name */
        public long f6587d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f6588e;

        /* renamed from: f, reason: collision with root package name */
        public long f6589f;

        /* renamed from: g, reason: collision with root package name */
        public byte f6590g;

        /* renamed from: h, reason: collision with root package name */
        public String f6591h;

        /* renamed from: i, reason: collision with root package name */
        public List<kl> f6592i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f6593j;
    }

    private jm() {
    }

    public static jm a() {
        if (f6576g == null) {
            synchronized (f6577h) {
                if (f6576g == null) {
                    f6576g = new jm();
                }
            }
        }
        return f6576g;
    }

    public final jo a(a aVar) {
        jo joVar = null;
        if (aVar == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        kr krVar = this.f6581d;
        if (krVar == null || aVar.f6584a.a(krVar) >= 10.0d) {
            jl.a a10 = this.f6578a.a(aVar.f6584a, aVar.f6593j, aVar.f6590g, aVar.f6591h, aVar.f6592i);
            List<ks> a11 = this.f6579b.a(aVar.f6584a, aVar.f6585b, aVar.f6588e, aVar.f6587d, currentTimeMillis);
            if (a10 != null || a11 != null) {
                kj.a(this.f6583f, aVar.f6584a, aVar.f6589f, currentTimeMillis);
                joVar = new jo(0, this.f6582e.a(this.f6583f, a10, aVar.f6586c, a11));
            }
            this.f6581d = aVar.f6584a;
            this.f6580c = elapsedRealtime;
        }
        return joVar;
    }
}
