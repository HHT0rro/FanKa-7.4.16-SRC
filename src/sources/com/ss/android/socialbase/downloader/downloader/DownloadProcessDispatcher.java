package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadProcessDispatcher {
    private static volatile DownloadProcessDispatcher instance;
    private volatile SparseArray<Boolean> independentMap = new SparseArray<>();
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private volatile List<IDownloaderProcessConnectedListener> processConnectedListeners = new ArrayList();

    public static DownloadProcessDispatcher getInstance() {
        if (instance == null) {
            synchronized (DownloadProcessDispatcher.class) {
                instance = new DownloadProcessDispatcher();
            }
        }
        return instance;
    }

    private List<DownloadInfo> handleDownloadInfos(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i10)));
        }
        return arrayList;
    }

    public void addDownloadListener(int i10, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.addDownloadListener(i10, iDownloadListener.hashCode(), iDownloadListener, listenerType, z10);
    }

    public boolean canResume(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return false;
        }
        return downloadHandler.canResume(i10);
    }

    public void cancel(int i10, boolean z10) {
        if (DownloadUtils.isMainProcess()) {
            if (DownloadExpSwitchCode.isSwitchEnable(8388608)) {
                IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
                if (iDownloadProxy != null) {
                    iDownloadProxy.cancel(i10, z10);
                }
                IDownloadProxy iDownloadProxy2 = DownloadProxy.get(false);
                if (iDownloadProxy2 != null) {
                    iDownloadProxy2.cancel(i10, z10);
                    return;
                }
                return;
            }
            IDownloadProxy iDownloadProxy3 = DownloadProxy.get(false);
            if (iDownloadProxy3 != null) {
                iDownloadProxy3.cancel(i10, z10);
            }
            IDownloadProxy iDownloadProxy4 = DownloadProxy.get(true);
            if (iDownloadProxy4 != null) {
                iDownloadProxy4.cancel(i10, z10);
                return;
            }
            return;
        }
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler != null) {
            downloadHandler.cancel(i10, z10);
        }
        DownloadProxy.get(true).dispatchProcessCallback(2, i10);
    }

    public void clearDownloadData(int i10, boolean z10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.clearDownloadData(i10, z10);
    }

    public void dispatchDownloaderProcessConnectedEvent() {
        synchronized (this.processConnectedListeners) {
            for (IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener : this.processConnectedListeners) {
                if (iDownloaderProcessConnectedListener != null) {
                    iDownloaderProcessConnectedListener.onConnected();
                }
            }
        }
    }

    public void forceDownloadIngoreRecommendSize(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.forceDownloadIngoreRecommendSize(i10);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> allDownloadInfo = iDownloadProxy != null ? iDownloadProxy.getAllDownloadInfo() : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        return handleDownloadInfos(allDownloadInfo, iDownloadProxy2 != null ? iDownloadProxy2.getAllDownloadInfo() : null, sparseArray);
    }

    public long getCurBytes(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return 0L;
        }
        return downloadHandler.getCurBytes(i10);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadFileUriProvider(i10);
    }

    public IDownloadProxy getDownloadHandler(int i10) {
        return DownloadProxy.get(getDownloadWithIndependentProcessStatus(i10) == 1 && !DownloadUtils.isDownloaderProcess());
    }

    public int getDownloadId(String str, String str2) {
        return DownloadComponentManager.getDownloadId(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadInfo(i10);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        List<DownloadInfo> downloadInfoList = DownloadProxy.get(false).getDownloadInfoList(str);
        List<DownloadInfo> downloadInfoList2 = DownloadProxy.get(true).getDownloadInfoList(str);
        if (downloadInfoList == null && downloadInfoList2 == null) {
            return null;
        }
        if (downloadInfoList == null || downloadInfoList2 == null) {
            return downloadInfoList != null ? downloadInfoList : downloadInfoList2;
        }
        ArrayList arrayList = new ArrayList(downloadInfoList);
        arrayList.addAll(downloadInfoList2);
        return arrayList;
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadNotificationEventListener(i10);
    }

    public int getDownloadWithIndependentProcessStatus(int i10) {
        if (!DownloadComponentManager.supportMultiProc()) {
            return -1;
        }
        if (!DownloadUtils.isDownloaderProcess() && DownloadProxy.get(true).isServiceAlive()) {
            return DownloadProxy.get(true).getDownloadWithIndependentProcessStatus(i10);
        }
        return getDownloadWithIndependentProcessStatusInner(i10);
    }

    public synchronized int getDownloadWithIndependentProcessStatusInner(int i10) {
        if (this.independentMap.get(i10) == null) {
            return -1;
        }
        return this.independentMap.get(i10).booleanValue() ? 1 : 0;
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> downloadingDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getDownloadingDownloadInfosWithMimeType(str) : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        return handleDownloadInfos(downloadingDownloadInfosWithMimeType, iDownloadProxy2 != null ? iDownloadProxy2.getDownloadingDownloadInfosWithMimeType(str) : null, sparseArray);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> failedDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getFailedDownloadInfosWithMimeType(str) : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        return handleDownloadInfos(failedDownloadInfosWithMimeType, iDownloadProxy2 != null ? iDownloadProxy2.getFailedDownloadInfosWithMimeType(str) : null, sparseArray);
    }

    public INotificationClickCallback getNotificationClickCallback(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getNotificationClickCallback(i10);
    }

    public int getStatus(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return 0;
        }
        return downloadHandler.getStatus(i10);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> successedDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getSuccessedDownloadInfosWithMimeType(str) : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        return handleDownloadInfos(successedDownloadInfosWithMimeType, iDownloadProxy2 != null ? iDownloadProxy2.getSuccessedDownloadInfosWithMimeType(str) : null, sparseArray);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> unCompletedDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getUnCompletedDownloadInfosWithMimeType(str) : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        return handleDownloadInfos(unCompletedDownloadInfosWithMimeType, iDownloadProxy2 != null ? iDownloadProxy2.getUnCompletedDownloadInfosWithMimeType(str) : null, sparseArray);
    }

    public boolean isDownloadCacheSyncSuccess() {
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            return iDownloadProxy.isDownloadCacheSyncSuccess();
        }
        return false;
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        IDownloadProxy downloadHandler;
        if (downloadInfo == null || (downloadHandler = getDownloadHandler(downloadInfo.getId())) == null) {
            return false;
        }
        return downloadHandler.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    public boolean isDownloading(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return false;
        }
        return downloadHandler.isDownloading(i10);
    }

    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    public void pause(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.pause(i10);
    }

    public void pauseAll() {
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.pauseAll();
        }
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.pauseAll();
        }
    }

    public void recordTaskProcessIndependent(int i10) {
        if (i10 == 0) {
            return;
        }
        setDownloadIndependentProcessStatus(i10, true);
        IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.startService();
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadComponentManager.registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        if (iDownloaderProcessConnectedListener == null) {
            return;
        }
        if (DownloadUtils.isDownloaderProcess()) {
            iDownloaderProcessConnectedListener.onConnected();
            return;
        }
        if (DownloadProxy.get(true).isServiceAlive()) {
            iDownloaderProcessConnectedListener.onConnected();
        }
        synchronized (this.processConnectedListeners) {
            if (!this.processConnectedListeners.contains(iDownloaderProcessConnectedListener)) {
                this.processConnectedListeners.add(iDownloaderProcessConnectedListener);
            }
        }
    }

    public void removeDownloadListener(int i10, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.removeDownloadListener(i10, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, listenerType, z10);
    }

    public void restart(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.restart(i10);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.restartAllFailedDownloadTasks(list);
        }
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.restartAllFailedDownloadTasks(list);
        }
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
    }

    public void resume(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.resume(i10);
    }

    public boolean retryDelayStart(int i10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return false;
        }
        return downloadHandler.retryDelayStart(i10);
    }

    public synchronized void setDownloadIndependentProcessStatus(int i10, boolean z10) {
        this.independentMap.put(i10, z10 ? Boolean.TRUE : Boolean.FALSE);
    }

    public void setDownloadNotificationEventListener(int i10, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.setDownloadNotificationEventListener(i10, iDownloadNotificationEventListener);
    }

    public void setDownloadWithIndependentProcessStatus(int i10, boolean z10) {
        setDownloadIndependentProcessStatus(i10, z10);
        if (DownloadComponentManager.supportMultiProc() && !DownloadUtils.isDownloaderProcess() && DownloadProxy.get(true).isServiceAlive()) {
            DownloadProxy.get(true).setDownloadWithIndependentProcessStatus(i10, z10);
        }
        if (DownloadComponentManager.isDownloadInMultiProcess() || DownloadUtils.isDownloaderProcess() || DownloadUtils.isMainProcess()) {
            return;
        }
        try {
            Intent intent = new Intent(DownloadComponentManager.getAppContext(), (Class<?>) DownloadHandleService.class);
            intent.setAction(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY);
            intent.putExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, i10);
            DownloadComponentManager.getAppContext().startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLogLevel(int i10) {
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.setLogLevel(i10);
        }
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.setLogLevel(i10);
        }
    }

    public void setThrottleNetSpeed(int i10, long j10) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.setThrottleNetSpeed(i10, j10);
    }

    public void tryDownload(final DownloadTask downloadTask) {
        final IDownloadProxy downloadHandler = getDownloadHandler(downloadTask);
        if (downloadHandler == null) {
            if (downloadTask != null) {
                DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.mainThreadHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    downloadHandler.tryDownload(downloadTask);
                }
            }, 500L);
        } else {
            downloadHandler.tryDownload(downloadTask);
        }
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadComponentManager.unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        if (iDownloaderProcessConnectedListener == null) {
            return;
        }
        synchronized (this.processConnectedListeners) {
            if (this.processConnectedListeners.contains(iDownloaderProcessConnectedListener)) {
                this.processConnectedListeners.remove(iDownloaderProcessConnectedListener);
            }
        }
    }

    private IDownloadProxy getDownloadHandler(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<DownloadChunk> downloadChunk;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        boolean isNeedIndependentProcess = downloadInfo.isNeedIndependentProcess();
        if (DownloadUtils.isDownloaderProcess() || !DownloadUtils.isMainProcess()) {
            isNeedIndependentProcess = true;
        }
        int downloadWithIndependentProcessStatus = getDownloadWithIndependentProcessStatus(downloadInfo.getId());
        if (downloadWithIndependentProcessStatus >= 0 && downloadWithIndependentProcessStatus != isNeedIndependentProcess) {
            try {
                if (downloadWithIndependentProcessStatus == 1) {
                    if (DownloadUtils.isMainProcess()) {
                        DownloadProxy.get(true).pause(downloadInfo.getId());
                        DownloadInfo downloadInfo2 = DownloadProxy.get(true).getDownloadInfo(downloadInfo.getId());
                        if (downloadInfo2 != null) {
                            DownloadProxy.get(false).syncDownloadInfo(downloadInfo2);
                        }
                        if (downloadInfo2.getChunkCount() > 1 && (downloadChunk = DownloadProxy.get(true).getDownloadChunk(downloadInfo.getId())) != null) {
                            DownloadProxy.get(false).syncDownloadChunks(downloadInfo.getId(), DownloadUtils.parseHostChunkList(downloadChunk));
                        }
                    }
                } else if (DownloadUtils.isMainProcess()) {
                    DownloadProxy.get(false).pause(downloadInfo.getId());
                    List<DownloadChunk> downloadChunk2 = DownloadProxy.get(false).getDownloadChunk(downloadInfo.getId());
                    if (downloadChunk2 != null) {
                        DownloadProxy.get(true).syncDownloadChunks(downloadInfo.getId(), DownloadUtils.parseHostChunkList(downloadChunk2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    DownloadProxy.get(true).dispatchProcessCallback(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        setDownloadWithIndependentProcessStatus(downloadInfo.getId(), isNeedIndependentProcess);
        return DownloadProxy.get(isNeedIndependentProcess);
    }

    public void addDownloadListener(int i10, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10, boolean z11) {
        IDownloadProxy downloadHandler = getDownloadHandler(i10);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.addDownloadListener(i10, iDownloadListener.hashCode(), iDownloadListener, listenerType, z10, z11);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        int downloadId = getDownloadId(str, str2);
        IDownloadProxy downloadHandler = getDownloadHandler(downloadId);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadInfo(downloadId);
    }
}
