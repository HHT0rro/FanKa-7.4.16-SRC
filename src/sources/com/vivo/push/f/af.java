package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnUnBindAppReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.i f46195a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ae f46196b;

    public af(ae aeVar, com.vivo.push.b.i iVar) {
        this.f46196b = aeVar;
        this.f46195a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ae aeVar = this.f46196b;
        PushMessageCallback pushMessageCallback = ((aa) aeVar).f46183b;
        context = aeVar.f46360a;
        pushMessageCallback.onUnBind(context, this.f46195a.i(), this.f46195a.d());
    }
}
