package sun.security.x509;

import java.io.IOException;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class EDIPartyName implements GeneralNameInterface {
    private static final byte TAG_ASSIGNER = 0;
    private static final byte TAG_PARTYNAME = 1;
    private String assigner;
    private int myhash;
    private String party;

    public EDIPartyName(String assignerName, String partyName) {
        this.assigner = null;
        this.party = null;
        this.myhash = -1;
        this.assigner = assignerName;
        this.party = partyName;
    }

    public EDIPartyName(String partyName) {
        this.assigner = null;
        this.party = null;
        this.myhash = -1;
        this.party = partyName;
    }

    public EDIPartyName(DerValue derValue) throws IOException {
        this.assigner = null;
        this.party = null;
        this.myhash = -1;
        DerInputStream in = new DerInputStream(derValue.toByteArray());
        DerValue[] seq = in.getSequence(2);
        int len = seq.length;
        if (len < 1 || len > 2) {
            throw new IOException("Invalid encoding of EDIPartyName");
        }
        for (int i10 = 0; i10 < len; i10++) {
            DerValue opt = seq[i10];
            if (opt.isContextSpecific((byte) 0) && !opt.isConstructed()) {
                if (this.assigner != null) {
                    throw new IOException("Duplicate nameAssigner found in EDIPartyName");
                }
                opt = opt.data.getDerValue();
                this.assigner = opt.getAsString();
            }
            if (opt.isContextSpecific((byte) 1) && !opt.isConstructed()) {
                if (this.party != null) {
                    throw new IOException("Duplicate partyName found in EDIPartyName");
                }
                this.party = opt.data.getDerValue().getAsString();
            }
        }
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int getType() {
        return 5;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public void encode(DerOutputStream out) throws IOException {
        DerOutputStream tagged = new DerOutputStream();
        DerOutputStream tmp = new DerOutputStream();
        if (this.assigner != null) {
            DerOutputStream tmp2 = new DerOutputStream();
            tmp2.putPrintableString(this.assigner);
            tagged.write(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 0), tmp2);
        }
        String str = this.party;
        if (str == null) {
            throw new IOException("Cannot have null partyName");
        }
        tmp.putPrintableString(str);
        tagged.write(DerValue.createTag(Byte.MIN_VALUE, false, (byte) 1), tmp);
        out.write((byte) 48, tagged);
    }

    public String getAssignerName() {
        return this.assigner;
    }

    public String getPartyName() {
        return this.party;
    }

    public boolean equals(Object other) {
        if (!(other instanceof EDIPartyName)) {
            return false;
        }
        String otherAssigner = ((EDIPartyName) other).assigner;
        String str = this.assigner;
        if (str == null) {
            if (otherAssigner != null) {
                return false;
            }
        } else if (!str.equals(otherAssigner)) {
            return false;
        }
        String otherParty = ((EDIPartyName) other).party;
        String str2 = this.party;
        return str2 == null ? otherParty == null : str2.equals(otherParty);
    }

    public int hashCode() {
        if (this.myhash == -1) {
            String str = this.party;
            int hashCode = (str == null ? 1 : str.hashCode()) + 37;
            this.myhash = hashCode;
            String str2 = this.assigner;
            if (str2 != null) {
                this.myhash = (hashCode * 37) + str2.hashCode();
            }
        }
        return this.myhash;
    }

    public String toString() {
        return "EDIPartyName: " + (this.assigner == null ? "" : "  nameAssigner = " + this.assigner + ",") + "  partyName = " + this.party;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int constrains(GeneralNameInterface inputName) throws UnsupportedOperationException {
        if (inputName == null) {
            return -1;
        }
        int constraintType = inputName.getType();
        if (constraintType != 5) {
            return -1;
        }
        throw new UnsupportedOperationException("Narrowing, widening, and matching of names not supported for EDIPartyName");
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int subtreeDepth() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("subtreeDepth() not supported for EDIPartyName");
    }
}
