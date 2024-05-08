package com.android.internal.org.bouncycastle.crypto.digests;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class XofUtils {
    public static byte[] leftEncode(long strLen) {
        byte n10 = 1;
        long v2 = strLen;
        while (true) {
            long j10 = v2 >> 8;
            v2 = j10;
            if (j10 == 0) {
                break;
            }
            n10 = (byte) (n10 + 1);
        }
        byte[] b4 = new byte[n10 + 1];
        b4[0] = n10;
        for (int i10 = 1; i10 <= n10; i10++) {
            b4[i10] = (byte) (strLen >> ((n10 - i10) * 8));
        }
        return b4;
    }

    public static byte[] rightEncode(long strLen) {
        byte n10 = 1;
        long v2 = strLen;
        while (true) {
            long j10 = v2 >> 8;
            v2 = j10;
            if (j10 == 0) {
                break;
            }
            n10 = (byte) (n10 + 1);
        }
        byte[] b4 = new byte[n10 + 1];
        b4[n10] = n10;
        for (int i10 = 0; i10 < n10; i10++) {
            b4[i10] = (byte) (strLen >> (((n10 - i10) - 1) * 8));
        }
        return b4;
    }
}
