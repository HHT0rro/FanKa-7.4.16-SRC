package com.zego.zegoliveroom.callback;

import com.zego.zegoliveroom.entity.ZegoPlayStats;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoLivePlayerCallback2 extends IZegoLivePlayerCallback {
    void onPlayStatsUpdate(ZegoPlayStats zegoPlayStats);

    void onPlayVideoSuperResolutionUpdate(String str, int i10, int i11);

    void onRecvRemoteAudioFirstFrame(String str);

    void onRecvRemoteVideoFirstFrame(String str);

    void onRemoteCameraStatusUpdate(String str, int i10, int i11);

    void onRemoteMicStatusUpdate(String str, int i10, int i11);

    void onRemoteSpeakerStatusUpdate(String str, int i10, int i11);

    void onRenderRemoteVideoFirstFrame(String str);

    void onVideoDecoderError(int i10, int i11, String str);
}
