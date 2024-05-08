package com.alimm.tanx.core.view.player.cache.videocache.file;

import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TotalSizeLruDiskUsage extends LruDiskUsage {
    public final long maxSize;

    public TotalSizeLruDiskUsage(long j10) {
        if (j10 > 0) {
            this.maxSize = j10;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage
    public boolean accept(File file, long j10, int i10) {
        return j10 <= this.maxSize;
    }
}
