package sun.misc;

import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ASCIICaseInsensitiveComparator implements Comparator<String> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Comparator<String> CASE_INSENSITIVE_ORDER = new ASCIICaseInsensitiveComparator();

    @Override // java.util.Comparator
    public int compare(String s12, String s2) {
        char c12;
        char c22;
        int n12 = s12.length();
        int n22 = s2.length();
        int minLen = n12 < n22 ? n12 : n22;
        for (int i10 = 0; i10 < minLen; i10++) {
            char c13 = s12.charAt(i10);
            char c23 = s2.charAt(i10);
            if (c13 != c23 && (c12 = (char) toLower(c13)) != (c22 = (char) toLower(c23))) {
                return c12 - c22;
            }
        }
        int i11 = n12 - n22;
        return i11;
    }

    public static int lowerCaseHashCode(String s2) {
        int h10 = 0;
        int len = s2.length();
        for (int i10 = 0; i10 < len; i10++) {
            h10 = (h10 * 31) + toLower(s2.charAt(i10));
        }
        return h10;
    }

    static boolean isLower(int ch) {
        return ((ch + (-97)) | (122 - ch)) >= 0;
    }

    static boolean isUpper(int ch) {
        return ((ch + (-65)) | (90 - ch)) >= 0;
    }

    static int toLower(int ch) {
        return isUpper(ch) ? ch + 32 : ch;
    }

    static int toUpper(int ch) {
        return isLower(ch) ? ch - 32 : ch;
    }
}
