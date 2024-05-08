package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r3 {
    public static int a(int i10, byte[] bArr, int i11, int i12, s3 s3Var) throws zzjk {
        if ((i10 >>> 3) == 0) {
            throw zzjk.zzd();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            return k(bArr, i11, s3Var);
        }
        if (i13 == 1) {
            return i11 + 8;
        }
        if (i13 == 2) {
            return i(bArr, i11, s3Var) + s3Var.f25631a;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                return i11 + 4;
            }
            throw zzjk.zzd();
        }
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (i11 < i12) {
            i11 = i(bArr, i11, s3Var);
            i15 = s3Var.f25631a;
            if (i15 == i14) {
                break;
            }
            i11 = a(i15, bArr, i11, i12, s3Var);
        }
        if (i11 > i12 || i15 != i14) {
            throw zzjk.zzg();
        }
        return i11;
    }

    public static int b(int i10, byte[] bArr, int i11, int i12, g5<?> g5Var, s3 s3Var) {
        z4 z4Var = (z4) g5Var;
        int i13 = i(bArr, i11, s3Var);
        z4Var.f(s3Var.f25631a);
        while (i13 < i12) {
            int i14 = i(bArr, i13, s3Var);
            if (i10 != s3Var.f25631a) {
                break;
            }
            i13 = i(bArr, i14, s3Var);
            z4Var.f(s3Var.f25631a);
        }
        return i13;
    }

    public static int c(int i10, byte[] bArr, int i11, int i12, m7 m7Var, s3 s3Var) throws zzjk {
        if ((i10 >>> 3) == 0) {
            throw zzjk.zzd();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int k10 = k(bArr, i11, s3Var);
            m7Var.c(i10, Long.valueOf(s3Var.f25632b));
            return k10;
        }
        if (i13 == 1) {
            m7Var.c(i10, Long.valueOf(l(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int i14 = i(bArr, i11, s3Var);
            int i15 = s3Var.f25631a;
            if (i15 >= 0) {
                if (i15 > bArr.length - i14) {
                    throw zzjk.zza();
                }
                if (i15 == 0) {
                    m7Var.c(i10, zzht.zza);
                } else {
                    m7Var.c(i10, zzht.zza(bArr, i14, i15));
                }
                return i14 + i15;
            }
            throw zzjk.zzb();
        }
        if (i13 != 3) {
            if (i13 == 5) {
                m7Var.c(i10, Integer.valueOf(h(bArr, i11)));
                return i11 + 4;
            }
            throw zzjk.zzd();
        }
        m7 g3 = m7.g();
        int i16 = (i10 & (-8)) | 4;
        int i17 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int i18 = i(bArr, i11, s3Var);
            int i19 = s3Var.f25631a;
            i17 = i19;
            if (i19 == i16) {
                i11 = i18;
                break;
            }
            int c4 = c(i17, bArr, i18, i12, g3, s3Var);
            i17 = i19;
            i11 = c4;
        }
        if (i11 <= i12 && i17 == i16) {
            m7Var.c(i10, g3);
            return i11;
        }
        throw zzjk.zzg();
    }

    public static int d(int i10, byte[] bArr, int i11, s3 s3Var) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b4 = bArr[i11];
        if (b4 >= 0) {
            s3Var.f25631a = i12 | (b4 << 7);
            return i13;
        }
        int i14 = i12 | ((b4 & Byte.MAX_VALUE) << 7);
        int i15 = i13 + 1;
        byte b10 = bArr[i13];
        if (b10 >= 0) {
            s3Var.f25631a = i14 | (b10 << 14);
            return i15;
        }
        int i16 = i14 | ((b10 & Byte.MAX_VALUE) << 14);
        int i17 = i15 + 1;
        byte b11 = bArr[i15];
        if (b11 >= 0) {
            s3Var.f25631a = i16 | (b11 << 21);
            return i17;
        }
        int i18 = i16 | ((b11 & Byte.MAX_VALUE) << 21);
        int i19 = i17 + 1;
        byte b12 = bArr[i17];
        if (b12 >= 0) {
            s3Var.f25631a = i18 | (b12 << 28);
            return i19;
        }
        int i20 = i18 | ((b12 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                s3Var.f25631a = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    public static int e(t6<?> t6Var, int i10, byte[] bArr, int i11, int i12, g5<?> g5Var, s3 s3Var) throws IOException {
        int g3 = g(t6Var, bArr, i11, i12, s3Var);
        g5Var.add(s3Var.f25633c);
        while (g3 < i12) {
            int i13 = i(bArr, g3, s3Var);
            if (i10 != s3Var.f25631a) {
                break;
            }
            g3 = g(t6Var, bArr, i13, i12, s3Var);
            g5Var.add(s3Var.f25633c);
        }
        return g3;
    }

    public static int f(t6 t6Var, byte[] bArr, int i10, int i11, int i12, s3 s3Var) throws IOException {
        g6 g6Var = (g6) t6Var;
        Object zza = g6Var.zza();
        int m10 = g6Var.m(zza, bArr, i10, i11, i12, s3Var);
        g6Var.a(zza);
        s3Var.f25633c = zza;
        return m10;
    }

    public static int g(t6 t6Var, byte[] bArr, int i10, int i11, s3 s3Var) throws IOException {
        int i12 = i10 + 1;
        int i13 = bArr[i10];
        if (i13 < 0) {
            i12 = d(i13, bArr, i12, s3Var);
            i13 = s3Var.f25631a;
        }
        int i14 = i12;
        if (i13 >= 0 && i13 <= i11 - i14) {
            Object zza = t6Var.zza();
            int i15 = i13 + i14;
            t6Var.g(zza, bArr, i14, i15, s3Var);
            t6Var.a(zza);
            s3Var.f25633c = zza;
            return i15;
        }
        throw zzjk.zza();
    }

    public static int h(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public static int i(byte[] bArr, int i10, s3 s3Var) {
        int i11 = i10 + 1;
        byte b4 = bArr[i10];
        if (b4 >= 0) {
            s3Var.f25631a = b4;
            return i11;
        }
        return d(b4, bArr, i11, s3Var);
    }

    public static int j(byte[] bArr, int i10, g5<?> g5Var, s3 s3Var) throws IOException {
        z4 z4Var = (z4) g5Var;
        int i11 = i(bArr, i10, s3Var);
        int i12 = s3Var.f25631a + i11;
        while (i11 < i12) {
            i11 = i(bArr, i11, s3Var);
            z4Var.f(s3Var.f25631a);
        }
        if (i11 == i12) {
            return i11;
        }
        throw zzjk.zza();
    }

    public static int k(byte[] bArr, int i10, s3 s3Var) {
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        if (j10 >= 0) {
            s3Var.f25632b = j10;
            return i11;
        }
        int i12 = i11 + 1;
        byte b4 = bArr[i11];
        long j11 = (j10 & 127) | ((b4 & Byte.MAX_VALUE) << 7);
        int i13 = 7;
        while (b4 < 0) {
            int i14 = i12 + 1;
            i13 += 7;
            j11 |= (r10 & Byte.MAX_VALUE) << i13;
            b4 = bArr[i12];
            i12 = i14;
        }
        s3Var.f25632b = j11;
        return i12;
    }

    public static long l(byte[] bArr, int i10) {
        return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }

    public static double m(byte[] bArr, int i10) {
        return Double.longBitsToDouble(l(bArr, i10));
    }

    public static int n(byte[] bArr, int i10, s3 s3Var) throws zzjk {
        int i11 = i(bArr, i10, s3Var);
        int i12 = s3Var.f25631a;
        if (i12 < 0) {
            throw zzjk.zzb();
        }
        if (i12 == 0) {
            s3Var.f25633c = "";
            return i11;
        }
        s3Var.f25633c = new String(bArr, i11, i12, b5.f25436a);
        return i11 + i12;
    }

    public static float o(byte[] bArr, int i10) {
        return Float.intBitsToFloat(h(bArr, i10));
    }

    public static int p(byte[] bArr, int i10, s3 s3Var) throws zzjk {
        int i11 = i(bArr, i10, s3Var);
        int i12 = s3Var.f25631a;
        if (i12 < 0) {
            throw zzjk.zzb();
        }
        if (i12 == 0) {
            s3Var.f25633c = "";
            return i11;
        }
        s3Var.f25633c = s7.k(bArr, i11, i12);
        return i11 + i12;
    }

    public static int q(byte[] bArr, int i10, s3 s3Var) throws zzjk {
        int i11 = i(bArr, i10, s3Var);
        int i12 = s3Var.f25631a;
        if (i12 >= 0) {
            if (i12 > bArr.length - i11) {
                throw zzjk.zza();
            }
            if (i12 == 0) {
                s3Var.f25633c = zzht.zza;
                return i11;
            }
            s3Var.f25633c = zzht.zza(bArr, i11, i12);
            return i11 + i12;
        }
        throw zzjk.zzb();
    }
}
