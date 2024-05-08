package java.security;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DigestOutputStream extends FilterOutputStream {
    protected MessageDigest digest;
    private boolean on;

    public DigestOutputStream(OutputStream stream, MessageDigest digest) {
        super(stream);
        this.on = true;
        setMessageDigest(digest);
    }

    public MessageDigest getMessageDigest() {
        return this.digest;
    }

    public void setMessageDigest(MessageDigest digest) {
        this.digest = digest;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b4) throws IOException {
        this.out.write(b4);
        if (this.on) {
            this.digest.update((byte) b4);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        if (b4 == null || off + len > b4.length) {
            throw new IllegalArgumentException("wrong parameters for write");
        }
        if (off < 0 || len < 0) {
            throw new IndexOutOfBoundsException("wrong index for write");
        }
        this.out.write(b4, off, len);
        if (this.on) {
            this.digest.update(b4, off, len);
        }
    }

    public void on(boolean on) {
        this.on = on;
    }

    public String toString() {
        return "[Digest Output Stream] " + this.digest.toString();
    }
}
