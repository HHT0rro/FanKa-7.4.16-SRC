package com.zego.zegoliveroom.callback;

import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoLivePublisherCallback {
    void onCaptureAudioFirstFrame();

    void onCaptureVideoFirstFrame();

    void onCaptureVideoSizeChangedTo(int i10, int i11);

    void onJoinLiveRequest(int i10, String str, String str2, String str3);

    void onPublishQualityUpdate(String str, ZegoPublishStreamQuality zegoPublishStreamQuality);

    void onPublishStateUpdate(int i10, String str, HashMap<String, Object> hashMap);
}
