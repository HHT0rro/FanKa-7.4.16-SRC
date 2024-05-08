package com.jd.ad.sdk.bl.initsdk;

import com.jd.ad.sdk.bl.initsdk.JADYunSdk;

/* compiled from: JADYunSdk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo implements Runnable {
    public final /* synthetic */ int jad_an;
    public final /* synthetic */ String jad_bo;

    public jad_bo(JADYunSdk.jad_cp jad_cpVar, int i10, String str) {
        this.jad_an = i10;
        this.jad_bo = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        JADInitCallback jADInitCallback;
        JADInitCallback jADInitCallback2;
        jADInitCallback = JADYunSdk.mInitCallback;
        if (jADInitCallback != null) {
            jADInitCallback2 = JADYunSdk.mInitCallback;
            jADInitCallback2.onInitFailure(this.jad_an, this.jad_bo);
        }
    }
}
