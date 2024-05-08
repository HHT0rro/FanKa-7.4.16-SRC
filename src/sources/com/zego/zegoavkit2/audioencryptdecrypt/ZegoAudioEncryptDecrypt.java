package com.zego.zegoavkit2.audioencryptdecrypt;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoAudioEncryptDecrypt implements IZegoAudioEncryptDecryptCallback {
    private volatile IZegoAudioEncryptDecryptCallback mAudioEncryptDecryptCallback = null;

    public static void enableAudioEncryptDecrypt(boolean z10) {
        ZegoAudioEncryptDecryptJNI.enableAudioEncryptDecrypt(z10);
    }

    @Override // com.zego.zegoavkit2.audioencryptdecrypt.IZegoAudioEncryptDecryptCallback
    public int onAudioEncryptDecrypt(String str, ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11) {
        IZegoAudioEncryptDecryptCallback iZegoAudioEncryptDecryptCallback = this.mAudioEncryptDecryptCallback;
        if (iZegoAudioEncryptDecryptCallback != null) {
            return iZegoAudioEncryptDecryptCallback.onAudioEncryptDecrypt(str, byteBuffer, i10, byteBuffer2, i11);
        }
        return 0;
    }

    public void setAudioEncryptDecryptCallback(IZegoAudioEncryptDecryptCallback iZegoAudioEncryptDecryptCallback) {
        this.mAudioEncryptDecryptCallback = iZegoAudioEncryptDecryptCallback;
        if (iZegoAudioEncryptDecryptCallback != null) {
            ZegoAudioEncryptDecryptJNI.setZegoAudioEncryptDecryptCallback(this);
        } else {
            ZegoAudioEncryptDecryptJNI.setZegoAudioEncryptDecryptCallback(null);
        }
    }
}
