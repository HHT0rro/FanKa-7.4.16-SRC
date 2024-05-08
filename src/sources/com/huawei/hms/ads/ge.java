package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ge {
    private static final String Code = "InterstitialGlobalDataShare";
    private static final byte[] I = new byte[0];
    private static gd V;

    public static gd Code() {
        gd gdVar;
        synchronized (I) {
            gdVar = V;
        }
        return gdVar;
    }

    public static void Code(gd gdVar) {
        synchronized (I) {
            if (gdVar == null) {
                gl.Code(Code, "set interstitial ad null");
                V = null;
            } else {
                V = gdVar;
            }
        }
    }
}
