package java.security;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DigestInputStream extends FilterInputStream {
    protected MessageDigest digest;
    private boolean on;

    public DigestInputStream(InputStream stream, MessageDigest digest) {
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

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int ch = this.in.read();
        if (this.on && ch != -1) {
            this.digest.update((byte) ch);
        }
        return ch;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        int result = this.in.read(b4, off, len);
        if (this.on && result != -1) {
            this.digest.update(b4, off, result);
        }
        return result;
    }

    public void on(boolean on) {
        this.on = on;
    }

    public String toString() {
        return "[Digest Input Stream] " + this.digest.toString();
    }
}
