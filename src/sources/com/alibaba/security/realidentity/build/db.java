package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.common.utils.OSSUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

/* compiled from: CheckCRC64DownloadInputStream.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class db extends CheckedInputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f3420a;

    /* renamed from: b, reason: collision with root package name */
    private long f3421b;

    /* renamed from: c, reason: collision with root package name */
    private long f3422c;

    /* renamed from: d, reason: collision with root package name */
    private long f3423d;

    /* renamed from: e, reason: collision with root package name */
    private String f3424e;

    public db(InputStream inputStream, Checksum checksum, long j10, long j11, String str) {
        super(inputStream, checksum);
        this.f3422c = j10;
        this.f3423d = j11;
        this.f3424e = str;
    }

    private void a(int i10) throws IOException {
        long j10 = this.f3421b + i10;
        this.f3421b = j10;
        if (j10 >= this.f3422c) {
            long value = getChecksum().getValue();
            this.f3420a = value;
            OSSUtils.a(Long.valueOf(value), Long.valueOf(this.f3423d), this.f3424e);
        }
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = super.read();
        a(read);
        return read;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = super.read(bArr, i10, i11);
        a(read);
        return read;
    }

    private long a() {
        return this.f3420a;
    }
}
