package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadHandleService extends Service {
    private static final String TAG = DownloadHandleService.class.getSimpleName();

    private void handleIntent(Intent intent) {
        final int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, 0)) == 0) {
            return;
        }
        if (action.equals(DownloadConstants.ACTION_RETRY)) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DownloadHandleService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DownloadProcessDispatcher.getInstance().retryDelayStart(intExtra);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else if (action.equals(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY)) {
            DownloadProcessDispatcher.getInstance().recordTaskProcessIndependent(intExtra);
        } else if (action.equals(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY)) {
            DownloadComponentManager.setDownloadInMultiProcess();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        handleIntent(intent);
        return 2;
    }
}
