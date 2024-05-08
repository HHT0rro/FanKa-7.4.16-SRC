package com.tencent.liteav.base.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class w extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private int f42922a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f42923b;

    /* renamed from: c, reason: collision with root package name */
    private final a f42924c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void onTimeout();
    }

    public w(Looper looper, a aVar) {
        super(looper);
        this.f42923b = false;
        this.f42924c = aVar;
    }

    public final synchronized void a(int i10, int i11) {
        a();
        this.f42922a = i11;
        this.f42923b = true;
        sendEmptyMessageDelayed(0, i10);
    }

    @Override // android.os.Handler
    public final synchronized void handleMessage(Message message) {
        if (this.f42923b) {
            removeMessages(0);
            sendEmptyMessageDelayed(0, this.f42922a);
        }
        a aVar = this.f42924c;
        if (aVar != null) {
            aVar.onTimeout();
        }
    }

    public final synchronized void a() {
        while (hasMessages(0)) {
            removeMessages(0);
        }
        this.f42923b = false;
    }
}
