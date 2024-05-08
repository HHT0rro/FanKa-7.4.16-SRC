package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultDownloadServiceHandler extends AbsDownloadServiceHandler {
    private static final String TAG = "DefaultDownloadServiceHandler";

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(Intent intent, int i10, int i11) {
        if (Logger.debug()) {
            Logger.d(TAG, "onStartCommand");
        }
        if (!DownloadExpSwitchCode.isSwitchEnable(262144)) {
            this.isServiceAlive = true;
        }
        resumePendingTask();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
        if (DownloadExpSwitchCode.isSwitchEnable(262144)) {
            this.isServiceAlive = true;
            this.isInvokeStartService = false;
            if (Logger.debug()) {
                Logger.d(TAG, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) DownloadService.class));
        this.isServiceAlive = false;
    }
}
