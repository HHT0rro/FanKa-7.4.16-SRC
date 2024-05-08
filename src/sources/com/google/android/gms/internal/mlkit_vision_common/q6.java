package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q6 {

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public static zzp<String> f24583j;

    /* renamed from: a, reason: collision with root package name */
    public final String f24584a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24585b;

    /* renamed from: c, reason: collision with root package name */
    public final p6 f24586c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.mlkit.common.sdkinternal.m f24587d;

    /* renamed from: e, reason: collision with root package name */
    public final p7.f<String> f24588e;

    /* renamed from: f, reason: collision with root package name */
    public final p7.f<String> f24589f;

    /* renamed from: g, reason: collision with root package name */
    public final String f24590g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<zzfp, Long> f24591h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final Map<zzfp, Object> f24592i = new HashMap();

    @VisibleForTesting
    public q6(Context context, com.google.mlkit.common.sdkinternal.m mVar, p6 p6Var, final String str) {
        this.f24584a = context.getPackageName();
        this.f24585b = com.google.mlkit.common.sdkinternal.c.a(context);
        this.f24587d = mVar;
        this.f24586c = p6Var;
        this.f24590g = str;
        this.f24588e = com.google.mlkit.common.sdkinternal.g.a().b(new Callable(str) { // from class: com.google.android.gms.internal.mlkit_vision_common.l6

            /* renamed from: b, reason: collision with root package name */
            public final String f24446b;

            {
                this.f24446b = str;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return com.google.android.gms.common.internal.f.a().b(this.f24446b);
            }
        });
        com.google.mlkit.common.sdkinternal.g a10 = com.google.mlkit.common.sdkinternal.g.a();
        mVar.getClass();
        this.f24589f = a10.b(m6.a(mVar));
    }

    @NonNull
    public static synchronized zzp<String> c() {
        synchronized (q6.class) {
            zzp<String> zzpVar = f24583j;
            if (zzpVar != null) {
                return zzpVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            i7 i7Var = new i7();
            for (int i10 = 0; i10 < locales.size(); i10++) {
                i7Var.c(com.google.mlkit.common.sdkinternal.c.b(locales.get(i10)));
            }
            zzp<String> d10 = i7Var.d();
            f24583j = d10;
            return d10;
        }
    }

    @WorkerThread
    public final void a(o6 o6Var, final zzfp zzfpVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f24591h.get(zzfpVar) != null && elapsedRealtime - this.f24591h.get(zzfpVar).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.f24591h.put(zzfpVar, Long.valueOf(elapsedRealtime));
        final r6 zza = o6Var.zza();
        final byte[] bArr = null;
        com.google.mlkit.common.sdkinternal.g.d().execute(new Runnable(this, zza, zzfpVar, bArr) { // from class: com.google.android.gms.internal.mlkit_vision_common.n6

            /* renamed from: b, reason: collision with root package name */
            public final q6 f24500b;

            /* renamed from: c, reason: collision with root package name */
            public final zzfp f24501c;

            /* renamed from: d, reason: collision with root package name */
            public final r6 f24502d;

            {
                this.f24500b = this;
                this.f24502d = zza;
                this.f24501c = zzfpVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f24500b.b(this.f24502d, this.f24501c);
            }
        });
    }

    public final /* synthetic */ void b(r6 r6Var, zzfp zzfpVar) {
        r6Var.e(zzfpVar);
        String b4 = r6Var.b();
        z5 z5Var = new z5();
        z5Var.a(this.f24584a);
        z5Var.b(this.f24585b);
        z5Var.e(c());
        z5Var.h(Boolean.TRUE);
        z5Var.d(b4);
        z5Var.c(this.f24588e.i() ? this.f24588e.f() : com.google.android.gms.common.internal.f.a().b(this.f24590g));
        z5Var.f(this.f24589f.i() ? this.f24589f.f() : this.f24587d.a());
        z5Var.j(10);
        r6Var.d(z5Var);
        this.f24586c.a(r6Var);
    }
}
