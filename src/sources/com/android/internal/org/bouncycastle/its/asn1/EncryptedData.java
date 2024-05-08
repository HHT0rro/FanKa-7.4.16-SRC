package com.android.internal.org.bouncycastle.its.asn1;

import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class EncryptedData {
    private EncryptedData(ASN1Sequence seq) {
    }

    public static EncryptedData getInstance(Object o10) {
        if (o10 instanceof EncryptedData) {
            return (EncryptedData) o10;
        }
        if (o10 != null) {
            return new EncryptedData(ASN1Sequence.getInstance(o10));
        }
        return null;
    }
}
