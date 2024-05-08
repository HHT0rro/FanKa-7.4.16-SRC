package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadCache implements IDownloadCache {
    private final SparseArray<DownloadInfo> downloadInfoMap = new SparseArray<>();
    private final SparseArray<List<DownloadChunk>> chunkListMap = new SparseArray<>();
    private final SparseArray<Map<Long, Segment>> segmentListMap = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i10, long j10) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j10, false);
            downloadInfo.setStatus(-4);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i10, long j10) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j10, false);
            downloadInfo.setStatus(-3);
            downloadInfo.setFirstDownload(false);
            downloadInfo.setFirstSuccess(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i10, long j10, String str, String str2) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setTotalBytes(j10);
            downloadInfo.seteTag(str);
            if (TextUtils.isEmpty(downloadInfo.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfo.setName(str2);
            }
            downloadInfo.setStatus(3);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i10, long j10) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j10, false);
            downloadInfo.setStatus(-1);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i10) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setStatus(-7);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i10, long j10) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j10, false);
            downloadInfo.setStatus(-2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i10) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setStatus(1);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i10, long j10) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j10, false);
            if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfo.getStatus()) && downloadInfo.getStatus() != -4) {
                downloadInfo.setStatus(4);
            }
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i10) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setStatus(5);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        int id2 = downloadChunk.getId();
        List<DownloadChunk> list = this.chunkListMap.get(id2);
        if (list == null) {
            list = new ArrayList<>();
            this.chunkListMap.put(id2, list);
        }
        list.add(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i10) {
        return getDownloadInfo(i10) != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized void clearData() {
        this.downloadInfoMap.clear();
        this.chunkListMap.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized List<DownloadInfo> getAllDownloadInfo() {
        if (this.downloadInfoMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.downloadInfoMap.size());
        for (int i10 = 0; i10 < this.downloadInfoMap.size(); i10++) {
            DownloadInfo valueAt = this.downloadInfoMap.valueAt(i10);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    public SparseArray<List<DownloadChunk>> getChunkListMap() {
        return this.chunkListMap;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized List<DownloadChunk> getDownloadChunk(int i10) {
        return this.chunkListMap.get(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized DownloadInfo getDownloadInfo(int i10) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.downloadInfoMap.get(i10);
        } catch (Exception e2) {
            e2.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized List<DownloadInfo> getDownloadInfoList(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.downloadInfoMap.size();
            for (int i10 = 0; i10 < size; i10++) {
                DownloadInfo valueAt = this.downloadInfoMap.valueAt(i10);
                if (str != null && str.equals(valueAt.getUrl())) {
                    arrayList.add(valueAt);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public SparseArray<DownloadInfo> getDownloadInfoMap() {
        return this.downloadInfoMap;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.downloadInfoMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.downloadInfoMap.size(); i10++) {
            DownloadInfo downloadInfo = this.downloadInfoMap.get(this.downloadInfoMap.keyAt(i10));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized Map<Long, Segment> getSegmentMap(int i10) {
        return this.segmentListMap.get(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized List<Segment> getSegments(int i10) {
        Map<Long, Segment> map = this.segmentListMap.get(i10);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.downloadInfoMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.downloadInfoMap.size(); i10++) {
            DownloadInfo downloadInfo = this.downloadInfoMap.get(this.downloadInfoMap.keyAt(i10));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.downloadInfoMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.downloadInfoMap.size(); i10++) {
            DownloadInfo downloadInfo = this.downloadInfoMap.get(this.downloadInfoMap.keyAt(i10));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i10) {
        DownloadInfo downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setStatus(2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized void removeAllDownloadChunk(int i10) {
        this.chunkListMap.remove(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized boolean removeDownloadInfo(int i10) {
        this.downloadInfoMap.remove(i10);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i10) {
        removeDownloadInfo(i10);
        removeAllDownloadChunk(i10);
        removeSegments(i10);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized void removeSegments(int i10) {
        this.segmentListMap.remove(i10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized void syncDownloadChunks(int i10, List<DownloadChunk> list) {
        if (list == null) {
            return;
        }
        removeAllDownloadChunk(i10);
        for (DownloadChunk downloadChunk : list) {
            if (downloadChunk != null) {
                addDownloadChunk(downloadChunk);
                if (downloadChunk.hasChunkDivided()) {
                    Iterator<DownloadChunk> iterator2 = downloadChunk.getSubChunkList().iterator2();
                    while (iterator2.hasNext()) {
                        addDownloadChunk(iterator2.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i10, List<DownloadChunk> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized DownloadInfo updateChunkCount(int i10, int i11) {
        DownloadInfo downloadInfo;
        downloadInfo = getDownloadInfo(i10);
        if (downloadInfo != null) {
            downloadInfo.setChunkCount(i11);
        }
        return downloadInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0021, code lost:
    
        r0.setCurrentOffset(r5);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void updateDownloadChunk(int r3, int r4, long r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.getDownloadChunk(r3)     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator2()     // Catch: java.lang.Throwable -> L26
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L26
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = (com.ss.android.socialbase.downloader.model.DownloadChunk) r0     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto Ld
            int r1 = r0.getChunkIndex()     // Catch: java.lang.Throwable -> L26
            if (r1 != r4) goto Ld
            r0.setCurrentOffset(r5)     // Catch: java.lang.Throwable -> L26
        L24:
            monitor-exit(r2)
            return
        L26:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.DownloadCache.updateDownloadChunk(int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        boolean z10 = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.downloadInfoMap.get(downloadInfo.getId()) == null) {
            z10 = false;
        }
        this.downloadInfoMap.put(downloadInfo.getId(), downloadInfo);
        return z10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized boolean updateSegments(int i10, Map<Long, Segment> map) {
        this.segmentListMap.put(i10, map);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        if (r0.getSubChunkList() != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002e, code lost:
    
        r3 = r0.getSubChunkList().iterator2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003a, code lost:
    
        if (r3.hasNext() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003c, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
    
        if (r5 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:
    
        if (r5.getChunkIndex() != r4) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        r5.setCurrentOffset(r6);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void updateSubDownloadChunk(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.getDownloadChunk(r3)     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator2()     // Catch: java.lang.Throwable -> L4f
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L4d
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = (com.ss.android.socialbase.downloader.model.DownloadChunk) r0     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto Ld
            int r1 = r0.getChunkIndex()     // Catch: java.lang.Throwable -> L4f
            if (r1 != r5) goto Ld
            boolean r1 = r0.hasChunkDivided()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.getSubChunkList()     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L2e
            goto L4d
        L2e:
            java.util.List r3 = r0.getSubChunkList()     // Catch: java.lang.Throwable -> L4f
            java.util.Iterator r3 = r3.iterator2()     // Catch: java.lang.Throwable -> L4f
        L36:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.DownloadChunk r5 = (com.ss.android.socialbase.downloader.model.DownloadChunk) r5     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L36
            int r0 = r5.getChunkIndex()     // Catch: java.lang.Throwable -> L4f
            if (r0 != r4) goto L36
            r5.setCurrentOffset(r6)     // Catch: java.lang.Throwable -> L4f
        L4d:
            monitor-exit(r2)
            return
        L4f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.DownloadCache.updateSubDownloadChunk(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i10, int i11, int i12, int i13) {
    }
}
