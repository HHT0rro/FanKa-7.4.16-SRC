package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ProcessDownloadHandler implements IDownloadProxy {
    private final boolean bugFixServiceAlive;
    private final IDownloadCache downloadCache;
    private final AbsDownloadEngine downloadEngine;
    private final IDownloadServiceHandler downloadServiceHandler;

    public ProcessDownloadHandler() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        this.downloadCache.addDownloadChunk(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.addDownloadListener(i10, i11, iDownloadListener, listenerType, z10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback processCallback) {
        DownloadComponentManager.addProcessCallback(processCallback);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.isInDownloadTaskPool(i10);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(int i10, boolean z10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.cancel(i10, z10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        this.downloadCache.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(int i10, boolean z10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.clearDownloadData(i10, z10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int i10, int i11) {
        if (DownloadComponentManager.getProcessCallbacks() != null) {
            for (ProcessCallback processCallback : DownloadComponentManager.getProcessCallbacks()) {
                if (processCallback != null) {
                    processCallback.callback(i11, i10);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void forceDownloadIngoreRecommendSize(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.forceDownloadIgnoreRecommendSize(i10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getAllDownloadInfo();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int i10) {
        DownloadInfo downloadInfo;
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache == null || (downloadInfo = iDownloadCache.getDownloadInfo(i10)) == null) {
            return 0L;
        }
        int chunkCount = downloadInfo.getChunkCount();
        if (chunkCount <= 1) {
            return downloadInfo.getCurBytes();
        }
        List<DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(i10);
        if (downloadChunk == null || downloadChunk.size() != chunkCount) {
            return 0L;
        }
        return DownloadUtils.getTotalOffset(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadChunk> getDownloadChunk(int i10) {
        return this.downloadCache.getDownloadChunk(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadFileUriProvider(i10);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String str, String str2) {
        return DownloadComponentManager.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadInfo(i10);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String str) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadInfoList(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadNotificationEventListener(i10);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int i10) {
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.getDownloadingDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getFailedDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        INotificationClickCallback notificationClickCallback = absDownloadEngine != null ? absDownloadEngine.getNotificationClickCallback(i10) : null;
        return notificationClickCallback == null ? DownloadComponentManager.getNotificationClickCallback() : notificationClickCallback;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int i10) {
        DownloadInfo downloadInfo;
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine == null || (downloadInfo = absDownloadEngine.getDownloadInfo(i10)) == null) {
            return 0;
        }
        return downloadInfo.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getSuccessedDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        IDownloadCache iDownloadCache = this.downloadCache;
        if (iDownloadCache != null) {
            return iDownloadCache.getUnCompletedDownloadInfosWithMimeType(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        return this.downloadCache.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean isDownloadSuccessAndFileNotExist = DownloadUtils.isDownloadSuccessAndFileNotExist(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (isDownloadSuccessAndFileNotExist) {
            if (DownloadExpSwitchCode.isSwitchEnable(33554432)) {
                clearDownloadData(downloadInfo.getId(), true);
            } else {
                resetDownloadData(downloadInfo.getId(), true);
            }
        }
        return isDownloadSuccessAndFileNotExist;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.isDownloading(i10);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        IDownloadServiceHandler iDownloadServiceHandler;
        return this.bugFixServiceAlive && (iDownloadServiceHandler = this.downloadServiceHandler) != null && iDownloadServiceHandler.isServiceAlive();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceForeground() {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            return iDownloadServiceHandler.isServiceForeground();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.pause(i10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.shutDown();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeAllDownloadChunk(int i10) {
        this.downloadCache.removeAllDownloadChunk(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int i10) {
        return this.downloadCache.removeDownloadInfo(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.removeDownloadListener(i10, i11, iDownloadListener, listenerType, z10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int i10) {
        return this.downloadCache.removeDownloadTaskData(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(int i10, boolean z10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.resetDownloadData(i10, z10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.restart(i10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(List<String> list) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.restartAllFailedDownloadTasks(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.resume(i10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean retryDelayStart(int i10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            return absDownloadEngine.retryDelayStart(i10);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int i10, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.setDownloadNotificationEventListener(i10, iDownloadNotificationEventListener);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int i10, boolean z10) {
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(i10, z10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int i10) {
        Logger.setLogLevel(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(int i10, long j10) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.setThrottleNetSpeed(i10, j10);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startForeground(int i10, Notification notification) {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.startForeground(i10, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void stopForeground(boolean z10, boolean z11) {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.stopForeground(z11);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadChunks(int i10, List<DownloadChunk> list) {
        this.downloadCache.syncDownloadChunks(i10, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        this.downloadCache.syncDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int i10, List<DownloadChunk> list) {
        this.downloadCache.syncDownloadInfoFromOtherCache(i10, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(DownloadTask downloadTask) {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.tryDownload(downloadTask);
        } else if (downloadTask != null) {
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
        IDownloadServiceHandler iDownloadServiceHandler = this.downloadServiceHandler;
        if (iDownloadServiceHandler != null) {
            iDownloadServiceHandler.tryDownloadWithEngine(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateDownloadChunk(int i10, int i11, long j10) {
        this.downloadCache.updateDownloadChunk(i10, i11, j10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        return this.downloadCache.updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunk(int i10, int i11, int i12, long j10) {
        this.downloadCache.updateSubDownloadChunk(i10, i11, i12, j10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void updateSubDownloadChunkIndex(int i10, int i11, int i12, int i13) {
        this.downloadCache.updateSubDownloadChunkIndex(i10, i11, i12, i13);
    }

    public ProcessDownloadHandler(boolean z10) {
        this.downloadEngine = DownloadComponentManager.getDownloadEngine();
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        if (!z10) {
            this.downloadServiceHandler = DownloadComponentManager.getDownloadServiceHandler();
        } else {
            this.downloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        }
        this.bugFixServiceAlive = DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.SERVICE_ALIVE, false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10, boolean z11) {
        AbsDownloadEngine absDownloadEngine = this.downloadEngine;
        if (absDownloadEngine != null) {
            absDownloadEngine.addDownloadListener(i10, i11, iDownloadListener, listenerType, z10, z11);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String str, String str2) {
        return getDownloadInfo(DownloadComponentManager.getDownloadId(str, str2));
    }
}
