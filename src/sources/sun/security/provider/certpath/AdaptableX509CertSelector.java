package sun.security.provider.certpath;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import sun.security.util.Debug;
import sun.security.util.DerInputStream;
import sun.security.x509.AuthorityKeyIdentifierExtension;
import sun.security.x509.SerialNumber;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class AdaptableX509CertSelector extends X509CertSelector {
    private static final Debug debug = Debug.getInstance("certpath");
    private Date endDate;
    private BigInteger serial;
    private byte[] ski;
    private Date startDate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValidityPeriod(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override // java.security.cert.X509CertSelector
    public void setSubjectKeyIdentifier(byte[] subjectKeyID) {
        throw new IllegalArgumentException();
    }

    @Override // java.security.cert.X509CertSelector
    public void setSerialNumber(BigInteger serial) {
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSkiAndSerialNumber(AuthorityKeyIdentifierExtension ext) throws IOException {
        this.ski = null;
        this.serial = null;
        if (ext != null) {
            this.ski = ext.getEncodedKeyIdentifier();
            SerialNumber asn = (SerialNumber) ext.get(AuthorityKeyIdentifierExtension.SERIAL_NUMBER);
            if (asn != null) {
                this.serial = asn.getNumber();
            }
        }
    }

    @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector
    public boolean match(Certificate cert) {
        X509Certificate xcert = (X509Certificate) cert;
        if (!matchSubjectKeyID(xcert)) {
            return false;
        }
        int version = xcert.getVersion();
        BigInteger bigInteger = this.serial;
        if (bigInteger != null && version > 2 && !bigInteger.equals(xcert.getSerialNumber())) {
            return false;
        }
        if (version < 3) {
            Date date = this.startDate;
            if (date != null) {
                try {
                    xcert.checkValidity(date);
                } catch (CertificateException e2) {
                    return false;
                }
            }
            Date date2 = this.endDate;
            if (date2 != null) {
                try {
                    xcert.checkValidity(date2);
                } catch (CertificateException e10) {
                    return false;
                }
            }
        }
        return super.match(cert);
    }

    private boolean matchSubjectKeyID(X509Certificate xcert) {
        if (this.ski == null) {
            return true;
        }
        try {
            byte[] extVal = xcert.getExtensionValue("2.5.29.14");
            if (extVal == null) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("AdaptableX509CertSelector.match: no subject key ID extension. Subject: " + ((Object) xcert.getSubjectX500Principal()));
                }
                return true;
            }
            DerInputStream in = new DerInputStream(extVal);
            byte[] certSubjectKeyID = in.getOctetString();
            if (certSubjectKeyID != null && Arrays.equals(this.ski, certSubjectKeyID)) {
                return true;
            }
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("AdaptableX509CertSelector.match: subject key IDs don't match. Expected: " + Arrays.toString(this.ski) + " Cert's: " + Arrays.toString(certSubjectKeyID));
            }
            return false;
        } catch (IOException e2) {
            Debug debug4 = debug;
            if (debug4 != null) {
                debug4.println("AdaptableX509CertSelector.match: exception in subject key ID check");
            }
            return false;
        }
    }

    @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector, com.android.internal.org.bouncycastle.util.Selector
    public Object clone() {
        AdaptableX509CertSelector copy = (AdaptableX509CertSelector) super.clone();
        Date date = this.startDate;
        if (date != null) {
            copy.startDate = (Date) date.clone();
        }
        Date date2 = this.endDate;
        if (date2 != null) {
            copy.endDate = (Date) date2.clone();
        }
        byte[] bArr = this.ski;
        if (bArr != null) {
            copy.ski = (byte[]) bArr.clone();
        }
        return copy;
    }
}
