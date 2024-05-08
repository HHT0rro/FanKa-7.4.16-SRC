package com.bytedance.pangle.res.a;

import java.io.EOFException;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {
    private static <T> T a(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static void a(InputStream inputStream, byte[] bArr, int i10, int i11) {
        a(inputStream);
        a(bArr);
        int i12 = 0;
        if (i11 >= 0) {
            int i13 = i10 + i11;
            int length = bArr.length;
            if (i10 < 0 || i13 < i10 || i13 > length) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10);
                sb2.append(i13);
                sb2.append(length);
                throw new IndexOutOfBoundsException(sb2.toString());
            }
            while (i12 < i11) {
                int read = inputStream.read(bArr, i10 + i12, i11 - i12);
                if (read == -1) {
                    break;
                } else {
                    i12 += read;
                }
            }
            if (i12 == i11) {
                return;
            }
            throw new EOFException("reached end of stream after reading " + i12 + " bytes; " + i11 + " bytes expected");
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i11)));
    }
}
