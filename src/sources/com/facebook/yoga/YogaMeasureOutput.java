package com.facebook.yoga;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class YogaMeasureOutput {
    public static long a(float f10, float f11) {
        return Float.floatToRawIntBits(f11) | (Float.floatToRawIntBits(f10) << 32);
    }

    public static long b(int i10, int i11) {
        return a(i10, i11);
    }
}
