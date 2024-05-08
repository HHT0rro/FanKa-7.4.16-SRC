package sun.security.x509;

import java.io.IOException;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X400Address implements GeneralNameInterface {
    byte[] nameValue;

    public X400Address(byte[] value) {
        this.nameValue = null;
        this.nameValue = value;
    }

    public X400Address(DerValue derValue) throws IOException {
        this.nameValue = null;
        this.nameValue = derValue.toByteArray();
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int getType() {
        return 3;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public void encode(DerOutputStream out) throws IOException {
        DerValue derValue = new DerValue(this.nameValue);
        out.putDerValue(derValue);
    }

    public String toString() {
        return "X400Address: <DER-encoded value>";
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int constrains(GeneralNameInterface inputName) throws UnsupportedOperationException {
        if (inputName == null) {
            return -1;
        }
        int constraintType = inputName.getType();
        if (constraintType != 3) {
            return -1;
        }
        throw new UnsupportedOperationException("Narrowing, widening, and match are not supported for X400Address.");
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int subtreeDepth() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("subtreeDepth not supported for X400Address");
    }
}
