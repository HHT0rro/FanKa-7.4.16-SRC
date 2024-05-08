package com.vivo.push.restructure.b;

import android.content.Context;
import com.vivo.push.PushConfig;
import com.vivo.push.util.ag;

/* compiled from: PushRelyImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f46328a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushConfig f46329b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f46330c;

    public e(d dVar, Context context, PushConfig pushConfig) {
        this.f46330c = dVar;
        this.f46328a = context;
        this.f46329b = pushConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f46328a;
        ag.a(context, context.getPackageName(), this.f46329b.isAgreePrivacyStatement());
    }
}
