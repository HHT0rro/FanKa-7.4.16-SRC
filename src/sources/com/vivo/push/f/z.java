package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnPublishReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.r f46223a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f46224b;

    public z(y yVar, com.vivo.push.b.r rVar) {
        this.f46224b = yVar;
        this.f46223a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        y yVar = this.f46224b;
        PushMessageCallback pushMessageCallback = ((aa) yVar).f46183b;
        context = yVar.f46360a;
        pushMessageCallback.onPublish(context, this.f46223a.i(), this.f46223a.h());
    }
}
