package com.ss.android.socialbase.downloader.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ExecutorGroup;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.thread.DownloadThreadPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadTask {
    private boolean autoSetHashCodeForSameTask;
    private IChunkAdjustCalculator chunkAdjustCalculator;
    private IChunkCntCalculator chunkStrategy;
    private IDownloadDepend depend;
    private IDownloadDiskSpaceHandler diskSpaceHandler;
    private final List<IDownloadCompleteHandler> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.Builder downloadInfoBuilder;
    private IDownloadFileUriProvider fileUriProvider;
    private IDownloadForbiddenHandler forbiddenHandler;
    private int hashCodeForSameTask;
    private IDownloadInterceptor interceptor;
    private final SparseArray<IDownloadListener> mainThreadListeners;
    private IDownloadMonitorDepend monitorDepend;
    private boolean needDelayForCacheSync;
    private INotificationClickCallback notificationClickCallback;
    private IDownloadNotificationEventListener notificationEventListener;
    private final SparseArray<IDownloadListener> notificationListeners;
    private IRetryDelayTimeCalculator retryDelayTimeCalculator;
    private final SparseArray<ListenerType> singleListenerHashCodeMap;
    private final Map<ListenerType, IDownloadListener> singleListenerMap;
    private final SparseArray<IDownloadListener> subThreadListeners;

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new SparseArray<>();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoSetHashCodeForSameTask = true;
        this.downloadInfoBuilder = new DownloadInfo.Builder();
        this.mainThreadListeners = new SparseArray<>();
        this.subThreadListeners = new SparseArray<>();
        this.notificationListeners = new SparseArray<>();
    }

    private void addAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            int keyAt = sparseArray.keyAt(i10);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    private void copyListeners(SparseArray<IDownloadListener> sparseArray, SparseArray<IDownloadListener> sparseArray2) {
        sparseArray.clear();
        for (int i10 = 0; i10 < sparseArray2.size(); i10++) {
            int keyAt = sparseArray2.keyAt(i10);
            IDownloadListener iDownloadListener = sparseArray2.get(keyAt);
            if (iDownloadListener != null) {
                sparseArray.put(keyAt, iDownloadListener);
            }
        }
    }

    private void removeAll(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.remove(sparseArray2.keyAt(i10));
        }
    }

    private void setChunkCalculator() {
        if (this.downloadInfo.getThrottleNetSpeed() > 0) {
            chunkStategy(new IChunkCntCalculator() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.2
                @Override // com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator
                public int calculateChunkCount(long j10) {
                    return 1;
                }
            });
        }
    }

    public DownloadTask addDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.downloadCompleteHandlers) {
            if (iDownloadCompleteHandler != null) {
                if (!this.downloadCompleteHandlers.contains(iDownloadCompleteHandler)) {
                    this.downloadCompleteHandlers.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }

    public void addDownloadListener(int i10, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        Map<ListenerType, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z10 && (map = this.singleListenerMap) != null) {
            map.put(listenerType, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i10, listenerType);
            }
        }
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(i10, iDownloadListener);
        }
    }

    public void addListenerToDownloadingSameTask() {
        Logger.d("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
            this.downloadInfo.setAddListenerToSameTask(true);
        }
        addListenerToDownloadingSameTask(ListenerType.MAIN);
        addListenerToDownloadingSameTask(ListenerType.SUB);
        DownloadMonitorHelper.monitorSendWithTaskMonitor(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    public DownloadTask addListenerToSameTask(boolean z10) {
        this.downloadInfoBuilder.addListenerToSameTask(z10);
        return this;
    }

    public void asyncDownload(final IDownloadStartCallback iDownloadStartCallback) {
        DownloadThreadPool.executeOP(new Runnable() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                int download = DownloadTask.this.download();
                IDownloadStartCallback iDownloadStartCallback2 = iDownloadStartCallback;
                if (iDownloadStartCallback2 != null) {
                    iDownloadStartCallback2.onStart(download);
                }
            }
        });
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        IDownloadListener singleDownloadListener = getSingleDownloadListener(ListenerType.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(ListenerType.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public DownloadTask autoResumed(boolean z10) {
        this.downloadInfoBuilder.autoResumed(z10);
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z10) {
        this.autoSetHashCodeForSameTask = z10;
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i10) {
        this.downloadInfoBuilder.backUpUrlRetryCount(i10);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.backUpUrls(list);
        return this;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public DownloadTask chunkAdjustCalculator(IChunkAdjustCalculator iChunkAdjustCalculator) {
        this.chunkAdjustCalculator = iChunkAdjustCalculator;
        return this;
    }

    public DownloadTask chunkStategy(IChunkCntCalculator iChunkCntCalculator) {
        this.chunkStrategy = iChunkCntCalculator;
        return this;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        this.chunkAdjustCalculator = downloadTask.chunkAdjustCalculator;
        this.chunkStrategy = downloadTask.chunkStrategy;
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.retryDelayTimeCalculator = downloadTask.retryDelayTimeCalculator;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        for (Map.Entry<ListenerType, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z10) {
        this.downloadInfoBuilder.deleteCacheIfCheckFailed(z10);
        return this;
    }

    public DownloadTask depend(IDownloadDepend iDownloadDepend) {
        this.depend = iDownloadDepend;
        return this;
    }

    public DownloadTask diskSpaceHandler(IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.diskSpaceHandler = iDownloadDiskSpaceHandler;
        return this;
    }

    public DownloadTask distinctDirectory(boolean z10) {
        this.downloadInfoBuilder.distinctDirectory(z10);
        return this;
    }

    public int download() {
        this.downloadInfo = this.downloadInfoBuilder.build();
        DownloadInfo downloadInfo = DownloadComponentManager.getDownloadCache().getDownloadInfo(this.downloadInfo.getId());
        if (downloadInfo == null) {
            this.downloadInfo.generateTaskId();
            DownloadMonitorHelper.monitorSend(this, null, 0);
        } else {
            this.downloadInfo.copyTaskIdFromCacheData(downloadInfo);
        }
        setChunkCalculator();
        DownloadProcessDispatcher.getInstance().tryDownload(this);
        DownloadInfo downloadInfo2 = this.downloadInfo;
        if (downloadInfo2 == null) {
            return 0;
        }
        return downloadInfo2.getId();
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.downloadSetting(jSONObject);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.enqueueType(enqueueType);
        return this;
    }

    public DownloadTask executorGroup(@ExecutorGroup int i10) {
        this.downloadInfoBuilder.executorGroup(i10);
        return this;
    }

    public DownloadTask expectFileLength(long j10) {
        this.downloadInfoBuilder.expectFileLength(j10);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z10) {
        this.downloadInfoBuilder.expiredRedownload(z10);
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.extra(str);
        return this;
    }

    public DownloadTask extraHeaders(List<HttpHeader> list) {
        this.downloadInfoBuilder.extraHeaders(list);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.extraMonitorStatus(iArr);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask forbiddenHandler(IDownloadForbiddenHandler iDownloadForbiddenHandler) {
        this.forbiddenHandler = iDownloadForbiddenHandler;
        return this;
    }

    public DownloadTask force(boolean z10) {
        this.downloadInfoBuilder.force(z10);
        return this;
    }

    public IChunkAdjustCalculator getChunkAdjustCalculator() {
        return this.chunkAdjustCalculator;
    }

    public IChunkCntCalculator getChunkStrategy() {
        return this.chunkStrategy;
    }

    public IDownloadDepend getDepend() {
        return this.depend;
    }

    public IDownloadDiskSpaceHandler getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public IDownloadCompleteHandler getDownloadCompleteHandlerByIndex(int i10) {
        synchronized (this.downloadCompleteHandlers) {
            if (i10 >= this.downloadCompleteHandlers.size()) {
                return null;
            }
            return this.downloadCompleteHandlers.get(i10);
        }
    }

    @NonNull
    public List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public IDownloadListener getDownloadListenerByIndex(ListenerType listenerType, int i10) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null || i10 < 0) {
            return null;
        }
        synchronized (downloadListeners) {
            if (i10 >= downloadListeners.size()) {
                return null;
            }
            return downloadListeners.get(downloadListeners.keyAt(i10));
        }
    }

    public int getDownloadListenerSize(ListenerType listenerType) {
        int size;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null) {
            return 0;
        }
        synchronized (downloadListeners) {
            size = downloadListeners.size();
        }
        return size;
    }

    public SparseArray<IDownloadListener> getDownloadListeners(ListenerType listenerType) {
        if (listenerType == ListenerType.MAIN) {
            return this.mainThreadListeners;
        }
        if (listenerType == ListenerType.SUB) {
            return this.subThreadListeners;
        }
        if (listenerType == ListenerType.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public IDownloadForbiddenHandler getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public IDownloadMonitorDepend getMonitorDepend() {
        return this.monitorDepend;
    }

    public INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public IDownloadNotificationEventListener getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public IRetryDelayTimeCalculator getRetryDelayTimeCalculator() {
        return this.retryDelayTimeCalculator;
    }

    public IDownloadListener getSingleDownloadListener(ListenerType listenerType) {
        return this.singleListenerMap.get(listenerType);
    }

    public DownloadTask hashCodeForSameTask(int i10) {
        this.hashCodeForSameTask = i10;
        return this;
    }

    public DownloadTask headConnectionAvailable(boolean z10) {
        this.downloadInfoBuilder.headConnectionAvailable(z10);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.iconUrl(str);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z10) {
        this.downloadInfoBuilder.ignoreDataVerify(z10);
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public DownloadTask isOpenLimitSpeed(boolean z10) {
        this.downloadInfoBuilder.isOpenLimitSpeed(z10);
        return this;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i10, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(i10, iDownloadListener);
            }
            Map<ListenerType, IDownloadListener> map = this.singleListenerMap;
            ListenerType listenerType = ListenerType.MAIN;
            map.put(listenerType, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i10, listenerType);
            }
        }
        return this;
    }

    public DownloadTask maxBytes(int i10) {
        this.downloadInfoBuilder.maxBytes(i10);
        return this;
    }

    public DownloadTask maxProgressCount(int i10) {
        this.downloadInfoBuilder.maxProgressCount(i10);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.md5(str);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.mimeType(str);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i10) {
        this.downloadInfoBuilder.minProgressTimeMsInterval(i10);
        return this;
    }

    public DownloadTask monitorDepend(IDownloadMonitorDepend iDownloadMonitorDepend) {
        this.monitorDepend = iDownloadMonitorDepend;
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.monitorScene(str);
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.name(str);
        return this;
    }

    public DownloadTask needChunkDowngradeRetry(boolean z10) {
        this.downloadInfoBuilder.needChunkDowngradeRetry(z10);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z10) {
        this.downloadInfoBuilder.needDefaultHttpServiceBackUp(z10);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z10) {
        this.downloadInfoBuilder.needHttpsToHttpRetry(z10);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z10) {
        this.downloadInfoBuilder.needIndependentProcess(z10);
        return this;
    }

    public DownloadTask needPostProgress(boolean z10) {
        this.downloadInfoBuilder.needPostProgress(z10);
        return this;
    }

    public DownloadTask needRetryDelay(boolean z10) {
        this.downloadInfoBuilder.needRetryDelay(z10);
        return this;
    }

    public DownloadTask needReuseChunkRunnable(boolean z10) {
        this.downloadInfoBuilder.needReuseChunkRunnable(z10);
        return this;
    }

    public DownloadTask needReuseFirstConnection(boolean z10) {
        this.downloadInfoBuilder.needReuseFirstConnection(z10);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z10) {
        this.downloadInfoBuilder.needSDKMonitor(z10);
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z10) {
        return this;
    }

    public DownloadTask notificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        this.notificationClickCallback = iNotificationClickCallback;
        return this;
    }

    public DownloadTask notificationEventListener(IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        this.notificationEventListener = iDownloadNotificationEventListener;
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i10, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(i10, iDownloadListener);
            }
            Map<ListenerType, IDownloadListener> map = this.singleListenerMap;
            ListenerType listenerType = ListenerType.NOTIFICATION;
            map.put(listenerType, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i10, listenerType);
            }
        }
        return this;
    }

    public DownloadTask onlyWifi(boolean z10) {
        this.downloadInfoBuilder.onlyWifi(z10);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.outIp(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.outSize(iArr);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.packageName(str);
        return this;
    }

    public void removeDownloadListener(int i10, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10) {
        int indexOfValue;
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null) {
            if (z10 && this.singleListenerMap.containsKey(listenerType)) {
                this.singleListenerMap.remove(listenerType);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            if (z10) {
                if (this.singleListenerMap.containsKey(listenerType)) {
                    iDownloadListener = this.singleListenerMap.get(listenerType);
                    this.singleListenerMap.remove(listenerType);
                }
                if (iDownloadListener != null && (indexOfValue = downloadListeners.indexOfValue(iDownloadListener)) >= 0 && indexOfValue < downloadListeners.size()) {
                    downloadListeners.removeAt(indexOfValue);
                }
            } else {
                downloadListeners.remove(i10);
                synchronized (this.singleListenerHashCodeMap) {
                    ListenerType listenerType2 = this.singleListenerHashCodeMap.get(i10);
                    if (listenerType2 != null && this.singleListenerMap.containsKey(listenerType2)) {
                        this.singleListenerMap.remove(listenerType2);
                        this.singleListenerHashCodeMap.remove(i10);
                    }
                }
            }
        }
    }

    public DownloadTask retryCount(int i10) {
        this.downloadInfoBuilder.retryCount(i10);
        return this;
    }

    public DownloadTask retryDelayTimeArray(String str) {
        this.downloadInfoBuilder.retryDelayTimeArray(str);
        return this;
    }

    public DownloadTask retryDelayTimeCalculator(IRetryDelayTimeCalculator iRetryDelayTimeCalculator) {
        this.retryDelayTimeCalculator = iRetryDelayTimeCalculator;
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.savePath(str);
        return this;
    }

    public DownloadTask setAutoInstall(boolean z10) {
        this.downloadInfoBuilder.setAutoInstall(z10);
        return this;
    }

    public DownloadTask setDownloadCompleteHandlers(List<IDownloadCompleteHandler> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<IDownloadCompleteHandler> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                addDownloadCompleteHandler(iterator2.next());
            }
        }
        return this;
    }

    public void setDownloadListeners(SparseArray<IDownloadListener> sparseArray, ListenerType listenerType) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (listenerType == ListenerType.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, sparseArray);
                }
                return;
            } else if (listenerType == ListenerType.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, sparseArray);
                }
                return;
            } else {
                if (listenerType == ListenerType.NOTIFICATION) {
                    synchronized (this.notificationListeners) {
                        copyListeners(this.notificationListeners, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    public void setNeedDelayForCacheSync(boolean z10) {
        this.needDelayForCacheSync = z10;
    }

    public void setNotificationEventListener(IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        this.notificationEventListener = iDownloadNotificationEventListener;
    }

    public DownloadTask showNotification(boolean z10) {
        this.downloadInfoBuilder.showNotification(z10);
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z10) {
        this.downloadInfoBuilder.showNotificationForAutoResumed(z10);
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i10, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(i10, iDownloadListener);
            }
            Map<ListenerType, IDownloadListener> map = this.singleListenerMap;
            ListenerType listenerType = ListenerType.SUB;
            map.put(listenerType, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(i10, listenerType);
            }
        }
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.taskKey(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.tempPath(str);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j10) {
        this.downloadInfoBuilder.throttleNetSpeed(j10);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.title(str);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j10) {
        this.downloadInfoBuilder.ttnetProtectTimeout(j10);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.url(str);
        return this;
    }

    private void addListenerToDownloadingSameTask(ListenerType listenerType) {
        SparseArray<IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        synchronized (downloadListeners) {
            for (int i10 = 0; i10 < downloadListeners.size(); i10++) {
                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i10));
                if (iDownloadListener != null) {
                    DownloadProcessDispatcher.getInstance().addDownloadListener(getDownloadId(), iDownloadListener, listenerType, false);
                }
            }
        }
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }
}
