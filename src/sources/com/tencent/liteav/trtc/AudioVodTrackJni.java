package com.tencent.liteav.trtc;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.trtc.TRTCCloudDef;

@JNINamespace("liteav::trtc")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AudioVodTrackJni {
    private long mNativeAudioVodTrackJni;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AudioFrame {

        /* renamed from: a, reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioFrame f43195a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.f43195a = tRTCAudioFrame;
        }

        @CalledByNative("AudioFrame")
        public int getChannel() {
            return this.f43195a.channel;
        }

        @CalledByNative("AudioFrame")
        public byte[] getData() {
            return this.f43195a.data;
        }

        @CalledByNative("AudioFrame")
        public int getSampleRate() {
            return this.f43195a.sampleRate;
        }

        @CalledByNative("AudioFrame")
        public long getTimestamp() {
            return this.f43195a.timestamp;
        }
    }

    public AudioVodTrackJni() {
        this.mNativeAudioVodTrackJni = 0L;
        this.mNativeAudioVodTrackJni = nativeCreateAudioVodTrackJni(this);
    }

    private static native void nativeClean(long j10);

    private static native long nativeCreateAudioVodTrackJni(AudioVodTrackJni audioVodTrackJni);

    private static native void nativeEnablePlayout(long j10, boolean z10);

    private static native void nativePause(long j10);

    private static native void nativeResume(long j10);

    private static native void nativeSeek(long j10);

    private static native void nativeSetPlayoutVolume(long j10, int i10);

    private static native int nativeWriteData(long j10, AudioFrame audioFrame);

    public synchronized void clean() {
        long j10 = this.mNativeAudioVodTrackJni;
        if (j10 != 0) {
            nativeClean(j10);
        }
    }

    public synchronized void enablePlayout(boolean z10) {
        long j10 = this.mNativeAudioVodTrackJni;
        if (j10 != 0) {
            nativeEnablePlayout(j10, z10);
        }
    }

    public synchronized void pause() {
        long j10 = this.mNativeAudioVodTrackJni;
        if (j10 != 0) {
            nativePause(j10);
        }
    }

    public synchronized void resume() {
        long j10 = this.mNativeAudioVodTrackJni;
        if (j10 != 0) {
            nativeResume(j10);
        }
    }

    public synchronized void seek() {
        long j10 = this.mNativeAudioVodTrackJni;
        if (j10 != 0) {
            nativeSeek(j10);
        }
    }

    public synchronized void setPlayoutVolume(int i10) {
        long j10 = this.mNativeAudioVodTrackJni;
        if (j10 != 0) {
            nativeSetPlayoutVolume(j10, i10);
        }
    }

    public synchronized int writeData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        long j10 = this.mNativeAudioVodTrackJni;
        if (j10 == 0) {
            return -1;
        }
        return nativeWriteData(j10, new AudioFrame(tRTCAudioFrame));
    }
}
