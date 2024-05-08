package com.android.internal.org.bouncycastle.asn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BERFactory {
    static final BERSequence EMPTY_SEQUENCE = new BERSequence();
    static final BERSet EMPTY_SET = new BERSet();

    BERFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BERSequence createSequence(ASN1EncodableVector v2) {
        if (v2.size() < 1) {
            return EMPTY_SEQUENCE;
        }
        return new BERSequence(v2);
    }

    static BERSet createSet(ASN1EncodableVector v2) {
        if (v2.size() < 1) {
            return EMPTY_SET;
        }
        return new BERSet(v2);
    }
}
