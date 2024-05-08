package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.concurrent.atomic.AtomicLong;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ProducerChainTimestamp {
    private AtomicLong mCaptureTimestamp = new AtomicLong(0);
    private AtomicLong mPreprocessTimestamp = new AtomicLong(0);
    private AtomicLong mEncodeTimestamp = new AtomicLong(0);
    private AtomicLong mEncodeFinishTimestamp = new AtomicLong(0);

    public void copy(ProducerChainTimestamp producerChainTimestamp) {
        this.mCaptureTimestamp = producerChainTimestamp.mCaptureTimestamp;
        this.mPreprocessTimestamp = producerChainTimestamp.mPreprocessTimestamp;
        this.mEncodeTimestamp = producerChainTimestamp.mEncodeTimestamp;
        this.mEncodeFinishTimestamp = producerChainTimestamp.mEncodeFinishTimestamp;
    }

    @CalledByNative
    public long getCaptureTimestamp() {
        return this.mCaptureTimestamp.get();
    }

    @CalledByNative
    public long getEncodeFinishTimestamp() {
        return this.mEncodeFinishTimestamp.get();
    }

    @CalledByNative
    public long getEncodeTimestamp() {
        return this.mEncodeTimestamp.get();
    }

    @CalledByNative
    public long getPreprocessTimestamp() {
        return this.mPreprocessTimestamp.get();
    }

    public void setCaptureTimestamp(long j10) {
        this.mCaptureTimestamp.set(j10);
    }

    public void setEncodeFinishTimestamp(long j10) {
        this.mEncodeFinishTimestamp.set(j10);
    }

    public void setEncodeTimestamp(long j10) {
        this.mEncodeTimestamp.set(j10);
    }

    public void setPreprocessTimestamp(long j10) {
        this.mPreprocessTimestamp.set(j10);
    }
}
