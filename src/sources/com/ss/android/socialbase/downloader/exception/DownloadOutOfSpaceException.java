package com.ss.android.socialbase.downloader.exception;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadOutOfSpaceException extends BaseException {
    private final long avaliableSpaceBytes;
    private final long requiredSpaceBytes;

    public DownloadOutOfSpaceException(long j10, long j11) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j11), String.valueOf(j10)));
        this.avaliableSpaceBytes = j10;
        this.requiredSpaceBytes = j11;
    }

    public long getAvaliableSpaceBytes() {
        return this.avaliableSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
