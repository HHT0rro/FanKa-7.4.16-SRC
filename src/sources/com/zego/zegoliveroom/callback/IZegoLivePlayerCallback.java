package com.zego.zegoliveroom.callback;

import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoLivePlayerCallback {
    void onInviteJoinLiveRequest(int i10, String str, String str2, String str3);

    void onPlayQualityUpdate(String str, ZegoPlayStreamQuality zegoPlayStreamQuality);

    void onPlayStateUpdate(int i10, String str);

    void onRecvEndJoinLiveCommand(String str, String str2, String str3);

    void onVideoSizeChangedTo(String str, int i10, int i11);
}
