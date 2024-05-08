package com.kwad.sdk.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
abstract class n implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            doTask();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
