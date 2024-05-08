package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum DiskCacheStrategy {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);

    public final boolean cacheResult;
    public final boolean cacheSource;

    DiskCacheStrategy(boolean z10, boolean z11) {
        this.cacheSource = z10;
        this.cacheResult = z11;
    }

    public boolean cacheResult() {
        return this.cacheResult;
    }

    public boolean cacheSource() {
        return this.cacheSource;
    }
}
