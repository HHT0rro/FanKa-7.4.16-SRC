package java.security.cert;

import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CertPath implements Serializable {
    private static final long serialVersionUID = 6068470306649138683L;
    private String type;

    public abstract List<? extends Certificate> getCertificates();

    public abstract byte[] getEncoded() throws CertificateEncodingException;

    public abstract byte[] getEncoded(String str) throws CertificateEncodingException;

    public abstract Iterator<String> getEncodings();

    /* JADX INFO: Access modifiers changed from: protected */
    public CertPath(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CertPath)) {
            return false;
        }
        CertPath otherCP = (CertPath) other;
        if (!otherCP.getType().equals(this.type)) {
            return false;
        }
        List<? extends Certificate> thisCertList = getCertificates();
        List<? extends Certificate> otherCertList = otherCP.getCertificates();
        return thisCertList.equals(otherCertList);
    }

    public int hashCode() {
        int hashCode = this.type.hashCode();
        return (hashCode * 31) + getCertificates().hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n" + this.type + " Cert Path: length = " + getCertificates().size() + ".\n");
        sb2.append("[\n");
        int i10 = 1;
        for (Certificate stringCert : getCertificates()) {
            sb2.append("=========================================================Certificate " + i10 + " start.\n");
            sb2.append(stringCert.toString());
            sb2.append("\n=========================================================Certificate " + i10 + " end.\n\n\n");
            i10++;
        }
        sb2.append("\n]");
        return sb2.toString();
    }

    protected Object writeReplace() throws ObjectStreamException {
        try {
            return new CertPathRep(this.type, getEncoded());
        } catch (CertificateException ce2) {
            NotSerializableException nse = new NotSerializableException("java.security.cert.CertPath: " + this.type);
            nse.initCause(ce2);
            throw nse;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    protected static class CertPathRep implements Serializable {
        private static final long serialVersionUID = 3015633072427920915L;
        private byte[] data;
        private String type;

        protected CertPathRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                CertificateFactory cf = CertificateFactory.getInstance(this.type);
                return cf.generateCertPath(new ByteArrayInputStream(this.data));
            } catch (CertificateException ce2) {
                NotSerializableException nse = new NotSerializableException("java.security.cert.CertPath: " + this.type);
                nse.initCause(ce2);
                throw nse;
            }
        }
    }
}
