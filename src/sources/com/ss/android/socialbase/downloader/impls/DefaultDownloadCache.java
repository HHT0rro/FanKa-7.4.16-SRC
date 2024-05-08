package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultDownloadCache implements IDownloadCache {
    private static final int MSG_RESUME = 1;
    private static final String TAG = "DefaultDownloadCache";
    private WeakDownloadHandler.IHandler IHandler = new WeakDownloadHandler.IHandler() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.1
        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message.what == 1) {
                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DefaultDownloadCache.this.resumeUnCompleteTask();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    private final DownloadCache downloadCache = new DownloadCache();
    private volatile boolean hasInitSqlDownloadCache;
    private ISqlDownloadCache sqlDownloadCache;
    private volatile boolean unCompleteTaskResumed;
    private WeakDownloadHandler weakHandler;

    public DefaultDownloadCache() {
        this.weakHandler = null;
        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_SIGBUS_DOWNLOADER_DB)) {
            if (!DownloadUtils.isMainProcess() && DownloadComponentManager.supportMultiProc()) {
                this.sqlDownloadCache = DownloadComponentManager.getIndependentHolderCreator().createCache(new DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.2
                    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener
                    public void onRebindError() {
                        DefaultDownloadCache.this.sqlDownloadCache = new SqlDownloadCache();
                    }
                });
            } else {
                this.sqlDownloadCache = new SqlDownloadCache();
            }
        } else {
            this.sqlDownloadCache = new SqlDownloadCache();
        }
        this.hasInitSqlDownloadCache = false;
        this.weakHandler = new WeakDownloadHandler(Looper.getMainLooper(), this.IHandler);
        init();
    }

    private boolean isPauseReserveOnWifi(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadCacheSyncSuccess() {
        synchronized (this) {
            this.hasInitSqlDownloadCache = true;
            notifyAll();
        }
    }

    private void updateDownloadInfoInDB(DownloadInfo downloadInfo) {
        updateDownloadInfoInDB(downloadInfo, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i10, long j10) {
        DownloadInfo OnDownloadTaskCancel = this.downloadCache.OnDownloadTaskCancel(i10, j10);
        syncDownloadInfoFromOtherCache(i10, null);
        return OnDownloadTaskCancel;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i10, long j10) {
        DownloadInfo OnDownloadTaskCompleted = this.downloadCache.OnDownloadTaskCompleted(i10, j10);
        syncDownloadInfoFromOtherCache(i10, null);
        return OnDownloadTaskCompleted;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i10, long j10, String str, String str2) {
        DownloadInfo OnDownloadTaskConnected = this.downloadCache.OnDownloadTaskConnected(i10, j10, str, str2);
        updateDownloadInfoInDB(OnDownloadTaskConnected);
        return OnDownloadTaskConnected;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i10, long j10) {
        DownloadInfo OnDownloadTaskError = this.downloadCache.OnDownloadTaskError(i10, j10);
        syncDownloadInfoFromOtherCache(i10, null);
        return OnDownloadTaskError;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i10) {
        DownloadInfo OnDownloadTaskIntercept = this.downloadCache.OnDownloadTaskIntercept(i10);
        updateDownloadInfoInDB(OnDownloadTaskIntercept);
        return OnDownloadTaskIntercept;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i10, long j10) {
        DownloadInfo OnDownloadTaskPause = this.downloadCache.OnDownloadTaskPause(i10, j10);
        syncDownloadInfoFromOtherCache(i10, null);
        return OnDownloadTaskPause;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i10) {
        DownloadInfo OnDownloadTaskPrepare = this.downloadCache.OnDownloadTaskPrepare(i10);
        updateDownloadInfoInDB(OnDownloadTaskPrepare);
        return OnDownloadTaskPrepare;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i10, long j10) {
        DownloadInfo OnDownloadTaskProgress = this.downloadCache.OnDownloadTaskProgress(i10, j10);
        updateDownloadInfoInDB(OnDownloadTaskProgress, false);
        return OnDownloadTaskProgress;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i10) {
        DownloadInfo OnDownloadTaskRetry = this.downloadCache.OnDownloadTaskRetry(i10);
        updateDownloadInfoInDB(OnDownloadTaskRetry);
        return OnDownloadTaskRetry;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        synchronized (this.downloadCache) {
            this.downloadCache.addDownloadChunk(downloadChunk);
        }
        if (DownloadUtils.needNotifyDownloaderProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.addDownloadChunk(downloadChunk);
                return;
            } else {
                this.sqlDownloadCache.addDownloadChunk(downloadChunk);
                return;
            }
        }
        this.sqlDownloadCache.addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
        if (DownloadUtils.needNotifyDownloaderProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.addDownloadChunk(downloadChunk);
                return;
            } else {
                this.sqlDownloadCache.addDownloadChunk(downloadChunk);
                return;
            }
        }
        this.sqlDownloadCache.addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i10) {
        return getDownloadInfo(i10) != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        try {
            this.downloadCache.clearData();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        if (DownloadUtils.needNotifyDownloaderProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.clearData();
                return;
            } else {
                this.sqlDownloadCache.clearData();
                return;
            }
        }
        this.sqlDownloadCache.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        if (this.hasInitSqlDownloadCache) {
            return true;
        }
        synchronized (this) {
            if (!this.hasInitSqlDownloadCache) {
                Logger.w(TAG, "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                Logger.w(TAG, "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.hasInitSqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        return this.downloadCache.getAllDownloadInfo();
    }

    public DownloadCache getDownloadCache() {
        return this.downloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadChunk> getDownloadChunk(int i10) {
        return this.downloadCache.getDownloadChunk(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i10) {
        return this.downloadCache.getDownloadInfo(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String str) {
        return this.downloadCache.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i10) {
        Map<Long, Segment> segmentMap = this.downloadCache.getSegmentMap(i10);
        if (segmentMap != null && !segmentMap.isEmpty()) {
            return segmentMap;
        }
        Map<Long, Segment> segmentMap2 = this.sqlDownloadCache.getSegmentMap(i10);
        this.downloadCache.updateSegments(i10, segmentMap2);
        return segmentMap2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int i10) {
        List<Segment> segments = this.downloadCache.getSegments(i10);
        return (segments == null || segments.size() == 0) ? this.sqlDownloadCache.getSegments(i10) : segments;
    }

    public ISqlDownloadCache getSqlDownloadCache() {
        return this.sqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
        List<DownloadChunk> list;
        DownloadInfo downloadInfo;
        DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<DownloadChunk>> sparseArray2 = new SparseArray<>();
        synchronized (this.downloadCache) {
            SparseArray<DownloadInfo> downloadInfoMap = this.downloadCache.getDownloadInfoMap();
            for (int i10 = 0; i10 < downloadInfoMap.size(); i10++) {
                int keyAt = downloadInfoMap.keyAt(i10);
                if (keyAt != 0 && (downloadInfo = downloadInfoMap.get(keyAt)) != null) {
                    sparseArray.put(keyAt, downloadInfo);
                }
            }
            SparseArray<List<DownloadChunk>> chunkListMap = this.downloadCache.getChunkListMap();
            for (int i11 = 0; i11 < chunkListMap.size(); i11++) {
                int keyAt2 = chunkListMap.keyAt(i11);
                if (keyAt2 != 0 && (list = chunkListMap.get(keyAt2)) != null) {
                    sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.sqlDownloadCache.init(sparseArray, sparseArray2, new SqlCacheLoadCompleteCallback() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadCache.3
            @Override // com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback
            public void callback() {
                synchronized (DefaultDownloadCache.this.downloadCache) {
                    SparseArray<DownloadInfo> downloadInfoMap2 = DefaultDownloadCache.this.downloadCache.getDownloadInfoMap();
                    if (sparseArray != null) {
                        for (int i12 = 0; i12 < sparseArray.size(); i12++) {
                            int keyAt3 = sparseArray.keyAt(i12);
                            if (keyAt3 != 0) {
                                downloadInfoMap2.put(keyAt3, (DownloadInfo) sparseArray.get(keyAt3));
                            }
                        }
                    }
                    SparseArray<List<DownloadChunk>> chunkListMap2 = DefaultDownloadCache.this.downloadCache.getChunkListMap();
                    if (sparseArray2 != null) {
                        for (int i13 = 0; i13 < sparseArray2.size(); i13++) {
                            int keyAt4 = sparseArray2.keyAt(i13);
                            if (keyAt4 != 0) {
                                chunkListMap2.put(keyAt4, (List) sparseArray2.get(keyAt4));
                            }
                        }
                    }
                }
                DefaultDownloadCache.this.onDownloadCacheSyncSuccess();
                DefaultDownloadCache.this.resumeUnCompleteTaskMayDelayed();
                DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_SUCCESS);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return this.hasInitSqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i10) {
        DownloadInfo onDownloadTaskStart = this.downloadCache.onDownloadTaskStart(i10);
        updateDownloadInfoInDB(onDownloadTaskStart);
        return onDownloadTaskStart;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeAllDownloadChunk(int i10) {
        this.downloadCache.removeAllDownloadChunk(i10);
        if (DownloadUtils.needNotifyDownloaderProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.removeAllDownloadChunk(i10);
                return;
            } else {
                this.sqlDownloadCache.removeAllDownloadChunk(i10);
                return;
            }
        }
        this.sqlDownloadCache.removeAllDownloadChunk(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i10) {
        try {
            if (DownloadUtils.needNotifyDownloaderProcess()) {
                IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
                if (iDownloadProxy != null) {
                    iDownloadProxy.removeDownloadInfo(i10);
                } else {
                    this.sqlDownloadCache.removeDownloadInfo(i10);
                }
            } else {
                this.sqlDownloadCache.removeDownloadInfo(i10);
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        return this.downloadCache.removeDownloadInfo(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i10) {
        if (DownloadUtils.needNotifyDownloaderProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.removeDownloadTaskData(i10);
            } else {
                this.sqlDownloadCache.removeDownloadTaskData(i10);
            }
        } else {
            this.sqlDownloadCache.removeDownloadTaskData(i10);
        }
        return this.downloadCache.removeDownloadTaskData(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i10) {
        this.downloadCache.removeSegments(i10);
        this.sqlDownloadCache.removeSegments(i10);
    }

    public void resumeUnCompleteTask() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.hasInitSqlDownloadCache) {
            if (this.unCompleteTaskResumed) {
                Logger.d(TAG, "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.unCompleteTaskResumed = true;
            if (DownloadUtils.isMainProcess()) {
                IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
                if (downloadLaunchHandler != null) {
                    list = downloadLaunchHandler.getResumeMimeTypes();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> downloadInfoMap = this.downloadCache.getDownloadInfoMap();
                    for (int i10 = 0; i10 < downloadInfoMap.size(); i10++) {
                        int keyAt = downloadInfoMap.keyAt(i10);
                        if (keyAt != 0 && (downloadInfo2 = downloadInfoMap.get(keyAt)) != null) {
                            sparseArray.put(keyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                    int keyAt2 = sparseArray.keyAt(i11);
                    if (keyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                            DownloadMonitorHelper.monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), downloadInfo, null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (downloadLaunchHandler == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                downloadLaunchHandler.onLaunchResume(arrayList, 1);
            }
        }
    }

    public void resumeUnCompleteTaskMayDelayed() {
        long j10;
        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_TASK_RESUME_DELAY)) {
            j10 = HwCubicBezierInterpolator.f34870a;
        } else {
            j10 = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
        }
        this.weakHandler.sendMessageDelayed(this.weakHandler.obtainMessage(1), j10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadChunks(int i10, List<DownloadChunk> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.downloadCache.syncDownloadChunks(i10, list);
        if (DownloadUtils.isDownloaderProcess()) {
            this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i10, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.downloadCache.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i10, List<DownloadChunk> list) {
        try {
            updateDownloadInfo(this.downloadCache.getDownloadInfo(i10));
            if (list == null) {
                list = this.downloadCache.getDownloadChunk(i10);
            }
            if (DownloadUtils.needNotifyDownloaderProcess()) {
                IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
                if (iDownloadProxy != null) {
                    iDownloadProxy.syncDownloadInfoFromOtherCache(i10, list);
                    return;
                } else {
                    this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i10, list);
                    return;
                }
            }
            this.sqlDownloadCache.syncDownloadInfoFromOtherCache(i10, list);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo updateChunkCount(int i10, int i11) {
        DownloadInfo updateChunkCount = this.downloadCache.updateChunkCount(i10, i11);
        updateDownloadInfoInDB(updateChunkCount);
        return updateChunkCount;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateDownloadChunk(int i10, int i11, long j10) {
        this.downloadCache.updateDownloadChunk(i10, i11, j10);
        if (DownloadUtils.needNotifyDownloaderProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.updateDownloadChunk(i10, i11, j10);
                return;
            } else {
                this.sqlDownloadCache.updateDownloadChunk(i10, i11, j10);
                return;
            }
        }
        this.sqlDownloadCache.updateDownloadChunk(i10, i11, j10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean updateDownloadInfo = this.downloadCache.updateDownloadInfo(downloadInfo);
        updateDownloadInfoInDB(downloadInfo);
        return updateDownloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i10, Map<Long, Segment> map) {
        this.downloadCache.updateSegments(i10, map);
        this.sqlDownloadCache.updateSegments(i10, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunk(int i10, int i11, int i12, long j10) {
        if (DownloadUtils.needNotifyDownloaderProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.updateSubDownloadChunk(i10, i11, i12, j10);
                return;
            } else {
                this.sqlDownloadCache.updateSubDownloadChunk(i10, i11, i12, j10);
                return;
            }
        }
        this.sqlDownloadCache.updateSubDownloadChunk(i10, i11, i12, j10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i10, int i11, int i12, int i13) {
        if (DownloadUtils.needNotifyDownloaderProcess()) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.updateSubDownloadChunkIndex(i10, i11, i12, i13);
                return;
            } else {
                this.sqlDownloadCache.updateSubDownloadChunkIndex(i10, i11, i12, i13);
                return;
            }
        }
        this.sqlDownloadCache.updateSubDownloadChunkIndex(i10, i11, i12, i13);
    }

    private void updateDownloadInfoInDB(DownloadInfo downloadInfo, boolean z10) {
        if (downloadInfo == null) {
            return;
        }
        if (!DownloadUtils.needNotifyDownloaderProcess()) {
            this.sqlDownloadCache.updateDownloadInfo(downloadInfo);
            return;
        }
        if (z10) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.updateDownloadInfo(downloadInfo);
            } else {
                this.sqlDownloadCache.updateDownloadInfo(downloadInfo);
            }
        }
    }
}
