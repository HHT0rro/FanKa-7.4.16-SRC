package com.cupidapp.live.liveshow.entity;

import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class c implements IZegoLivePlayerCallback {
    @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
    public void onInviteJoinLiveRequest(int i10, @Nullable String str, @Nullable String str2, @Nullable String str3) {
    }

    @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
    public void onPlayQualityUpdate(@Nullable String str, @Nullable ZegoPlayStreamQuality zegoPlayStreamQuality) {
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "onPlayQualityUpdate 拉流质量更新 streamID: " + str + " 视频帧率: " + ((Object) (zegoPlayStreamQuality != null ? Double.valueOf(zegoPlayStreamQuality.vdecFps) : null)) + " 视频码率: " + ((Object) (zegoPlayStreamQuality != null ? Double.valueOf(zegoPlayStreamQuality.vkbps) : null)) + " width: " + ((Object) (zegoPlayStreamQuality != null ? Integer.valueOf(zegoPlayStreamQuality.width) : null)) + " height: " + ((Object) (zegoPlayStreamQuality != null ? Integer.valueOf(zegoPlayStreamQuality.height) : null)) + " quality: " + ((Object) (zegoPlayStreamQuality != null ? Integer.valueOf(zegoPlayStreamQuality.quality) : null)));
    }

    @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
    public void onPlayStateUpdate(int i10, @Nullable String str) {
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "onPlayStateUpdate 拉流状态更新 stateCode:" + i10 + "  streamID:" + str);
    }

    @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
    public void onRecvEndJoinLiveCommand(@Nullable String str, @Nullable String str2, @Nullable String str3) {
    }

    @Override // com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
    public void onVideoSizeChangedTo(@Nullable String str, int i10, int i11) {
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "onVideoSizeChangedTo 视频宽高变化通知 streamId:" + str + " width: " + i10 + " height: " + i11);
    }
}
