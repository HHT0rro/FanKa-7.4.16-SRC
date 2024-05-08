package com.google.android.gms.internal.vision;

import com.android.internal.os.PowerProfile;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s7 {

    /* renamed from: a, reason: collision with root package name */
    public static final t7 f25638a;

    static {
        t7 v7Var;
        if ((p7.m() && p7.r()) && !o3.b()) {
            v7Var = new x7();
        } else {
            v7Var = new v7();
        }
        f25638a = v7Var;
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                int length2 = charSequence.length();
                while (i11 < length2) {
                    char charAt2 = charSequence.charAt(i11);
                    if (charAt2 < 2048) {
                        i10 += (127 - charAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i11) < 65536) {
                                throw new zzmg(i11, length2);
                            }
                            i11++;
                        }
                    }
                    i11++;
                }
                i12 += i10;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        long j10 = i12 + PowerProfile.SUBSYSTEM_MODEM;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int e(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        return f25638a.b(charSequence, bArr, i10, i11);
    }

    public static boolean f(byte[] bArr) {
        return f25638a.c(bArr, 0, bArr.length);
    }

    public static boolean g(byte[] bArr, int i10, int i11) {
        return f25638a.c(bArr, i10, i11);
    }

    public static int h(int i10) {
        if (i10 > -12) {
            return -1;
        }
        return i10;
    }

    public static int i(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    public static int j(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    public static String k(byte[] bArr, int i10, int i11) throws zzjk {
        return f25638a.d(bArr, i10, i11);
    }

    public static int m(byte[] bArr, int i10, int i11) {
        byte b4 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            return h(b4);
        }
        if (i12 == 1) {
            return i(b4, bArr[i10]);
        }
        if (i12 == 2) {
            return j(b4, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }
}
