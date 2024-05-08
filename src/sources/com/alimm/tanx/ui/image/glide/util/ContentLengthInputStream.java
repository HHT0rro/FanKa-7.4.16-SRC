package com.alimm.tanx.ui.image.glide.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    public static final String TAG = "ContentLengthStream";
    public static final int UNKNOWN = -1;
    public final long contentLength;
    public int readSoFar;

    public ContentLengthInputStream(InputStream inputStream, long j10) {
        super(inputStream);
        this.contentLength = j10;
    }

    private int checkReadSoFarOrThrow(int i10) throws IOException {
        if (i10 >= 0) {
            this.readSoFar += i10;
        } else if (this.contentLength - this.readSoFar > 0) {
            StringBuilder a10 = a.a("Failed to read all expected data, expected: ");
            a10.append(this.contentLength);
            a10.append(", but read: ");
            a10.append(this.readSoFar);
            throw new IOException(a10.toString());
        }
        return i10;
    }

    public static InputStream obtain(InputStream inputStream, String str) {
        return obtain(inputStream, parseContentLength(str));
    }

    public static int parseContentLength(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                if (Log.isLoggable(TAG, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("failed to parse content length header: ");
                    sb2.append(str);
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.contentLength - this.readSoFar, this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        return checkReadSoFarOrThrow(super.read());
    }

    public static InputStream obtain(InputStream inputStream, long j10) {
        return new ContentLengthInputStream(inputStream, j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        return checkReadSoFarOrThrow(super.read(bArr, i10, i11));
    }
}
