package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    public final CacheDirectoryGetter cacheDirectoryGetter;
    public final int diskCacheSize;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    public DiskLruCacheFactory(final String str, int i10) {
        CacheDirectoryGetter cacheDirectoryGetter = new CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.1
            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(String.this);
            }
        };
        this.diskCacheSize = i10;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.mkdirs() || (cacheDirectory.exists() && cacheDirectory.isDirectory())) {
            return DiskLruCacheWrapper.get(cacheDirectory, this.diskCacheSize);
        }
        return null;
    }

    public DiskLruCacheFactory(final String str, final String str2, int i10) {
        CacheDirectoryGetter cacheDirectoryGetter = new CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.2
            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(String.this, str2);
            }
        };
        this.diskCacheSize = i10;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, int i10) {
        this.diskCacheSize = i10;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }
}
