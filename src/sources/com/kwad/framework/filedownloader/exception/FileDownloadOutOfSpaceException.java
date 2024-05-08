package com.kwad.framework.filedownloader.exception;

import com.kwad.framework.filedownloader.f.f;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FileDownloadOutOfSpaceException extends IOException {
    private long breakpointBytes;
    private long freeSpaceBytes;
    private long requiredSpaceBytes;

    public FileDownloadOutOfSpaceException(long j10, long j11, long j12, Throwable th) {
        super(f.b("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j12), Long.valueOf(j11), Long.valueOf(j10)), th);
        init(j10, j11, j12);
    }

    private void init(long j10, long j11, long j12) {
        this.freeSpaceBytes = j10;
        this.requiredSpaceBytes = j11;
        this.breakpointBytes = j12;
    }

    public long getBreakpointBytes() {
        return this.breakpointBytes;
    }

    public long getFreeSpaceBytes() {
        return this.freeSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }

    public FileDownloadOutOfSpaceException(long j10, long j11, long j12) {
        super(f.b("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j12), Long.valueOf(j11), Long.valueOf(j10)));
        init(j10, j11, j12);
    }
}
