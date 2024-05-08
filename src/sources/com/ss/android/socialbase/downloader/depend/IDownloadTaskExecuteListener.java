package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.constants.BoundType;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IDownloadTaskExecuteListener {
    void onFinish(DownloadTask downloadTask, @BoundType int i10);

    void onStart(DownloadTask downloadTask, @BoundType int i10);
}
