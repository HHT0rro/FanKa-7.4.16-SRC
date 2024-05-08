package com.vivo.push.f;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnBindAppReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46202a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.i f46203b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f46204c;

    public i(h hVar, String str, com.vivo.push.b.i iVar) {
        this.f46204c = hVar;
        this.f46202a = str;
        this.f46203b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f46202a)) {
            h hVar = this.f46204c;
            PushMessageCallback pushMessageCallback = ((aa) hVar).f46183b;
            context2 = hVar.f46360a;
            pushMessageCallback.onReceiveRegId(context2, this.f46202a);
        }
        h hVar2 = this.f46204c;
        PushMessageCallback pushMessageCallback2 = ((aa) hVar2).f46183b;
        context = hVar2.f46360a;
        pushMessageCallback2.onBind(context, this.f46203b.i(), this.f46203b.d());
    }
}
