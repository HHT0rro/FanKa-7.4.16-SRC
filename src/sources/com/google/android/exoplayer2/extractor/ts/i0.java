package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: TsUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i0 {
    public static int a(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && bArr[i10] != 71) {
            i10++;
        }
        return i10;
    }

    public static boolean b(byte[] bArr, int i10, int i11, int i12) {
        int i13 = 0;
        for (int i14 = -4; i14 <= 4; i14++) {
            int i15 = (i14 * 188) + i12;
            if (i15 < i10 || i15 >= i11 || bArr[i15] != 71) {
                i13 = 0;
            } else {
                i13++;
                if (i13 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(ParsableByteArray parsableByteArray, int i10, int i11) {
        parsableByteArray.P(i10);
        if (parsableByteArray.a() < 5) {
            return -9223372036854775807L;
        }
        int n10 = parsableByteArray.n();
        if ((8388608 & n10) != 0 || ((2096896 & n10) >> 8) != i11) {
            return -9223372036854775807L;
        }
        if (((n10 & 32) != 0) && parsableByteArray.D() >= 7 && parsableByteArray.a() >= 7) {
            if ((parsableByteArray.D() & 16) == 16) {
                byte[] bArr = new byte[6];
                parsableByteArray.j(bArr, 0, 6);
                return d(bArr);
            }
        }
        return -9223372036854775807L;
    }

    public static long d(byte[] bArr) {
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((255 & bArr[4]) >> 7);
    }
}
