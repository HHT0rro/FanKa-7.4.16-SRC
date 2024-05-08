package sun.security.x509;

import java.io.IOException;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertificatePolicyId {

    /* renamed from: id, reason: collision with root package name */
    private ObjectIdentifier f53746id;

    public CertificatePolicyId(ObjectIdentifier id2) {
        this.f53746id = id2;
    }

    public CertificatePolicyId(DerValue val) throws IOException {
        this.f53746id = val.getOID();
    }

    public ObjectIdentifier getIdentifier() {
        return this.f53746id;
    }

    public String toString() {
        String s2 = "CertificatePolicyId: [" + this.f53746id.toString() + "]\n";
        return s2;
    }

    public void encode(DerOutputStream out) throws IOException {
        out.putOID(this.f53746id);
    }

    public boolean equals(Object other) {
        if (other instanceof CertificatePolicyId) {
            return this.f53746id.equals((Object) ((CertificatePolicyId) other).getIdentifier());
        }
        return false;
    }

    public int hashCode() {
        return this.f53746id.hashCode();
    }
}
