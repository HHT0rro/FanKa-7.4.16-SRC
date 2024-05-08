package sun.security.provider.certpath;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import sun.security.util.Debug;
import sun.security.x509.AuthorityKeyIdentifierExtension;
import sun.security.x509.KeyIdentifier;
import sun.security.x509.SubjectKeyIdentifierExtension;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Vertex {
    private static final Debug debug = Debug.getInstance("certpath");
    private X509Certificate cert;
    private int index = -1;
    private Throwable throwable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vertex(X509Certificate cert) {
        this.cert = cert;
    }

    public X509Certificate getCertificate() {
        return this.cert;
    }

    public int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndex(int ndx) {
        this.index = ndx;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String toString() {
        return certToString() + throwableToString() + indexToString();
    }

    public String certToString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            X509CertImpl impl = X509CertImpl.toImpl(this.cert);
            sb2.append("Issuer:     ").append((Object) impl.getIssuerX500Principal()).append("\n");
            sb2.append("Subject:    ").append((Object) impl.getSubjectX500Principal()).append("\n");
            sb2.append("SerialNum:  ").append(impl.getSerialNumber().toString(16)).append("\n");
            sb2.append("Expires:    ").append(impl.getNotAfter().toString()).append("\n");
            boolean[] issuerUniqueID = impl.getIssuerUniqueID();
            if (issuerUniqueID != null) {
                sb2.append("IssuerUID:  ");
                for (boolean z10 : issuerUniqueID) {
                    sb2.append(z10 ? 1 : 0);
                }
                sb2.append("\n");
            }
            boolean[] subjectUniqueID = impl.getSubjectUniqueID();
            if (subjectUniqueID != null) {
                sb2.append("SubjectUID: ");
                for (boolean z11 : subjectUniqueID) {
                    sb2.append(z11 ? 1 : 0);
                }
                sb2.append("\n");
            }
            try {
                SubjectKeyIdentifierExtension subjectKeyIdentifierExtension = impl.getSubjectKeyIdentifierExtension();
                if (subjectKeyIdentifierExtension != null) {
                    sb2.append("SubjKeyID:  ").append(subjectKeyIdentifierExtension.get("key_id").toString());
                }
                AuthorityKeyIdentifierExtension authorityKeyIdentifierExtension = impl.getAuthorityKeyIdentifierExtension();
                if (authorityKeyIdentifierExtension != null) {
                    sb2.append("AuthKeyID:  ").append(((KeyIdentifier) authorityKeyIdentifierExtension.get("key_id")).toString());
                }
            } catch (IOException e2) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("Vertex.certToString() unexpected exception");
                    e2.printStackTrace();
                }
            }
            return sb2.toString();
        } catch (CertificateException e10) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("Vertex.certToString() unexpected exception");
                e10.printStackTrace();
            }
            return sb2.toString();
        }
    }

    public String throwableToString() {
        StringBuilder sb2 = new StringBuilder("Exception:  ");
        Throwable th = this.throwable;
        if (th != null) {
            sb2.append(th.toString());
        } else {
            sb2.append("null");
        }
        sb2.append("\n");
        return sb2.toString();
    }

    public String moreToString() {
        StringBuilder sb2 = new StringBuilder("Last cert?  ");
        sb2.append(this.index == -1 ? "Yes" : "No");
        sb2.append("\n");
        return sb2.toString();
    }

    public String indexToString() {
        return "Index:      " + this.index + "\n";
    }
}
