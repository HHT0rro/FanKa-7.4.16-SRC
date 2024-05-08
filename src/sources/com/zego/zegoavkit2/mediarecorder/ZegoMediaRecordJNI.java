package com.zego.zegoavkit2.mediarecorder;

import com.zego.zegoavkit2.entities.ZegoPublishStreamQuality;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoMediaRecordJNI {
    private static volatile IZegoMediaRecordCallback2 sCallback;

    public static void onMediaRecord(int i10, int i11, String str) {
        IZegoMediaRecordCallback2 iZegoMediaRecordCallback2 = sCallback;
        if (iZegoMediaRecordCallback2 != null) {
            iZegoMediaRecordCallback2.onMediaRecord(i10, ZegoMediaRecordChannelIndex.values()[i11], str);
        }
    }

    public static void onRecordStatusUpdate(int i10, String str, long j10, long j11, ZegoPublishStreamQuality zegoPublishStreamQuality) {
        IZegoMediaRecordCallback2 iZegoMediaRecordCallback2 = sCallback;
        if (iZegoMediaRecordCallback2 != null) {
            iZegoMediaRecordCallback2.onRecordStatusUpdate(ZegoMediaRecordChannelIndex.values()[i10], str, j10, j11, zegoPublishStreamQuality);
        }
    }

    public static void setCallback(IZegoMediaRecordCallback2 iZegoMediaRecordCallback2) {
        sCallback = iZegoMediaRecordCallback2;
    }

    public static native void setMediaRecordCallback(boolean z10);

    public static native boolean startRecord(int i10, int i11, String str);

    public static native boolean startRecordEx(int i10, int i11, String str, boolean z10, int i12, int i13, boolean z11, String str2);

    public static native void stopRecord(int i10);
}
