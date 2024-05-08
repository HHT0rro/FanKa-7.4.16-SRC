package com.android.internal.org.bouncycastle.jcajce.interfaces;

import com.android.internal.org.bouncycastle.asn1.x500.X500Name;
import com.android.internal.org.bouncycastle.asn1.x509.TBSCertificate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface BCX509Certificate {
    X500Name getIssuerX500Name();

    X500Name getSubjectX500Name();

    TBSCertificate getTBSCertificateNative();
}
