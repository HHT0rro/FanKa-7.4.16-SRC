package sun.security.x509;

import java.io.IOException;
import java.util.Objects;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DistributionPointName {
    private static final byte TAG_FULL_NAME = 0;
    private static final byte TAG_RELATIVE_NAME = 1;
    private GeneralNames fullName;
    private volatile int hashCode;
    private RDN relativeName;

    public DistributionPointName(GeneralNames fullName) {
        this.fullName = null;
        this.relativeName = null;
        if (fullName == null) {
            throw new IllegalArgumentException("fullName must not be null");
        }
        this.fullName = fullName;
    }

    public DistributionPointName(RDN relativeName) {
        this.fullName = null;
        this.relativeName = null;
        if (relativeName == null) {
            throw new IllegalArgumentException("relativeName must not be null");
        }
        this.relativeName = relativeName;
    }

    public DistributionPointName(DerValue encoding) throws IOException {
        this.fullName = null;
        this.relativeName = null;
        if (encoding.isContextSpecific((byte) 0) && encoding.isConstructed()) {
            encoding.resetTag((byte) 48);
            this.fullName = new GeneralNames(encoding);
        } else {
            if (encoding.isContextSpecific((byte) 1) && encoding.isConstructed()) {
                encoding.resetTag((byte) 49);
                this.relativeName = new RDN(encoding);
                return;
            }
            throw new IOException("Invalid encoding for DistributionPointName");
        }
    }

    public GeneralNames getFullName() {
        return this.fullName;
    }

    public RDN getRelativeName() {
        return this.relativeName;
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream theChoice = new DerOutputStream();
        GeneralNames generalNames = this.fullName;
        if (generalNames != null) {
            generalNames.encode(theChoice);
            out.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 0), theChoice);
        } else {
            this.relativeName.encode(theChoice);
            out.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, true, (byte) 1), theChoice);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DistributionPointName)) {
            return false;
        }
        DistributionPointName other = (DistributionPointName) obj;
        return Objects.equals(this.fullName, other.fullName) && Objects.equals(this.relativeName, other.relativeName);
    }

    public int hashCode() {
        int hash = this.hashCode;
        if (hash == 0) {
            GeneralNames generalNames = this.fullName;
            hash = generalNames != null ? 1 + generalNames.hashCode() : 1 + this.relativeName.hashCode();
            this.hashCode = hash;
        }
        return hash;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.fullName != null) {
            sb2.append("DistributionPointName:\n     " + ((Object) this.fullName) + "\n");
        } else {
            sb2.append("DistributionPointName:\n     " + ((Object) this.relativeName) + "\n");
        }
        return sb2.toString();
    }
}
