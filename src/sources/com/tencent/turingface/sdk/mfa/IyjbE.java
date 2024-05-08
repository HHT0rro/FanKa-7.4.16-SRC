package com.tencent.turingface.sdk.mfa;

import android.os.Handler;
import android.os.Message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class IyjbE implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final Handler.Callback f45607a;

    /* renamed from: b, reason: collision with root package name */
    public final Ww1Z6 f45608b;

    /* renamed from: c, reason: collision with root package name */
    public final String f45609c;

    public IyjbE(Handler.Callback callback, Ww1Z6 ww1Z6, String str) {
        this.f45607a = callback;
        this.f45608b = ww1Z6;
        this.f45609c = str;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        try {
            int i10 = message.arg2;
            int i11 = message.what;
            Ww1Z6 ww1Z6 = this.f45608b;
            if (ww1Z6 != null && i11 == 1) {
                ww1Z6.a(this.f45609c);
            }
        } catch (Throwable unused) {
        }
        Handler.Callback callback = this.f45607a;
        if (callback != null) {
            return callback.handleMessage(message);
        }
        return false;
    }
}
