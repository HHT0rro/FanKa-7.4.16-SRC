package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadService extends Service {
    private static final String TAG = DownloadService.class.getSimpleName();
    public IDownloadServiceHandler downloadServiceHandler;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onBind downloadServiceHandler != null:");
        sb2.append(this.downloadServiceHandler != null);
        Logger.d(str, sb2.toString());
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            return iDownloadServiceHandler.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
        IDownloadServiceHandler downloadServiceHandler = DownloadComponentManager.getDownloadServiceHandler();
        this.downloadServiceHandler = downloadServiceHandler;
        downloadServiceHandler.setDownloadService(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (Logger.debug()) {
            Logger.d(TAG, "Service onDestroy");
        }
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.onDestroy();
            this.downloadServiceHandler = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i10, final int i11) {
        if (Logger.debug()) {
            Logger.d(TAG, "DownloadService onStartCommand");
        }
        this.downloadServiceHandler.onStartCommandOnMainThread();
        ExecutorService cPUThreadExecutor = DownloadComponentManager.getCPUThreadExecutor();
        if (cPUThreadExecutor != null) {
            cPUThreadExecutor.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    IDownloadServiceHandler iDownloadServiceHandler = DownloadService.this.downloadServiceHandler;
                    if (iDownloadServiceHandler != null) {
                        iDownloadServiceHandler.onStartCommand(intent, i10, i11);
                    }
                }
            });
        }
        return DownloadComponentManager.notAutoRebootService() ? 2 : 3;
    }
}
