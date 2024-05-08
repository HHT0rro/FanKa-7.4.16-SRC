package com.zego.zegoavkit2.audioencryptdecrypt;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoAudioEncryptDecryptJNI {
    private static volatile IZegoAudioEncryptDecryptCallback sCallback;

    public static native void enableAudioEncryptDecrypt(boolean z10);

    public static int onAudioEncryptDecrypt(String str, ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11) {
        IZegoAudioEncryptDecryptCallback iZegoAudioEncryptDecryptCallback = sCallback;
        if (iZegoAudioEncryptDecryptCallback != null) {
            return iZegoAudioEncryptDecryptCallback.onAudioEncryptDecrypt(str, byteBuffer, i10, byteBuffer2, i11);
        }
        return 0;
    }

    public static void setZegoAudioEncryptDecryptCallback(IZegoAudioEncryptDecryptCallback iZegoAudioEncryptDecryptCallback) {
        sCallback = iZegoAudioEncryptDecryptCallback;
    }
}
