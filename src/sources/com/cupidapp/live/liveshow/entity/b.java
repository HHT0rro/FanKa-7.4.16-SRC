package com.cupidapp.live.liveshow.entity;

import android.graphics.Bitmap;
import com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class b implements IZegoMediaPlayerWithIndexCallback {
    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onAudioBegin(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onAudioBegin: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onBufferBegin(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onBufferBegin p0: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onBufferEnd(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onBufferEnd: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onLoadComplete(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onLoadComplete: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onMediaPlayerVideoSizeChanged(int i10, int i11, int i12) {
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onPlayEnd(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onPlayEnd: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onPlayError(int i10, int i11) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onPlayError: " + i10 + " p1: " + i11);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onPlayPause(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onPlayPause : " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onPlayResume(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onPlayResume: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onPlayStart(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onPlayStart p0: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onPlayStop(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onPlayStop: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onProcessInterval(long j10, int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onProcessInterval: " + j10 + " p1: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onReadEOF(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onReadEOF p0: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onRenderingProcessInterval(long j10, int i10) {
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onSeekComplete(int i10, long j10, int i11) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onSeekComplete: " + i10 + " p1: " + j10 + " p2: " + i11);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onSnapshot(@Nullable Bitmap bitmap, int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onSnapshot: " + ((Object) bitmap) + " p1: " + i10);
    }

    @Override // com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
    public void onVideoBegin(int i10) {
        com.cupidapp.live.base.utils.j.f12332a.a("HFLiveApi", "onVideoBegin: " + i10);
    }
}
