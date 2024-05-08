package com.google.common.cache;

import com.google.common.base.l;
import com.google.common.base.o;

/* compiled from: CacheStats.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final long f26131a;

    /* renamed from: b, reason: collision with root package name */
    public final long f26132b;

    /* renamed from: c, reason: collision with root package name */
    public final long f26133c;

    /* renamed from: d, reason: collision with root package name */
    public final long f26134d;

    /* renamed from: e, reason: collision with root package name */
    public final long f26135e;

    /* renamed from: f, reason: collision with root package name */
    public final long f26136f;

    public d(long j10, long j11, long j12, long j13, long j14, long j15) {
        o.d(j10 >= 0);
        o.d(j11 >= 0);
        o.d(j12 >= 0);
        o.d(j13 >= 0);
        o.d(j14 >= 0);
        o.d(j15 >= 0);
        this.f26131a = j10;
        this.f26132b = j11;
        this.f26133c = j12;
        this.f26134d = j13;
        this.f26135e = j14;
        this.f26136f = j15;
    }

    public long a() {
        return this.f26136f;
    }

    public long b() {
        return this.f26131a;
    }

    public long c() {
        return this.f26134d;
    }

    public long d() {
        return this.f26133c;
    }

    public long e() {
        return this.f26132b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f26131a == dVar.f26131a && this.f26132b == dVar.f26132b && this.f26133c == dVar.f26133c && this.f26134d == dVar.f26134d && this.f26135e == dVar.f26135e && this.f26136f == dVar.f26136f;
    }

    public long f() {
        return this.f26135e;
    }

    public int hashCode() {
        return l.b(Long.valueOf(this.f26131a), Long.valueOf(this.f26132b), Long.valueOf(this.f26133c), Long.valueOf(this.f26134d), Long.valueOf(this.f26135e), Long.valueOf(this.f26136f));
    }

    public String toString() {
        return com.google.common.base.j.c(this).c("hitCount", this.f26131a).c("missCount", this.f26132b).c("loadSuccessCount", this.f26133c).c("loadExceptionCount", this.f26134d).c("totalLoadTime", this.f26135e).c("evictionCount", this.f26136f).toString();
    }
}
