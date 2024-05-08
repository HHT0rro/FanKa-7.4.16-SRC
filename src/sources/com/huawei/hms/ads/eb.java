package com.huawei.hms.ads;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class eb {
    private static volatile em Code;
    private static final byte[] V = new byte[0];

    public static em Code(Context context) {
        if (Code == null) {
            synchronized (V) {
                if (Code == null) {
                    Code = ea.Z(context) ? eh.Code(context) : ej.Code(context);
                }
            }
        }
        return Code;
    }
}
