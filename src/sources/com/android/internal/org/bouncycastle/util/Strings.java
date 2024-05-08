package com.android.internal.org.bouncycastle.util;

import com.android.internal.org.bouncycastle.util.encoders.UTF8;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class Strings {
    private static String LINE_SEPARATOR;

    static {
        try {
            LINE_SEPARATOR = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: com.android.internal.org.bouncycastle.util.Strings.1
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.getProperty("line.separator");
                }
            });
        } catch (Exception e2) {
            try {
                LINE_SEPARATOR = String.format("%n", new Object[0]);
            } catch (Exception e10) {
                LINE_SEPARATOR = "\n";
            }
        }
    }

    public static String fromUTF8ByteArray(byte[] bytes) {
        char[] chars = new char[bytes.length];
        int len = UTF8.transcodeToUTF16(bytes, chars);
        if (len < 0) {
            throw new IllegalArgumentException("Invalid UTF-8 input");
        }
        return new String(chars, 0, len);
    }

    public static byte[] toUTF8ByteArray(String string) {
        return toUTF8ByteArray(string.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] string) {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        try {
            toUTF8ByteArray(string, bOut);
            return bOut.toByteArray();
        } catch (IOException e2) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }

    public static void toUTF8ByteArray(char[] string, OutputStream sOut) throws IOException {
        int i10 = 0;
        while (i10 < string.length) {
            char ch = string[i10];
            if (ch < 128) {
                sOut.write(ch);
            } else if (ch < 2048) {
                sOut.write((ch >> 6) | 192);
                sOut.write(128 | (ch & '?'));
            } else if (ch >= 55296 && ch <= 57343) {
                if (i10 + 1 >= string.length) {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                i10++;
                char ch2 = string[i10];
                if (ch <= 56319) {
                    int codePoint = (((ch & 1023) << 10) | (ch2 & 1023)) + 65536;
                    sOut.write((codePoint >> 18) | 240);
                    sOut.write(((codePoint >> 12) & 63) | 128);
                    sOut.write(((codePoint >> 6) & 63) | 128);
                    sOut.write(128 | (codePoint & 63));
                } else {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
            } else {
                sOut.write((ch >> '\f') | 224);
                sOut.write(((ch >> 6) & 63) | 128);
                sOut.write(128 | (ch & '?'));
            }
            i10++;
        }
    }

    public static String toUpperCase(String string) {
        boolean changed = false;
        char[] chars = string.toCharArray();
        for (int i10 = 0; i10 != chars.length; i10++) {
            char ch = chars[i10];
            if ('a' <= ch && 'z' >= ch) {
                changed = true;
                chars[i10] = (char) ((ch - 'a') + 65);
            }
        }
        if (changed) {
            return new String(chars);
        }
        return string;
    }

    public static String toLowerCase(String string) {
        boolean changed = false;
        char[] chars = string.toCharArray();
        for (int i10 = 0; i10 != chars.length; i10++) {
            char ch = chars[i10];
            if ('A' <= ch && 'Z' >= ch) {
                changed = true;
                chars[i10] = (char) ((ch - 'A') + 97);
            }
        }
        if (changed) {
            return new String(chars);
        }
        return string;
    }

    public static byte[] toByteArray(char[] chars) {
        byte[] bytes = new byte[chars.length];
        for (int i10 = 0; i10 != bytes.length; i10++) {
            bytes[i10] = (byte) chars[i10];
        }
        return bytes;
    }

    public static byte[] toByteArray(String string) {
        byte[] bytes = new byte[string.length()];
        for (int i10 = 0; i10 != bytes.length; i10++) {
            char ch = string.charAt(i10);
            bytes[i10] = (byte) ch;
        }
        return bytes;
    }

    public static int toByteArray(String s2, byte[] buf, int off) {
        int count = s2.length();
        for (int i10 = 0; i10 < count; i10++) {
            char c4 = s2.charAt(i10);
            buf[off + i10] = (byte) c4;
        }
        return count;
    }

    public static String fromByteArray(byte[] bytes) {
        return new String(asCharArray(bytes));
    }

    public static char[] asCharArray(byte[] bytes) {
        char[] chars = new char[bytes.length];
        for (int i10 = 0; i10 != chars.length; i10++) {
            chars[i10] = (char) (bytes[i10] & 255);
        }
        return chars;
    }

    public static String[] split(String input, char delimiter) {
        Vector v2 = new Vector();
        boolean moreTokens = true;
        while (moreTokens) {
            int tokenLocation = input.indexOf(delimiter);
            if (tokenLocation > 0) {
                String subString = input.substring(0, tokenLocation);
                v2.addElement(subString);
                input = input.substring(tokenLocation + 1);
            } else {
                moreTokens = false;
                v2.addElement(input);
            }
        }
        String[] res = new String[v2.size()];
        for (int i10 = 0; i10 != res.length; i10++) {
            res[i10] = (String) v2.elementAt(i10);
        }
        return res;
    }

    public static StringList newList() {
        return new StringListImpl();
    }

    public static String lineSeparator() {
        return LINE_SEPARATOR;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class StringListImpl extends ArrayList<String> implements StringList {
        private StringListImpl() {
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ String get(int i10) {
            return (String) super.get(i10);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(String s2) {
            return super.add((StringListImpl) s2);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public String set(int index, String element) {
            return (String) super.set(index, (int) element);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public void add(int index, String element) {
            super.add(index, (int) element);
        }

        @Override // com.android.internal.org.bouncycastle.util.StringList
        public String[] toStringArray() {
            String[] strs = new String[size()];
            for (int i10 = 0; i10 != strs.length; i10++) {
                strs[i10] = (String) get(i10);
            }
            return strs;
        }

        @Override // com.android.internal.org.bouncycastle.util.StringList
        public String[] toStringArray(int from, int to) {
            String[] strs = new String[to - from];
            for (int i10 = from; i10 != size() && i10 != to; i10++) {
                strs[i10 - from] = (String) get(i10);
            }
            return strs;
        }
    }
}
