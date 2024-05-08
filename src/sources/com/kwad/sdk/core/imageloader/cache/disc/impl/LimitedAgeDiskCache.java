package com.kwad.sdk.core.imageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DefaultConfigurationFactory;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LimitedAgeDiskCache extends BaseDiskCache {
    private final Map<File, Long> loadingDates;
    private final long maxFileAge;

    public LimitedAgeDiskCache(File file, long j10) {
        this(file, null, DefaultConfigurationFactory.createFileNameGenerator(), j10);
    }

    private void rememberUsage(String str) {
        File file = getFile(str);
        long currentTimeMillis = System.currentTimeMillis();
        file.setLastModified(currentTimeMillis);
        this.loadingDates.put(file, Long.valueOf(currentTimeMillis));
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        super.clear();
        this.loadingDates.clear();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        boolean z10;
        File file = super.get(str);
        if (file != null && file.exists()) {
            Long l10 = this.loadingDates.get(file);
            if (l10 == null) {
                l10 = Long.valueOf(file.lastModified());
                z10 = false;
            } else {
                z10 = true;
            }
            if (System.currentTimeMillis() - l10.longValue() > this.maxFileAge) {
                file.delete();
                this.loadingDates.remove(file);
            } else if (!z10) {
                this.loadingDates.put(file, l10);
            }
        }
        return file;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        this.loadingDates.remove(getFile(str));
        return super.remove(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        boolean save = super.save(str, inputStream, copyListener);
        rememberUsage(str);
        return save;
    }

    public LimitedAgeDiskCache(File file, File file2, long j10) {
        this(file, file2, DefaultConfigurationFactory.createFileNameGenerator(), j10);
    }

    public LimitedAgeDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j10) {
        super(file, file2, fileNameGenerator);
        this.loadingDates = Collections.synchronizedMap(new HashMap());
        this.maxFileAge = j10 * 1000;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.impl.BaseDiskCache, com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        boolean save = super.save(str, bitmap);
        rememberUsage(str);
        return save;
    }
}
