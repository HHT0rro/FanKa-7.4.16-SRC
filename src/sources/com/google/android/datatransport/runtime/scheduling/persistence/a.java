package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.c;

/* compiled from: AutoValue_EventStoreConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends c {

    /* renamed from: b, reason: collision with root package name */
    public final long f19422b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19423c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19424d;

    /* renamed from: e, reason: collision with root package name */
    public final long f19425e;

    /* renamed from: f, reason: collision with root package name */
    public final int f19426f;

    /* compiled from: AutoValue_EventStoreConfig.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends c.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f19427a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f19428b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f19429c;

        /* renamed from: d, reason: collision with root package name */
        public Long f19430d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f19431e;

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.c.a
        public c a() {
            String str = "";
            if (this.f19427a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f19428b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f19429c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f19430d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f19431e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f19427a.longValue(), this.f19428b.intValue(), this.f19429c.intValue(), this.f19430d.longValue(), this.f19431e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.c.a
        public c.a b(int i10) {
            this.f19429c = Integer.valueOf(i10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.c.a
        public c.a c(long j10) {
            this.f19430d = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.c.a
        public c.a d(int i10) {
            this.f19428b = Integer.valueOf(i10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.c.a
        public c.a e(int i10) {
            this.f19431e = Integer.valueOf(i10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.persistence.c.a
        public c.a f(long j10) {
            this.f19427a = Long.valueOf(j10);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.c
    public int b() {
        return this.f19424d;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.c
    public long c() {
        return this.f19425e;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.c
    public int d() {
        return this.f19423c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.c
    public int e() {
        return this.f19426f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f19422b == cVar.f() && this.f19423c == cVar.d() && this.f19424d == cVar.b() && this.f19425e == cVar.c() && this.f19426f == cVar.e();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.c
    public long f() {
        return this.f19422b;
    }

    public int hashCode() {
        long j10 = this.f19422b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f19423c) * 1000003) ^ this.f19424d) * 1000003;
        long j11 = this.f19425e;
        return this.f19426f ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f19422b + ", loadBatchSize=" + this.f19423c + ", criticalSectionEnterTimeoutMs=" + this.f19424d + ", eventCleanUpAge=" + this.f19425e + ", maxBlobByteSizePerRow=" + this.f19426f + com.alipay.sdk.util.i.f4738d;
    }

    public a(long j10, int i10, int i11, long j11, int i12) {
        this.f19422b = j10;
        this.f19423c = i10;
        this.f19424d = i11;
        this.f19425e = j11;
        this.f19426f = i12;
    }
}
