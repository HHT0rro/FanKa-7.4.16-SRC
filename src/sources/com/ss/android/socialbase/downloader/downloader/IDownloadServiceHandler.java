package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IDownloadServiceHandler<T extends DownloadService> {
    boolean isServiceAlive();

    boolean isServiceForeground();

    IBinder onBind(Intent intent);

    void onDestroy();

    void onStartCommand(Intent intent, int i10, int i11);

    void onStartCommandOnMainThread();

    void pendDownloadTask(DownloadTask downloadTask);

    void setDownloadService(WeakReference<T> weakReference);

    void setLogLevel(int i10);

    void setServiceConnectionListener(IDownloadServiceConnectionListener iDownloadServiceConnectionListener);

    void startForeground(int i10, Notification notification);

    void startService();

    void stopForeground(boolean z10);

    void tryDownload(DownloadTask downloadTask);

    void tryDownloadWithEngine(DownloadTask downloadTask);
}
