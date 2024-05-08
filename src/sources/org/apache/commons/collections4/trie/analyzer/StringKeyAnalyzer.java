package org.apache.commons.collections4.trie.analyzer;

import org.apache.commons.collections4.trie.KeyAnalyzer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class StringKeyAnalyzer extends KeyAnalyzer<String> {
    public static final StringKeyAnalyzer INSTANCE = new StringKeyAnalyzer();
    public static final int LENGTH = 16;
    private static final int MSB = 32768;
    private static final long serialVersionUID = -7032449491269434877L;

    private static int mask(int i10) {
        return 32768 >>> i10;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitsPerElement() {
        return 16;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitIndex(String str, int i10, int i11, String str2, int i12, int i13) {
        if (i10 % 16 == 0 && i12 % 16 == 0 && i11 % 16 == 0 && i13 % 16 == 0) {
            int i14 = i10 / 16;
            int i15 = i12 / 16;
            int i16 = (i11 / 16) + i14;
            int i17 = (i13 / 16) + i15;
            int max = Math.max(i16, i17);
            boolean z10 = true;
            for (int i18 = 0; i18 < max; i18++) {
                int i19 = i14 + i18;
                int i20 = i15 + i18;
                char charAt = i19 >= i16 ? (char) 0 : str.charAt(i19);
                if (charAt != ((str2 == null || i20 >= i17) ? (char) 0 : str2.charAt(i20))) {
                    return ((i18 * 16) + Integer.numberOfLeadingZeros(charAt ^ r5)) - 16;
                }
                if (charAt != 0) {
                    z10 = false;
                }
            }
            return z10 ? -1 : -2;
        }
        throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isBitSet(String str, int i10, int i11) {
        if (str == null || i10 >= i11) {
            return false;
        }
        return (str.charAt(i10 / 16) & mask(i10 % 16)) != 0;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public boolean isPrefix(String str, int i10, int i11, String str2) {
        if (i10 % 16 == 0 && i11 % 16 == 0) {
            return str2.startsWith(str.substring(i10 / 16, i11 / 16));
        }
        throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int lengthInBits(String str) {
        if (str != null) {
            return str.length() * 16;
        }
        return 0;
    }
}
