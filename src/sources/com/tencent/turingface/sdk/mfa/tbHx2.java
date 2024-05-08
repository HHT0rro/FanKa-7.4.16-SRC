package com.tencent.turingface.sdk.mfa;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class tbHx2 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public boolean f45949a = false;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f45950b = new LinkedBlockingQueue<>(1);

    public final IBinder a() throws InterruptedException {
        if (!this.f45949a) {
            this.f45949a = true;
            return this.f45950b.take();
        }
        throw new IllegalStateException();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f45950b.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
