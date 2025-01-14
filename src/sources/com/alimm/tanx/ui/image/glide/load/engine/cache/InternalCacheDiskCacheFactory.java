package com.alimm.tanx.ui.image.glide.load.engine.cache;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public InternalCacheDiskCacheFactory(Context context, int i10) {
        this(context, "image_manager_disk_cache", i10);
    }

    public InternalCacheDiskCacheFactory(final Context context, final String str, int i10) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.InternalCacheDiskCacheFactory.1
            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                String str2 = str;
                return str2 != null ? new File(cacheDir, str2) : cacheDir;
            }
        }, i10);
    }
}
