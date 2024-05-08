package java.security.cert;

import com.huawei.hms.feature.dynamic.f.e;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import sun.security.x509.X509CRLImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class X509CRL extends CRL implements X509Extension {
    private transient X500Principal issuerPrincipal;

    public abstract byte[] getEncoded() throws CRLException;

    public abstract Principal getIssuerDN();

    public abstract Date getNextUpdate();

    public abstract X509CRLEntry getRevokedCertificate(BigInteger bigInteger);

    public abstract Set<? extends X509CRLEntry> getRevokedCertificates();

    public abstract String getSigAlgName();

    public abstract String getSigAlgOID();

    public abstract byte[] getSigAlgParams();

    public abstract byte[] getSignature();

    public abstract byte[] getTBSCertList() throws CRLException;

    public abstract Date getThisUpdate();

    public abstract int getVersion();

    public abstract void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public abstract void verify(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    /* JADX INFO: Access modifiers changed from: protected */
    public X509CRL() {
        super(e.f29912b);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof X509CRL)) {
            return false;
        }
        try {
            byte[] thisCRL = X509CRLImpl.getEncodedInternal(this);
            byte[] otherCRL = X509CRLImpl.getEncodedInternal((X509CRL) other);
            return Arrays.equals(thisCRL, otherCRL);
        } catch (CRLException e2) {
            return false;
        }
    }

    public int hashCode() {
        int retval = 0;
        try {
            byte[] crlData = X509CRLImpl.getEncodedInternal(this);
            for (int i10 = 1; i10 < crlData.length; i10++) {
                retval += crlData[i10] * i10;
            }
            return retval;
        } catch (CRLException e2) {
            return retval;
        }
    }

    public void verify(PublicKey key, Provider sigProvider) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        throw new UnsupportedOperationException("X509CRL instance doesn't not support X509CRL#verify(PublicKey, Provider)");
    }

    public X500Principal getIssuerX500Principal() {
        if (this.issuerPrincipal == null) {
            this.issuerPrincipal = X509CRLImpl.getIssuerX500Principal(this);
        }
        return this.issuerPrincipal;
    }

    public X509CRLEntry getRevokedCertificate(X509Certificate certificate) {
        X500Principal certIssuer = certificate.getIssuerX500Principal();
        X500Principal crlIssuer = getIssuerX500Principal();
        if (!certIssuer.equals(crlIssuer)) {
            return null;
        }
        return getRevokedCertificate(certificate.getSerialNumber());
    }
}
