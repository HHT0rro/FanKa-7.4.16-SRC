package com.kwad.sdk.core.imageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptions;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecoder;
import com.kwad.sdk.core.imageloader.core.decode.ImageDecodingInfo;
import com.kwad.sdk.core.imageloader.core.download.ImageDownloader;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingProgressListener;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class LoadAndDisplayImageTask implements IoUtils.CopyListener, Runnable {
    private static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    private static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
    private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String ERROR_PROCESSOR_FOR_DISK_CACHE_NULL = "Bitmap processor for disk cache returned null [%s]";
    private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final String LOG_CACHE_IMAGE_ON_DISK = "Cache image on disk [%s]";
    private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_DISK_CACHE = "Load image from disk cache [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK = "Process image before cache on disk [%s]";
    private static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disk cache [%s]";
    private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    private final ImageLoaderConfiguration configuration;
    private final ImageDecoder decoder;
    private final ImageDownloader downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    public final ImageAware imageAware;
    private final ImageLoadingInfo imageLoadingInfo;
    public final ImageLoadingListener listener;
    private LoadedFrom loadedFrom = LoadedFrom.NETWORK;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader;
    public final DisplayImageOptions options;
    public final ImageLoadingProgressListener progressListener;
    private final ImageDownloader slowNetworkDownloader;
    private final boolean syncLoading;
    private final ImageSize targetSize;
    public final String uri;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class FireCancelEventRunnable implements Runnable {
        private WeakReference<LoadAndDisplayImageTask> weakReference;

        public FireCancelEventRunnable(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            this.weakReference = new WeakReference<>(loadAndDisplayImageTask);
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = this.weakReference.get();
            if (loadAndDisplayImageTask != null) {
                loadAndDisplayImageTask.listener.onLoadingCancelled(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class FireFailEventRunnable implements Runnable {
        public final Throwable failCause;
        public final FailReason.FailType failType;
        private WeakReference<LoadAndDisplayImageTask> weakReference;

        public FireFailEventRunnable(LoadAndDisplayImageTask loadAndDisplayImageTask, FailReason.FailType failType, Throwable th) {
            this.weakReference = new WeakReference<>(loadAndDisplayImageTask);
            this.failCause = th;
            this.failType = failType;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = this.weakReference.get();
            if (loadAndDisplayImageTask != null) {
                if (loadAndDisplayImageTask.options.shouldShowImageOnFail()) {
                    loadAndDisplayImageTask.imageAware.setImageDrawable(loadAndDisplayImageTask.options.getImageOnFail(loadAndDisplayImageTask.configuration.resources));
                }
                loadAndDisplayImageTask.listener.onLoadingFailed(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), new FailReason(this.failType, this.failCause));
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class TaskCancelledException extends Exception {
        private static final long serialVersionUID = -504619855289909996L;

        public TaskCancelledException() {
        }
    }

    public LoadAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = imageLoaderEngine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        ImageLoaderConfiguration imageLoaderConfiguration = imageLoaderEngine.configuration;
        this.configuration = imageLoaderConfiguration;
        this.downloader = imageLoaderConfiguration.downloader;
        this.networkDeniedDownloader = imageLoaderConfiguration.networkDeniedDownloader;
        this.slowNetworkDownloader = imageLoaderConfiguration.slowNetworkDownloader;
        this.decoder = imageLoaderConfiguration.decoder;
        this.uri = imageLoadingInfo.uri;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.imageAware = imageLoadingInfo.imageAware;
        this.targetSize = imageLoadingInfo.targetSize;
        DisplayImageOptions displayImageOptions = imageLoadingInfo.options;
        this.options = displayImageOptions;
        this.listener = imageLoadingInfo.listener;
        this.progressListener = imageLoadingInfo.progressListener;
        this.syncLoading = displayImageOptions.isSyncLoading();
    }

    private void checkTaskInterrupted() {
        if (isTaskInterrupted()) {
            throw new TaskCancelledException();
        }
    }

    private void checkTaskNotActual() {
        checkViewCollected();
        checkViewReused();
    }

    private void checkViewCollected() {
        if (isViewCollected()) {
            throw new TaskCancelledException();
        }
    }

    private void checkViewReused() {
        if (isViewReused()) {
            throw new TaskCancelledException();
        }
    }

    private DecodedResult decodeImage(String str) {
        return this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, str, this.uri, this.targetSize, this.imageAware.getScaleType(), getDownloader(), this.options, this.listener));
    }

    private boolean delayIfNeed() {
        if (!this.options.shouldDelayBeforeLoading()) {
            return false;
        }
        L.d(LOG_DELAY_BEFORE_LOADING, Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
        try {
            Thread.sleep(this.options.getDelayBeforeLoading());
            return isTaskNotActual();
        } catch (InterruptedException unused) {
            L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
            return true;
        }
    }

    private boolean downloadImage() {
        InputStream stream = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
        if (stream == null) {
            L.e("No stream for image [%s]", this.memoryCacheKey);
            return false;
        }
        try {
            return this.configuration.diskCache.save(this.uri, stream, this);
        } finally {
            b.closeQuietly(stream);
        }
    }

    private void fireCancelEvent() {
        if (this.syncLoading || isTaskInterrupted()) {
            return;
        }
        runTask(new FireCancelEventRunnable(this), false, this.handler, this.engine);
    }

    private void fireFailEvent(FailReason.FailType failType, Throwable th) {
        if (this.syncLoading || isTaskInterrupted() || isTaskNotActual()) {
            return;
        }
        runTask(new FireFailEventRunnable(this, failType, th), false, this.handler, this.engine);
    }

    private boolean fireProgressEvent(final int i10, final int i11) {
        if (isTaskInterrupted() || isTaskNotActual()) {
            return false;
        }
        if (this.progressListener == null) {
            return true;
        }
        runTask(new Runnable() { // from class: com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.1
            @Override // java.lang.Runnable
            public void run() {
                LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask.progressListener.onProgressUpdate(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), i10, i11);
            }
        }, false, this.handler, this.engine);
        return true;
    }

    private ImageDownloader getDownloader() {
        if (this.engine.isNetworkDenied()) {
            return this.networkDeniedDownloader;
        }
        if (this.engine.isSlowNetwork()) {
            return this.slowNetworkDownloader;
        }
        return this.downloader;
    }

    private boolean isTaskInterrupted() {
        if (!Thread.interrupted()) {
            return false;
        }
        L.d(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
        return true;
    }

    private boolean isTaskNotActual() {
        return isViewCollected() || isViewReused();
    }

    private boolean isViewCollected() {
        if (!this.imageAware.isCollected()) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED, this.memoryCacheKey);
        return true;
    }

    private boolean isViewReused() {
        if (!(!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware)))) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED, this.memoryCacheKey);
        return true;
    }

    private boolean resizeAndSaveImage(int i10, int i11) {
        File file = this.configuration.diskCache.get(this.uri);
        if (file == null || !file.exists()) {
            return false;
        }
        DecodedResult decode = this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.uri, new ImageSize(i10, i11), ViewScaleType.FIT_INSIDE, getDownloader(), new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build(), this.listener));
        Bitmap bitmap = decode != null ? decode.mBitmap : null;
        if (bitmap != null && this.configuration.processorForDiskCache != null) {
            L.d(LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK, this.memoryCacheKey);
            bitmap = this.configuration.processorForDiskCache.process(bitmap);
            if (bitmap == null) {
                L.e(ERROR_PROCESSOR_FOR_DISK_CACHE_NULL, this.memoryCacheKey);
            }
        }
        if (bitmap == null) {
            return false;
        }
        boolean save = this.configuration.diskCache.save(this.uri, bitmap);
        bitmap.recycle();
        return save;
    }

    public static void runTask(Runnable runnable, boolean z10, Handler handler, ImageLoaderEngine imageLoaderEngine) {
        if (z10) {
            runnable.run();
        } else if (handler == null) {
            imageLoaderEngine.fireCallback(runnable);
        } else {
            handler.post(runnable);
        }
    }

    private boolean tryCacheImageOnDisk() {
        L.d(LOG_CACHE_IMAGE_ON_DISK, this.memoryCacheKey);
        try {
            boolean downloadImage = downloadImage();
            if (downloadImage) {
                ImageLoaderConfiguration imageLoaderConfiguration = this.configuration;
                int i10 = imageLoaderConfiguration.maxImageWidthForDiskCache;
                int i11 = imageLoaderConfiguration.maxImageHeightForDiskCache;
                if (i10 > 0 || i11 > 0) {
                    L.d(LOG_RESIZE_CACHED_IMAGE_FILE, this.memoryCacheKey);
                    resizeAndSaveImage(i10, i11);
                }
            }
            return downloadImage;
        } catch (IOException e2) {
            L.e(e2);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0047, code lost:
    
        if (r1.isDecoded() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwad.sdk.core.imageloader.core.decode.DecodedResult tryLoadBitmap() {
        /*
            r10 = this;
            r0 = 0
            com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration r1 = r10.configuration     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            com.kwad.sdk.core.imageloader.cache.disc.DiskCache r1 = r1.diskCache     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            java.lang.String r2 = r10.uri     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            java.io.File r1 = r1.get(r2)     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L40
            boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            if (r4 == 0) goto L40
            long r4 = r1.length()     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L40
            java.lang.String r4 = "Load image from disk cache [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            java.lang.String r6 = r10.memoryCacheKey     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            r5[r2] = r6     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            com.kwad.sdk.core.imageloader.utils.L.d(r4, r5)     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            com.kwad.sdk.core.imageloader.core.assist.LoadedFrom r4 = com.kwad.sdk.core.imageloader.core.assist.LoadedFrom.DISC_CACHE     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            r10.loadedFrom = r4     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            r10.checkTaskNotActual()     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            com.kwad.sdk.core.imageloader.core.download.ImageDownloader$Scheme r4 = com.kwad.sdk.core.imageloader.core.download.ImageDownloader.Scheme.FILE     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            java.lang.String r1 = r4.wrap(r1)     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            com.kwad.sdk.core.imageloader.core.decode.DecodedResult r1 = r10.decodeImage(r1)     // Catch: java.lang.Throwable -> La2 java.lang.OutOfMemoryError -> Lac java.io.IOException -> Lb6 com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc3
            goto L41
        L40:
            r1 = r0
        L41:
            if (r1 == 0) goto L49
            boolean r4 = r1.isDecoded()     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            if (r4 != 0) goto L85
        L49:
            java.lang.String r4 = "Load image from network [%s]"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            java.lang.String r5 = r10.memoryCacheKey     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            r3[r2] = r5     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            com.kwad.sdk.core.imageloader.utils.L.d(r4, r3)     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            com.kwad.sdk.core.imageloader.core.assist.LoadedFrom r2 = com.kwad.sdk.core.imageloader.core.assist.LoadedFrom.NETWORK     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            r10.loadedFrom = r2     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            java.lang.String r2 = r10.uri     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            com.kwad.sdk.core.imageloader.core.DisplayImageOptions r3 = r10.options     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            boolean r3 = r3.isCacheOnDisk()     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            if (r3 == 0) goto L7e
            boolean r3 = r10.tryCacheImageOnDisk()     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            if (r3 == 0) goto L7e
            com.kwad.sdk.core.imageloader.core.ImageLoaderConfiguration r3 = r10.configuration     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            com.kwad.sdk.core.imageloader.cache.disc.DiskCache r3 = r3.diskCache     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            java.lang.String r4 = r10.uri     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            java.io.File r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            if (r3 == 0) goto L7e
            com.kwad.sdk.core.imageloader.core.download.ImageDownloader$Scheme r2 = com.kwad.sdk.core.imageloader.core.download.ImageDownloader.Scheme.FILE     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            java.lang.String r2 = r2.wrap(r3)     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
        L7e:
            r10.checkTaskNotActual()     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            com.kwad.sdk.core.imageloader.core.decode.DecodedResult r1 = r10.decodeImage(r2)     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
        L85:
            if (r1 == 0) goto L8d
            boolean r2 = r1.isDecoded()     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            if (r2 != 0) goto Lc9
        L8d:
            com.kwad.sdk.core.imageloader.core.assist.FailReason$FailType r2 = com.kwad.sdk.core.imageloader.core.assist.FailReason.FailType.DECODING_ERROR     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            r10.fireFailEvent(r2, r0)     // Catch: java.lang.Throwable -> L93 java.lang.OutOfMemoryError -> L98 java.io.IOException -> L9d com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException -> Lc1 java.lang.IllegalStateException -> Lc4
            goto Lc9
        L93:
            r0 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto La3
        L98:
            r0 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto Lad
        L9d:
            r0 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto Lb7
        La2:
            r1 = move-exception
        La3:
            com.kwad.sdk.core.imageloader.utils.L.e(r1)
            com.kwad.sdk.core.imageloader.core.assist.FailReason$FailType r2 = com.kwad.sdk.core.imageloader.core.assist.FailReason.FailType.UNKNOWN
            r10.fireFailEvent(r2, r1)
            goto Lbf
        Lac:
            r1 = move-exception
        Lad:
            com.kwad.sdk.core.imageloader.utils.L.e(r1)
            com.kwad.sdk.core.imageloader.core.assist.FailReason$FailType r2 = com.kwad.sdk.core.imageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY
            r10.fireFailEvent(r2, r1)
            goto Lbf
        Lb6:
            r1 = move-exception
        Lb7:
            com.kwad.sdk.core.imageloader.utils.L.e(r1)
            com.kwad.sdk.core.imageloader.core.assist.FailReason$FailType r2 = com.kwad.sdk.core.imageloader.core.assist.FailReason.FailType.IO_ERROR
            r10.fireFailEvent(r2, r1)
        Lbf:
            r1 = r0
            goto Lc9
        Lc1:
            r0 = move-exception
            throw r0
        Lc3:
            r1 = r0
        Lc4:
            com.kwad.sdk.core.imageloader.core.assist.FailReason$FailType r2 = com.kwad.sdk.core.imageloader.core.assist.FailReason.FailType.NETWORK_DENIED
            r10.fireFailEvent(r2, r0)
        Lc9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.tryLoadBitmap():com.kwad.sdk.core.imageloader.core.decode.DecodedResult");
    }

    private boolean waitIfPaused() {
        AtomicBoolean pause = this.engine.getPause();
        if (pause.get()) {
            synchronized (this.engine.getPauseLock()) {
                if (pause.get()) {
                    L.d(LOG_WAITING_FOR_RESUME, this.memoryCacheKey);
                    try {
                        this.engine.getPauseLock().wait();
                        L.d(LOG_RESUME_AFTER_PAUSE, this.memoryCacheKey);
                    } catch (InterruptedException unused) {
                        L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                        return true;
                    }
                }
            }
        }
        return isTaskNotActual();
    }

    public final String getLoadingUri() {
        return this.uri;
    }

    @Override // com.kwad.sdk.core.imageloader.utils.IoUtils.CopyListener
    public final boolean onBytesCopied(int i10, int i11) {
        return this.syncLoading || fireProgressEvent(i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c5 A[Catch: all -> 0x010d, TaskCancelledException -> 0x010f, Merged into TryCatch #0 {all -> 0x010d, TaskCancelledException -> 0x010f, blocks: (B:13:0x0033, B:15:0x0042, B:18:0x0049, B:19:0x00bd, B:21:0x00c5, B:23:0x00e0, B:24:0x00eb, B:28:0x0059, B:30:0x005f, B:33:0x0067, B:35:0x0075, B:37:0x0084, B:38:0x0092, B:40:0x0096, B:41:0x00a1, B:43:0x00a9, B:49:0x010f), top: B:12:0x0033 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.core.LoadAndDisplayImageTask.run():void");
    }
}
