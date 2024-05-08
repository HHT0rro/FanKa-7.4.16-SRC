package javax.security.cert;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Certificate {
    public abstract byte[] getEncoded() throws CertificateEncodingException;

    public abstract PublicKey getPublicKey();

    public abstract String toString();

    public abstract void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public abstract void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Certificate)) {
            return false;
        }
        try {
            byte[] thisCert = getEncoded();
            byte[] otherCert = ((Certificate) other).getEncoded();
            if (thisCert.length != otherCert.length) {
                return false;
            }
            for (int i10 = 0; i10 < thisCert.length; i10++) {
                if (thisCert[i10] != otherCert[i10]) {
                    return false;
                }
            }
            return true;
        } catch (CertificateException e2) {
            return false;
        }
    }

    public int hashCode() {
        int retval = 0;
        try {
            byte[] certData = getEncoded();
            for (int i10 = 1; i10 < certData.length; i10++) {
                retval += certData[i10] * i10;
            }
            return retval;
        } catch (CertificateException e2) {
            return retval;
        }
    }
}
