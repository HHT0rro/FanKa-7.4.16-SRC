package sun.security.x509;

import java.io.IOException;
import java.util.Locale;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class RFC822Name implements GeneralNameInterface {
    private String name;

    public RFC822Name(DerValue derValue) throws IOException {
        String iA5String = derValue.getIA5String();
        this.name = iA5String;
        parseName(iA5String);
    }

    public RFC822Name(String name) throws IOException {
        parseName(name);
        this.name = name;
    }

    public void parseName(String name) throws IOException {
        if (name == null || name.length() == 0) {
            throw new IOException("RFC822Name may not be null or empty");
        }
        String domain = name.substring(name.indexOf(64) + 1);
        if (domain.length() == 0) {
            throw new IOException("RFC822Name may not end with @");
        }
        if (domain.startsWith(".") && domain.length() == 1) {
            throw new IOException("RFC822Name domain may not be just .");
        }
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int getType() {
        return 1;
    }

    public String getName() {
        return this.name;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public void encode(DerOutputStream out) throws IOException {
        out.putIA5String(this.name);
    }

    public String toString() {
        return "RFC822Name: " + this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFC822Name)) {
            return false;
        }
        RFC822Name other = (RFC822Name) obj;
        return this.name.equalsIgnoreCase(other.name);
    }

    public int hashCode() {
        return this.name.toUpperCase(Locale.ENGLISH).hashCode();
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int constrains(GeneralNameInterface inputName) throws UnsupportedOperationException {
        int constraintType;
        int constraintType2;
        if (inputName == null) {
            return -1;
        }
        int constraintType3 = inputName.getType();
        if (constraintType3 != 1) {
            return -1;
        }
        String inName = ((RFC822Name) inputName).getName().toLowerCase(Locale.ENGLISH);
        String thisName = this.name.toLowerCase(Locale.ENGLISH);
        if (inName.equals(thisName)) {
            return 0;
        }
        if (thisName.endsWith(inName)) {
            if (inName.indexOf(64) != -1) {
                return 3;
            }
            if (inName.startsWith(".")) {
                return 2;
            }
            int inNdx = thisName.lastIndexOf(inName);
            if (thisName.charAt(inNdx - 1) == '@') {
                constraintType2 = 2;
            } else {
                constraintType2 = 3;
            }
            return constraintType2;
        }
        if (inName.endsWith(thisName) && thisName.indexOf(64) == -1) {
            if (thisName.startsWith(".")) {
                return 1;
            }
            int ndx = inName.lastIndexOf(thisName);
            if (inName.charAt(ndx - 1) == '@') {
                constraintType = 1;
            } else {
                constraintType = 3;
            }
            return constraintType;
        }
        return 3;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int subtreeDepth() throws UnsupportedOperationException {
        String subtree = this.name;
        int i10 = 1;
        int atNdx = subtree.lastIndexOf(64);
        if (atNdx >= 0) {
            i10 = 1 + 1;
            subtree = subtree.substring(atNdx + 1);
        }
        while (subtree.lastIndexOf(46) >= 0) {
            subtree = subtree.substring(0, subtree.lastIndexOf(46));
            i10++;
        }
        return i10;
    }
}
