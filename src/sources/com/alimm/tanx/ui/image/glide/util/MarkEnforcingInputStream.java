package com.alimm.tanx.ui.image.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MarkEnforcingInputStream extends FilterInputStream {
    public static final int END_OF_STREAM = -1;
    public static final int UNSET = Integer.MIN_VALUE;
    public int availableBytes;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
        this.availableBytes = Integer.MIN_VALUE;
    }

    private long getBytesToRead(long j10) {
        int i10 = this.availableBytes;
        if (i10 == 0) {
            return -1L;
        }
        if (i10 != Integer.MIN_VALUE) {
            long j11 = i10;
            if (j10 > j11) {
                return j11;
            }
        }
        return j10;
    }

    private void updateAvailableBytesAfterRead(long j10) {
        int i10 = this.availableBytes;
        if (i10 == Integer.MIN_VALUE || j10 == -1) {
            return;
        }
        this.availableBytes = (int) (i10 - j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i10 = this.availableBytes;
        return i10 == Integer.MIN_VALUE ? super.available() : Math.min(i10, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        super.mark(i10);
        this.availableBytes = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (getBytesToRead(1L) == -1) {
            return -1;
        }
        int read = super.read();
        updateAvailableBytesAfterRead(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.availableBytes = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long bytesToRead = getBytesToRead(j10);
        if (bytesToRead == -1) {
            return -1L;
        }
        long skip = super.skip(bytesToRead);
        updateAvailableBytesAfterRead(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int bytesToRead = (int) getBytesToRead(i11);
        if (bytesToRead == -1) {
            return -1;
        }
        int read = super.read(bArr, i10, bytesToRead);
        updateAvailableBytesAfterRead(read);
        return read;
    }
}
