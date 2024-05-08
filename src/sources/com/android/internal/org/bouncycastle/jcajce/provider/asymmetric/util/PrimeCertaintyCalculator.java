package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PrimeCertaintyCalculator {
    private PrimeCertaintyCalculator() {
    }

    public static int getDefaultCertainty(int keySizeInBits) {
        if (keySizeInBits <= 1024) {
            return 80;
        }
        return (((keySizeInBits - 1) / 1024) * 16) + 96;
    }
}
