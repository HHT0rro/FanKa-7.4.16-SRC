package sun.security.x509;

import java.io.IOException;
import java.util.Enumeration;
import sun.security.util.BitArray;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ReasonFlags {
    private boolean[] bitString;
    public static final String UNUSED = "unused";
    public static final String KEY_COMPROMISE = "key_compromise";
    public static final String CA_COMPROMISE = "ca_compromise";
    public static final String AFFILIATION_CHANGED = "affiliation_changed";
    public static final String SUPERSEDED = "superseded";
    public static final String CESSATION_OF_OPERATION = "cessation_of_operation";
    public static final String CERTIFICATE_HOLD = "certificate_hold";
    public static final String PRIVILEGE_WITHDRAWN = "privilege_withdrawn";
    public static final String AA_COMPROMISE = "aa_compromise";
    private static final String[] NAMES = {UNUSED, KEY_COMPROMISE, CA_COMPROMISE, AFFILIATION_CHANGED, SUPERSEDED, CESSATION_OF_OPERATION, CERTIFICATE_HOLD, PRIVILEGE_WITHDRAWN, AA_COMPROMISE};

    private static int name2Index(String name) throws IOException {
        int i10 = 0;
        while (true) {
            String[] strArr = NAMES;
            if (i10 < strArr.length) {
                if (!strArr[i10].equalsIgnoreCase(name)) {
                    i10++;
                } else {
                    return i10;
                }
            } else {
                throw new IOException("Name not recognized by ReasonFlags");
            }
        }
    }

    private boolean isSet(int position) {
        boolean[] zArr = this.bitString;
        return position < zArr.length && zArr[position];
    }

    private void set(int position, boolean val) {
        boolean[] zArr = this.bitString;
        if (position >= zArr.length) {
            boolean[] tmp = new boolean[position + 1];
            System.arraycopy((Object) zArr, 0, (Object) tmp, 0, zArr.length);
            this.bitString = tmp;
        }
        this.bitString[position] = val;
    }

    public ReasonFlags(byte[] reasons) {
        this.bitString = new BitArray(reasons.length * 8, reasons).toBooleanArray();
    }

    public ReasonFlags(boolean[] reasons) {
        this.bitString = reasons;
    }

    public ReasonFlags(BitArray reasons) {
        this.bitString = reasons.toBooleanArray();
    }

    public ReasonFlags(DerInputStream in) throws IOException {
        DerValue derVal = in.getDerValue();
        this.bitString = derVal.getUnalignedBitString(true).toBooleanArray();
    }

    public ReasonFlags(DerValue derVal) throws IOException {
        this.bitString = derVal.getUnalignedBitString(true).toBooleanArray();
    }

    public boolean[] getFlags() {
        return this.bitString;
    }

    public void set(String name, Object obj) throws IOException {
        if (!(obj instanceof Boolean)) {
            throw new IOException("Attribute must be of type Boolean.");
        }
        boolean val = ((Boolean) obj).booleanValue();
        set(name2Index(name), val);
    }

    public Object get(String name) throws IOException {
        return Boolean.valueOf(isSet(name2Index(name)));
    }

    public void delete(String name) throws IOException {
        set(name, Boolean.FALSE);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Reason Flags [\n");
        if (isSet(0)) {
            sb2.append("  Unused\n");
        }
        if (isSet(1)) {
            sb2.append("  Key Compromise\n");
        }
        if (isSet(2)) {
            sb2.append("  CA Compromise\n");
        }
        if (isSet(3)) {
            sb2.append("  Affiliation_Changed\n");
        }
        if (isSet(4)) {
            sb2.append("  Superseded\n");
        }
        if (isSet(5)) {
            sb2.append("  Cessation Of Operation\n");
        }
        if (isSet(6)) {
            sb2.append("  Certificate Hold\n");
        }
        if (isSet(7)) {
            sb2.append("  Privilege Withdrawn\n");
        }
        if (isSet(8)) {
            sb2.append("  AA Compromise\n");
        }
        sb2.append("]\n");
        return sb2.toString();
    }

    public void encode(DerOutputStream out) throws IOException {
        out.putTruncatedUnalignedBitString(new BitArray(this.bitString));
    }

    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        int i10 = 0;
        while (true) {
            String[] strArr = NAMES;
            if (i10 < strArr.length) {
                elements.addElement(strArr[i10]);
                i10++;
            } else {
                return elements.elements();
            }
        }
    }
}
