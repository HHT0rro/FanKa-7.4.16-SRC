package com.ss.android.socialbase.appdownloader.n.m;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {
    private int[] dk;

    /* renamed from: m, reason: collision with root package name */
    private int[] f38943m;

    private n() {
    }

    public static n m(l lVar) throws IOException {
        dk.m(lVar, 1835009);
        int dk = lVar.dk();
        int dk2 = lVar.dk();
        int dk3 = lVar.dk();
        lVar.dk();
        int dk4 = lVar.dk();
        int dk5 = lVar.dk();
        n nVar = new n();
        nVar.f38943m = lVar.dk(dk2);
        if (dk3 != 0) {
            lVar.dk(dk3);
        }
        int i10 = (dk5 == 0 ? dk : dk5) - dk4;
        if (i10 % 4 == 0) {
            nVar.dk = lVar.dk(i10 / 4);
            if (dk5 != 0) {
                int i11 = dk - dk5;
                if (i11 % 4 == 0) {
                    lVar.dk(i11 / 4);
                } else {
                    throw new IOException("Style data size is not multiple of 4 (" + i11 + ").");
                }
            }
            return nVar;
        }
        throw new IOException("String data size is not multiple of 4 (" + i10 + ").");
    }

    public String m(int i10) {
        int[] iArr;
        if (i10 < 0 || (iArr = this.f38943m) == null || i10 >= iArr.length) {
            return null;
        }
        int i11 = iArr[i10];
        int m10 = m(this.dk, i11);
        StringBuilder sb2 = new StringBuilder(m10);
        while (m10 != 0) {
            i11 += 2;
            sb2.append((char) m(this.dk, i11));
            m10--;
        }
        return sb2.toString();
    }

    private static final int m(int[] iArr, int i10) {
        int i11 = iArr[i10 / 4];
        return (i10 % 4) / 2 == 0 ? i11 & 65535 : i11 >>> 16;
    }
}
