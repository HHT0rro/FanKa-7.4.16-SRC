package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a0<O extends a.d> extends u0 {

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.b<O> f23409c;

    public a0(com.google.android.gms.common.api.b<O> bVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f23409c = bVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper a() {
        return this.f23409c.f();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void b(zack zackVar) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void c(zack zackVar) {
    }
}
