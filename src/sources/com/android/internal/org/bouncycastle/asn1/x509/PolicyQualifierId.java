package com.android.internal.org.bouncycastle.asn1.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PolicyQualifierId extends ASN1ObjectIdentifier {
    private static final String id_qt = "1.3.6.1.5.5.7.2";
    public static final PolicyQualifierId id_qt_cps = new PolicyQualifierId("1.3.6.1.5.5.7.2.1");
    public static final PolicyQualifierId id_qt_unotice = new PolicyQualifierId("1.3.6.1.5.5.7.2.2");

    private PolicyQualifierId(String id2) {
        super(id2);
    }
}
