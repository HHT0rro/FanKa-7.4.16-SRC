package com.cupidapp.live.liveshow.entity;

import com.zego.zegoavkit2.soundlevel.IZegoSoundLevelCallback;
import com.zego.zegoavkit2.soundlevel.ZegoSoundLevelInfo;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class e implements IZegoSoundLevelCallback {
    @Override // com.zego.zegoavkit2.soundlevel.IZegoSoundLevelCallback
    public void onCaptureSoundLevelUpdate(@Nullable ZegoSoundLevelInfo zegoSoundLevelInfo) {
        if (zegoSoundLevelInfo != null) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "本地音量采集回调 streamID: " + zegoSoundLevelInfo.streamID + " soundLevel: " + zegoSoundLevelInfo.soundLevel + " vad: " + zegoSoundLevelInfo.vad);
        }
    }

    @Override // com.zego.zegoavkit2.soundlevel.IZegoSoundLevelCallback
    public void onSoundLevelUpdate(@Nullable ZegoSoundLevelInfo[] zegoSoundLevelInfoArr) {
        if (zegoSoundLevelInfoArr != null) {
            for (ZegoSoundLevelInfo zegoSoundLevelInfo : zegoSoundLevelInfoArr) {
                com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "拉流声浪数据回调 streamID: " + zegoSoundLevelInfo.streamID + " soundLevel: " + zegoSoundLevelInfo.soundLevel + " vad: " + zegoSoundLevelInfo.vad);
            }
        }
    }
}
