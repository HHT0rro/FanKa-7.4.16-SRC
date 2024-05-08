package com.ss.android.socialbase.downloader.exception;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadTTNetException extends BaseException {
    public DownloadTTNetException(int i10, String str) {
        super(i10, str);
    }

    public String getRequestLog() {
        return getExtraInfo();
    }

    public DownloadTTNetException setRequestLog(String str) {
        setExtraInfo(str);
        return this;
    }

    public DownloadTTNetException(int i10, Throwable th) {
        super(i10, th);
    }
}
