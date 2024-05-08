package com.tencent.cloud.huiyansdkface.facelight.common;

import java.util.concurrent.ThreadFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbThreadFactory implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private String f40701a;

    public WbThreadFactory(String str) {
        this.f40701a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f40701a);
    }
}
