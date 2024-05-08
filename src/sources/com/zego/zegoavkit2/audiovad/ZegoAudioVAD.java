package com.zego.zegoavkit2.audiovad;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoAudioVAD {
    private long mNativeClient;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioVADType {
        public static final int Noise = 0;
        public static final int Speech = 1;
    }

    public ZegoAudioVAD() {
        this.mNativeClient = 0L;
        this.mNativeClient = createZegoAudioVAD();
    }

    private static native long createZegoAudioVAD();

    private static native void destroyZegoAudioVAD(long j10);

    private static native int resetNative(long j10);

    private static native int updateNative(long j10, ByteBuffer byteBuffer, int i10, int i11, int i12);

    public void finalize() {
        destroyZegoAudioVAD(this.mNativeClient);
        this.mNativeClient = 0L;
    }

    public int reset() {
        return resetNative(this.mNativeClient);
    }

    public int update(ByteBuffer byteBuffer, int i10, int i11, int i12) {
        return updateNative(this.mNativeClient, byteBuffer, i10, i11, i12);
    }
}
