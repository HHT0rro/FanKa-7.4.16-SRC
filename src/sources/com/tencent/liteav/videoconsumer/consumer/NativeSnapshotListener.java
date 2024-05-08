package com.tencent.liteav.videoconsumer.consumer;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeSnapshotListener implements TakeSnapshotListener {
    private long mNativeVideoSnapListener;

    @CalledByNative
    private NativeSnapshotListener(long j10) {
        this.mNativeVideoSnapListener = j10;
    }

    private native void nativeDestroy(long j10);

    private native void nativeOnComplete(long j10, Bitmap bitmap);

    public void finalize() throws Throwable {
        long j10 = this.mNativeVideoSnapListener;
        if (j10 != 0) {
            nativeDestroy(j10);
            this.mNativeVideoSnapListener = 0L;
        }
        super.finalize();
    }

    @Override // com.tencent.liteav.videobase.base.TakeSnapshotListener
    public void onComplete(Bitmap bitmap) {
        long j10 = this.mNativeVideoSnapListener;
        if (j10 != 0) {
            nativeOnComplete(j10, bitmap);
            this.mNativeVideoSnapListener = 0L;
        }
    }
}
