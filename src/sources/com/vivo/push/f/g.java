package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotifyOpenClientClickTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f46200a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f46201b;

    public g(e eVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f46201b = eVar;
        this.f46200a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        e eVar = this.f46201b;
        PushMessageCallback pushMessageCallback = ((aa) eVar).f46183b;
        context = eVar.f46360a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f46200a);
    }
}
