package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.alipay.sdk.util.i;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Objects;
import java.util.Set;

/* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends SchedulerConfig.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f19415a;

    /* renamed from: b, reason: collision with root package name */
    public final long f19416b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<SchedulerConfig.Flag> f19417c;

    /* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0183b extends SchedulerConfig.b.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f19418a;

        /* renamed from: b, reason: collision with root package name */
        public Long f19419b;

        /* renamed from: c, reason: collision with root package name */
        public Set<SchedulerConfig.Flag> f19420c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b a() {
            String str = "";
            if (this.f19418a == null) {
                str = " delta";
            }
            if (this.f19419b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f19420c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new b(this.f19418a.longValue(), this.f19419b.longValue(), this.f19420c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a b(long j10) {
            this.f19418a = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a c(Set<SchedulerConfig.Flag> set) {
            Objects.requireNonNull(set, "Null flags");
            this.f19420c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a d(long j10) {
            this.f19419b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long b() {
        return this.f19415a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public Set<SchedulerConfig.Flag> c() {
        return this.f19417c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long d() {
        return this.f19416b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.b)) {
            return false;
        }
        SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
        return this.f19415a == bVar.b() && this.f19416b == bVar.d() && this.f19417c.equals(bVar.c());
    }

    public int hashCode() {
        long j10 = this.f19415a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f19416b;
        return this.f19417c.hashCode() ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f19415a + ", maxAllowedDelay=" + this.f19416b + ", flags=" + ((Object) this.f19417c) + i.f4738d;
    }

    public b(long j10, long j11, Set<SchedulerConfig.Flag> set) {
        this.f19415a = j10;
        this.f19416b = j11;
        this.f19417c = set;
    }
}
