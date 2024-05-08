package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w8 {

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public static zzbl<String> f25285j;

    /* renamed from: a, reason: collision with root package name */
    public final String f25286a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25287b;

    /* renamed from: c, reason: collision with root package name */
    public final v8 f25288c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.mlkit.common.sdkinternal.m f25289d;

    /* renamed from: e, reason: collision with root package name */
    public final p7.f<String> f25290e;

    /* renamed from: f, reason: collision with root package name */
    public final p7.f<String> f25291f;

    /* renamed from: g, reason: collision with root package name */
    public final String f25292g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<zzio, Long> f25293h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final Map<zzio, f0<Object, Long>> f25294i = new HashMap();

    @VisibleForTesting
    public w8(Context context, com.google.mlkit.common.sdkinternal.m mVar, v8 v8Var, final String str) {
        this.f25286a = context.getPackageName();
        this.f25287b = com.google.mlkit.common.sdkinternal.c.a(context);
        this.f25289d = mVar;
        this.f25288c = v8Var;
        this.f25292g = str;
        this.f25290e = com.google.mlkit.common.sdkinternal.g.a().b(new Callable(str) { // from class: com.google.android.gms.internal.mlkit_vision_face.q8

            /* renamed from: b, reason: collision with root package name */
            public final String f25162b;

            {
                this.f25162b = str;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return com.google.android.gms.common.internal.f.a().b(this.f25162b);
            }
        });
        com.google.mlkit.common.sdkinternal.g a10 = com.google.mlkit.common.sdkinternal.g.a();
        mVar.getClass();
        this.f25291f = a10.b(r8.a(mVar));
    }

    @VisibleForTesting
    public static long c(List<Long> list, double d10) {
        return list.get(Math.max(((int) Math.ceil((d10 / 100.0d) * list.size())) - 1, 0)).longValue();
    }

    @NonNull
    public static synchronized zzbl<String> g() {
        synchronized (w8.class) {
            zzbl<String> zzblVar = f25285j;
            if (zzblVar != null) {
                return zzblVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            b0 b0Var = new b0();
            for (int i10 = 0; i10 < locales.size(); i10++) {
                b0Var.c(com.google.mlkit.common.sdkinternal.c.b(locales.get(i10)));
            }
            zzbl<String> d10 = b0Var.d();
            f25285j = d10;
            return d10;
        }
    }

    @WorkerThread
    public final void a(u8 u8Var, zzio zzioVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f(zzioVar, elapsedRealtime, 30L)) {
            this.f25293h.put(zzioVar, Long.valueOf(elapsedRealtime));
            d(u8Var.zza(), zzioVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final <K> void b(K k10, long j10, zzio zzioVar, t8<K> t8Var) {
        if (!this.f25294i.containsKey(zzioVar)) {
            this.f25294i.put(zzioVar, zzar.zzr());
        }
        f0<Object, Long> f0Var = this.f25294i.get(zzioVar);
        f0Var.zzd(k10, Long.valueOf(j10));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f(zzioVar, elapsedRealtime, 30L)) {
            this.f25293h.put(zzioVar, Long.valueOf(elapsedRealtime));
            for (Object obj : f0Var.zzp()) {
                List<Long> zzb = f0Var.zzb(obj);
                Collections.sort(zzb);
                h6 h6Var = new h6();
                Iterator<Long> iterator2 = zzb.iterator2();
                long j11 = 0;
                while (iterator2.hasNext()) {
                    j11 += iterator2.next().longValue();
                }
                h6Var.c(Long.valueOf(j11 / zzb.size()));
                h6Var.a(Long.valueOf(c(zzb, 100.0d)));
                h6Var.f(Long.valueOf(c(zzb, 75.0d)));
                h6Var.e(Long.valueOf(c(zzb, 50.0d)));
                h6Var.d(Long.valueOf(c(zzb, 25.0d)));
                h6Var.b(Long.valueOf(c(zzb, ShadowDrawableWrapper.COS_45)));
                d(t8Var.a(obj, f0Var.zzb(obj).size(), h6Var.g()), zzioVar);
            }
            this.f25294i.remove(zzioVar);
        }
    }

    public final void d(final x8 x8Var, final zzio zzioVar) {
        final byte[] bArr = null;
        com.google.mlkit.common.sdkinternal.g.d().execute(new Runnable(this, x8Var, zzioVar, bArr) { // from class: com.google.android.gms.internal.mlkit_vision_face.s8

            /* renamed from: b, reason: collision with root package name */
            public final w8 f25205b;

            /* renamed from: c, reason: collision with root package name */
            public final zzio f25206c;

            /* renamed from: d, reason: collision with root package name */
            public final x8 f25207d;

            {
                this.f25205b = this;
                this.f25207d = x8Var;
                this.f25206c = zzioVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f25205b.e(this.f25207d, this.f25206c);
            }
        });
    }

    public final /* synthetic */ void e(x8 x8Var, zzio zzioVar) {
        x8Var.e(zzioVar);
        String b4 = x8Var.b();
        f8 f8Var = new f8();
        f8Var.a(this.f25286a);
        f8Var.b(this.f25287b);
        f8Var.e(g());
        f8Var.h(Boolean.TRUE);
        f8Var.d(b4);
        f8Var.c(this.f25290e.i() ? this.f25290e.f() : com.google.android.gms.common.internal.f.a().b(this.f25292g));
        f8Var.f(this.f25291f.i() ? this.f25291f.f() : this.f25289d.a());
        f8Var.j(10);
        x8Var.d(f8Var);
        this.f25288c.a(x8Var);
    }

    @WorkerThread
    public final boolean f(zzio zzioVar, long j10, long j11) {
        return this.f25293h.get(zzioVar) == null || j10 - this.f25293h.get(zzioVar).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }
}
