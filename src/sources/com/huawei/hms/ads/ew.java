package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ew {
    private static final byte[] I = new byte[0];
    private static com.huawei.openalliance.ad.inter.data.n V;

    public static com.huawei.openalliance.ad.inter.data.n Code() {
        com.huawei.openalliance.ad.inter.data.n nVar;
        synchronized (I) {
            nVar = V;
        }
        return nVar;
    }

    public static void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        synchronized (I) {
            if (nVar == null) {
                gl.Code("GlobalDataShare", "set native ad null");
                V = null;
            } else {
                V = nVar;
            }
        }
    }
}
