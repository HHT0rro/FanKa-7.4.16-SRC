package java.security.cert;

import java.io.IOException;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import sun.security.x509.NameConstraintsExtension;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TrustAnchor {
    private final String caName;
    private final X500Principal caPrincipal;

    /* renamed from: nc, reason: collision with root package name */
    private NameConstraintsExtension f50392nc;
    private byte[] ncBytes;
    private final PublicKey pubKey;
    private final X509Certificate trustedCert;

    public TrustAnchor(X509Certificate trustedCert, byte[] nameConstraints) {
        if (trustedCert == null) {
            throw new NullPointerException("the trustedCert parameter must be non-null");
        }
        this.trustedCert = trustedCert;
        this.pubKey = null;
        this.caName = null;
        this.caPrincipal = null;
        setNameConstraints(nameConstraints);
    }

    public TrustAnchor(X500Principal caPrincipal, PublicKey pubKey, byte[] nameConstraints) {
        if (caPrincipal == null || pubKey == null) {
            throw new NullPointerException();
        }
        this.trustedCert = null;
        this.caPrincipal = caPrincipal;
        this.caName = caPrincipal.getName();
        this.pubKey = pubKey;
        setNameConstraints(nameConstraints);
    }

    public TrustAnchor(String caName, PublicKey pubKey, byte[] nameConstraints) {
        if (pubKey == null) {
            throw new NullPointerException("the pubKey parameter must be non-null");
        }
        if (caName == null) {
            throw new NullPointerException("the caName parameter must be non-null");
        }
        if (caName.length() == 0) {
            throw new IllegalArgumentException("the caName parameter must be a non-empty String");
        }
        this.caPrincipal = new X500Principal(caName);
        this.pubKey = pubKey;
        this.caName = caName;
        this.trustedCert = null;
        setNameConstraints(nameConstraints);
    }

    public final X509Certificate getTrustedCert() {
        return this.trustedCert;
    }

    public final X500Principal getCA() {
        return this.caPrincipal;
    }

    public final String getCAName() {
        return this.caName;
    }

    public final PublicKey getCAPublicKey() {
        return this.pubKey;
    }

    private void setNameConstraints(byte[] bytes) {
        if (bytes == null) {
            this.ncBytes = null;
            this.f50392nc = null;
            return;
        }
        this.ncBytes = (byte[]) bytes.clone();
        try {
            this.f50392nc = new NameConstraintsExtension(Boolean.FALSE, bytes);
        } catch (IOException ioe) {
            IllegalArgumentException iae = new IllegalArgumentException(ioe.getMessage());
            iae.initCause(ioe);
            throw iae;
        }
    }

    public final byte[] getNameConstraints() {
        byte[] bArr = this.ncBytes;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[\n");
        if (this.pubKey != null) {
            sb2.append("  Trusted CA Public Key: " + this.pubKey.toString() + "\n");
            sb2.append("  Trusted CA Issuer Name: " + String.valueOf(this.caName) + "\n");
        } else {
            sb2.append("  Trusted CA cert: " + this.trustedCert.toString() + "\n");
        }
        if (this.f50392nc != null) {
            sb2.append("  Name Constraints: " + this.f50392nc.toString() + "\n");
        }
        return sb2.toString();
    }
}
