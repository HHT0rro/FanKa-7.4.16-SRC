package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.concurrent.atomic.AtomicLong;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ConsumerChainTimestamp {
    private AtomicLong mDeliverTimestamp = new AtomicLong(0);
    private AtomicLong mDecodeFinishTimestamp = new AtomicLong(0);
    private AtomicLong mRenderFinishTimestamp = new AtomicLong(0);

    public void copy(ConsumerChainTimestamp consumerChainTimestamp) {
        this.mDeliverTimestamp = consumerChainTimestamp.mDeliverTimestamp;
        this.mDecodeFinishTimestamp = consumerChainTimestamp.mDecodeFinishTimestamp;
        this.mRenderFinishTimestamp = consumerChainTimestamp.mRenderFinishTimestamp;
    }

    @CalledByNative
    public long getDecodeFinishTimestamp() {
        return this.mDecodeFinishTimestamp.get();
    }

    @CalledByNative
    public long getDeliverTimestamp() {
        return this.mDeliverTimestamp.get();
    }

    @CalledByNative
    public long getRenderFinishTimestamp() {
        return this.mRenderFinishTimestamp.get();
    }

    public void setDecodeFinishTimestamp(long j10) {
        this.mDecodeFinishTimestamp.set(j10);
    }

    public void setDeliverTimestamp(long j10) {
        this.mDeliverTimestamp.set(j10);
    }

    public void setRenderFinishTimestamp(long j10) {
        this.mRenderFinishTimestamp.set(j10);
    }
}
