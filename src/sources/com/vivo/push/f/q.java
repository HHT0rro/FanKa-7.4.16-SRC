package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnListTagReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.m f46215a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f46216b;

    public q(p pVar, com.vivo.push.b.m mVar) {
        this.f46216b = pVar;
        this.f46215a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f46216b;
        PushMessageCallback pushMessageCallback = ((aa) pVar).f46183b;
        context = pVar.f46360a;
        pushMessageCallback.onListTags(context, this.f46215a.i(), this.f46215a.d(), this.f46215a.h());
    }
}
