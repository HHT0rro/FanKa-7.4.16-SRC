package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class AbsDownloadServiceHandler implements IDownloadServiceHandler {
    private static final String TAG = "AbsDownloadServiceHandler";
    private WeakReference<Service> downloadService;
    public volatile boolean isServiceForeground;
    public final SparseArray<List<DownloadTask>> pendingTasks = new SparseArray<>();
    public volatile boolean isServiceAlive = false;
    public volatile boolean isInvokeStartService = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable debounceStartServiceRunnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler.1
        @Override // java.lang.Runnable
        public void run() {
            if (Logger.debug()) {
                Logger.d(AbsDownloadServiceHandler.TAG, "tryDownload: 2 try");
            }
            if (AbsDownloadServiceHandler.this.isServiceAlive) {
                return;
            }
            if (Logger.debug()) {
                Logger.d(AbsDownloadServiceHandler.TAG, "tryDownload: 2 error");
            }
            AbsDownloadServiceHandler.this.startService(DownloadComponentManager.getAppContext(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public boolean isServiceAlive() {
        return this.isServiceAlive;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public boolean isServiceForeground() {
        Logger.i(TAG, "isServiceForeground = " + this.isServiceForeground);
        return this.isServiceForeground;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public IBinder onBind(Intent intent) {
        Logger.d(TAG, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onDestroy() {
        this.isServiceAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(Intent intent, int i10, int i11) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void pendDownloadTask(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.pendingTasks) {
            String str = TAG;
            Logger.d(str, "pendDownloadTask pendingTasks.size:" + this.pendingTasks.size() + " downloadId:" + downloadId);
            List<DownloadTask> list = this.pendingTasks.get(downloadId);
            if (list == null) {
                list = new ArrayList<>();
                this.pendingTasks.put(downloadId, list);
            }
            Logger.d(str, "before pendDownloadTask taskArray.size:" + list.size());
            list.add(downloadTask);
            Logger.d(str, "after pendDownloadTask pendingTasks.size:" + this.pendingTasks.size());
        }
    }

    public void resumePendingTask() {
        SparseArray<List<DownloadTask>> clone;
        synchronized (this.pendingTasks) {
            Logger.d(TAG, "resumePendingTask pendingTasks.size:" + this.pendingTasks.size());
            clone = this.pendingTasks.clone();
            this.pendingTasks.clear();
        }
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            for (int i10 = 0; i10 < clone.size(); i10++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i10));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        Logger.d(TAG, "resumePendingTask key:" + downloadTask.getDownloadId());
                        downloadEngine.tryDownload(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setDownloadService(WeakReference weakReference) {
        this.downloadService = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int i10) {
        Logger.setLogLevel(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(IDownloadServiceConnectionListener iDownloadServiceConnectionListener) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startForeground(int i10, Notification notification) {
        WeakReference<Service> weakReference = this.downloadService;
        if (weakReference != null && weakReference.get() != null) {
            Logger.i(TAG, "startForeground  id = " + i10 + ", service = " + ((Object) this.downloadService.get()) + ",  isServiceAlive = " + this.isServiceAlive);
            try {
                this.downloadService.get().startForeground(i10, notification);
                this.isServiceForeground = true;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        Logger.w(TAG, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.isServiceAlive) {
            return;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "startService");
        }
        startService(DownloadComponentManager.getAppContext(), null);
    }

    public void startService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void stopForeground(boolean z10) {
        WeakReference<Service> weakReference = this.downloadService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        Logger.i(TAG, "stopForeground  service = " + ((Object) this.downloadService.get()) + ",  isServiceAlive = " + this.isServiceAlive);
        try {
            this.isServiceForeground = false;
            this.downloadService.get().stopForeground(z10);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.isServiceAlive) {
            if (Logger.debug()) {
                Logger.d(TAG, "tryDownload but service is not alive");
            }
            if (DownloadExpSwitchCode.isSwitchEnable(262144)) {
                pendDownloadTask(downloadTask);
                if (!this.isInvokeStartService) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "tryDownload: 1");
                    }
                    startService(DownloadComponentManager.getAppContext(), null);
                    this.isInvokeStartService = true;
                    return;
                }
                this.handler.removeCallbacks(this.debounceStartServiceRunnable);
                this.handler.postDelayed(this.debounceStartServiceRunnable, 10L);
                return;
            }
            pendDownloadTask(downloadTask);
            startService(DownloadComponentManager.getAppContext(), null);
            return;
        }
        String str = TAG;
        Logger.d(str, "tryDownload when isServiceAlive");
        resumePendingTask();
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            Logger.d(str, "tryDownload current task: " + downloadTask.getDownloadId());
            downloadEngine.tryDownload(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
    }
}
