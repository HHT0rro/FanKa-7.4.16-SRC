package sun.security.x509;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertificatePolicySet {
    private final Vector<CertificatePolicyId> ids;

    public CertificatePolicySet(Vector<CertificatePolicyId> ids) {
        this.ids = ids;
    }

    public CertificatePolicySet(DerInputStream in) throws IOException {
        this.ids = new Vector<>();
        DerValue[] seq = in.getSequence(5);
        for (DerValue derValue : seq) {
            CertificatePolicyId id2 = new CertificatePolicyId(derValue);
            this.ids.addElement(id2);
        }
    }

    public String toString() {
        String s2 = "CertificatePolicySet:[\n" + this.ids.toString() + "]\n";
        return s2;
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        for (int i10 = 0; i10 < this.ids.size(); i10++) {
            this.ids.elementAt(i10).encode(tmp);
        }
        out.write((byte) 48, tmp);
    }

    public List<CertificatePolicyId> getCertPolicyIds() {
        return Collections.unmodifiableList(this.ids);
    }
}
