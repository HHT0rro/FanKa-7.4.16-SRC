package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.thread.DownloadRunnable;
import com.ss.android.socialbase.downloader.thread.DownloadThreadPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultDownloadEngine extends AbsDownloadEngine {
    private static final String TAG = "DefaultDownloadEngine";
    private static DownloadThreadPool downloadThreadPool;

    public DefaultDownloadEngine() {
        downloadThreadPool = new DownloadThreadPool();
    }

    public static List<Future> executeFutureTasks(List<Runnable> list) {
        ExecutorService chunkDownloadThreadExecutorService = DownloadComponentManager.getChunkDownloadThreadExecutorService();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(chunkDownloadThreadExecutorService.submit(iterator2.next()));
        }
        return arrayList;
    }

    public static Runnable getUnstartedTask(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService chunkDownloadThreadExecutorService = DownloadComponentManager.getChunkDownloadThreadExecutorService();
                if ((chunkDownloadThreadExecutorService instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) chunkDownloadThreadExecutorService).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> iterator2 = list.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = iterator2.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                Logger.w(TAG, "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    public static void invokeFutureTasks(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService chunkDownloadThreadExecutorService = DownloadComponentManager.getChunkDownloadThreadExecutorService();
        if (chunkDownloadThreadExecutorService != null) {
            chunkDownloadThreadExecutorService.invokeAll(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public DownloadRunnable doCancel(int i10) {
        DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null) {
            return null;
        }
        return downloadThreadPool2.cancel(i10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doDownload(int i10, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        Logger.d("DownloadTask", "start doDownload for task : " + i10);
        downloadThreadPool.execute(new DownloadRunnable(downloadTask, this.mainHandler));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doPause(int i10) {
        DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null) {
            return;
        }
        downloadThreadPool2.pause(i10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doSetThrottleNetSpeed(int i10, long j10) {
        DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null) {
            return;
        }
        downloadThreadPool2.setThrottleNetSpeed(i10, j10);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public List<Integer> getAllAliveDownloadIds() {
        return downloadThreadPool.getAllAliveDownloadIds();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public boolean isDownloading(int i10) {
        DownloadInfo downloadInfo;
        DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null || !downloadThreadPool2.containsTask(i10) || (downloadInfo = getDownloadInfo(i10)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(downloadInfo.getStatus())) {
            return true;
        }
        doPause(i10);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void removeDownloadRunnable(DownloadRunnable downloadRunnable) {
        DownloadThreadPool downloadThreadPool2 = downloadThreadPool;
        if (downloadThreadPool2 == null) {
            return;
        }
        downloadThreadPool2.removeUnAliveDownloadRunnable(downloadRunnable);
    }
}
