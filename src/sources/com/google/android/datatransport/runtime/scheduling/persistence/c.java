package com.google.android.datatransport.runtime.scheduling.persistence;

import com.baidu.mobads.sdk.internal.bk;
import com.google.android.datatransport.runtime.scheduling.persistence.a;
import com.google.auto.value.AutoValue;

/* compiled from: EventStoreConfig.java */
@AutoValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f19437a = a().f(10485760).d(200).b(10000).c(bk.f9895d).e(81920).a();

    /* compiled from: EventStoreConfig.java */
    @AutoValue.Builder
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class a {
        public abstract c a();

        public abstract a b(int i10);

        public abstract a c(long j10);

        public abstract a d(int i10);

        public abstract a e(int i10);

        public abstract a f(long j10);
    }

    public static a a() {
        return new a.b();
    }

    public abstract int b();

    public abstract long c();

    public abstract int d();

    public abstract int e();

    public abstract long f();
}
