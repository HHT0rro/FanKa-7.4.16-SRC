package com.tencent.liteav.base.util;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    public static long a(File file, int i10) {
        long length;
        long j10 = 0;
        if (i10 <= 0) {
            return 0L;
        }
        try {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = a(file2, i10 - 1);
                } else {
                    length = file2.length();
                }
                j10 += length;
            }
        } catch (Exception e2) {
            LiteavLog.i("FileUtil", "getFolderSize exception " + e2.toString());
        }
        return j10;
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
