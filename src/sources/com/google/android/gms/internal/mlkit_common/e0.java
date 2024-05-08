package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f24164a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24165b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f24166c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.mlkit.common.sdkinternal.m f24167d;

    /* renamed from: e, reason: collision with root package name */
    public final p7.f<String> f24168e;

    /* renamed from: f, reason: collision with root package name */
    public final p7.f<String> f24169f;

    /* renamed from: g, reason: collision with root package name */
    public final String f24170g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<zzgr, Long> f24171h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final Map<zzgr, Object> f24172i = new HashMap();

    @VisibleForTesting
    public e0(Context context, com.google.mlkit.common.sdkinternal.m mVar, d0 d0Var, final String str) {
        this.f24164a = context.getPackageName();
        this.f24165b = com.google.mlkit.common.sdkinternal.c.a(context);
        this.f24167d = mVar;
        this.f24166c = d0Var;
        this.f24170g = str;
        this.f24168e = com.google.mlkit.common.sdkinternal.g.a().b(new Callable(str) { // from class: com.google.android.gms.internal.mlkit_common.b0

            /* renamed from: b, reason: collision with root package name */
            public final String f24160b;

            {
                this.f24160b = str;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return com.google.android.gms.common.internal.f.a().b(this.f24160b);
            }
        });
        com.google.mlkit.common.sdkinternal.g a10 = com.google.mlkit.common.sdkinternal.g.a();
        mVar.getClass();
        this.f24169f = a10.b(c0.a(mVar));
    }
}
