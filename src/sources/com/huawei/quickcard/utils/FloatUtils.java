package com.huawei.quickcard.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FloatUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final float f34268a = 1.0E-5f;

    public static boolean equals(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) && Float.isNaN(f11) : Math.abs(f10 - f11) < 1.0E-5f;
    }

    public static boolean isNaN(float f10) {
        return Float.isNaN(f10) || Float.isInfinite(f10);
    }

    public static float parse(String str, float f10) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f10;
        }
    }
}
