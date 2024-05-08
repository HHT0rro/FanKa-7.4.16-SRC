package com.android.internal.org.bouncycastle.asn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DLFactory {
    static final ASN1Sequence EMPTY_SEQUENCE = new DLSequence();
    static final ASN1Set EMPTY_SET = new DLSet();

    DLFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASN1Sequence createSequence(ASN1EncodableVector v2) {
        if (v2.size() < 1) {
            return EMPTY_SEQUENCE;
        }
        return new DLSequence(v2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASN1Set createSet(ASN1EncodableVector v2) {
        if (v2.size() < 1) {
            return EMPTY_SET;
        }
        return new DLSet(v2);
    }
}
