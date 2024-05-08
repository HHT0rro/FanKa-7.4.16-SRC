package com.alimm.tanx.core.view.player.cache.videocache.file;

import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TotalCountLruDiskUsage extends LruDiskUsage {
    public final int maxCount;

    public TotalCountLruDiskUsage(int i10) {
        if (i10 > 0) {
            this.maxCount = i10;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage
    public boolean accept(File file, long j10, int i10) {
        return i10 <= this.maxCount;
    }
}
