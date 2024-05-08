package java.util.zip;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InflaterOutputStream extends FilterOutputStream {
    protected final byte[] buf;
    private boolean closed;
    protected final Inflater inf;
    private boolean usesDefaultInflater;
    private final byte[] wbuf;

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public InflaterOutputStream(OutputStream out) {
        this(out, new Inflater());
        this.usesDefaultInflater = true;
    }

    public InflaterOutputStream(OutputStream out, Inflater infl) {
        this(out, infl, 512);
    }

    public InflaterOutputStream(OutputStream out, Inflater infl, int bufLen) {
        super(out);
        this.wbuf = new byte[1];
        this.usesDefaultInflater = false;
        this.closed = false;
        if (out == null) {
            throw new NullPointerException("Null output");
        }
        if (infl == null) {
            throw new NullPointerException("Null inflater");
        }
        if (bufLen <= 0) {
            throw new IllegalArgumentException("Buffer size < 1");
        }
        this.inf = infl;
        this.buf = new byte[bufLen];
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            try {
                finish();
            } finally {
                this.out.close();
                this.closed = true;
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ensureOpen();
        if (!this.inf.finished()) {
            while (!this.inf.finished() && !this.inf.needsInput()) {
                try {
                    Inflater inflater = this.inf;
                    byte[] bArr = this.buf;
                    int n10 = inflater.inflate(bArr, 0, bArr.length);
                    if (n10 < 1) {
                        break;
                    } else {
                        this.out.write(this.buf, 0, n10);
                    }
                } catch (DataFormatException ex) {
                    String msg = ex.getMessage();
                    if (msg == null) {
                        msg = "Invalid ZLIB data format";
                    }
                    throw new ZipException(msg);
                }
            }
            super.flush();
        }
    }

    public void finish() throws IOException {
        ensureOpen();
        flush();
        if (this.usesDefaultInflater) {
            this.inf.end();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b4) throws IOException {
        byte[] bArr = this.wbuf;
        bArr[0] = (byte) b4;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        int n10;
        ensureOpen();
        if (b4 == null) {
            throw new NullPointerException("Null buffer for read");
        }
        if (off < 0 || len < 0 || len > b4.length - off) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        do {
            try {
                if (this.inf.needsInput()) {
                    if (len >= 1) {
                        int part = len < 512 ? len : 512;
                        this.inf.setInput(b4, off, part);
                        off += part;
                        len -= part;
                    } else {
                        return;
                    }
                }
                do {
                    Inflater inflater = this.inf;
                    byte[] bArr = this.buf;
                    n10 = inflater.inflate(bArr, 0, bArr.length);
                    if (n10 > 0) {
                        this.out.write(this.buf, 0, n10);
                    }
                } while (n10 > 0);
                if (this.inf.finished()) {
                    return;
                }
            } catch (DataFormatException ex) {
                String msg = ex.getMessage();
                if (msg == null) {
                    msg = "Invalid ZLIB data format";
                }
                throw new ZipException(msg);
            }
        } while (!this.inf.needsDictionary());
        throw new ZipException("ZLIB dictionary missing");
    }
}
