package com.google.android.gms.internal.vision;

import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u7 {
    public static void f(byte b4, byte b10, byte b11, byte b12, char[] cArr, int i10) throws zzjk {
        if (!o(b10) && (((b4 << 28) + (b10 + 112)) >> 30) == 0 && !o(b11) && !o(b12)) {
            int i11 = ((b4 & 7) << 18) | ((b10 & Utf8.REPLACEMENT_BYTE) << 12) | ((b11 & Utf8.REPLACEMENT_BYTE) << 6) | (b12 & Utf8.REPLACEMENT_BYTE);
            cArr[i10] = (char) ((i11 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
            cArr[i10 + 1] = (char) ((i11 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            return;
        }
        throw zzjk.zzh();
    }

    public static void g(byte b4, byte b10, byte b11, char[] cArr, int i10) throws zzjk {
        if (!o(b10) && ((b4 != -32 || b10 >= -96) && ((b4 != -19 || b10 < -96) && !o(b11)))) {
            cArr[i10] = (char) (((b4 & 15) << 12) | ((b10 & Utf8.REPLACEMENT_BYTE) << 6) | (b11 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw zzjk.zzh();
    }

    public static void h(byte b4, byte b10, char[] cArr, int i10) throws zzjk {
        if (b4 >= -62 && !o(b10)) {
            cArr[i10] = (char) (((b4 & 31) << 6) | (b10 & Utf8.REPLACEMENT_BYTE));
            return;
        }
        throw zzjk.zzh();
    }

    public static void i(byte b4, char[] cArr, int i10) {
        cArr[i10] = (char) b4;
    }

    public static boolean l(byte b4) {
        return b4 >= 0;
    }

    public static boolean m(byte b4) {
        return b4 < -32;
    }

    public static boolean n(byte b4) {
        return b4 < -16;
    }

    public static boolean o(byte b4) {
        return b4 > -65;
    }
}
