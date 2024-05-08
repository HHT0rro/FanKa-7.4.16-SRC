package com.kwad.sdk.core.videocache.a;

import com.alimm.tanx.core.view.player.cache.videocache.file.FileCache;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements com.kwad.sdk.core.videocache.a {
    private final a aBI;
    private RandomAccessFile aCz;
    public File file;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar != null) {
                this.aBI = aVar;
                d.u(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    file2 = new File(file.getParentFile(), file.getName() + FileCache.TEMP_POSTFIX);
                }
                this.file = file2;
                this.aCz = new RandomAccessFile(this.file, exists ? t.f36226k : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + ((Object) file) + " as disc cache", e2);
        }
    }

    private static boolean t(File file) {
        return file.getName().endsWith(FileCache.TEMP_POSTFIX);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized long Go() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + ((Object) this.file), e2);
        }
        return (int) this.aCz.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized int a(byte[] bArr, long j10, int i10) {
        try {
            this.aCz.seek(j10);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i10), Long.valueOf(j10), Long.valueOf(Go()), Integer.valueOf(bArr.length)), e2);
        }
        return this.aCz.read(bArr, 0, i10);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void close() {
        try {
            this.aCz.close();
            this.aBI.s(this.file);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + ((Object) this.file), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void complete() {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (this.file.renameTo(file)) {
            this.file = file;
            try {
                this.aCz = new RandomAccessFile(this.file, t.f36226k);
                this.aBI.s(this.file);
                return;
            } catch (IOException e2) {
                throw new ProxyCacheException("Error opening " + ((Object) this.file) + " as disc cache", e2);
            }
        }
        throw new ProxyCacheException("Error renaming file " + ((Object) this.file) + " to " + ((Object) file) + " for completion!");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void d(byte[] bArr, int i10) {
        try {
            if (!isCompleted()) {
                this.aCz.seek(Go());
                this.aCz.write(bArr, 0, i10);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + ((Object) this.file) + " is completed!");
            }
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i10), this.aCz, 1024), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized boolean isCompleted() {
        return !t(this.file);
    }
}
