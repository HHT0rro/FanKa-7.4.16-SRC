package n;

/* compiled from: GammaEvaluator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {
    public static float a(float f10) {
        return f10 <= 0.04045f ? f10 / 12.92f : (float) Math.pow((f10 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float b(float f10) {
        return f10 <= 0.0031308f ? f10 * 12.92f : (float) ((Math.pow(f10, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f10, int i10, int i11) {
        if (i10 == i11) {
            return i10;
        }
        float f11 = ((i10 >> 24) & 255) / 255.0f;
        float a10 = a(((i10 >> 16) & 255) / 255.0f);
        float a11 = a(((i10 >> 8) & 255) / 255.0f);
        float a12 = a((i10 & 255) / 255.0f);
        float a13 = a(((i11 >> 16) & 255) / 255.0f);
        float f12 = f11 + (((((i11 >> 24) & 255) / 255.0f) - f11) * f10);
        float a14 = a11 + ((a(((i11 >> 8) & 255) / 255.0f) - a11) * f10);
        float a15 = a12 + (f10 * (a((i11 & 255) / 255.0f) - a12));
        return (Math.round(b(a10 + ((a13 - a10) * f10)) * 255.0f) << 16) | (Math.round(f12 * 255.0f) << 24) | (Math.round(b(a14) * 255.0f) << 8) | Math.round(b(a15) * 255.0f);
    }
}
