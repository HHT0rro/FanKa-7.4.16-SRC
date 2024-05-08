package java.util.zip;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DeflaterOutputStream extends FilterOutputStream {
    protected byte[] buf;
    private boolean closed;
    protected Deflater def;
    private final boolean syncFlush;
    boolean usesDefaultDeflater;

    public DeflaterOutputStream(OutputStream out, Deflater def, int size, boolean syncFlush) {
        super(out);
        this.closed = false;
        this.usesDefaultDeflater = false;
        if (out == null || def == null) {
            throw new NullPointerException();
        }
        if (size <= 0) {
            throw new IllegalArgumentException("buffer size <= 0");
        }
        this.def = def;
        this.buf = new byte[size];
        this.syncFlush = syncFlush;
    }

    public DeflaterOutputStream(OutputStream out, Deflater def, int size) {
        this(out, def, size, false);
    }

    public DeflaterOutputStream(OutputStream out, Deflater def, boolean syncFlush) {
        this(out, def, 512, syncFlush);
    }

    public DeflaterOutputStream(OutputStream out, Deflater def) {
        this(out, def, 512, false);
    }

    public DeflaterOutputStream(OutputStream out, boolean syncFlush) {
        this(out, new Deflater(), 512, syncFlush);
        this.usesDefaultDeflater = true;
    }

    public DeflaterOutputStream(OutputStream out) {
        this(out, false);
        this.usesDefaultDeflater = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b4) throws IOException {
        byte[] buf = {(byte) (b4 & 255)};
        write(buf, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        if (this.def.finished()) {
            throw new IOException("write beyond end of stream");
        }
        if ((off | len | (off + len) | (b4.length - (off + len))) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (len != 0 && !this.def.finished()) {
            this.def.setInput(b4, off, len);
            while (!this.def.needsInput()) {
                deflate();
            }
        }
    }

    public void finish() throws IOException {
        if (!this.def.finished()) {
            this.def.finish();
            while (!this.def.finished()) {
                deflate();
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            finish();
            if (this.usesDefaultDeflater) {
                this.def.end();
            }
            this.out.close();
            this.closed = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void deflate() throws IOException {
        while (true) {
            Deflater deflater = this.def;
            byte[] bArr = this.buf;
            int len = deflater.deflate(bArr, 0, bArr.length);
            if (len > 0) {
                this.out.write(this.buf, 0, len);
            } else {
                return;
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        int len;
        if (this.syncFlush && !this.def.finished()) {
            do {
                Deflater deflater = this.def;
                byte[] bArr = this.buf;
                len = deflater.deflate(bArr, 0, bArr.length, 2);
                if (len <= 0) {
                    break;
                } else {
                    this.out.write(this.buf, 0, len);
                }
            } while (len >= this.buf.length);
        }
        this.out.flush();
    }
}
