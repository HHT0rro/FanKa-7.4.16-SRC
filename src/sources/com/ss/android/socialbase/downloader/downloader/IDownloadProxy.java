package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IDownloadProxy {
    void addDownloadChunk(DownloadChunk downloadChunk);

    void addDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10);

    void addDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10, boolean z11);

    void addProcessCallback(ProcessCallback processCallback);

    boolean canResume(int i10);

    void cancel(int i10, boolean z10);

    void clearData();

    void clearDownloadData(int i10, boolean z10);

    void dispatchProcessCallback(int i10, int i11);

    void forceDownloadIngoreRecommendSize(int i10);

    List<DownloadInfo> getAllDownloadInfo();

    long getCurBytes(int i10);

    List<DownloadChunk> getDownloadChunk(int i10);

    IDownloadFileUriProvider getDownloadFileUriProvider(int i10);

    int getDownloadId(String str, String str2);

    DownloadInfo getDownloadInfo(int i10);

    DownloadInfo getDownloadInfo(String str, String str2);

    List<DownloadInfo> getDownloadInfoList(String str);

    IDownloadNotificationEventListener getDownloadNotificationEventListener(int i10);

    int getDownloadWithIndependentProcessStatus(int i10);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str);

    List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str);

    INotificationClickCallback getNotificationClickCallback(int i10);

    int getStatus(int i10);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str);

    boolean isDownloadCacheSyncSuccess();

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo);

    boolean isDownloading(int i10);

    boolean isHttpServiceInit();

    boolean isServiceAlive();

    boolean isServiceForeground();

    void pause(int i10);

    void pauseAll();

    void removeAllDownloadChunk(int i10);

    boolean removeDownloadInfo(int i10);

    void removeDownloadListener(int i10, int i11, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z10);

    boolean removeDownloadTaskData(int i10);

    void resetDownloadData(int i10, boolean z10);

    void restart(int i10);

    void restartAllFailedDownloadTasks(List<String> list);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> list);

    void resume(int i10);

    boolean retryDelayStart(int i10);

    void setDownloadNotificationEventListener(int i10, IDownloadNotificationEventListener iDownloadNotificationEventListener);

    void setDownloadWithIndependentProcessStatus(int i10, boolean z10);

    void setLogLevel(int i10);

    void setThrottleNetSpeed(int i10, long j10);

    void startForeground(int i10, Notification notification);

    void startService();

    void stopForeground(boolean z10, boolean z11);

    void syncDownloadChunks(int i10, List<DownloadChunk> list);

    void syncDownloadInfo(DownloadInfo downloadInfo);

    void syncDownloadInfoFromOtherCache(int i10, List<DownloadChunk> list);

    void tryDownload(DownloadTask downloadTask);

    void tryDownloadWithEngine(DownloadTask downloadTask);

    void updateDownloadChunk(int i10, int i11, long j10);

    boolean updateDownloadInfo(DownloadInfo downloadInfo);

    void updateSubDownloadChunk(int i10, int i11, int i12, long j10);

    void updateSubDownloadChunkIndex(int i10, int i11, int i12, int i13);
}
