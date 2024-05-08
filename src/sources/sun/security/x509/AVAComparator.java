package sun.security.x509;

import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: RDN.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class AVAComparator implements Comparator<AVA> {
    private static final Comparator<AVA> INSTANCE = new AVAComparator();

    private AVAComparator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Comparator<AVA> getInstance() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(AVA a12, AVA a22) {
        boolean a1Has2253 = a12.hasRFC2253Keyword();
        boolean a2Has2253 = a22.hasRFC2253Keyword();
        if (a1Has2253) {
            if (a2Has2253) {
                return a12.toRFC2253CanonicalString().compareTo(a22.toRFC2253CanonicalString());
            }
            return -1;
        }
        if (a2Has2253) {
            return 1;
        }
        int[] a1Oid = a12.getObjectIdentifier().toIntArray();
        int[] a2Oid = a22.getObjectIdentifier().toIntArray();
        int pos = 0;
        int len = a1Oid.length > a2Oid.length ? a2Oid.length : a1Oid.length;
        while (pos < len && a1Oid[pos] == a2Oid[pos]) {
            pos++;
        }
        return pos == len ? a1Oid.length - a2Oid.length : a1Oid[pos] - a2Oid[pos];
    }
}
