package com.jd.ad.sdk.jad_re;

/* compiled from: MultiProcessManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        synchronized (jad_an.class) {
            jad_an.jad_an(jad_an.jad_an);
        }
        synchronized (jad_an.class) {
            jad_an.jad_an(jad_an.jad_bo);
        }
    }
}
