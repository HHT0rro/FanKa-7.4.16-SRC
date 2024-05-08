package sun.security.x509;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Extension implements java.security.cert.Extension {
    private static final int hashMagic = 31;
    protected boolean critical;
    protected ObjectIdentifier extensionId;
    protected byte[] extensionValue;

    public Extension() {
        this.extensionId = null;
        this.critical = false;
        this.extensionValue = null;
    }

    public Extension(DerValue derVal) throws IOException {
        this.extensionId = null;
        this.critical = false;
        this.extensionValue = null;
        DerInputStream in = derVal.toDerInputStream();
        this.extensionId = in.getOID();
        DerValue val = in.getDerValue();
        if (val.tag == 1) {
            this.critical = val.getBoolean();
            this.extensionValue = in.getDerValue().getOctetString();
        } else {
            this.critical = false;
            this.extensionValue = val.getOctetString();
        }
    }

    public Extension(ObjectIdentifier extensionId, boolean critical, byte[] extensionValue) throws IOException {
        this.extensionId = null;
        this.critical = false;
        this.extensionValue = null;
        this.extensionId = extensionId;
        this.critical = critical;
        DerValue inDerVal = new DerValue(extensionValue);
        this.extensionValue = inDerVal.getOctetString();
    }

    public Extension(Extension ext) {
        this.extensionId = null;
        this.critical = false;
        this.extensionValue = null;
        this.extensionId = ext.extensionId;
        this.critical = ext.critical;
        this.extensionValue = ext.extensionValue;
    }

    public static Extension newExtension(ObjectIdentifier extensionId, boolean critical, byte[] rawExtensionValue) throws IOException {
        Extension ext = new Extension();
        ext.extensionId = extensionId;
        ext.critical = critical;
        ext.extensionValue = rawExtensionValue;
        return ext;
    }

    @Override // java.security.cert.Extension, sun.security.x509.CertAttrSet
    public void encode(OutputStream out) throws IOException {
        if (out == null) {
            throw new NullPointerException();
        }
        DerOutputStream dos1 = new DerOutputStream();
        DerOutputStream dos2 = new DerOutputStream();
        dos1.putOID(this.extensionId);
        boolean z10 = this.critical;
        if (z10) {
            dos1.putBoolean(z10);
        }
        dos1.putOctetString(this.extensionValue);
        dos2.write((byte) 48, dos1);
        out.write(dos2.toByteArray());
    }

    public void encode(DerOutputStream out) throws IOException {
        if (this.extensionId == null) {
            throw new IOException("Null OID to encode for the extension!");
        }
        if (this.extensionValue == null) {
            throw new IOException("No value to encode for the extension!");
        }
        DerOutputStream dos = new DerOutputStream();
        dos.putOID(this.extensionId);
        boolean z10 = this.critical;
        if (z10) {
            dos.putBoolean(z10);
        }
        dos.putOctetString(this.extensionValue);
        out.write((byte) 48, dos);
    }

    @Override // java.security.cert.Extension
    public boolean isCritical() {
        return this.critical;
    }

    public ObjectIdentifier getExtensionId() {
        return this.extensionId;
    }

    @Override // java.security.cert.Extension
    public byte[] getValue() {
        return (byte[]) this.extensionValue.clone();
    }

    public byte[] getExtensionValue() {
        return this.extensionValue;
    }

    @Override // java.security.cert.Extension
    public String getId() {
        return this.extensionId.toString();
    }

    public String toString() {
        String s2 = "ObjectId: " + this.extensionId.toString();
        if (this.critical) {
            return s2 + " Criticality=true\n";
        }
        return s2 + " Criticality=false\n";
    }

    public int hashCode() {
        int h10 = 0;
        if (this.extensionValue != null) {
            byte[] val = this.extensionValue;
            int len = val.length;
            while (len > 0) {
                int len2 = len - 1;
                h10 += len * val[len2];
                len = len2;
            }
        }
        return (((h10 * 31) + this.extensionId.hashCode()) * 31) + (this.critical ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Extension)) {
            return false;
        }
        Extension otherExt = (Extension) other;
        if (this.critical == otherExt.critical && this.extensionId.equals((Object) otherExt.extensionId)) {
            return Arrays.equals(this.extensionValue, otherExt.extensionValue);
        }
        return false;
    }
}
