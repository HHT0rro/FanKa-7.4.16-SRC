package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hd {
    private static final String Code = "hd";

    public static hc Code(int i10, lo loVar) {
        gl.V(Code, "create ad mediator: %s", Integer.valueOf(i10));
        return (i10 == 2 || i10 == 3) ? new hf(loVar) : new he(loVar);
    }
}
