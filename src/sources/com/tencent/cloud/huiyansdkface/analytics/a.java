package com.tencent.cloud.huiyansdkface.analytics;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40452a = "a";

    /* renamed from: b, reason: collision with root package name */
    private long f40453b;

    /* renamed from: c, reason: collision with root package name */
    private long f40454c;

    /* renamed from: d, reason: collision with root package name */
    private long f40455d = 1;

    /* renamed from: e, reason: collision with root package name */
    private long f40456e = 0;

    private synchronized long e() {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        this.f40454c = currentTimeMillis;
        return currentTimeMillis;
    }

    public final synchronized boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f40456e != 0) {
            return false;
        }
        String str = f40452a;
        WBSLogger.d(str, "new life on first:".concat(String.valueOf(currentTimeMillis)), new Object[0]);
        this.f40453b = currentTimeMillis;
        this.f40455d = 1L;
        WBSLogger.d(str, "inn start new session.", new Object[0]);
        WBSLogger.d(str, "new session:".concat(String.valueOf(e())), new Object[0]);
        return true;
    }

    public final synchronized String b() {
        long j10;
        j10 = this.f40453b;
        if (j10 == 0) {
            throw new IllegalStateException("life not start");
        }
        return String.valueOf(j10);
    }

    public final synchronized String c() {
        long j10;
        j10 = this.f40454c;
        if (j10 == 0) {
            throw new IllegalStateException("session not started");
        }
        return String.valueOf(j10);
    }

    public final synchronized String d() {
        String valueOf;
        valueOf = String.valueOf(this.f40455d);
        this.f40455d++;
        return valueOf;
    }
}
