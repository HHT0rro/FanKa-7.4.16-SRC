package com.tencent.live2.impl;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.util.s;
import com.tencent.liteav.live.V2TXLivePlayerJni;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class V2TXLivePlayerImpl extends V2TXLivePlayer {
    private V2TXLivePlayer mImpl;

    static {
        s.a();
    }

    public V2TXLivePlayerImpl(Context context) {
        this.mImpl = new V2TXLivePlayerJni(context, this);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveAudioFrame(boolean z10) {
        return this.mImpl.enableObserveAudioFrame(z10);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveVideoFrame(boolean z10, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        return this.mImpl.enableObserveVideoFrame(z10, v2TXLivePixelFormat, v2TXLiveBufferType);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableReceiveSeiMessage(boolean z10, int i10) {
        return this.mImpl.enableReceiveSeiMessage(z10, i10);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableVolumeEvaluation(int i10) {
        return this.mImpl.enableVolumeEvaluation(i10);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamList() {
        return this.mImpl.getStreamList();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int isPlaying() {
        return this.mImpl.isPlaying();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseAudio() {
        return this.mImpl.pauseAudio();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseVideo() {
        return this.mImpl.pauseVideo();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeAudio() {
        return this.mImpl.resumeAudio();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeVideo() {
        return this.mImpl.resumeVideo();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setCacheParams(float f10, float f11) {
        return this.mImpl.setCacheParams(f10, f11);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void setObserver(V2TXLivePlayerObserver v2TXLivePlayerObserver) {
        this.mImpl.setObserver(v2TXLivePlayerObserver);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setPlayoutVolume(int i10) {
        return this.mImpl.setPlayoutVolume(i10);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setProperty(String str, Object obj) {
        return this.mImpl.setProperty(str, obj);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        return this.mImpl.setRenderFillMode(v2TXLiveFillMode);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        return this.mImpl.setRenderRotation(v2TXLiveRotation);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        return this.mImpl.setRenderView(tXCloudVideoView);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void showDebugView(boolean z10) {
        this.mImpl.showDebugView(z10);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int snapshot() {
        return this.mImpl.snapshot();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int startLivePlay(String str) {
        return this.mImpl.startLivePlay(str);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int stopPlay() {
        return this.mImpl.stopPlay();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int switchStream(String str) {
        return this.mImpl.switchStream(str);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TextureView textureView) {
        return this.mImpl.setRenderView(textureView);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(SurfaceView surfaceView) {
        return this.mImpl.setRenderView(surfaceView);
    }
}
