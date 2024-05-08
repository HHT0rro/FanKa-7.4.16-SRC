package com.zego.zegoavkit2.mediarecorder;

import com.zego.zegoavkit2.entities.ZegoPublishStreamQuality;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoMediaRecordCallback2 extends IZegoMediaRecordCallbackBase {
    void onRecordStatusUpdate(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, String str, long j10, long j11, ZegoPublishStreamQuality zegoPublishStreamQuality);
}
