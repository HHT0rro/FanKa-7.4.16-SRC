package com.baidu.mobads.sdk.internal;

import java.lang.Thread;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class be implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bd f9870a;

    public be(bd bdVar) {
        this.f9870a = bdVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        aw.h("ThreadPoolFactory").c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
