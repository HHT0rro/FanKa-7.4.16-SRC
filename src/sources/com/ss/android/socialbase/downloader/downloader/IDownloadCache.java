package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IDownloadCache {
    DownloadInfo OnDownloadTaskCancel(int i10, long j10);

    DownloadInfo OnDownloadTaskCompleted(int i10, long j10);

    DownloadInfo OnDownloadTaskConnected(int i10, long j10, String str, String str2);

    DownloadInfo OnDownloadTaskError(int i10, long j10);

    DownloadInfo OnDownloadTaskIntercept(int i10);

    DownloadInfo OnDownloadTaskPause(int i10, long j10);

    DownloadInfo OnDownloadTaskPrepare(int i10);

    DownloadInfo OnDownloadTaskProgress(int i10, long j10);

    DownloadInfo OnDownloadTaskRetry(int i10);

    void addDownloadChunk(DownloadChunk downloadChunk);

    void addSubDownloadChunk(DownloadChunk downloadChunk);

    boolean cacheExist(int i10);

    void clearData();

    boolean ensureDownloadCacheSyncSuccess();

    List<DownloadInfo> getAllDownloadInfo();

    List<DownloadChunk> getDownloadChunk(int i10);

    DownloadInfo getDownloadInfo(int i10);

    List<DownloadInfo> getDownloadInfoList(String str);

    List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str);

    Map<Long, Segment> getSegmentMap(int i10);

    List<Segment> getSegments(int i10);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str);

    void init();

    boolean isDownloadCacheSyncSuccess();

    DownloadInfo onDownloadTaskStart(int i10);

    void removeAllDownloadChunk(int i10);

    boolean removeDownloadInfo(int i10);

    boolean removeDownloadTaskData(int i10);

    void removeSegments(int i10);

    void syncDownloadChunks(int i10, List<DownloadChunk> list);

    void syncDownloadInfo(DownloadInfo downloadInfo);

    void syncDownloadInfoFromOtherCache(int i10, List<DownloadChunk> list);

    DownloadInfo updateChunkCount(int i10, int i11);

    void updateDownloadChunk(int i10, int i11, long j10);

    boolean updateDownloadInfo(DownloadInfo downloadInfo);

    boolean updateSegments(int i10, Map<Long, Segment> map);

    void updateSubDownloadChunk(int i10, int i11, int i12, long j10);

    void updateSubDownloadChunkIndex(int i10, int i11, int i12, int i13);
}
