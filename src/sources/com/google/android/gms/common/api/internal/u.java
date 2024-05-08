package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u implements c.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f23490a;

    public u(g gVar) {
        this.f23490a = gVar;
    }

    @Override // com.google.android.gms.common.api.internal.c.a
    public final void a(boolean z10) {
        this.f23490a.f23443m.sendMessage(this.f23490a.f23443m.obtainMessage(1, Boolean.valueOf(z10)));
    }
}
