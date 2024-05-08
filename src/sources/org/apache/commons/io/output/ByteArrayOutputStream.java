package org.apache.commons.io.output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.input.ClosedInputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ByteArrayOutputStream extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final List<byte[]> buffers;
    private int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;

    public ByteArrayOutputStream() {
        this(1024);
    }

    private void needNewBuffer(int i10) {
        if (this.currentBufferIndex < this.buffers.size() - 1) {
            this.filledBufferSum += this.currentBuffer.length;
            int i11 = this.currentBufferIndex + 1;
            this.currentBufferIndex = i11;
            this.currentBuffer = this.buffers.get(i11);
            return;
        }
        byte[] bArr = this.currentBuffer;
        if (bArr == null) {
            this.filledBufferSum = 0;
        } else {
            i10 = Math.max(bArr.length << 1, i10 - this.filledBufferSum);
            this.filledBufferSum += this.currentBuffer.length;
        }
        this.currentBufferIndex++;
        byte[] bArr2 = new byte[i10];
        this.currentBuffer = bArr2;
        this.buffers.add(bArr2);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(inputStream);
        return byteArrayOutputStream.toBufferedInputStream();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public synchronized void reset() {
        this.count = 0;
        this.filledBufferSum = 0;
        this.currentBufferIndex = 0;
        this.currentBuffer = this.buffers.get(0);
    }

    public synchronized int size() {
        return this.count;
    }

    public synchronized byte[] toByteArray() {
        int i10 = this.count;
        if (i10 == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (byte[] bArr2 : this.buffers) {
            int min = Math.min(bArr2.length, i10);
            System.arraycopy((Object) bArr2, 0, (Object) bArr, i11, min);
            i11 += min;
            i10 -= min;
            if (i10 == 0) {
                break;
            }
        }
        return bArr;
    }

    public String toString() {
        return new String(toByteArray());
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return;
        }
        synchronized (this) {
            int i13 = this.count;
            int i14 = i13 + i11;
            int i15 = i13 - this.filledBufferSum;
            while (i11 > 0) {
                int min = Math.min(i11, this.currentBuffer.length - i15);
                System.arraycopy((Object) bArr, i12 - i11, (Object) this.currentBuffer, i15, min);
                i11 -= min;
                if (i11 > 0) {
                    needNewBuffer(i14);
                    i15 = 0;
                }
            }
            this.count = i14;
        }
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException {
        int i10 = this.count;
        for (byte[] bArr : this.buffers) {
            int min = Math.min(bArr.length, i10);
            outputStream.write(bArr, 0, min);
            i10 -= min;
            if (i10 == 0) {
                break;
            }
        }
    }

    public ByteArrayOutputStream(int i10) {
        this.buffers = new ArrayList();
        if (i10 >= 0) {
            synchronized (this) {
                needNewBuffer(i10);
            }
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i10);
        }
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    private InputStream toBufferedInputStream() {
        int i10 = this.count;
        if (i10 == 0) {
            return new ClosedInputStream();
        }
        ArrayList arrayList = new ArrayList(this.buffers.size());
        for (byte[] bArr : this.buffers) {
            int min = Math.min(bArr.length, i10);
            arrayList.add(new ByteArrayInputStream(bArr, 0, min));
            i10 -= min;
            if (i10 == 0) {
                break;
            }
        }
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i10) {
        int i11 = this.count;
        int i12 = i11 - this.filledBufferSum;
        if (i12 == this.currentBuffer.length) {
            needNewBuffer(i11 + 1);
            i12 = 0;
        }
        this.currentBuffer[i12] = (byte) i10;
        this.count++;
    }

    public synchronized int write(InputStream inputStream) throws IOException {
        int i10;
        int i11 = this.count - this.filledBufferSum;
        byte[] bArr = this.currentBuffer;
        int read = inputStream.read(bArr, i11, bArr.length - i11);
        i10 = 0;
        while (read != -1) {
            i10 += read;
            i11 += read;
            this.count += read;
            byte[] bArr2 = this.currentBuffer;
            if (i11 == bArr2.length) {
                needNewBuffer(bArr2.length);
                i11 = 0;
            }
            byte[] bArr3 = this.currentBuffer;
            read = inputStream.read(bArr3, i11, bArr3.length - i11);
        }
        return i10;
    }
}
