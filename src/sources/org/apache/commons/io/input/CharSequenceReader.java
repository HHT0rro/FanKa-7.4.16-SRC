package org.apache.commons.io.input;

import java.io.Reader;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CharSequenceReader extends Reader implements Serializable {
    private final CharSequence charSequence;
    private int idx;
    private int mark;

    public CharSequenceReader(String str) {
        this.charSequence = str == null ? "" : str;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.idx = 0;
        this.mark = 0;
    }

    @Override // java.io.Reader
    public void mark(int i10) {
        this.mark = this.idx;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        CharSequence charSequence = this.charSequence;
        int i10 = this.idx;
        this.idx = i10 + 1;
        return charSequence.charAt(i10);
    }

    @Override // java.io.Reader
    public void reset() {
        this.idx = this.mark;
    }

    @Override // java.io.Reader
    public long skip(long j10) {
        if (j10 >= 0) {
            if (this.idx >= this.charSequence.length()) {
                return -1L;
            }
            int min = (int) Math.min(this.charSequence.length(), this.idx + j10);
            int i10 = min - this.idx;
            this.idx = min;
            return i10;
        }
        throw new IllegalArgumentException("Number of characters to skip is less than zero: " + j10);
    }

    public String toString() {
        return this.charSequence.toString();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i10, int i11) {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        Objects.requireNonNull(cArr, "Character array is missing");
        if (i11 < 0 || i10 < 0 || i10 + i11 > cArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i10 + ", length=" + i11);
        }
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            int read = read();
            if (read == -1) {
                return i12;
            }
            cArr[i10 + i13] = (char) read;
            i12++;
        }
        return i12;
    }
}
