package com.tencent.live2;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class V2TXLivePlayerObserver {
    public void onAudioLoading(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
    }

    public void onAudioPlaying(V2TXLivePlayer v2TXLivePlayer, boolean z10, Bundle bundle) {
    }

    public void onConnected(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
    }

    public void onError(V2TXLivePlayer v2TXLivePlayer, int i10, String str, Bundle bundle) {
    }

    public void onPlayoutAudioFrame(V2TXLivePlayer v2TXLivePlayer, V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
    }

    public void onPlayoutVolumeUpdate(V2TXLivePlayer v2TXLivePlayer, int i10) {
    }

    public void onReceiveSeiMessage(V2TXLivePlayer v2TXLivePlayer, int i10, byte[] bArr) {
    }

    public void onRenderVideoFrame(V2TXLivePlayer v2TXLivePlayer, V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
    }

    public void onSnapshotComplete(V2TXLivePlayer v2TXLivePlayer, Bitmap bitmap) {
    }

    public void onStatisticsUpdate(V2TXLivePlayer v2TXLivePlayer, V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics) {
    }

    public void onStreamSwitched(V2TXLivePlayer v2TXLivePlayer, String str, int i10) {
    }

    public void onVideoLoading(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
    }

    public void onVideoPlaying(V2TXLivePlayer v2TXLivePlayer, boolean z10, Bundle bundle) {
    }

    public void onVideoResolutionChanged(V2TXLivePlayer v2TXLivePlayer, int i10, int i11) {
    }

    public void onWarning(V2TXLivePlayer v2TXLivePlayer, int i10, String str, Bundle bundle) {
    }
}
