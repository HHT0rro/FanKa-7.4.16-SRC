package com.ss.android.downloadlib.hc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class sy extends Handler {

    /* renamed from: m, reason: collision with root package name */
    public WeakReference<m> f38780m;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface m {
        void m(Message message);
    }

    public sy(Looper looper, m mVar) {
        super(looper);
        this.f38780m = new WeakReference<>(mVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        m mVar = this.f38780m.get();
        if (mVar == null || message == null) {
            return;
        }
        mVar.m(message);
    }
}
