package java.util.zip;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CheckedOutputStream extends FilterOutputStream {
    private Checksum cksum;

    public CheckedOutputStream(OutputStream out, Checksum cksum) {
        super(out);
        this.cksum = cksum;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b4) throws IOException {
        this.out.write(b4);
        this.cksum.update(b4);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        this.out.write(b4, off, len);
        this.cksum.update(b4, off, len);
    }

    public Checksum getChecksum() {
        return this.cksum;
    }
}
