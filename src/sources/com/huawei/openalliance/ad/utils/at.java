package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.gl;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class at {
    public static String Code(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toString("UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void Code(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                gl.I("StmUt", "close " + th.getClass().getSimpleName());
            }
        }
    }
}
