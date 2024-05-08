package com.google.android.datatransport.cct.internal;

/* compiled from: AutoValue_LogResponse.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g extends k {

    /* renamed from: a, reason: collision with root package name */
    public final long f19363a;

    public g(long j10) {
        this.f19363a = j10;
    }

    @Override // com.google.android.datatransport.cct.internal.k
    public long c() {
        return this.f19363a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof k) && this.f19363a == ((k) obj).c();
    }

    public int hashCode() {
        long j10 = this.f19363a;
        return 1000003 ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f19363a + com.alipay.sdk.util.i.f4738d;
    }
}
