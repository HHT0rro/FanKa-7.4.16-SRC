package com.alimm.tanx.ui.image.glide.load.engine;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.provider.DataLoadProvider;
import com.alimm.tanx.ui.image.glide.util.LogTime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DecodeJob<A, T, Z> {
    public static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    public static final String TAG = "DecodeJob";
    public final DiskCacheProvider diskCacheProvider;
    public final DiskCacheStrategy diskCacheStrategy;
    public final DataFetcher<A> fetcher;
    public final FileOpener fileOpener;
    public final int height;
    public volatile boolean isCancelled;
    public final DataLoadProvider<A, T> loadProvider;
    public final Priority priority;
    public final EngineKey resultKey;
    public final ResourceTranscoder<T, Z> transcoder;
    public final Transformation<T> transformation;
    public final int width;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class FileOpener {
        public OutputStream open(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class SourceWriter<DataType> implements DiskCache.Writer {
        public final DataType data;
        public final Encoder<DataType> encoder;

        public SourceWriter(Encoder<DataType> encoder, DataType datatype) {
            this.encoder = encoder;
            this.data = datatype;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Writer
        public boolean write(File file) {
            boolean z10 = false;
            OutputStream outputStream = null;
            try {
                try {
                    try {
                        outputStream = DecodeJob.this.fileOpener.open(file);
                        z10 = this.encoder.encode(this.data, outputStream);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    } catch (FileNotFoundException unused) {
                        Log.isLoggable(DecodeJob.TAG, 3);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    }
                } catch (IOException unused2) {
                }
                return z10;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
    }

    public DecodeJob(EngineKey engineKey, int i10, int i11, DataFetcher<A> dataFetcher, DataLoadProvider<A, T> dataLoadProvider, Transformation<T> transformation, ResourceTranscoder<T, Z> resourceTranscoder, DiskCacheProvider diskCacheProvider, DiskCacheStrategy diskCacheStrategy, Priority priority) {
        this(engineKey, i10, i11, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, diskCacheProvider, diskCacheStrategy, priority, DEFAULT_FILE_OPENER);
    }

    private Resource<T> cacheAndDecodeSourceData(A a10) throws IOException {
        long logTime = LogTime.getLogTime();
        this.diskCacheProvider.getDiskCache().put(this.resultKey.getOriginalKey(), new SourceWriter(this.loadProvider.getSourceEncoder(), a10));
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Wrote source to cache", logTime);
        }
        long logTime2 = LogTime.getLogTime();
        Resource<T> loadFromCache = loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable(TAG, 2) && loadFromCache != null) {
            logWithTimeAndKey("Decoded source from cache", logTime2);
        }
        return loadFromCache;
    }

    private Resource<T> decodeFromSourceData(A a10) throws IOException {
        if (this.diskCacheStrategy.cacheSource()) {
            return cacheAndDecodeSourceData(a10);
        }
        long logTime = LogTime.getLogTime();
        Resource<T> decode = this.loadProvider.getSourceDecoder().decode(a10, this.width, this.height);
        if (!Log.isLoggable(TAG, 2)) {
            return decode;
        }
        logWithTimeAndKey("Decoded from source", logTime);
        return decode;
    }

    private Resource<T> decodeSource() throws Exception {
        try {
            long logTime = LogTime.getLogTime();
            A loadData = this.fetcher.loadData(this.priority);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Fetched data", logTime);
            }
            if (this.isCancelled) {
                this.fetcher.cleanup();
                return null;
            }
            return decodeFromSourceData(loadData);
        } finally {
            this.fetcher.cleanup();
        }
    }

    private Resource<T> loadFromCache(Key key) throws IOException {
        File file = this.diskCacheProvider.getDiskCache().get(key);
        if (file == null) {
            return null;
        }
        try {
            Resource<T> decode = this.loadProvider.getCacheDecoder().decode(file, this.width, this.height);
            if (decode == null) {
            }
            return decode;
        } finally {
            this.diskCacheProvider.getDiskCache().delete(key);
        }
    }

    private void logWithTimeAndKey(String str, long j10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(LogTime.getElapsedMillis(j10));
        sb2.append(", key: ");
        sb2.append((Object) this.resultKey);
    }

    private Resource<Z> transcode(Resource<T> resource) {
        if (resource == null) {
            return null;
        }
        return this.transcoder.transcode(resource);
    }

    private Resource<T> transform(Resource<T> resource) {
        if (resource == null) {
            return null;
        }
        Resource<T> transform = this.transformation.transform(resource, this.width, this.height);
        if (!resource.equals(transform)) {
            resource.recycle();
        }
        return transform;
    }

    private Resource<Z> transformEncodeAndTranscode(Resource<T> resource) {
        long logTime = LogTime.getLogTime();
        Resource<T> transform = transform(resource);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Transformed resource from source", logTime);
        }
        writeTransformedToCache(transform);
        long logTime2 = LogTime.getLogTime();
        Resource<Z> transcode = transcode(transform);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Transcoded transformed from source", logTime2);
        }
        return transcode;
    }

    private void writeTransformedToCache(Resource<T> resource) {
        if (resource == null || !this.diskCacheStrategy.cacheResult()) {
            return;
        }
        long logTime = LogTime.getLogTime();
        this.diskCacheProvider.getDiskCache().put(this.resultKey, new SourceWriter(this.loadProvider.getEncoder(), resource));
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Wrote transformed from source to cache", logTime);
        }
    }

    public void cancel() {
        this.isCancelled = true;
        this.fetcher.cancel();
    }

    public Resource<Z> decodeFromSource() throws Exception {
        return transformEncodeAndTranscode(decodeSource());
    }

    public Resource<Z> decodeResultFromCache() throws Exception {
        if (!this.diskCacheStrategy.cacheResult()) {
            return null;
        }
        long logTime = LogTime.getLogTime();
        Resource<T> loadFromCache = loadFromCache(this.resultKey);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Decoded transformed from cache", logTime);
        }
        long logTime2 = LogTime.getLogTime();
        Resource<Z> transcode = transcode(loadFromCache);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Transcoded transformed from cache", logTime2);
        }
        return transcode;
    }

    public Resource<Z> decodeSourceFromCache() throws Exception {
        if (!this.diskCacheStrategy.cacheSource()) {
            return null;
        }
        long logTime = LogTime.getLogTime();
        Resource<T> loadFromCache = loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Decoded source from cache", logTime);
        }
        return transformEncodeAndTranscode(loadFromCache);
    }

    public DecodeJob(EngineKey engineKey, int i10, int i11, DataFetcher<A> dataFetcher, DataLoadProvider<A, T> dataLoadProvider, Transformation<T> transformation, ResourceTranscoder<T, Z> resourceTranscoder, DiskCacheProvider diskCacheProvider, DiskCacheStrategy diskCacheStrategy, Priority priority, FileOpener fileOpener) {
        this.resultKey = engineKey;
        this.width = i10;
        this.height = i11;
        this.fetcher = dataFetcher;
        this.loadProvider = dataLoadProvider;
        this.transformation = transformation;
        this.transcoder = resourceTranscoder;
        this.diskCacheProvider = diskCacheProvider;
        this.diskCacheStrategy = diskCacheStrategy;
        this.priority = priority;
        this.fileOpener = fileOpener;
    }
}
