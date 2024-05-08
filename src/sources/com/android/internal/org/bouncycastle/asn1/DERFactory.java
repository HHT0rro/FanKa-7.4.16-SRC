package com.android.internal.org.bouncycastle.asn1;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class DERFactory {
    static final ASN1Sequence EMPTY_SEQUENCE = new DERSequence();
    static final ASN1Set EMPTY_SET = new DERSet();

    DERFactory() {
    }

    static ASN1Sequence createSequence(ASN1EncodableVector v2) {
        if (v2.size() < 1) {
            return EMPTY_SEQUENCE;
        }
        return new DERSequence(v2);
    }

    static ASN1Set createSet(ASN1EncodableVector v2) {
        if (v2.size() < 1) {
            return EMPTY_SET;
        }
        return new DERSet(v2);
    }
}
