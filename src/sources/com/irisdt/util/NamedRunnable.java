package com.irisdt.util;

import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class NamedRunnable implements Runnable {
    private volatile String name;

    public NamedRunnable(String str) {
        this.name = str;
    }

    public abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        Thread currentThread = Thread.currentThread();
        if (currentThread != Looper.getMainLooper().getThread()) {
            currentThread.setName(this.name);
        }
        execute();
    }
}
