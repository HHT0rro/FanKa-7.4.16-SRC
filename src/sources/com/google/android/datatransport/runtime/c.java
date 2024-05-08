package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.a0;
import com.google.android.datatransport.runtime.scheduling.persistence.g;
import com.google.android.datatransport.runtime.scheduling.persistence.g0;
import com.google.android.datatransport.runtime.scheduling.persistence.z;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import n4.f;
import o4.h;
import o4.j;
import s4.i;
import s4.m;
import s4.n;
import s4.o;

/* compiled from: DaggerTransportRuntimeComponent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c extends e {

    /* renamed from: b, reason: collision with root package name */
    public Provider<Executor> f19388b;

    /* renamed from: c, reason: collision with root package name */
    public Provider<Context> f19389c;

    /* renamed from: d, reason: collision with root package name */
    public Provider f19390d;

    /* renamed from: e, reason: collision with root package name */
    public Provider f19391e;

    /* renamed from: f, reason: collision with root package name */
    public Provider f19392f;

    /* renamed from: g, reason: collision with root package name */
    public Provider<z> f19393g;

    /* renamed from: h, reason: collision with root package name */
    public Provider<SchedulerConfig> f19394h;

    /* renamed from: i, reason: collision with root package name */
    public Provider<o> f19395i;

    /* renamed from: j, reason: collision with root package name */
    public Provider<r4.c> f19396j;

    /* renamed from: k, reason: collision with root package name */
    public Provider<i> f19397k;

    /* renamed from: l, reason: collision with root package name */
    public Provider<m> f19398l;

    /* renamed from: m, reason: collision with root package name */
    public Provider<d> f19399m;

    /* compiled from: DaggerTransportRuntimeComponent.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public Context f19400a;

        public b() {
        }

        @Override // com.google.android.datatransport.runtime.e.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f19400a = (Context) com.google.android.datatransport.runtime.dagger.internal.d.b(context);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.e.a
        public e build() {
            com.google.android.datatransport.runtime.dagger.internal.d.a(this.f19400a, Context.class);
            return new c(this.f19400a);
        }
    }

    public static e.a d() {
        return new b();
    }

    @Override // com.google.android.datatransport.runtime.e
    public com.google.android.datatransport.runtime.scheduling.persistence.b a() {
        return this.f19393g.get();
    }

    @Override // com.google.android.datatransport.runtime.e
    public d b() {
        return this.f19399m.get();
    }

    public final void e(Context context) {
        this.f19388b = com.google.android.datatransport.runtime.dagger.internal.a.a(f.a());
        com.google.android.datatransport.runtime.dagger.internal.b a10 = com.google.android.datatransport.runtime.dagger.internal.c.a(context);
        this.f19389c = a10;
        h a11 = h.a(a10, u4.c.a(), u4.d.a());
        this.f19390d = a11;
        this.f19391e = com.google.android.datatransport.runtime.dagger.internal.a.a(j.a(this.f19389c, a11));
        this.f19392f = g0.a(this.f19389c, com.google.android.datatransport.runtime.scheduling.persistence.e.a(), com.google.android.datatransport.runtime.scheduling.persistence.f.a());
        this.f19393g = com.google.android.datatransport.runtime.dagger.internal.a.a(a0.a(u4.c.a(), u4.d.a(), g.a(), this.f19392f));
        r4.g b4 = r4.g.b(u4.c.a());
        this.f19394h = b4;
        r4.i a12 = r4.i.a(this.f19389c, this.f19393g, b4, u4.d.a());
        this.f19395i = a12;
        Provider<Executor> provider = this.f19388b;
        Provider provider2 = this.f19391e;
        Provider<z> provider3 = this.f19393g;
        this.f19396j = r4.d.a(provider, provider2, a12, provider3, provider3);
        Provider<Context> provider4 = this.f19389c;
        Provider provider5 = this.f19391e;
        Provider<z> provider6 = this.f19393g;
        this.f19397k = s4.j.a(provider4, provider5, provider6, this.f19395i, this.f19388b, provider6, u4.c.a());
        Provider<Executor> provider7 = this.f19388b;
        Provider<z> provider8 = this.f19393g;
        this.f19398l = n.a(provider7, provider8, this.f19395i, provider8);
        this.f19399m = com.google.android.datatransport.runtime.dagger.internal.a.a(n4.m.a(u4.c.a(), u4.d.a(), this.f19396j, this.f19397k, this.f19398l));
    }

    public c(Context context) {
        e(context);
    }
}
