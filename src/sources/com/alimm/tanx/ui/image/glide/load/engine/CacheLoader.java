package com.alimm.tanx.ui.image.glide.load.engine;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CacheLoader {
    public static final String TAG = "CacheLoader";
    public final DiskCache diskCache;

    public CacheLoader(DiskCache diskCache) {
        this.diskCache = diskCache;
    }

    public <Z> Resource<Z> load(Key key, ResourceDecoder<File, Z> resourceDecoder, int i10, int i11) {
        File file = this.diskCache.get(key);
        Resource<Z> resource = null;
        if (file == null) {
            return null;
        }
        try {
            resource = resourceDecoder.decode(file, i10, i11);
        } catch (IOException unused) {
            Log.isLoggable(TAG, 3);
        }
        if (resource == null) {
            Log.isLoggable(TAG, 3);
            this.diskCache.delete(key);
        }
        return resource;
    }
}
