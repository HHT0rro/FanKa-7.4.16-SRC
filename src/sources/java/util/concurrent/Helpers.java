package java.util.concurrent;

import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class Helpers {
    private Helpers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String collectionToString(Collection<?> c4) {
        Object[] a10 = c4.toArray();
        int size = a10.length;
        if (size == 0) {
            return "[]";
        }
        int charLength = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Object e2 = a10[i10];
            String s2 = e2 == c4 ? "(this Collection)" : objectToString(e2);
            a10[i10] = s2;
            charLength += s2.length();
        }
        return toString(a10, size, charLength);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(Object[] a10, int size, int charLength) {
        char[] chars = new char[(size * 2) + charLength];
        chars[0] = '[';
        int j10 = 1;
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                int j11 = j10 + 1;
                chars[j10] = ',';
                j10 = j11 + 1;
                chars[j11] = ' ';
            }
            String s2 = (String) a10[i10];
            int len = s2.length();
            s2.getChars(0, len, chars, j10);
            j10 += len;
        }
        chars[j10] = ']';
        return new String(chars);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String mapEntryToString(Object key, Object val) {
        String k10 = objectToString(key);
        int klen = k10.length();
        String v2 = objectToString(val);
        int vlen = v2.length();
        char[] chars = new char[klen + vlen + 1];
        k10.getChars(0, klen, chars, 0);
        chars[klen] = '=';
        v2.getChars(0, vlen, chars, klen + 1);
        return new String(chars);
    }

    private static String objectToString(Object x10) {
        String obj;
        return (x10 == null || (obj = x10.toString()) == null) ? "null" : obj;
    }
}
