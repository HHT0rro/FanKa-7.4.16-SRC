package com.tencent.trtc;

import com.tencent.liteav.trtc.AudioVodTrackJni;
import com.tencent.trtc.TRTCCloudDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TRTCAudioVodTrack {
    private AudioVodTrackJni mAudioVodTrackJni;

    public TRTCAudioVodTrack() {
        this.mAudioVodTrackJni = null;
        this.mAudioVodTrackJni = new AudioVodTrackJni();
    }

    public void clean() {
        this.mAudioVodTrackJni.clean();
    }

    public void enablePlayout(boolean z10) {
        this.mAudioVodTrackJni.enablePlayout(z10);
    }

    public void pause() {
        this.mAudioVodTrackJni.pause();
    }

    public void resume() {
        this.mAudioVodTrackJni.resume();
    }

    public void seek() {
        this.mAudioVodTrackJni.seek();
    }

    public void setPlayoutVolume(int i10) {
        this.mAudioVodTrackJni.setPlayoutVolume(i10);
    }

    public int writeData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        return this.mAudioVodTrackJni.writeData(tRTCAudioFrame);
    }
}
