package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.android.internal.org.bouncycastle.asn1.x509.BasicConstraints;
import com.android.internal.org.bouncycastle.asn1.x509.Certificate;
import com.android.internal.org.bouncycastle.jcajce.util.JcaJceHelper;
import java.security.cert.CertificateEncodingException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class X509CertificateInternal extends X509CertificateImpl {
    private final byte[] encoding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X509CertificateInternal(JcaJceHelper bcHelper, Certificate c4, BasicConstraints basicConstraints, boolean[] keyUsage, String sigAlgName, byte[] sigAlgParams, byte[] encoding) {
        super(bcHelper, c4, basicConstraints, keyUsage, sigAlgName, sigAlgParams);
        this.encoding = encoding;
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] bArr = this.encoding;
        if (bArr == null) {
            throw new CertificateEncodingException();
        }
        return bArr;
    }
}
