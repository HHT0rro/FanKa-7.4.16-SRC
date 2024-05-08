package com.alimm.tanx.ui.image.glide.load.engine.cache;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DiskLruCacheWrapper implements DiskCache {
    public static final int APP_VERSION = 1;
    public static final String TAG = "DiskLruCacheWrapper";
    public static final int VALUE_COUNT = 1;
    public static DiskLruCacheWrapper wrapper;
    public final File directory;
    public DiskLruCache diskLruCache;
    public final int maxSize;
    public final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();
    public final SafeKeyGenerator safeKeyGenerator = new SafeKeyGenerator();

    public DiskLruCacheWrapper(File file, int i10) {
        this.directory = file;
        this.maxSize = i10;
    }

    public static synchronized DiskCache get(File file, int i10) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                wrapper = new DiskLruCacheWrapper(file, i10);
            }
            diskLruCacheWrapper = wrapper;
        }
        return diskLruCacheWrapper;
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            getDiskCache().delete();
            resetDiskCache();
        } catch (IOException unused) {
            Log.isLoggable(TAG, 5);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
        } catch (IOException unused) {
            Log.isLoggable(TAG, 5);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(key);
        try {
            try {
                DiskLruCache.Editor edit = getDiskCache().edit(safeKey);
                if (edit != null) {
                    try {
                        if (writer.write(edit.getFile(0))) {
                            edit.commit();
                        }
                        edit.abortUnlessCommitted();
                    } catch (Throwable th) {
                        edit.abortUnlessCommitted();
                        throw th;
                    }
                }
            } catch (IOException unused) {
                Log.isLoggable(TAG, 5);
            }
        } finally {
            this.writeLocker.release(key);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        try {
            DiskLruCache.Value value = getDiskCache().get(this.safeKeyGenerator.getSafeKey(key));
            if (value != null) {
                return value.getFile(0);
            }
        } catch (IOException unused) {
            Log.isLoggable(TAG, 5);
        }
        return null;
    }
}
