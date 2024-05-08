package com.tencent.cloud.huiyansdkface.okio;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i10, int i11) {
        long j10;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
        long j11 = 0;
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (charAt < 128) {
                j11++;
            } else {
                if (charAt < 2048) {
                    j10 = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    j10 = 3;
                } else {
                    int i12 = i10 + 1;
                    char charAt2 = i12 < i11 ? str.charAt(i12) : (char) 0;
                    if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                        j11++;
                        i10 = i12;
                    } else {
                        j11 += 4;
                        i10 += 2;
                    }
                }
                j11 += j10;
            }
            i10++;
        }
        return j11;
    }
}
