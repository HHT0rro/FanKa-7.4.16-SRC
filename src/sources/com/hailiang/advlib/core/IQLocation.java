package com.hailiang.advlib.core;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IQLocation {
    public static final int TYPE_BAIDU = 2;
    public static final int TYPE_CGJ02 = 0;
    public static final int TYPE_WGS84 = 1;

    double getLatitude();

    double getLongitude();

    int getType();
}
