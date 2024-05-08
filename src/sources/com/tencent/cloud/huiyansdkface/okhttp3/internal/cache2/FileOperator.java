package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache2;

import com.tencent.cloud.huiyansdkface.okio.Buffer;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class FileOperator {

    /* renamed from: a, reason: collision with root package name */
    private final FileChannel f41689a;

    public FileOperator(FileChannel fileChannel) {
        this.f41689a = fileChannel;
    }

    public void read(long j10, Buffer buffer, long j11) throws IOException {
        if (j11 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j11 > 0) {
            long transferTo = this.f41689a.transferTo(j10, j11, buffer);
            j10 += transferTo;
            j11 -= transferTo;
        }
    }

    public void write(long j10, Buffer buffer, long j11) throws IOException {
        if (j11 < 0 || j11 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j12 = j10;
        long j13 = j11;
        while (j13 > 0) {
            long transferFrom = this.f41689a.transferFrom(buffer, j12, j13);
            j12 += transferFrom;
            j13 -= transferFrom;
        }
    }
}
