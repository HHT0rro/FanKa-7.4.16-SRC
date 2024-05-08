package com.bef.effectsdk;

import android.content.res.AssetManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AssetResourceFinder implements ResourceFinder {
    private final AssetManager mAssetManager;
    private final String mDir;

    public AssetResourceFinder(AssetManager assetManager, String str) {
        this.mAssetManager = assetManager;
        this.mDir = str;
    }

    private static native long nativeCreateAssetResourceFinder(long j10, AssetManager assetManager, String str);

    private static native void nativeReleaseAssetResourceFinder(long j10);

    @Override // com.bef.effectsdk.ResourceFinder
    public synchronized long createNativeResourceFinder(long j10) {
        return nativeCreateAssetResourceFinder(j10, this.mAssetManager, this.mDir);
    }

    @Override // com.bef.effectsdk.ResourceFinder
    public synchronized void release(long j10) {
        nativeReleaseAssetResourceFinder(j10);
    }
}
