package com.bef.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FileResourceFinder implements ResourceFinder {
    private final String mDir;

    public FileResourceFinder(String str) {
        this.mDir = str;
    }

    private static native long nativeCreateFileResourceFinder(long j10, String str);

    @Override // com.bef.effectsdk.ResourceFinder
    public long createNativeResourceFinder(long j10) {
        return nativeCreateFileResourceFinder(j10, this.mDir);
    }

    @Override // com.bef.effectsdk.ResourceFinder
    public void release(long j10) {
    }
}
