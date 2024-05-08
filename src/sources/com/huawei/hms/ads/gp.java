package com.huawei.hms.ads;

import androidx.exifinterface.media.ExifInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class gp {
    public static final int Code = 3;
    public static final int I = 5;
    public static final int V = 4;
    public static final int Z = 6;

    public static String Code(int i10) {
        return i10 != 3 ? i10 != 4 ? i10 != 5 ? i10 != 6 ? String.valueOf(i10) : ExifInterface.LONGITUDE_EAST : "W" : "I" : "D";
    }
}
