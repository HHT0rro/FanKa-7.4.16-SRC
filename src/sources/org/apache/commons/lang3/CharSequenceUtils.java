package org.apache.commons.lang3;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CharSequenceUtils {
    private static final int NOT_FOUND = -1;

    public static int indexOf(CharSequence charSequence, int i10, int i11) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(i10, i11);
        }
        int length = charSequence.length();
        if (i11 < 0) {
            i11 = 0;
        }
        if (i10 < 65536) {
            for (int i12 = i11; i12 < length; i12++) {
                if (charSequence.charAt(i12) == i10) {
                    return i12;
                }
            }
        }
        if (i10 > 1114111) {
            return -1;
        }
        char[] chars = Character.toChars(i10);
        while (i11 < length - 1) {
            char charAt = charSequence.charAt(i11);
            int i13 = i11 + 1;
            char charAt2 = charSequence.charAt(i13);
            if (charAt == chars[0] && charAt2 == chars[1]) {
                return i11;
            }
            i11 = i13;
        }
        return -1;
    }

    public static int lastIndexOf(CharSequence charSequence, int i10, int i11) {
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(i10, i11);
        }
        int length = charSequence.length();
        if (i11 < 0) {
            return -1;
        }
        if (i11 >= length) {
            i11 = length - 1;
        }
        if (i10 < 65536) {
            for (int i12 = i11; i12 >= 0; i12--) {
                if (charSequence.charAt(i12) == i10) {
                    return i12;
                }
            }
        }
        if (i10 <= 1114111) {
            char[] chars = Character.toChars(i10);
            if (i11 == length - 1) {
                return -1;
            }
            while (i11 >= 0) {
                char charAt = charSequence.charAt(i11);
                char charAt2 = charSequence.charAt(i11 + 1);
                if (chars[0] == charAt && chars[1] == charAt2) {
                    return i11;
                }
                i11--;
            }
        }
        return -1;
    }

    public static boolean regionMatches(CharSequence charSequence, boolean z10, int i10, CharSequence charSequence2, int i11, int i12) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z10, i10, (String) charSequence2, i11, i12);
        }
        int length = charSequence.length() - i10;
        int length2 = charSequence2.length() - i11;
        if (i10 < 0 || i11 < 0 || i12 < 0 || length < i12 || length2 < i12) {
            return false;
        }
        while (true) {
            int i13 = i12 - 1;
            if (i12 <= 0) {
                return true;
            }
            int i14 = i10 + 1;
            char charAt = charSequence.charAt(i10);
            int i15 = i11 + 1;
            char charAt2 = charSequence2.charAt(i11);
            if (charAt != charAt2) {
                if (!z10) {
                    return false;
                }
                if (Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                    return false;
                }
            }
            i10 = i14;
            i12 = i13;
            i11 = i15;
        }
    }

    public static CharSequence subSequence(CharSequence charSequence, int i10) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.subSequence(i10, charSequence.length());
    }

    public static char[] toCharArray(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = charSequence.charAt(i10);
        }
        return cArr;
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i10) {
        return charSequence.toString().indexOf(charSequence2.toString(), i10);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i10) {
        return charSequence.toString().lastIndexOf(charSequence2.toString(), i10);
    }
}
