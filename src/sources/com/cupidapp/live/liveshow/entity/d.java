package com.cupidapp.live.liveshow.entity;

import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import java.util.HashMap;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class d implements IZegoLivePublisherCallback {
    @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
    public void onCaptureAudioFirstFrame() {
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "onCaptureAudioFirstFrame 采集音频的首帧通知");
    }

    @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
    public void onCaptureVideoFirstFrame() {
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "onCaptureVideoFirstFrame 采集视频的首帧通知");
    }

    @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
    public void onCaptureVideoSizeChangedTo(int i10, int i11) {
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "onCaptureVideoSizeChangedTo 采集视频的宽度和高度变化通知 width: " + i10 + " height:" + i11);
    }

    @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
    public void onJoinLiveRequest(int i10, @NotNull String userId, @NotNull String userName, @NotNull String roomId) {
        s.i(userId, "userId");
        s.i(userName, "userName");
        s.i(roomId, "roomId");
    }

    @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
    public void onPublishQualityUpdate(@NotNull String streamID, @NotNull ZegoPublishStreamQuality sq) {
        s.i(streamID, "streamID");
        s.i(sq, "sq");
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "onPublishQualityUpdate 推流质量更新 streamID: " + streamID + " vnetFps: " + sq.vnetFps + " vkbps: " + sq.vkbps + " width: " + sq.width + " height: " + sq.height + " quality: " + sq.quality);
    }

    @Override // com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
    public void onPublishStateUpdate(int i10, @Nullable String str, @Nullable HashMap<String, Object> hashMap) {
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "onPublishStateUpdate 推流状态更新 stateCode: " + i10 + " streamID: " + str + " streamInfo: " + ((Object) hashMap));
    }
}
