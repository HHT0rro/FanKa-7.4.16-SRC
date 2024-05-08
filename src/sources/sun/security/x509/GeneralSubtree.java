package sun.security.x509;

import java.io.IOException;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GeneralSubtree {
    private static final int MIN_DEFAULT = 0;
    private static final byte TAG_MAX = 1;
    private static final byte TAG_MIN = 0;
    private int maximum;
    private int minimum;
    private int myhash = -1;
    private GeneralName name;

    public GeneralSubtree(GeneralName name, int min, int max) {
        this.minimum = 0;
        this.maximum = -1;
        this.name = name;
        this.minimum = min;
        this.maximum = max;
    }

    public GeneralSubtree(DerValue val) throws IOException {
        this.minimum = 0;
        this.maximum = -1;
        if (val.tag != 48) {
            throw new IOException("Invalid encoding for GeneralSubtree.");
        }
        this.name = new GeneralName(val.data.getDerValue(), true);
        while (val.data.available() != 0) {
            DerValue opt = val.data.getDerValue();
            if (opt.isContextSpecific((byte) 0) && !opt.isConstructed()) {
                opt.resetTag((byte) 2);
                this.minimum = opt.getInteger();
            } else if (opt.isContextSpecific((byte) 1) && !opt.isConstructed()) {
                opt.resetTag((byte) 2);
                this.maximum = opt.getInteger();
            } else {
                throw new IOException("Invalid encoding of GeneralSubtree.");
            }
        }
    }

    public GeneralName getName() {
        return this.name;
    }

    public int getMinimum() {
        return this.minimum;
    }

    public int getMaximum() {
        return this.maximum;
    }

    public String toString() {
        String s2;
        StringBuilder append = new StringBuilder().append("\n   GeneralSubtree: [\n    GeneralName: ");
        GeneralName generalName = this.name;
        String s10 = append.append(generalName == null ? "" : generalName.toString()).append("\n    Minimum: ").append(this.minimum).toString();
        if (this.maximum == -1) {
            s2 = s10 + "\t    Maximum: undefined";
        } else {
            s2 = s10 + "\t    Maximum: " + this.maximum;
        }
        return s2 + "    ]\n";
    }

    public boolean equals(Object other) {
        if (!(other instanceof GeneralSubtree)) {
            return false;
        }
        GeneralSubtree otherGS = (GeneralSubtree) other;
        GeneralName generalName = this.name;
        if (generalName == null) {
            if (otherGS.name != null) {
                return false;
            }
        } else if (!generalName.equals(otherGS.name)) {
            return false;
        }
        return this.minimum == otherGS.minimum && this.maximum == otherGS.maximum;
    }

    public int hashCode() {
        if (this.myhash == -1) {
            this.myhash = 17;
            GeneralName generalName = this.name;
            if (generalName != null) {
                this.myhash = (17 * 37) + generalName.hashCode();
            }
            int i10 = this.minimum;
            if (i10 != 0) {
                this.myhash = (this.myhash * 37) + i10;
            }
            int i11 = this.maximum;
            if (i11 != -1) {
                this.myhash = (this.myhash * 37) + i11;
            }
        }
        return this.myhash;
    }

    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream seq = new DerOutputStream();
        this.name.encode(seq);
        if (this.minimum != 0) {
            DerOutputStream tmp = new DerOutputStream();
            tmp.putInteger(this.minimum);
            seq.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 0), tmp);
        }
        if (this.maximum != -1) {
            DerOutputStream tmp2 = new DerOutputStream();
            tmp2.putInteger(this.maximum);
            seq.writeImplicit(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 1), tmp2);
        }
        out.write((byte) 48, seq);
    }
}
