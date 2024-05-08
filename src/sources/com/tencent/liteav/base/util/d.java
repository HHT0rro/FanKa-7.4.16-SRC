package com.tencent.liteav.base.util;

import android.os.MessageQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class d implements MessageQueue.IdleHandler {

    /* renamed from: a, reason: collision with root package name */
    private final CustomHandler f42879a;

    private d(CustomHandler customHandler) {
        this.f42879a = customHandler;
    }

    public static MessageQueue.IdleHandler a(CustomHandler customHandler) {
        return new d(customHandler);
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        return CustomHandler.lambda$quitLooper$2(this.f42879a);
    }
}
