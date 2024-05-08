package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class StreamClosedException extends BaseException {
    public StreamClosedException(String str) {
        super(DownloadErrorCode.ERROR_STREAM_CLOSED, str);
    }
}
