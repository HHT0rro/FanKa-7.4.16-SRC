package java.security.cert;

import java.security.PublicKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PKIXCertPathBuilderResult extends PKIXCertPathValidatorResult implements CertPathBuilderResult {
    private CertPath certPath;

    public PKIXCertPathBuilderResult(CertPath certPath, TrustAnchor trustAnchor, PolicyNode policyTree, PublicKey subjectPublicKey) {
        super(trustAnchor, policyTree, subjectPublicKey);
        if (certPath == null) {
            throw new NullPointerException("certPath must be non-null");
        }
        this.certPath = certPath;
    }

    @Override // java.security.cert.CertPathBuilderResult
    public CertPath getCertPath() {
        return this.certPath;
    }

    @Override // java.security.cert.PKIXCertPathValidatorResult
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PKIXCertPathBuilderResult: [\n");
        sb2.append("  Certification Path: " + ((Object) this.certPath) + "\n");
        sb2.append("  Trust Anchor: " + getTrustAnchor().toString() + "\n");
        sb2.append("  Policy Tree: " + String.valueOf(getPolicyTree()) + "\n");
        sb2.append("  Subject Public Key: " + ((Object) getPublicKey()) + "\n");
        sb2.append("]");
        return sb2.toString();
    }
}
