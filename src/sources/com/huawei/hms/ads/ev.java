package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ev {
    private static final byte[] I = new byte[0];
    private static com.huawei.openalliance.ad.inter.data.i V;

    public static com.huawei.openalliance.ad.inter.data.i Code() {
        com.huawei.openalliance.ad.inter.data.i iVar;
        synchronized (I) {
            iVar = V;
        }
        return iVar;
    }

    public static void Code(com.huawei.openalliance.ad.inter.data.i iVar) {
        synchronized (I) {
            if (iVar == null) {
                gl.Code("GlobalDataShare", "set reward ad null");
                V = null;
            } else {
                V = iVar;
            }
        }
    }
}
