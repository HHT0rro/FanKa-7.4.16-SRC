package com.alibaba.security.common.http.ok.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class NamedRunnable implements Runnable {
    public final String name;

    public NamedRunnable(String str, Object... objArr) {
        this.name = Util.format(str, objArr);
    }

    public abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
