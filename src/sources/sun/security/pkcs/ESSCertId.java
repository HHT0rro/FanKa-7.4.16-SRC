package sun.security.pkcs;

import java.io.IOException;
import sun.misc.HexDumpEncoder;
import sun.security.util.DerValue;
import sun.security.x509.GeneralNames;
import sun.security.x509.SerialNumber;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: SigningCertificateInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ESSCertId {
    private static volatile HexDumpEncoder hexDumper;
    private byte[] certHash;
    private GeneralNames issuer;
    private SerialNumber serialNumber;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ESSCertId(DerValue certId) throws IOException {
        this.certHash = certId.data.getDerValue().toByteArray();
        if (certId.data.available() > 0) {
            DerValue issuerSerial = certId.data.getDerValue();
            this.issuer = new GeneralNames(issuerSerial.data.getDerValue());
            this.serialNumber = new SerialNumber(issuerSerial.data.getDerValue());
        }
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[\n\tCertificate hash (SHA-1):\n");
        if (hexDumper == null) {
            hexDumper = new HexDumpEncoder();
        }
        buffer.append(hexDumper.encode(this.certHash));
        if (this.issuer != null && this.serialNumber != null) {
            buffer.append("\n\tIssuer: " + ((Object) this.issuer) + "\n");
            buffer.append("\t" + ((Object) this.serialNumber));
        }
        buffer.append("\n]");
        return buffer.toString();
    }
}
