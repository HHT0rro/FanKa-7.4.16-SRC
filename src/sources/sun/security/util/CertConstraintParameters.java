package sun.security.util;

import java.security.cert.X509Certificate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertConstraintParameters {
    private final X509Certificate cert;
    private final boolean trustedMatch;

    public CertConstraintParameters(X509Certificate c4, boolean match) {
        this.cert = c4;
        this.trustedMatch = match;
    }

    public CertConstraintParameters(X509Certificate c4) {
        this(c4, false);
    }

    public boolean isTrustedMatch() {
        return this.trustedMatch;
    }

    public X509Certificate getCertificate() {
        return this.cert;
    }
}
