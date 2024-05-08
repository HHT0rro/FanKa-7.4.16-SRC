package com.amap.api.col.p0003l;

/* compiled from: GeoUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class lb {
    public static double a(double d10, double d11, double d12, double d13) {
        double d14 = (((90.0d - d11) * 21412.0d) / 90.0d) + 6356725.0d;
        double cos = ((d12 * 0.01745329238474369d) - (d10 * 0.01745329238474369d)) * Math.cos((3.1415927410125732d * d11) / 180.0d) * d14;
        double d15 = ((d13 * 0.01745329238474369d) - (d11 * 0.01745329238474369d)) * d14;
        return Math.pow((cos * cos) + (d15 * d15), 0.5d);
    }
}
