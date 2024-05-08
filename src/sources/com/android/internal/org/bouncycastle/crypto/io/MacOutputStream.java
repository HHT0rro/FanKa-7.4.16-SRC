package com.android.internal.org.bouncycastle.crypto.io;

import com.android.internal.org.bouncycastle.crypto.Mac;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class MacOutputStream extends OutputStream {
    protected Mac mac;

    public MacOutputStream(Mac mac) {
        this.mac = mac;
    }

    @Override // java.io.OutputStream
    public void write(int b4) throws IOException {
        this.mac.update((byte) b4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        this.mac.update(b4, off, len);
    }

    public byte[] getMac() {
        byte[] res = new byte[this.mac.getMacSize()];
        this.mac.doFinal(res, 0);
        return res;
    }
}
