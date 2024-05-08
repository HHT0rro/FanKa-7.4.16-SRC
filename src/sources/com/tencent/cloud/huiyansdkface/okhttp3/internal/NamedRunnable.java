package com.tencent.cloud.huiyansdkface.okhttp3.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class NamedRunnable implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final String f41599c;

    public NamedRunnable(String str, Object... objArr) {
        this.f41599c = Util.format(str, objArr);
    }

    public abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f41599c);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
