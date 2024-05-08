package com.kwad.sdk.core.imageloader.core;

import android.app.ActivityManager;
import android.content.Context;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.impl.UnlimitedDiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.impl.ext.LruDiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.cache.memory.impl.LruMemoryCache;
import com.kwad.sdk.core.imageloader.core.assist.QueueProcessingType;
import com.kwad.sdk.core.imageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.display.SimpleBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.download.BaseImageDownloader;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultConfigurationFactory {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public DefaultThreadFactory(int i10, String str) {
            this.threadPriority = i10;
            this.namePrefix = str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    public static BitmapDisplayer createBitmapDisplayer() {
        return new SimpleBitmapDisplayer();
    }

    public static DiskCache createDiskCache(Context context, FileNameGenerator fileNameGenerator, long j10, int i10, String str) {
        File createReserveDiskCacheDir = createReserveDiskCacheDir(context, str);
        if (j10 > 0 || i10 > 0) {
            try {
                return new LruDiskCache(StorageUtils.getIndividualCacheDirectory(context, str), createReserveDiskCacheDir, fileNameGenerator, j10, i10);
            } catch (IOException e2) {
                L.e(e2);
            }
        }
        return new UnlimitedDiskCache(new File(str), createReserveDiskCacheDir, fileNameGenerator);
    }

    public static Executor createExecutor(int i10, int i11, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i10, i10, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue()), createThreadFactory(i11, "uil-pool-"));
    }

    public static FileNameGenerator createFileNameGenerator() {
        return new HashCodeFileNameGenerator();
    }

    public static ImageDecoder createImageDecoder(boolean z10) {
        return new BaseImageDecoder(z10);
    }

    public static ImageDownloader createImageDownloader(Context context) {
        return new BaseImageDownloader(context);
    }

    public static MemoryCache createMemoryCache(Context context, int i10) {
        if (i10 == 0) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = activityManager.getMemoryClass();
            if (hasHoneycomb() && isLargeHeap(context)) {
                memoryClass = getLargeMemoryClass(activityManager);
            }
            i10 = (memoryClass * 1048576) / 8;
        }
        return new LruMemoryCache(i10);
    }

    private static File createReserveDiskCacheDir(Context context, String str) {
        File file = new File(str);
        File file2 = new File(file, StorageUtils.INDIVIDUAL_DIR_NAME);
        return (file2.exists() || file2.mkdir()) ? file2 : file;
    }

    public static Executor createTaskDistributor() {
        return Executors.newCachedThreadPool(createThreadFactory(5, "uil-pool-d-"));
    }

    private static ThreadFactory createThreadFactory(int i10, String str) {
        return new DefaultThreadFactory(i10, str);
    }

    private static int getLargeMemoryClass(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }

    private static boolean hasHoneycomb() {
        return true;
    }

    private static boolean isLargeHeap(Context context) {
        return (context.getApplicationInfo().flags & 1048576) != 0;
    }
}
