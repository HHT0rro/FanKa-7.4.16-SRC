package com.android.internal.org.bouncycastle.crypto.io;

import com.android.internal.org.bouncycastle.crypto.Digest;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DigestOutputStream extends OutputStream {
    protected Digest digest;

    public DigestOutputStream(Digest Digest) {
        this.digest = Digest;
    }

    @Override // java.io.OutputStream
    public void write(int b4) throws IOException {
        this.digest.update((byte) b4);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        this.digest.update(b4, off, len);
    }

    public byte[] getDigest() {
        byte[] res = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(res, 0);
        return res;
    }
}
