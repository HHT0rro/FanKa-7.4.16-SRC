package com.zego.zegoavkit2.mediaside;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoMediaSideInfo {
    private volatile IZegoMediaSideCallback mZegoMediaSideCallback;

    public void sendMediaSideInfo(ByteBuffer byteBuffer, int i10, boolean z10, int i11) {
        ZegoMediaSideInfoJNI.sendMediaSideInfo(byteBuffer, i10, z10, i11);
    }

    public void setMediaSideFlags(boolean z10, boolean z11, int i10) {
        ZegoMediaSideInfoJNI.setMediaSideFlags(z10, z11, 0, 0, i10);
    }

    public void setZegoMediaSideCallback(IZegoMediaSideCallback iZegoMediaSideCallback) {
        this.mZegoMediaSideCallback = iZegoMediaSideCallback;
        if (iZegoMediaSideCallback != null) {
            ZegoMediaSideInfoJNI.setCallback(new IZegoMediaSideCallback() { // from class: com.zego.zegoavkit2.mediaside.ZegoMediaSideInfo.1
                @Override // com.zego.zegoavkit2.mediaside.IZegoMediaSideCallback
                public void onRecvMediaSideInfo(String str, ByteBuffer byteBuffer, int i10) {
                    IZegoMediaSideCallback iZegoMediaSideCallback2 = ZegoMediaSideInfo.this.mZegoMediaSideCallback;
                    if (iZegoMediaSideCallback2 != null) {
                        iZegoMediaSideCallback2.onRecvMediaSideInfo(str, byteBuffer, i10);
                    }
                }
            });
        } else {
            ZegoMediaSideInfoJNI.setCallback(null);
        }
    }

    public void setMediaSideFlags(boolean z10, boolean z11, int i10, int i11, int i12) {
        ZegoMediaSideInfoJNI.setMediaSideFlags(z10, z11, i10, i11, i12);
    }
}
