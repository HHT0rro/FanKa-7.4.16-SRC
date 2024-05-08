package com.google.android.datatransport.runtime.backends;

import com.alipay.sdk.util.i;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import java.util.Objects;

/* compiled from: AutoValue_BackendResponse.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends BackendResponse {

    /* renamed from: a, reason: collision with root package name */
    public final BackendResponse.Status f19386a;

    /* renamed from: b, reason: collision with root package name */
    public final long f19387b;

    public a(BackendResponse.Status status, long j10) {
        Objects.requireNonNull(status, "Null status");
        this.f19386a = status;
        this.f19387b = j10;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.f19387b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.f19386a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.f19386a.equals(backendResponse.c()) && this.f19387b == backendResponse.b();
    }

    public int hashCode() {
        int hashCode = (this.f19386a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f19387b;
        return hashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + ((Object) this.f19386a) + ", nextRequestWaitMillis=" + this.f19387b + i.f4738d;
    }
}
