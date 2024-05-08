package com.vivo.push.restructure.a.a;

import com.vivo.push.PushClient;

/* compiled from: DispatchNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f46305a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f46306b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f46307c;

    public f(e eVar, int i10, String str) {
        this.f46307c = eVar;
        this.f46305a = i10;
        this.f46306b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f46305a;
        if (i10 == 3) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).unBindAlias(this.f46306b, null);
        } else if (i10 == 4) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).delTopic(this.f46306b, null);
        }
    }
}
