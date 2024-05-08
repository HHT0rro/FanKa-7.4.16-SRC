package java.io;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ByteArrayOutputStream extends OutputStream {
    private static final int MAX_ARRAY_SIZE = 2147483639;
    protected byte[] buf;
    protected int count;

    public ByteArrayOutputStream() {
        this(32);
    }

    public ByteArrayOutputStream(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative initial size: " + size);
        }
        this.buf = new byte[size];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - this.buf.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = this.buf.length;
        int newCapacity = oldCapacity << 1;
        if (newCapacity < 131072 && newCapacity >= 1024) {
            newCapacity = 131072;
        }
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - 2147483639 > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        this.buf = Arrays.copyOf(this.buf, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity <= 2147483639) {
            return 2147483639;
        }
        return Integer.MAX_VALUE;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int b4) {
        ensureCapacity(this.count + 1);
        byte[] bArr = this.buf;
        int i10 = this.count;
        bArr[i10] = (byte) b4;
        this.count = i10 + 1;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] b4, int off, int len) {
        Objects.checkFromIndexSize(off, len, b4.length);
        ensureCapacity(this.count + len);
        System.arraycopy((Object) b4, off, (Object) this.buf, this.count, len);
        this.count += len;
    }

    public void writeBytes(byte[] b4) {
        write(b4, 0, b4.length);
    }

    public synchronized void writeTo(OutputStream out) throws IOException {
        out.write(this.buf, 0, this.count);
    }

    public synchronized void reset() {
        this.count = 0;
    }

    public synchronized byte[] toByteArray() {
        return Arrays.copyOf(this.buf, this.count);
    }

    public synchronized int size() {
        return this.count;
    }

    public synchronized String toString() {
        return new String(this.buf, 0, this.count);
    }

    public synchronized String toString(String charsetName) throws UnsupportedEncodingException {
        return new String(this.buf, 0, this.count, charsetName);
    }

    public synchronized String toString(Charset charset) {
        return new String(this.buf, 0, this.count, charset);
    }

    @Deprecated
    public synchronized String toString(int hibyte) {
        return new String(this.buf, hibyte, 0, this.count);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
