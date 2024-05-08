package com.android.internal.org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class SignatureUpdatingOutputStream extends OutputStream {
    private Signature sig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignatureUpdatingOutputStream(Signature sig) {
        this.sig = sig;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes, int off, int len) throws IOException {
        try {
            this.sig.update(bytes, off, len);
        } catch (SignatureException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes) throws IOException {
        try {
            this.sig.update(bytes);
        } catch (SignatureException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Override // java.io.OutputStream
    public void write(int b4) throws IOException {
        try {
            this.sig.update((byte) b4);
        } catch (SignatureException e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
