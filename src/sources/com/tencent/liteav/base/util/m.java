package com.tencent.liteav.base.util;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class m implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final String f42902a;

    private m(String str) {
        this.f42902a = str;
    }

    public static ThreadFactory a(String str) {
        return new m(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f42902a);
    }
}
