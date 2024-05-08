package com.android.internal.org.bouncycastle.crypto.io;

import com.android.internal.org.bouncycastle.crypto.Mac;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class MacInputStream extends FilterInputStream {
    protected Mac mac;

    public MacInputStream(InputStream stream, Mac mac) {
        super(stream);
        this.mac = mac;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int b4 = this.in.read();
        if (b4 >= 0) {
            this.mac.update((byte) b4);
        }
        return b4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        int n10 = this.in.read(b4, off, len);
        if (n10 >= 0) {
            this.mac.update(b4, off, n10);
        }
        return n10;
    }

    public Mac getMac() {
        return this.mac;
    }
}
