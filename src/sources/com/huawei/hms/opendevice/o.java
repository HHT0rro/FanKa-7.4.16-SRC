package com.huawei.hms.opendevice;

/* compiled from: TaskWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f30346a;

    public o(Runnable runnable) {
        this.f30346a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f30346a;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
            }
        }
    }
}
