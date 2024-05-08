package java.security.cert;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PKIXBuilderParameters extends PKIXParameters {
    private int maxPathLength;

    public PKIXBuilderParameters(Set<TrustAnchor> trustAnchors, CertSelector targetConstraints) throws InvalidAlgorithmParameterException {
        super(trustAnchors);
        this.maxPathLength = 5;
        setTargetCertConstraints(targetConstraints);
    }

    public PKIXBuilderParameters(KeyStore keystore, CertSelector targetConstraints) throws KeyStoreException, InvalidAlgorithmParameterException {
        super(keystore);
        this.maxPathLength = 5;
        setTargetCertConstraints(targetConstraints);
    }

    public void setMaxPathLength(int maxPathLength) {
        if (maxPathLength < -1) {
            throw new InvalidParameterException("the maximum path length parameter can not be less than -1");
        }
        this.maxPathLength = maxPathLength;
    }

    public int getMaxPathLength() {
        return this.maxPathLength;
    }

    @Override // java.security.cert.PKIXParameters
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[\n");
        sb2.append(super.toString());
        sb2.append("  Maximum Path Length: " + this.maxPathLength + "\n");
        sb2.append("]\n");
        return sb2.toString();
    }
}
