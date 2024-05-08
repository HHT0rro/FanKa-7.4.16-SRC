package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RandomAccessOutputStream implements Closeable {
    private static final int MAX_FLUSH_BUFFER_SIZE = 131072;
    private static final int MIN_FLUSH_BUFFER_SIZE = 8192;

    /* renamed from: fd, reason: collision with root package name */
    private FileDescriptor f38978fd;
    private BufferedOutputStream outputStream;
    private RandomAccessFile randomAccess;

    public RandomAccessOutputStream(File file, int i10) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.randomAccess = randomAccessFile;
            this.f38978fd = randomAccessFile.getFD();
            if (i10 > 0) {
                if (i10 < 8192) {
                    i10 = 8192;
                } else if (i10 > 131072) {
                    i10 = 131072;
                }
                this.outputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()), i10);
                return;
            }
            this.outputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()));
        } catch (IOException e2) {
            throw new BaseException(DownloadErrorCode.ERROR_OUTPUT_STREAM_CREATE_IO, e2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        DownloadUtils.safeClose(this.randomAccess, this.outputStream);
    }

    public void flush() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.outputStream;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void flushAndSync() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.outputStream;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f38978fd;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void seek(long j10) throws IOException {
        this.randomAccess.seek(j10);
    }

    public void setLength(long j10) throws IOException {
        this.randomAccess.setLength(j10);
    }

    public void sync() throws IOException {
        FileDescriptor fileDescriptor = this.f38978fd;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.outputStream.write(bArr, i10, i11);
    }
}
