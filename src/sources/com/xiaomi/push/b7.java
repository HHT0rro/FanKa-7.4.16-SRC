package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b7 extends e7 {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f47142a = null;

    /* renamed from: b, reason: collision with root package name */
    public OutputStream f47143b;

    public b7(OutputStream outputStream) {
        this.f47143b = outputStream;
    }

    @Override // com.xiaomi.push.e7
    public int b(byte[] bArr, int i10, int i11) {
        InputStream inputStream = this.f47142a;
        if (inputStream == null) {
            throw new jx(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i10, i11);
            if (read >= 0) {
                return read;
            }
            throw new jx(4);
        } catch (IOException e2) {
            throw new jx(0, e2);
        }
    }

    @Override // com.xiaomi.push.e7
    public void d(byte[] bArr, int i10, int i11) {
        OutputStream outputStream = this.f47143b;
        if (outputStream == null) {
            throw new jx(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i10, i11);
        } catch (IOException e2) {
            throw new jx(0, e2);
        }
    }
}
