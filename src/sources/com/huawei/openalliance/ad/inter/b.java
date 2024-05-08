package com.huawei.openalliance.ad.inter;

import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    private static final String Code = "AdATManager";
    private static b I;
    private static final byte[] V = new byte[0];
    private String B;
    private r Z;

    private b() {
    }

    public static b Code() {
        b bVar;
        synchronized (V) {
            if (I == null) {
                I = new b();
            }
            bVar = I;
        }
        return bVar;
    }

    public void Code(r rVar) {
        this.Z = rVar;
    }

    public void Code(String str) {
        this.B = str;
    }

    public String I() {
        return this.B;
    }

    public String V() {
        r rVar = this.Z;
        if (rVar != null) {
            return rVar.Code();
        }
        gl.V(Code, "accessTokenProvider is null, return");
        return null;
    }
}
