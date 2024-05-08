package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnLogReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.n f46217a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f46218b;

    public s(r rVar, com.vivo.push.b.n nVar) {
        this.f46218b = rVar;
        this.f46217a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        r rVar = this.f46218b;
        PushMessageCallback pushMessageCallback = ((aa) rVar).f46183b;
        context = rVar.f46360a;
        pushMessageCallback.onLog(context, this.f46217a.d(), this.f46217a.e(), this.f46217a.f());
    }
}
