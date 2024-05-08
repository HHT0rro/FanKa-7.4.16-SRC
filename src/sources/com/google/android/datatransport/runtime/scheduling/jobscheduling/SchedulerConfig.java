package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.b;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AutoValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class SchedulerConfig {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public u4.a f19411a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Priority, b> f19412b = new HashMap();

        public a a(Priority priority, b bVar) {
            this.f19412b.put(priority, bVar);
            return this;
        }

        public SchedulerConfig b() {
            Objects.requireNonNull(this.f19411a, "missing required property: clock");
            if (this.f19412b.keySet().size() >= Priority.values().length) {
                Map<Priority, b> map = this.f19412b;
                this.f19412b = new HashMap();
                return SchedulerConfig.d(this.f19411a, map);
            }
            throw new IllegalStateException("Not all priorities have been configured");
        }

        public a c(u4.a aVar) {
            this.f19411a = aVar;
            return this;
        }
    }

    @AutoValue
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class b {

        @AutoValue.Builder
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j10);

            public abstract a c(Set<Flag> set);

            public abstract a d(long j10);
        }

        public static a a() {
            return new b.C0183b().c(Collections.emptySet());
        }

        public abstract long b();

        public abstract Set<Flag> c();

        public abstract long d();
    }

    public static a b() {
        return new a();
    }

    public static SchedulerConfig d(u4.a aVar, Map<Priority, b> map) {
        return new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(aVar, map);
    }

    public static SchedulerConfig f(u4.a aVar) {
        return b().a(Priority.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(Priority.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(Priority.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE)).a()).c(aVar).b();
    }

    public static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    public final long a(int i10, long j10) {
        return (long) (Math.pow(3.0d, i10 - 1) * j10 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j10 > 1 ? j10 : 2L) * r7)));
    }

    @RequiresApi(api = 21)
    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j10, int i10) {
        builder.setMinimumLatency(g(priority, j10, i10));
        j(builder, h().get(priority).c());
        return builder;
    }

    public abstract u4.a e();

    public long g(Priority priority, long j10, int i10) {
        long time = j10 - e().getTime();
        b bVar = h().get(priority);
        return Math.min(Math.max(a(i10, bVar.b()), time), bVar.d());
    }

    public abstract Map<Priority, b> h();

    @RequiresApi(api = 21)
    public final void j(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }
}
