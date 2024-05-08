package java.security;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.cert.CertPath;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class CodeSigner implements Serializable {
    private static final long serialVersionUID = 6819288105193937581L;
    private transient int myhash = -1;
    private CertPath signerCertPath;
    private Timestamp timestamp;

    public CodeSigner(CertPath signerCertPath, Timestamp timestamp) {
        if (signerCertPath == null) {
            throw new NullPointerException();
        }
        this.signerCertPath = signerCertPath;
        this.timestamp = timestamp;
    }

    public CertPath getSignerCertPath() {
        return this.signerCertPath;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        if (this.myhash == -1) {
            if (this.timestamp == null) {
                this.myhash = this.signerCertPath.hashCode();
            } else {
                this.myhash = this.signerCertPath.hashCode() + this.timestamp.hashCode();
            }
        }
        return this.myhash;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CodeSigner)) {
            return false;
        }
        CodeSigner that = (CodeSigner) obj;
        if (this == that) {
            return true;
        }
        Timestamp thatTimestamp = that.getTimestamp();
        Timestamp timestamp = this.timestamp;
        if (timestamp == null) {
            if (thatTimestamp != null) {
                return false;
            }
        } else if (thatTimestamp == null || !timestamp.equals(thatTimestamp)) {
            return false;
        }
        return this.signerCertPath.equals(that.getSignerCertPath());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        sb2.append("Signer: " + ((Object) this.signerCertPath.getCertificates().get(0)));
        if (this.timestamp != null) {
            sb2.append("timestamp: " + ((Object) this.timestamp));
        }
        sb2.append(")");
        return sb2.toString();
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.myhash = -1;
    }
}
