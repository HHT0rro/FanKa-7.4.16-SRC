package com.android.internal.org.bouncycastle.its.asn1;

import com.android.internal.org.bouncycastle.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class Utils {
    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] octetStringFixed(byte[] octets, int n10) {
        if (octets.length != n10) {
            throw new IllegalArgumentException("octet string out of range");
        }
        return octets;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] octetStringFixed(byte[] octets) {
        if (octets.length < 1 || octets.length > 32) {
            throw new IllegalArgumentException("octet string out of range");
        }
        return Arrays.clone(octets);
    }
}
