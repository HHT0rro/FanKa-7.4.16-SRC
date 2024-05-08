package com.vivo.push.util;

import java.util.concurrent.ThreadFactory;

/* compiled from: ConcurrentUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class h implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46424a;

    public h(String str) {
        this.f46424a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(this.f46424a);
        thread.setDaemon(true);
        return thread;
    }
}
