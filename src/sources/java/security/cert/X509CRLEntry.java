package java.security.cert;

import java.math.BigInteger;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import sun.security.x509.X509CRLEntryImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class X509CRLEntry implements X509Extension {
    public abstract byte[] getEncoded() throws CRLException;

    public abstract Date getRevocationDate();

    public abstract BigInteger getSerialNumber();

    public abstract boolean hasExtensions();

    public abstract String toString();

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof X509CRLEntry)) {
            return false;
        }
        try {
            byte[] thisCRLEntry = getEncoded();
            byte[] otherCRLEntry = ((X509CRLEntry) other).getEncoded();
            if (thisCRLEntry.length != otherCRLEntry.length) {
                return false;
            }
            for (int i10 = 0; i10 < thisCRLEntry.length; i10++) {
                if (thisCRLEntry[i10] != otherCRLEntry[i10]) {
                    return false;
                }
            }
            return true;
        } catch (CRLException e2) {
            return false;
        }
    }

    public int hashCode() {
        int retval = 0;
        try {
            byte[] entryData = getEncoded();
            for (int i10 = 1; i10 < entryData.length; i10++) {
                retval += entryData[i10] * i10;
            }
            return retval;
        } catch (CRLException e2) {
            return retval;
        }
    }

    public X500Principal getCertificateIssuer() {
        return null;
    }

    public CRLReason getRevocationReason() {
        if (!hasExtensions()) {
            return null;
        }
        return X509CRLEntryImpl.getRevocationReason(this);
    }
}
