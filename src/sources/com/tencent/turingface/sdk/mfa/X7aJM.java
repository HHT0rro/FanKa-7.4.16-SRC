package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import com.tencent.turingface.sdk.mfa.vqARY;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class X7aJM extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vqARY.spXPg f45720a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f45721b;

    public X7aJM(vqARY.spXPg spxpg, Context context) {
        this.f45720a = spxpg;
        this.f45721b = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        this.f45720a.f45983a.a(this.f45721b);
    }
}
