package com.jd.ad.sdk.jad_ve;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_bo {
    public static float jad_an(float f10) {
        return f10 <= 0.04045f ? f10 / 12.92f : (float) Math.pow((f10 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int jad_an(float f10, int i10, int i11) {
        if (i10 == i11) {
            return i10;
        }
        float f11 = ((i10 >> 24) & 255) / 255.0f;
        float f12 = ((i11 >> 24) & 255) / 255.0f;
        float jad_an = jad_an(((i10 >> 16) & 255) / 255.0f);
        float jad_an2 = jad_an(((i10 >> 8) & 255) / 255.0f);
        float jad_an3 = jad_an((i10 & 255) / 255.0f);
        float jad_an4 = jad_an(((i11 >> 16) & 255) / 255.0f);
        float jad_an5 = ((jad_an(((i11 >> 8) & 255) / 255.0f) - jad_an2) * f10) + jad_an2;
        float jad_an6 = ((jad_an((i11 & 255) / 255.0f) - jad_an3) * f10) + jad_an3;
        float f13 = (((f12 - f11) * f10) + f11) * 255.0f;
        return (Math.round(jad_bo(((jad_an4 - jad_an) * f10) + jad_an) * 255.0f) << 16) | (Math.round(f13) << 24) | (Math.round(jad_bo(jad_an5) * 255.0f) << 8) | Math.round(jad_bo(jad_an6) * 255.0f);
    }

    public static float jad_bo(float f10) {
        return f10 <= 0.0031308f ? f10 * 12.92f : (float) ((Math.pow(f10, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }
}
