package sun.security.x509;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import sun.security.util.DerOutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DeltaCRLIndicatorExtension extends CRLNumberExtension {
    private static final String LABEL = "Base CRL Number";
    public static final String NAME = "DeltaCRLIndicator";

    public DeltaCRLIndicatorExtension(int crlNum) throws IOException {
        super(PKIXExtensions.DeltaCRLIndicator_Id, true, BigInteger.valueOf(crlNum), NAME, LABEL);
    }

    public DeltaCRLIndicatorExtension(BigInteger crlNum) throws IOException {
        super(PKIXExtensions.DeltaCRLIndicator_Id, true, crlNum, NAME, LABEL);
    }

    public DeltaCRLIndicatorExtension(Boolean critical, Object value) throws IOException {
        super(PKIXExtensions.DeltaCRLIndicator_Id, Boolean.valueOf(critical.booleanValue()), value, NAME, LABEL);
    }

    @Override // sun.security.x509.CRLNumberExtension, sun.security.x509.Extension, java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        new DerOutputStream();
        super.encode(out, PKIXExtensions.DeltaCRLIndicator_Id, true);
    }
}
