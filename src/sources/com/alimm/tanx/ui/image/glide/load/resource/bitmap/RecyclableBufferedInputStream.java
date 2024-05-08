package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    public static final String TAG = "BufferedIs";
    public volatile byte[] buf;
    public int count;
    public int marklimit;
    public int markpos;
    public int pos;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class InvalidMarkException extends RuntimeException {
        public static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.markpos = -1;
        if (bArr != null && bArr.length != 0) {
            this.buf = bArr;
            return;
        }
        throw new IllegalArgumentException("buffer is null or empty");
    }

    private int fillbuf(InputStream inputStream, byte[] bArr) throws IOException {
        int i10 = this.markpos;
        if (i10 != -1) {
            int i11 = this.pos - i10;
            int i12 = this.marklimit;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.count == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    if (Log.isLoggable(TAG, 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("allocate buffer of length: ");
                        sb2.append(i12);
                    }
                    byte[] bArr2 = new byte[i12];
                    System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
                    this.buf = bArr2;
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy((Object) bArr, i10, (Object) bArr, 0, bArr.length - i10);
                }
                int i13 = this.pos - this.markpos;
                this.pos = i13;
                this.markpos = 0;
                this.count = 0;
                int read = inputStream.read(bArr, i13, bArr.length - i13);
                this.count = read <= 0 ? this.pos : this.pos + read;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.markpos = -1;
            this.pos = 0;
            this.count = read2;
        }
        return read2;
    }

    public static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.buf != null && inputStream != null) {
        } else {
            streamClosed();
            throw null;
        }
        return inputStream.available() + (this.count - this.pos);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.buf = null;
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void fixMarkLimit() {
        this.marklimit = this.buf.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.marklimit = Math.max(this.marklimit, i10);
        this.markpos = this.pos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.buf;
        InputStream inputStream = this.in;
        if (bArr != null && inputStream != null) {
            if (this.pos >= this.count && fillbuf(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.buf && (bArr = this.buf) == null) {
                streamClosed();
                throw null;
            }
            int i10 = this.count;
            int i11 = this.pos;
            if (i10 - i11 <= 0) {
                return -1;
            }
            this.pos = i11 + 1;
            return bArr[i11] & 255;
        }
        streamClosed();
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.buf != null) {
            int i10 = this.markpos;
            if (-1 != i10) {
                this.pos = i10;
            } else {
                throw new InvalidMarkException("Mark has been invalidated");
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) throws IOException {
        byte[] bArr = this.buf;
        InputStream inputStream = this.in;
        if (bArr == null) {
            streamClosed();
            throw null;
        }
        if (j10 < 1) {
            return 0L;
        }
        if (inputStream != null) {
            int i10 = this.count;
            int i11 = this.pos;
            long j11 = i10 - i11;
            if (j11 >= j10) {
                this.pos = (int) (i11 + j10);
                return j10;
            }
            this.pos = i10;
            if (this.markpos != -1 && j10 <= this.marklimit) {
                if (fillbuf(inputStream, bArr) == -1) {
                    return j11;
                }
                int i12 = this.count;
                int i13 = this.pos;
                long j12 = j10 - j11;
                if (i12 - i13 >= j12) {
                    this.pos = (int) (i13 + j12);
                    return j10;
                }
                long j13 = (j11 + i12) - i13;
                this.pos = i12;
                return j13;
            }
            return inputStream.skip(j10 - j11) + j11;
        }
        streamClosed();
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13;
        byte[] bArr2 = this.buf;
        if (bArr2 == null) {
            streamClosed();
            throw null;
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = this.in;
        if (inputStream != null) {
            int i14 = this.pos;
            int i15 = this.count;
            if (i14 < i15) {
                int i16 = i15 - i14;
                if (i16 >= i11) {
                    i16 = i11;
                }
                System.arraycopy((Object) bArr2, i14, (Object) bArr, i10, i16);
                this.pos += i16;
                if (i16 == i11 || inputStream.available() == 0) {
                    return i16;
                }
                i10 += i16;
                i12 = i11 - i16;
            } else {
                i12 = i11;
            }
            while (true) {
                if (this.markpos == -1 && i12 >= bArr2.length) {
                    i13 = inputStream.read(bArr, i10, i12);
                    if (i13 == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                } else {
                    if (fillbuf(inputStream, bArr2) == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                    if (bArr2 != this.buf && (bArr2 = this.buf) == null) {
                        streamClosed();
                        throw null;
                    }
                    int i17 = this.count;
                    int i18 = this.pos;
                    i13 = i17 - i18;
                    if (i13 >= i12) {
                        i13 = i12;
                    }
                    System.arraycopy((Object) bArr2, i18, (Object) bArr, i10, i13);
                    this.pos += i13;
                }
                i12 -= i13;
                if (i12 == 0) {
                    return i11;
                }
                if (inputStream.available() == 0) {
                    return i11 - i12;
                }
                i10 += i13;
            }
        } else {
            streamClosed();
            throw null;
        }
    }
}
