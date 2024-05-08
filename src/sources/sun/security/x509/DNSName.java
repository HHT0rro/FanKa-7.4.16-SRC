package sun.security.x509;

import java.io.IOException;
import java.util.Locale;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DNSName implements GeneralNameInterface {
    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String alphaDigitsAndHyphen = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-";
    private static final String digitsAndHyphen = "0123456789-";
    private String name;

    public DNSName(DerValue derValue) throws IOException {
        this.name = derValue.getIA5String();
    }

    public DNSName(String name) throws IOException {
        if (name == null || name.length() == 0) {
            throw new IOException("DNS name must not be null");
        }
        if (name.indexOf(32) != -1) {
            throw new IOException("DNS names or NameConstraints with blank components are not permitted");
        }
        if (name.charAt(0) == '.' || name.charAt(name.length() - 1) == '.') {
            throw new IOException("DNS names or NameConstraints may not begin or end with a .");
        }
        int startIndex = 0;
        while (startIndex < name.length()) {
            int endIndex = name.indexOf(46, startIndex);
            endIndex = endIndex < 0 ? name.length() : endIndex;
            if (endIndex - startIndex < 1) {
                throw new IOException("DNSName SubjectAltNames with empty components are not permitted");
            }
            if (alpha.indexOf(name.charAt(startIndex)) < 0) {
                throw new IOException("DNSName components must begin with a letter");
            }
            for (int nonStartIndex = startIndex + 1; nonStartIndex < endIndex; nonStartIndex++) {
                char x10 = name.charAt(nonStartIndex);
                if (alphaDigitsAndHyphen.indexOf(x10) < 0) {
                    throw new IOException("DNSName components must consist of letters, digits, and hyphens");
                }
            }
            startIndex = endIndex + 1;
        }
        this.name = name;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public int getType() {
        return 2;
    }

    public String getName() {
        return this.name;
    }

    @Override // sun.security.x509.GeneralNameInterface
    public void encode(DerOutputStream out) throws IOException {
        out.putIA5String(this.name);
    }

    public String toString() {
        return "DNSName: " + this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DNSName)) {
            return false;
        }
        DNSName other = (DNSName) obj;
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
        if (constraintType3 != 2) {
            return -1;
        }
        String inName = ((DNSName) inputName).getName().toLowerCase(Locale.ENGLISH);
        String thisName = this.name.toLowerCase(Locale.ENGLISH);
        if (inName.equals(thisName)) {
            return 0;
        }
        if (thisName.endsWith(inName)) {
            int inNdx = thisName.lastIndexOf(inName);
            if (thisName.charAt(inNdx - 1) == '.') {
                constraintType2 = 2;
            } else {
                constraintType2 = 3;
            }
            return constraintType2;
        }
        if (inName.endsWith(thisName)) {
            int ndx = inName.lastIndexOf(thisName);
            if (inName.charAt(ndx - 1) == '.') {
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
        int sum = 1;
        int i10 = this.name.indexOf(46);
        while (i10 >= 0) {
            sum++;
            i10 = this.name.indexOf(46, i10 + 1);
        }
        return sum;
    }
}
