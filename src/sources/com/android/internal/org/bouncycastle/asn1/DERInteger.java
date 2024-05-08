package com.android.internal.org.bouncycastle.asn1;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DERInteger extends ASN1Integer {
    public DERInteger(byte[] bytes) {
        super(bytes, true);
    }

    public DERInteger(BigInteger value) {
        super(value);
    }

    public DERInteger(long value) {
        super(value);
    }
}
