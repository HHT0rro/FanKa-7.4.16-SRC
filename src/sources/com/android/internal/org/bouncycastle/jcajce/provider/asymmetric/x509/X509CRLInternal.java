package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.android.internal.org.bouncycastle.asn1.x509.CertificateList;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import java.security.cert.CRLException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class X509CRLInternal extends X509CRLImpl {
    private final byte[] encoding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509CRLInternal(JcaJceHelper bcHelper, CertificateList c4, String sigAlgName, byte[] sigAlgParams, boolean isIndirect, byte[] encoding) {
        super(bcHelper, c4, sigAlgName, sigAlgParams, isIndirect);
        this.encoding = encoding;
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLImpl, java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        byte[] bArr = this.encoding;
        if (bArr == null) {
            throw new CRLException();
        }
        return bArr;
    }
}
