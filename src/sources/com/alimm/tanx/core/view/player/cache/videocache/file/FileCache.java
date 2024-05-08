package com.alimm.tanx.core.view.player.cache.videocache.file;

import com.alimm.tanx.core.view.player.cache.videocache.Cache;
import com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FileCache implements Cache {
    public static final String TEMP_POSTFIX = ".download";
    public RandomAccessFile dataFile;
    public final DiskUsage diskUsage;
    public File file;

    public FileCache(File file) throws ProxyCacheException {
        this(file, new UnlimitedDiskUsage());
    }

    private boolean isTempFile(File file) {
        return file.getName().endsWith(TEMP_POSTFIX);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized void append(byte[] bArr, int i10) throws ProxyCacheException {
        try {
            if (!isCompleted()) {
                this.dataFile.seek(available());
                this.dataFile.write(bArr, 0, i10);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + ((Object) this.file) + " is completed!");
            }
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i10), this.dataFile, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + ((Object) this.file), e2);
        }
        return (int) this.dataFile.length();
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized void close() throws ProxyCacheException {
        try {
            this.dataFile.close();
            this.diskUsage.touch(this.file);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + ((Object) this.file), e2);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized void complete() throws ProxyCacheException {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (this.file.renameTo(file)) {
            this.file = file;
            try {
                this.dataFile = new RandomAccessFile(this.file, t.f36226k);
                this.diskUsage.touch(this.file);
                return;
            } catch (IOException e2) {
                throw new ProxyCacheException("Error opening " + ((Object) this.file) + " as disc cache", e2);
            }
        }
        throw new ProxyCacheException("Error renaming file " + ((Object) this.file) + " to " + ((Object) file) + " for completion!");
    }

    public File getFile() {
        return this.file;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized boolean isCompleted() {
        return !isTempFile(this.file);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized int read(byte[] bArr, long j10, int i10) throws ProxyCacheException {
        try {
            this.dataFile.seek(j10);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i10), Long.valueOf(j10), Long.valueOf(available()), Integer.valueOf(bArr.length)), e2);
        }
        return this.dataFile.read(bArr, 0, i10);
    }

    public FileCache(File file, DiskUsage diskUsage) throws ProxyCacheException {
        File file2;
        try {
            if (diskUsage != null) {
                this.diskUsage = diskUsage;
                Files.makeDir(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    file2 = new File(file.getParentFile(), file.getName() + TEMP_POSTFIX);
                }
                this.file = file2;
                this.dataFile = new RandomAccessFile(this.file, exists ? t.f36226k : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + ((Object) file) + " as disc cache", e2);
        }
    }
}
