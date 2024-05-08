package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f4731a;

    public f(e eVar) {
        this.f4731a = eVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        Object obj2;
        obj = this.f4731a.f4725e;
        synchronized (obj) {
            this.f4731a.f4724d = IAlixPay.Stub.asInterface(iBinder);
            obj2 = this.f4731a.f4725e;
            obj2.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f4731a.f4724d = null;
    }
}
