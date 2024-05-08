package sun.security.provider.certpath;

import java.io.IOException;
import java.security.cert.Extension;
import java.util.Collections;
import java.util.List;
import sun.misc.HexDumpEncoder;
import sun.security.util.Debug;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class OCSPRequest {
    private static final Debug debug;
    private static final boolean dump;
    private final List<CertId> certIds;
    private final List<Extension> extensions;
    private byte[] nonce;

    static {
        Debug debug2 = Debug.getInstance("certpath");
        debug = debug2;
        dump = debug2 != null && Debug.isOn("ocsp");
    }

    OCSPRequest(CertId certId) {
        this((List<CertId>) Collections.singletonList(certId));
    }

    OCSPRequest(List<CertId> certIds) {
        this.certIds = certIds;
        this.extensions = Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OCSPRequest(List<CertId> certIds, List<Extension> extensions) {
        this.certIds = certIds;
        this.extensions = extensions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] encodeBytes() throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        DerOutputStream requestsOut = new DerOutputStream();
        for (CertId certId : this.certIds) {
            DerOutputStream certIdOut = new DerOutputStream();
            certId.encode(certIdOut);
            requestsOut.write((byte) 48, certIdOut);
        }
        tmp.write((byte) 48, requestsOut);
        if (!this.extensions.isEmpty()) {
            DerOutputStream extOut = new DerOutputStream();
            for (Extension ext : this.extensions) {
                ext.encode(extOut);
                if (ext.getId().equals(OCSP.NONCE_EXTENSION_OID.toString())) {
                    this.nonce = ext.getValue();
                }
            }
            DerOutputStream extsOut = new DerOutputStream();
            extsOut.write((byte) 48, extOut);
            tmp.write(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 2), extsOut);
        }
        DerOutputStream tbsRequest = new DerOutputStream();
        tbsRequest.write((byte) 48, tmp);
        DerOutputStream ocspRequest = new DerOutputStream();
        ocspRequest.write((byte) 48, tbsRequest);
        byte[] bytes = ocspRequest.toByteArray();
        if (dump) {
            HexDumpEncoder hexEnc = new HexDumpEncoder();
            debug.println("OCSPRequest bytes...\n\n" + hexEnc.encode(bytes) + "\n");
        }
        return bytes;
    }

    List<CertId> getCertIds() {
        return this.certIds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getNonce() {
        return this.nonce;
    }
}
