package com.sina.weibo.sdk.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g implements f {
    private int code;

    /* renamed from: p, reason: collision with root package name */
    private InputStream f38358p;

    public g(int i10, InputStream inputStream) {
        this.code = i10;
        this.f38358p = inputStream;
    }

    @Override // com.sina.weibo.sdk.net.f
    public final String i() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.f38358p.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (IOException e2) {
            throw e2;
        }
    }
}
