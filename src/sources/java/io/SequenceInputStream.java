package java.io;

import java.util.Enumeration;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SequenceInputStream extends InputStream {

    /* renamed from: e, reason: collision with root package name */
    Enumeration<? extends InputStream> f50356e;
    InputStream in;

    public SequenceInputStream(Enumeration<? extends InputStream> e2) {
        this.f50356e = e2;
        peekNextStream();
    }

    public SequenceInputStream(InputStream s12, InputStream s2) {
        Vector<InputStream> v2 = new Vector<>(2);
        v2.addElement(s12);
        v2.addElement(s2);
        this.f50356e = v2.elements();
        peekNextStream();
    }

    final void nextStream() throws IOException {
        InputStream inputStream = this.in;
        if (inputStream != null) {
            inputStream.close();
        }
        peekNextStream();
    }

    private void peekNextStream() {
        if (this.f50356e.hasMoreElements()) {
            InputStream nextElement = this.f50356e.nextElement();
            this.in = nextElement;
            if (nextElement == null) {
                throw new NullPointerException();
            }
            return;
        }
        this.in = null;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                return -1;
            }
            int c4 = inputStream.read();
            if (c4 != -1) {
                return c4;
            }
            nextStream();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        if (this.in == null) {
            return -1;
        }
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || len > b4.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return 0;
        }
        do {
            int n10 = this.in.read(b4, off, len);
            if (n10 > 0) {
                return n10;
            }
            nextStream();
        } while (this.in != null);
        return -1;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        do {
            nextStream();
        } while (this.in != null);
    }
}
