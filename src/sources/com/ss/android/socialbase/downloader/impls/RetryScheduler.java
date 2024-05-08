package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RetryScheduler implements Handler.Callback, AppStatusManager.AppStatusChangeListener {
    private static final int MIN_INTERVAL_MS = 3000;
    private static final int MIN_INTERVAL_MS_ACCELERATION = 5000;
    public static final int NET_TYPE_COMMON = 1;
    public static final int NET_TYPE_NONE = 0;
    public static final int NET_TYPE_WIFI = 2;
    public static final int RETRY_SCHEDULE_NORMAL = 1;
    public static final int RETRY_SCHEDULE_WHEN_APP_BACKGROUND = 3;
    public static final int RETRY_SCHEDULE_WHEN_APP_FOREGROUND = 4;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_CONNECTED = 5;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_SUCCEED = 2;
    private static final int SCHEDULE_ALL_TASK_RETRY_DELAY = 2000;
    private static final int SCHEDULE_ALL_TASK_RETRY_MIN_INTERVAL = 10000;
    private static final String TAG = "RetryScheduler";
    private static volatile RetryScheduler sInstance;
    private static RetryScheduleHandler sRetryScheduleHandler;
    private ConnectivityManager mConnectivityManager;
    private final boolean mIsDownloaderProcess;
    private long mLastHandleAllTaskTime;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<RetryInfo> mRetryInfoList = new SparseArray<>();
    private int mWaitingRetryTasksCount = 0;
    private final Context mContext = DownloadComponentManager.getAppContext();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class RetryInfo {
        public final int[] allowErrorCode;

        /* renamed from: id, reason: collision with root package name */
        public final int f38974id;
        public final int intervalMs;
        public final int intervalMsAcceleration;
        public final int level;
        private int mCurrentIntervalMs;
        private boolean mIsWaitingRetry;
        private long mLastRetryTime;
        private boolean mNeedWifi;
        private int mRetryCount;
        public final int maxCount;
        public final boolean useJobScheduler;

        public RetryInfo(int i10, int i11, int i12, int i13, int i14, boolean z10, int[] iArr) {
            i13 = i13 < 3000 ? 3000 : i13;
            i14 = i14 < 5000 ? 5000 : i14;
            this.f38974id = i10;
            this.level = i11;
            this.maxCount = i12;
            this.intervalMs = i13;
            this.intervalMsAcceleration = i14;
            this.useJobScheduler = z10;
            this.allowErrorCode = iArr;
            this.mCurrentIntervalMs = i13;
        }

        public boolean canRetry(long j10, int i10, int i11, boolean z10) {
            if (!this.mIsWaitingRetry) {
                Logger.i(RetryScheduler.TAG, "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.level < i10 || this.mRetryCount >= this.maxCount) {
                return false;
            }
            if (!this.mNeedWifi || i11 == 2) {
                return z10 || j10 - this.mLastRetryTime >= ((long) this.intervalMs);
            }
            return false;
        }

        public int getCurrentRetryIntervalMs() {
            return this.mCurrentIntervalMs;
        }

        public synchronized void increaseRetryCount() {
            this.mRetryCount++;
        }

        public synchronized void increaseRetryInterval() {
            this.mCurrentIntervalMs += this.intervalMsAcceleration;
        }

        public void resetRetryInterval() {
            this.mCurrentIntervalMs = this.intervalMs;
        }

        public synchronized void updateRetryTimeStamp(long j10) {
            this.mLastRetryTime = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface RetryScheduleHandler {
        void cancelRetry(int i10);

        void scheduleRetry(DownloadInfo downloadInfo, long j10, boolean z10, int i10);
    }

    private RetryScheduler() {
        registerNetworkCallback();
        this.mIsDownloaderProcess = DownloadUtils.isDownloaderProcess();
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    private boolean canRetryForAllowErrorCode(RetryInfo retryInfo, int i10) {
        int[] iArr = retryInfo.allowErrorCode;
        if (iArr != null && iArr.length != 0) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canRetryWhenInsufficientSpace(DownloadInfo downloadInfo, BaseException baseException) {
        long j10;
        long totalBytes;
        try {
            j10 = DownloadUtils.getAvailableSpaceBytes(downloadInfo.getTempPath());
        } catch (BaseException e2) {
            e2.printStackTrace();
            j10 = 0;
        }
        if (baseException instanceof DownloadOutOfSpaceException) {
            totalBytes = ((DownloadOutOfSpaceException) baseException).getRequiredSpaceBytes();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (j10 < totalBytes) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            if (obtain.optInt(DownloadSettingKeys.SPACE_FILL_PART_DOWNLOAD, 0) == 1) {
                if (j10 > 0) {
                    int optInt = obtain.optInt(DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100);
                    if (optInt > 0) {
                        long j11 = j10 - (optInt * 1048576);
                        Logger.i(TAG, "retry schedule: available = " + DownloadUtils.byteToMb(j10) + "MB, minKeep = " + optInt + "MB, canDownload = " + DownloadUtils.byteToMb(j11) + "MB");
                        if (j11 <= 0) {
                            Logger.w(TAG, "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (obtain.optInt(DownloadSettingKeys.DOWNLOAD_WHEN_SPACE_NEGATIVE, 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    private RetryInfo createRetryInfo(int i10) {
        int[] iArr;
        int i11;
        int i12;
        boolean z10;
        DownloadSetting obtain = DownloadSetting.obtain(i10);
        boolean z11 = false;
        int optInt = obtain.optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0);
        JSONObject optJSONObject = obtain.optJSONObject(DownloadSettingKeys.RETRY_SCHEDULE_CONFIG);
        int i13 = 60;
        if (optJSONObject != null) {
            int optInt2 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, 60);
            int optInt3 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC, 60);
            int optInt4 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC_ACCELERATION, 60);
            if (sRetryScheduleHandler != null && optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.USE_JOB_SCHEDULER, 0) == 1) {
                z11 = true;
            }
            iArr = parserAllowErrorCode(optJSONObject.optString(DownloadSettingKeys.RetryScheduleConfig.ALLOW_ERROR_CODE));
            i11 = optInt4;
            z10 = z11;
            i12 = optInt2;
            i13 = optInt3;
        } else {
            iArr = null;
            i11 = 60;
            i12 = 60;
            z10 = false;
        }
        return new RetryInfo(i10, optInt, i12, i13 * 1000, i11 * 1000, z10, iArr);
    }

    private void doScheduleAllTaskRetry(final int i10, final boolean z10) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.2
            @Override // java.lang.Runnable
            public void run() {
                int netWorkType;
                try {
                    if (RetryScheduler.this.mWaitingRetryTasksCount > 0 && (netWorkType = RetryScheduler.this.getNetWorkType()) != 0) {
                        Logger.i(RetryScheduler.TAG, "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + RetryScheduler.this.mWaitingRetryTasksCount);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (RetryScheduler.this.mRetryInfoList) {
                            for (int i11 = 0; i11 < RetryScheduler.this.mRetryInfoList.size(); i11++) {
                                RetryInfo retryInfo = (RetryInfo) RetryScheduler.this.mRetryInfoList.valueAt(i11);
                                if (retryInfo != null && retryInfo.canRetry(currentTimeMillis, i10, netWorkType, z10)) {
                                    if (z10) {
                                        retryInfo.resetRetryInterval();
                                    }
                                    arrayList.add(retryInfo);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator<E> iterator2 = arrayList.iterator2();
                            while (iterator2.hasNext()) {
                                RetryScheduler.this.doSchedulerRetryInSubThread(((RetryInfo) iterator2.next()).f38974id, netWorkType, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSchedulerRetryInSubThread(int i10, int i11, boolean z10) {
        IReserveWifiStatusListener reserveWifiStatusListener;
        boolean z11;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        synchronized (this.mRetryInfoList) {
            RetryInfo retryInfo = this.mRetryInfoList.get(i10);
            if (retryInfo == null) {
                return;
            }
            boolean z12 = true;
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i12 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i12;
                if (i12 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            Logger.i(TAG, "doSchedulerRetryInSubThread: downloadId = " + i10 + ", retryCount = " + retryInfo.mRetryCount + ", mWaitingRetryTasksCount = " + this.mWaitingRetryTasksCount);
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10);
            if (downloadInfo == null) {
                removeRetryInfo(i10);
                return;
            }
            Logger.e(TAG, "doSchedulerRetryInSubThread，id:" + i10);
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus != -3 && realStatus != -4) {
                if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                    if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
                        reserveWifiStatusListener.onStatusChanged(downloadInfo, 4, 3);
                    }
                    IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
                    if (downloadLaunchHandler != null) {
                        downloadLaunchHandler.onLaunchResume(Collections.singletonList(downloadInfo), 3);
                    }
                    removeRetryInfo(i10);
                    return;
                }
                if (realStatus != -1) {
                    return;
                }
                if (i11 != 0) {
                    z11 = true;
                } else if (!retryInfo.useJobScheduler) {
                    return;
                } else {
                    z11 = false;
                }
                BaseException failedException = downloadInfo.getFailedException();
                if (z11 && DownloadUtils.isInsufficientSpaceError(failedException)) {
                    z11 = canRetryWhenInsufficientSpace(downloadInfo, failedException);
                }
                retryInfo.increaseRetryCount();
                if (z11) {
                    Logger.i(TAG, "doSchedulerRetry: restart task, ****** id = " + retryInfo.f38974id);
                    retryInfo.updateRetryTimeStamp(System.currentTimeMillis());
                    if (z10) {
                        retryInfo.increaseRetryInterval();
                    }
                    downloadInfo.setRetryScheduleCount(retryInfo.mRetryCount);
                    if (downloadInfo.getStatus() == -1) {
                        Downloader.getInstance(context).restart(downloadInfo.getId());
                        return;
                    }
                    return;
                }
                if (z10) {
                    retryInfo.increaseRetryInterval();
                }
                if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                    z12 = false;
                }
                tryStartScheduleRetry(downloadInfo, z12, i11);
                return;
            }
            removeRetryInfo(i10);
        }
    }

    public static RetryScheduler getInstance() {
        if (sInstance == null) {
            synchronized (RetryScheduler.class) {
                if (sInstance == null) {
                    sInstance = new RetryScheduler();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNetWorkType() {
        try {
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (ConnectivityManager) this.mContext.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private RetryInfo obtainRetryInfo(int i10) {
        RetryInfo retryInfo = this.mRetryInfoList.get(i10);
        if (retryInfo == null) {
            synchronized (this.mRetryInfoList) {
                retryInfo = this.mRetryInfoList.get(i10);
                if (retryInfo == null) {
                    retryInfo = createRetryInfo(i10);
                }
                this.mRetryInfoList.put(i10, retryInfo);
            }
        }
        return retryInfo;
    }

    private int[] parserAllowErrorCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i10 = 0; i10 < split.length; i10++) {
                iArr[i10] = Integer.parseInt(split[i10]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void registerNetworkCallback() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.USE_NETWORK_CALLBACK, 0) != 1) {
            return;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (RetryScheduler.this.mContext != null) {
                        RetryScheduler retryScheduler = RetryScheduler.this;
                        retryScheduler.mConnectivityManager = (ConnectivityManager) retryScheduler.mContext.getApplicationContext().getSystemService("connectivity");
                        RetryScheduler.this.mConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                Logger.d(RetryScheduler.TAG, "network onAvailable: ");
                                RetryScheduler.this.scheduleAllTaskRetry(1, true);
                            }
                        });
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void removeRetryInfo(int i10) {
        synchronized (this.mRetryInfoList) {
            this.mRetryInfoList.remove(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAllTaskRetry(int i10, boolean z10) {
        if (this.mWaitingRetryTasksCount <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z10) {
                if (currentTimeMillis - this.mLastHandleAllTaskTime < 10000) {
                    return;
                }
            }
            this.mLastHandleAllTaskTime = currentTimeMillis;
            Logger.i(TAG, "scheduleAllTaskRetry, level = [" + i10 + "], force = [" + z10 + "]");
            if (z10) {
                this.mHandler.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i10;
            obtain.arg2 = z10 ? 1 : 0;
            this.mHandler.sendMessageDelayed(obtain, 2000L);
        }
    }

    public static void setRetryScheduleHandler(RetryScheduleHandler retryScheduleHandler) {
        sRetryScheduleHandler = retryScheduleHandler;
    }

    public void doSchedulerRetry(final int i10) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetryScheduler.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RetryScheduler retryScheduler = RetryScheduler.this;
                    retryScheduler.doSchedulerRetryInSubThread(i10, retryScheduler.getNetWorkType(), true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            doScheduleAllTaskRetry(message.arg1, message.arg2 == 1);
        } else {
            Logger.i(TAG, "handleMessage, doSchedulerRetry, id = " + message.what);
            doSchedulerRetry(message.what);
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        scheduleAllTaskRetry(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        scheduleAllTaskRetry(4, false);
    }

    public void scheduleRetryWhenHasTaskConnected() {
        scheduleAllTaskRetry(5, false);
    }

    public void scheduleRetryWhenHasTaskSucceed() {
        scheduleAllTaskRetry(2, true);
    }

    public void tryCancelScheduleRetry(int i10) {
        synchronized (this.mRetryInfoList) {
            RetryInfo retryInfo = this.mRetryInfoList.get(i10);
            if (retryInfo == null) {
                return;
            }
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i11 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i11;
                if (i11 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            if (retryInfo.useJobScheduler) {
                RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
                if (retryScheduleHandler != null) {
                    retryScheduleHandler.cancelRetry(i10);
                    return;
                }
                return;
            }
            this.mHandler.removeMessages(i10);
        }
    }

    public void tryStartScheduleRetry(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(DownloadConstants.MIME_APK) || !DownloadConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
            return;
        }
        tryStartScheduleRetry(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), getNetWorkType());
    }

    private void tryStartScheduleRetry(DownloadInfo downloadInfo, boolean z10, int i10) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        RetryInfo obtainRetryInfo = obtainRetryInfo(downloadInfo.getId());
        if (obtainRetryInfo.mRetryCount > obtainRetryInfo.maxCount) {
            Logger.w(TAG, "tryStartScheduleRetry, id = " + obtainRetryInfo.f38974id + ", mRetryCount = " + obtainRetryInfo.mRetryCount + ", maxCount = " + obtainRetryInfo.maxCount);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!DownloadUtils.isInsufficientSpaceError(failedException) && !DownloadUtils.isNetworkError(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!canRetryForAllowErrorCode(obtainRetryInfo, errorCode)) {
                return;
            }
            Logger.i(TAG, "allow error code, id = " + obtainRetryInfo.f38974id + ", error code = " + errorCode);
        }
        obtainRetryInfo.mNeedWifi = z10;
        synchronized (this.mRetryInfoList) {
            if (!obtainRetryInfo.mIsWaitingRetry) {
                obtainRetryInfo.mIsWaitingRetry = true;
                this.mWaitingRetryTasksCount++;
            }
        }
        int currentRetryIntervalMs = obtainRetryInfo.getCurrentRetryIntervalMs();
        Logger.i(TAG, "tryStartScheduleRetry: id = " + obtainRetryInfo.f38974id + ", delayTimeMills = " + currentRetryIntervalMs + ", mWaitingRetryTasks = " + this.mWaitingRetryTasksCount);
        if (!obtainRetryInfo.useJobScheduler) {
            if (z10) {
                return;
            }
            this.mHandler.removeMessages(downloadInfo.getId());
            this.mHandler.sendEmptyMessageDelayed(downloadInfo.getId(), currentRetryIntervalMs);
            return;
        }
        if (i10 == 0) {
            obtainRetryInfo.resetRetryInterval();
        }
        RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
        if (retryScheduleHandler != null) {
            retryScheduleHandler.scheduleRetry(downloadInfo, currentRetryIntervalMs, z10, i10);
        }
        if (this.mIsDownloaderProcess) {
            obtainRetryInfo.updateRetryTimeStamp(System.currentTimeMillis());
            obtainRetryInfo.increaseRetryCount();
            obtainRetryInfo.increaseRetryInterval();
        }
    }
}
