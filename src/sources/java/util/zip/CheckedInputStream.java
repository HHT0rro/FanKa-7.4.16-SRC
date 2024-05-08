package java.util.zip;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CheckedInputStream extends FilterInputStream {
    private Checksum cksum;

    public CheckedInputStream(InputStream in, Checksum cksum) {
        super(in);
        this.cksum = cksum;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int b4 = this.in.read();
        if (b4 != -1) {
            this.cksum.update(b4);
        }
        return b4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        int len2 = this.in.read(buf, off, len);
        if (len2 != -1) {
            this.cksum.update(buf, off, len2);
        }
        return len2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n10) throws IOException {
        byte[] buf = new byte[512];
        long total = 0;
        while (total < n10) {
            long len = n10 - total;
            long len2 = read(buf, 0, len < ((long) buf.length) ? (int) len : buf.length);
            if (len2 == -1) {
                return total;
            }
            total += len2;
        }
        return total;
    }

    public Checksum getChecksum() {
        return this.cksum;
    }
}
