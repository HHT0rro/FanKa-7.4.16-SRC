package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference<i> f27050b = new AtomicReference<>();

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public z7.k f27051a;

    @RecentlyNonNull
    public static i c() {
        i iVar = f27050b.get();
        com.google.android.gms.common.internal.h.k(iVar != null, "MlKitContext has not been initialized");
        return iVar;
    }

    @RecentlyNonNull
    public static i d(@RecentlyNonNull Context context) {
        i iVar = new i();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        z7.k kVar = new z7.k(p7.h.f52912a, z7.e.b(context, MlKitComponentDiscoveryService.class).a(), z7.c.l(context, Context.class, new Class[0]), z7.c.l(iVar, i.class, new Class[0]));
        iVar.f27051a = kVar;
        kVar.d(true);
        com.google.android.gms.common.internal.h.k(f27050b.getAndSet(iVar) == null, "MlKitContext is already initialized");
        return iVar;
    }

    @RecentlyNonNull
    public <T> T a(@RecentlyNonNull Class<T> cls) {
        com.google.android.gms.common.internal.h.k(f27050b.get() == this, "MlKitContext has been deleted");
        com.google.android.gms.common.internal.h.h(this.f27051a);
        return (T) this.f27051a.get(cls);
    }

    @RecentlyNonNull
    public Context b() {
        return (Context) a(Context.class);
    }
}
