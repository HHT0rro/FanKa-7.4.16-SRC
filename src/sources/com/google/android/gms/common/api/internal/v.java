package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.g;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f23492b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g.a f23493c;

    public v(g.a aVar, int i10) {
        this.f23493c = aVar;
        this.f23492b = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23493c.d(this.f23492b);
    }
}
