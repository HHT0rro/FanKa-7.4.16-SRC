package com.tencent.liteav.base.util;

import android.os.MessageQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CustomHandler f42880a;

    /* renamed from: b, reason: collision with root package name */
    private final MessageQueue.IdleHandler f42881b;

    private e(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        this.f42880a = customHandler;
        this.f42881b = idleHandler;
    }

    public static Runnable a(CustomHandler customHandler, MessageQueue.IdleHandler idleHandler) {
        return new e(customHandler, idleHandler);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CustomHandler.lambda$quitLooper$3(this.f42880a, this.f42881b);
    }
}
