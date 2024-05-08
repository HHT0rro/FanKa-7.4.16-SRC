package com.google.android.gms.internal.clearcut;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v {
    public static int a(int i10, byte[] bArr, int i11, int i12, w wVar) throws zzco {
        if ((i10 >>> 3) == 0) {
            throw zzco.zzbm();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            return g(bArr, i11, wVar);
        }
        if (i13 == 1) {
            return i11 + 8;
        }
        if (i13 == 2) {
            return e(bArr, i11, wVar) + wVar.f24064a;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                return i11 + 4;
            }
            throw zzco.zzbm();
        }
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (i11 < i12) {
            i11 = e(bArr, i11, wVar);
            i15 = wVar.f24064a;
            if (i15 == i14) {
                break;
            }
            i11 = a(i15, bArr, i11, i12, wVar);
        }
        if (i11 > i12 || i15 != i14) {
            throw zzco.zzbo();
        }
        return i11;
    }

    public static int b(int i10, byte[] bArr, int i11, int i12, c1<?> c1Var, w wVar) {
        y0 y0Var = (y0) c1Var;
        int e2 = e(bArr, i11, wVar);
        while (true) {
            y0Var.c(wVar.f24064a);
            if (e2 >= i12) {
                break;
            }
            int e10 = e(bArr, e2, wVar);
            if (i10 != wVar.f24064a) {
                break;
            }
            e2 = e(bArr, e10, wVar);
        }
        return e2;
    }

    public static int c(int i10, byte[] bArr, int i11, int i12, j3 j3Var, w wVar) throws IOException {
        if ((i10 >>> 3) == 0) {
            throw zzco.zzbm();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int g3 = g(bArr, i11, wVar);
            j3Var.e(i10, Long.valueOf(wVar.f24065b));
            return g3;
        }
        if (i13 == 1) {
            j3Var.e(i10, Long.valueOf(k(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int e2 = e(bArr, i11, wVar);
            int i14 = wVar.f24064a;
            j3Var.e(i10, i14 == 0 ? zzbb.zzfi : zzbb.zzb(bArr, e2, i14));
            return e2 + i14;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw zzco.zzbm();
            }
            j3Var.e(i10, Integer.valueOf(h(bArr, i11)));
            return i11 + 4;
        }
        j3 i15 = j3.i();
        int i16 = (i10 & (-8)) | 4;
        int i17 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int e10 = e(bArr, i11, wVar);
            int i18 = wVar.f24064a;
            i17 = i18;
            if (i18 == i16) {
                i11 = e10;
                break;
            }
            int c4 = c(i17, bArr, e10, i12, i15, wVar);
            i17 = i18;
            i11 = c4;
        }
        if (i11 > i12 || i17 != i16) {
            throw zzco.zzbo();
        }
        j3Var.e(i10, i15);
        return i11;
    }

    public static int d(int i10, byte[] bArr, int i11, w wVar) {
        int i12;
        int i13;
        int i14 = i10 & 127;
        int i15 = i11 + 1;
        byte b4 = bArr[i11];
        if (b4 < 0) {
            int i16 = i14 | ((b4 & Byte.MAX_VALUE) << 7);
            int i17 = i15 + 1;
            byte b10 = bArr[i15];
            if (b10 >= 0) {
                i12 = b10 << 14;
            } else {
                i14 = i16 | ((b10 & Byte.MAX_VALUE) << 14);
                i15 = i17 + 1;
                byte b11 = bArr[i17];
                if (b11 >= 0) {
                    i13 = b11 << 21;
                } else {
                    i16 = i14 | ((b11 & Byte.MAX_VALUE) << 21);
                    i17 = i15 + 1;
                    byte b12 = bArr[i15];
                    if (b12 >= 0) {
                        i12 = b12 << 28;
                    } else {
                        int i18 = i16 | ((b12 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i19 = i17 + 1;
                            if (bArr[i17] >= 0) {
                                wVar.f24064a = i18;
                                return i19;
                            }
                            i17 = i19;
                        }
                    }
                }
            }
            wVar.f24064a = i16 | i12;
            return i17;
        }
        i13 = b4 << 7;
        wVar.f24064a = i14 | i13;
        return i15;
    }

    public static int e(byte[] bArr, int i10, w wVar) {
        int i11 = i10 + 1;
        byte b4 = bArr[i10];
        if (b4 < 0) {
            return d(b4, bArr, i11, wVar);
        }
        wVar.f24064a = b4;
        return i11;
    }

    public static int f(byte[] bArr, int i10, c1<?> c1Var, w wVar) throws IOException {
        y0 y0Var = (y0) c1Var;
        int e2 = e(bArr, i10, wVar);
        int i11 = wVar.f24064a + e2;
        while (e2 < i11) {
            e2 = e(bArr, e2, wVar);
            y0Var.c(wVar.f24064a);
        }
        if (e2 == i11) {
            return e2;
        }
        throw zzco.zzbl();
    }

    public static int g(byte[] bArr, int i10, w wVar) {
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        if (j10 >= 0) {
            wVar.f24065b = j10;
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
        wVar.f24065b = j11;
        return i12;
    }

    public static int h(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public static int i(byte[] bArr, int i10, w wVar) {
        int e2 = e(bArr, i10, wVar);
        int i11 = wVar.f24064a;
        if (i11 == 0) {
            wVar.f24066c = "";
            return e2;
        }
        wVar.f24066c = new String(bArr, e2, i11, z0.f24119a);
        return e2 + i11;
    }

    public static int j(byte[] bArr, int i10, w wVar) throws IOException {
        int e2 = e(bArr, i10, wVar);
        int i11 = wVar.f24064a;
        if (i11 == 0) {
            wVar.f24066c = "";
            return e2;
        }
        int i12 = e2 + i11;
        if (!r3.i(bArr, e2, i12)) {
            throw zzco.zzbp();
        }
        wVar.f24066c = new String(bArr, e2, i11, z0.f24119a);
        return i12;
    }

    public static long k(byte[] bArr, int i10) {
        return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }

    public static double l(byte[] bArr, int i10) {
        return Double.longBitsToDouble(k(bArr, i10));
    }

    public static int m(byte[] bArr, int i10, w wVar) {
        int e2 = e(bArr, i10, wVar);
        int i11 = wVar.f24064a;
        if (i11 == 0) {
            wVar.f24066c = zzbb.zzfi;
            return e2;
        }
        wVar.f24066c = zzbb.zzb(bArr, e2, i11);
        return e2 + i11;
    }

    public static float n(byte[] bArr, int i10) {
        return Float.intBitsToFloat(h(bArr, i10));
    }
}
