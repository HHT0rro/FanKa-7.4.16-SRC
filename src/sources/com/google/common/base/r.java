package com.google.common.base;

import com.huawei.quickcard.base.Attributes;
import java.util.concurrent.TimeUnit;

/* compiled from: Stopwatch.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final v f25991a = v.b();

    /* renamed from: b, reason: collision with root package name */
    public boolean f25992b;

    /* renamed from: c, reason: collision with root package name */
    public long f25993c;

    /* renamed from: d, reason: collision with root package name */
    public long f25994d;

    /* compiled from: Stopwatch.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25995a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f25995a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25995a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25995a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25995a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25995a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25995a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25995a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static String a(TimeUnit timeUnit) {
        switch (a.f25995a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return com.kuaishou.weapon.p0.t.f36222g;
            case 5:
                return Attributes.Style.MIN;
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    public static TimeUnit b(long j10) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j10, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j10, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j10, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j10, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j10, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        return timeUnit7.convert(j10, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static r c() {
        return new r().h();
    }

    public static r d() {
        return new r();
    }

    public long e(TimeUnit timeUnit) {
        return timeUnit.convert(f(), TimeUnit.NANOSECONDS);
    }

    public final long f() {
        return this.f25992b ? (this.f25991a.a() - this.f25994d) + this.f25993c : this.f25993c;
    }

    public r g() {
        this.f25993c = 0L;
        this.f25992b = false;
        return this;
    }

    public r h() {
        o.y(!this.f25992b, "This stopwatch is already running.");
        this.f25992b = true;
        this.f25994d = this.f25991a.a();
        return this;
    }

    public r i() {
        long a10 = this.f25991a.a();
        o.y(this.f25992b, "This stopwatch is already stopped.");
        this.f25992b = false;
        this.f25993c += a10 - this.f25994d;
        return this;
    }

    public String toString() {
        long f10 = f();
        TimeUnit b4 = b(f10);
        String c4 = n.c(f10 / TimeUnit.NANOSECONDS.convert(1L, b4));
        String a10 = a(b4);
        StringBuilder sb2 = new StringBuilder(String.valueOf(c4).length() + 1 + String.valueOf(a10).length());
        sb2.append(c4);
        sb2.append(" ");
        sb2.append(a10);
        return sb2.toString();
    }
}
