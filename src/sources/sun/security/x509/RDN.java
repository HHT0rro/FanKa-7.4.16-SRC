package sun.security.x509;

import com.google.android.material.badge.BadgeDrawable;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import javax.security.auth.x500.X500Principal;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class RDN {
    final AVA[] assertion;
    private volatile List<AVA> avaList;
    private volatile String canonicalString;

    public RDN(String name) throws IOException {
        this(name, (Map<String, String>) Collections.emptyMap());
    }

    public RDN(String name, Map<String, String> keywordMap) throws IOException {
        int quoteCount = 0;
        int searchOffset = 0;
        int avaOffset = 0;
        List<AVA> avaVec = new ArrayList<>(3);
        int nextPlus = name.indexOf(43);
        while (nextPlus >= 0) {
            quoteCount += X500Name.countQuotes(name, searchOffset, nextPlus);
            if (nextPlus > 0 && name.charAt(nextPlus - 1) != '\\' && quoteCount != 1) {
                String avaString = name.substring(avaOffset, nextPlus);
                if (avaString.length() == 0) {
                    throw new IOException("empty AVA in RDN \"" + name + "\"");
                }
                AVA ava = new AVA(new StringReader(avaString), keywordMap);
                avaVec.add(ava);
                avaOffset = nextPlus + 1;
                quoteCount = 0;
            }
            searchOffset = nextPlus + 1;
            nextPlus = name.indexOf(43, searchOffset);
        }
        String avaString2 = name.substring(avaOffset);
        if (avaString2.length() == 0) {
            throw new IOException("empty AVA in RDN \"" + name + "\"");
        }
        AVA ava2 = new AVA(new StringReader(avaString2), keywordMap);
        avaVec.add(ava2);
        this.assertion = (AVA[]) avaVec.toArray(new AVA[avaVec.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RDN(String name, String format) throws IOException {
        this(name, format, Collections.emptyMap());
    }

    RDN(String name, String format, Map<String, String> keywordMap) throws IOException {
        if (!format.equalsIgnoreCase(X500Principal.RFC2253)) {
            throw new IOException("Unsupported format " + format);
        }
        int avaOffset = 0;
        List<AVA> avaVec = new ArrayList<>(3);
        int nextPlus = name.indexOf(43);
        while (nextPlus >= 0) {
            if (nextPlus > 0 && name.charAt(nextPlus - 1) != '\\') {
                String avaString = name.substring(avaOffset, nextPlus);
                if (avaString.length() == 0) {
                    throw new IOException("empty AVA in RDN \"" + name + "\"");
                }
                AVA ava = new AVA(new StringReader(avaString), 3, keywordMap);
                avaVec.add(ava);
                avaOffset = nextPlus + 1;
            }
            int searchOffset = nextPlus + 1;
            nextPlus = name.indexOf(43, searchOffset);
        }
        String avaString2 = name.substring(avaOffset);
        if (avaString2.length() == 0) {
            throw new IOException("empty AVA in RDN \"" + name + "\"");
        }
        AVA ava2 = new AVA(new StringReader(avaString2), 3, keywordMap);
        avaVec.add(ava2);
        this.assertion = (AVA[]) avaVec.toArray(new AVA[avaVec.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RDN(DerValue rdn) throws IOException {
        if (rdn.tag != 49) {
            throw new IOException("X500 RDN");
        }
        DerInputStream dis = new DerInputStream(rdn.toByteArray());
        DerValue[] avaset = dis.getSet(5);
        this.assertion = new AVA[avaset.length];
        for (int i10 = 0; i10 < avaset.length; i10++) {
            this.assertion[i10] = new AVA(avaset[i10]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RDN(int i10) {
        this.assertion = new AVA[i10];
    }

    public RDN(AVA ava) {
        if (ava == null) {
            throw new NullPointerException();
        }
        this.assertion = new AVA[]{ava};
    }

    public RDN(AVA[] avas) {
        this.assertion = (AVA[]) avas.clone();
        int i10 = 0;
        while (true) {
            AVA[] avaArr = this.assertion;
            if (i10 < avaArr.length) {
                if (avaArr[i10] != null) {
                    i10++;
                } else {
                    throw new NullPointerException();
                }
            } else {
                return;
            }
        }
    }

    public List<AVA> avas() {
        List<AVA> list = this.avaList;
        if (list == null) {
            List<AVA> list2 = Collections.unmodifiableList(Arrays.asList(this.assertion));
            this.avaList = list2;
            return list2;
        }
        return list;
    }

    public int size() {
        return this.assertion.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RDN)) {
            return false;
        }
        RDN other = (RDN) obj;
        if (this.assertion.length != other.assertion.length) {
            return false;
        }
        String thisCanon = toRFC2253String(true);
        String otherCanon = other.toRFC2253String(true);
        return thisCanon.equals(otherCanon);
    }

    public int hashCode() {
        return toRFC2253String(true).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DerValue findAttribute(ObjectIdentifier oid) {
        int i10 = 0;
        while (true) {
            AVA[] avaArr = this.assertion;
            if (i10 < avaArr.length) {
                if (!avaArr[i10].oid.equals((Object) oid)) {
                    i10++;
                } else {
                    return this.assertion[i10].value;
                }
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(DerOutputStream out) throws IOException {
        out.putOrderedSetOf((byte) 49, this.assertion);
    }

    public String toString() {
        AVA[] avaArr = this.assertion;
        if (avaArr.length == 1) {
            return avaArr[0].toString();
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.assertion.length; i10++) {
            if (i10 != 0) {
                sb2.append(" + ");
            }
            sb2.append(this.assertion[i10].toString());
        }
        return sb2.toString();
    }

    public String toRFC1779String() {
        return toRFC1779String(Collections.emptyMap());
    }

    public String toRFC1779String(Map<String, String> oidMap) {
        AVA[] avaArr = this.assertion;
        if (avaArr.length == 1) {
            return avaArr[0].toRFC1779String(oidMap);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.assertion.length; i10++) {
            if (i10 != 0) {
                sb2.append(" + ");
            }
            sb2.append(this.assertion[i10].toRFC1779String(oidMap));
        }
        return sb2.toString();
    }

    public String toRFC2253String() {
        return toRFC2253StringInternal(false, Collections.emptyMap());
    }

    public String toRFC2253String(Map<String, String> oidMap) {
        return toRFC2253StringInternal(false, oidMap);
    }

    public String toRFC2253String(boolean canonical) {
        if (!canonical) {
            return toRFC2253StringInternal(false, Collections.emptyMap());
        }
        String c4 = this.canonicalString;
        if (c4 == null) {
            String c10 = toRFC2253StringInternal(true, Collections.emptyMap());
            this.canonicalString = c10;
            return c10;
        }
        return c4;
    }

    private String toRFC2253StringInternal(boolean canonical, Map<String, String> oidMap) {
        AVA[] avaArr = this.assertion;
        if (avaArr.length == 1) {
            return canonical ? avaArr[0].toRFC2253CanonicalString() : avaArr[0].toRFC2253String(oidMap);
        }
        AVA[] toOutput = this.assertion;
        if (canonical) {
            toOutput = (AVA[]) avaArr.clone();
            Arrays.sort(toOutput, AVAComparator.getInstance());
        }
        StringJoiner sj = new StringJoiner(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        for (AVA ava : toOutput) {
            sj.add(canonical ? ava.toRFC2253CanonicalString() : ava.toRFC2253String(oidMap));
        }
        return sj.toString();
    }
}
