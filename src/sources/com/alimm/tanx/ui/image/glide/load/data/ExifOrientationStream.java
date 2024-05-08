package com.alimm.tanx.ui.image.glide.load.data;

import androidx.exifinterface.media.ExifInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ExifOrientationStream extends FilterInputStream {
    public static final byte[] EXIF_SEGMENT;
    public static final int ORIENTATION_POSITION;
    public static final int SEGMENT_LENGTH;
    public static final int SEGMENT_START_POSITION = 2;
    public final byte orientation;
    public int position;

    static {
        byte[] bArr = {-1, ExifInterface.MARKER_APP1, 0, 28, 69, ObjectStreamConstants.TC_ENDBLOCKDATA, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 >= -1 && i10 <= 8) {
            this.orientation = (byte) i10;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i10;
        int i11 = this.position;
        if (i11 < 2 || i11 > (i10 = ORIENTATION_POSITION)) {
            read = super.read();
        } else if (i11 == i10) {
            read = this.orientation;
        } else {
            read = EXIF_SEGMENT[i11 - 2] & 255;
        }
        if (read != -1) {
            this.position++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long skip = super.skip(j10);
        if (skip > 0) {
            this.position = (int) (this.position + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.position;
        int i14 = ORIENTATION_POSITION;
        if (i13 > i14) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == i14) {
            bArr[i10] = this.orientation;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int min = Math.min(i14 - i13, i11);
            System.arraycopy((Object) EXIF_SEGMENT, this.position - 2, (Object) bArr, i10, min);
            i12 = min;
        }
        if (i12 > 0) {
            this.position += i12;
        }
        return i12;
    }
}
