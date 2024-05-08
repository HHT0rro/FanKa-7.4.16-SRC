package com.kwad.framework.filedownloader.e;

import com.kwad.framework.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements com.kwad.framework.filedownloader.e.a {
    private final BufferedOutputStream aig;
    private final RandomAccessFile aih;

    /* renamed from: fd, reason: collision with root package name */
    private final FileDescriptor f36639fd;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements c.e {
        @Override // com.kwad.framework.filedownloader.f.c.e
        public final com.kwad.framework.filedownloader.e.a c(File file) {
            return new b(file);
        }
    }

    public b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.aih = randomAccessFile;
        this.f36639fd = randomAccessFile.getFD();
        this.aig = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // com.kwad.framework.filedownloader.e.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.aig.close();
        this.aih.close();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void seek(long j10) {
        this.aih.seek(j10);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void setLength(long j10) {
        this.aih.setLength(j10);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void wI() {
        this.aig.flush();
        this.f36639fd.sync();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void write(byte[] bArr, int i10, int i11) {
        this.aig.write(bArr, 0, i11);
    }
}
