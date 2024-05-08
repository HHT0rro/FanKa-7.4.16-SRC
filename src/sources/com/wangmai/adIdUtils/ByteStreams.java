package com.wangmai.adIdUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ByteStreams {
    public static long copy(InputStream inputStream, OutputStream outputStream) {
        long j10 = 0;
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j10 += read;
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("copy--");
            sb2.append(th.toString());
        }
        return j10;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(inputStream, byteArrayOutputStream);
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("byte--");
            sb2.append(th.toString());
        }
        return byteArrayOutputStream.toByteArray();
    }
}
