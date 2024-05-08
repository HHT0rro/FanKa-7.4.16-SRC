package com.baidu.mobads.sdk.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class bi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f9889a;

    public bi(Runnable runnable) {
        this.f9889a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9889a.run();
    }
}
