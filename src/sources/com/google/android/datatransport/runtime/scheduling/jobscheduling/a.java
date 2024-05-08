package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.alipay.sdk.util.i;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Map;
import java.util.Objects;

/* compiled from: AutoValue_SchedulerConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends SchedulerConfig {

    /* renamed from: a, reason: collision with root package name */
    public final u4.a f19413a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Priority, SchedulerConfig.b> f19414b;

    public a(u4.a aVar, Map<Priority, SchedulerConfig.b> map) {
        Objects.requireNonNull(aVar, "Null clock");
        this.f19413a = aVar;
        Objects.requireNonNull(map, "Null values");
        this.f19414b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public u4.a e() {
        return this.f19413a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.f19413a.equals(schedulerConfig.e()) && this.f19414b.equals(schedulerConfig.h());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public Map<Priority, SchedulerConfig.b> h() {
        return this.f19414b;
    }

    public int hashCode() {
        return ((this.f19413a.hashCode() ^ 1000003) * 1000003) ^ this.f19414b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + ((Object) this.f19413a) + ", values=" + ((Object) this.f19414b) + i.f4738d;
    }
}
