package sun.security.pkcs;

import java.io.IOException;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SigningCertificateInfo {
    private byte[] ber = null;
    private ESSCertId[] certId = null;

    public SigningCertificateInfo(byte[] ber) throws IOException {
        parse(ber);
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[\n");
        int i10 = 0;
        while (true) {
            ESSCertId[] eSSCertIdArr = this.certId;
            if (i10 < eSSCertIdArr.length) {
                buffer.append(eSSCertIdArr[i10].toString());
                i10++;
            } else {
                buffer.append("\n]");
                return buffer.toString();
            }
        }
    }

    public void parse(byte[] bytes) throws IOException {
        DerValue derValue = new DerValue(bytes);
        if (derValue.tag != 48) {
            throw new IOException("Bad encoding for signingCertificate");
        }
        DerValue[] certs = derValue.data.getSequence(1);
        this.certId = new ESSCertId[certs.length];
        for (int i10 = 0; i10 < certs.length; i10++) {
            this.certId[i10] = new ESSCertId(certs[i10]);
        }
        if (derValue.data.available() > 0) {
            DerValue[] policies = derValue.data.getSequence(1);
            for (int i11 = 0; i11 < policies.length; i11++) {
            }
        }
    }
}
