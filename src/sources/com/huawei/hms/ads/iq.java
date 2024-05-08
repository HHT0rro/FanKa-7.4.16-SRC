package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class iq {
    public static final int B = 100;
    public static final int Code = 0;
    public static final int I = 50;
    public static final int V = 25;
    public static final int Z = 75;

    public static int Code(float f10, float f11) {
        if (f11 >= 75.0f && f10 < 75.0f) {
            return 75;
        }
        if (f11 < 50.0f || f10 >= 50.0f) {
            return (f11 < 25.0f || f10 >= 25.0f) ? 0 : 25;
        }
        return 50;
    }
}
