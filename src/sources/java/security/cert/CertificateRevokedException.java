package java.security.cert;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.InvalidityDateExtension;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertificateRevokedException extends CertificateException {
    private static final long serialVersionUID = 7839996631571608627L;
    private final X500Principal authority;
    private transient Map<String, Extension> extensions;
    private final CRLReason reason;
    private Date revocationDate;

    public CertificateRevokedException(Date revocationDate, CRLReason reason, X500Principal authority, Map<String, Extension> extensions) {
        if (revocationDate == null || reason == null || authority == null || extensions == null) {
            throw new NullPointerException();
        }
        this.revocationDate = new Date(revocationDate.getTime());
        this.reason = reason;
        this.authority = authority;
        Map<String, Extension> checkedMap = Collections.checkedMap(new HashMap(), String.class, Extension.class);
        this.extensions = checkedMap;
        checkedMap.putAll(extensions);
    }

    public Date getRevocationDate() {
        return (Date) this.revocationDate.clone();
    }

    public CRLReason getRevocationReason() {
        return this.reason;
    }

    public X500Principal getAuthorityName() {
        return this.authority;
    }

    public Date getInvalidityDate() {
        Extension ext = getExtensions().get("2.5.29.24");
        if (ext == null) {
            return null;
        }
        try {
            Date invalidity = InvalidityDateExtension.toImpl(ext).get("DATE");
            return new Date(invalidity.getTime());
        } catch (IOException e2) {
            return null;
        }
    }

    public Map<String, Extension> getExtensions() {
        return Collections.unmodifiableMap(this.extensions);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Certificate has been revoked, reason: " + ((Object) this.reason) + ", revocation date: " + ((Object) this.revocationDate) + ", authority: " + ((Object) this.authority) + ", extension OIDs: " + ((Object) this.extensions.h());
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(this.extensions.size());
        for (Map.Entry<String, Extension> entry : this.extensions.entrySet()) {
            Extension ext = entry.getValue();
            oos.writeObject(ext.getId());
            oos.writeBoolean(ext.isCritical());
            byte[] extVal = ext.getValue();
            oos.writeInt(extVal.length);
            oos.write(extVal);
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.revocationDate = new Date(this.revocationDate.getTime());
        int size = ois.readInt();
        if (size == 0) {
            this.extensions = Collections.emptyMap();
        } else {
            this.extensions = new HashMap(size);
        }
        for (int i10 = 0; i10 < size; i10++) {
            String oid = (String) ois.readObject();
            boolean critical = ois.readBoolean();
            int length = ois.readInt();
            byte[] extVal = new byte[length];
            ois.readFully(extVal);
            Extension ext = sun.security.x509.Extension.newExtension(new ObjectIdentifier(oid), critical, extVal);
            this.extensions.put(oid, ext);
        }
    }
}
