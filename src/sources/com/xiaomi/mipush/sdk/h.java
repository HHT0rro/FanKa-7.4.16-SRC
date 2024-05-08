package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.mipush.sdk.MiPushClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f47002b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f47003c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f47004d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ MiPushClient.ICallbackResult f47005e;

    public h(String str, String str2, String str3, MiPushClient.ICallbackResult iCallbackResult) {
        this.f47002b = str;
        this.f47003c = str2;
        this.f47004d = str3;
        this.f47005e = iCallbackResult;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = MiPushClient.f46947b;
        MiPushClient.F(context, this.f47002b, this.f47003c, null, this.f47004d, this.f47005e);
    }
}
