package com.google.common.base;

/* compiled from: Ascii.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class a {
    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int b4;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = charSequence.charAt(i10);
            char charAt2 = charSequence2.charAt(i10);
            if (charAt != charAt2 && ((b4 = b(charAt)) >= 26 || b4 != b(charAt2))) {
                return false;
            }
        }
        return true;
    }

    public static int b(char c4) {
        return (char) ((c4 | ' ') - 97);
    }

    public static boolean c(char c4) {
        return c4 >= 'a' && c4 <= 'z';
    }

    public static boolean d(char c4) {
        return c4 >= 'A' && c4 <= 'Z';
    }

    public static String e(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (d(str.charAt(i10))) {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c4 = charArray[i10];
                    if (d(c4)) {
                        charArray[i10] = (char) (c4 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }

    public static char f(char c4) {
        return c(c4) ? (char) (c4 ^ ' ') : c4;
    }

    public static String g(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (c(str.charAt(i10))) {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c4 = charArray[i10];
                    if (c(c4)) {
                        charArray[i10] = (char) (c4 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }
}
