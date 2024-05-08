package com.alimm.tanx.ui.image.glide.load.engine.cache;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i10) {
        this(context, "image_manager_disk_cache", i10);
    }

    public ExternalCacheDiskCacheFactory(final Context context, final String str, int i10) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.ExternalCacheDiskCacheFactory.1
            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                String str2 = str;
                return str2 != null ? new File(externalCacheDir, str2) : externalCacheDir;
            }
        }, i10);
    }
}
