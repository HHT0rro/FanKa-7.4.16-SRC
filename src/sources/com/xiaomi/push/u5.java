package com.xiaomi.push;

import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class u5 {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f48402a = "&quot;".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f48403b = "&apos;".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f48404c = "&amp;".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f48405d = "&lt;".toCharArray();

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f48406e = "&gt;".toCharArray();

    /* renamed from: f, reason: collision with root package name */
    public static Random f48407f = new Random();

    /* renamed from: g, reason: collision with root package name */
    public static char[] f48408g = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String a(int i10) {
        if (i10 < 1) {
            return null;
        }
        char[] cArr = new char[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            cArr[i11] = f48408g[f48407f.nextInt(71)];
        }
        return new String(cArr);
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb2 = new StringBuilder((int) (length * 1.3d));
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            char c4 = charArray[i10];
            if (c4 <= '>') {
                if (c4 == '<') {
                    if (i10 > i11) {
                        sb2.append(charArray, i11, i10 - i11);
                    }
                    i11 = i10 + 1;
                    sb2.append(f48405d);
                } else if (c4 == '>') {
                    if (i10 > i11) {
                        sb2.append(charArray, i11, i10 - i11);
                    }
                    i11 = i10 + 1;
                    sb2.append(f48406e);
                } else if (c4 == '&') {
                    if (i10 > i11) {
                        sb2.append(charArray, i11, i10 - i11);
                    }
                    int i12 = i10 + 5;
                    if (length <= i12 || charArray[i10 + 1] != '#' || !Character.isDigit(charArray[i10 + 2]) || !Character.isDigit(charArray[i10 + 3]) || !Character.isDigit(charArray[i10 + 4]) || charArray[i12] != ';') {
                        i11 = i10 + 1;
                        sb2.append(f48404c);
                    }
                } else if (c4 == '\"') {
                    if (i10 > i11) {
                        sb2.append(charArray, i11, i10 - i11);
                    }
                    i11 = i10 + 1;
                    sb2.append(f48402a);
                } else if (c4 == '\'') {
                    if (i10 > i11) {
                        sb2.append(charArray, i11, i10 - i11);
                    }
                    i11 = i10 + 1;
                    sb2.append(f48403b);
                }
            }
            i10++;
        }
        if (i11 == 0) {
            return str;
        }
        if (i10 > i11) {
            sb2.append(charArray, i11, i10 - i11);
        }
        return sb2.toString();
    }

    public static final String c(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb2 = new StringBuilder(charArray.length);
        sb2.append(charArray, 0, indexOf);
        sb2.append(charArray2);
        int i10 = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i10);
            if (indexOf2 <= 0) {
                sb2.append(charArray, i10, charArray.length - i10);
                return sb2.toString();
            }
            sb2.append(charArray, i10, indexOf2 - i10);
            sb2.append(charArray2);
            i10 = indexOf2 + length;
        }
    }

    public static String d(byte[] bArr) {
        return String.valueOf(m0.e(bArr));
    }

    public static final String e(String str) {
        return c(c(c(c(c(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }
}
