package com.tencent.rtmp;

import android.view.Surface;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface a {
    void callExperimentalAPI(String str);

    void enableAudioVolumeEvaluation(int i10);

    boolean enableHardwareDecode(boolean z10);

    long getCurrentRenderPts();

    boolean isPlaying();

    void pause();

    void resume();

    void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener);

    void setAudioRoute(int i10);

    void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener);

    void setConfig(TXLivePlayConfig tXLivePlayConfig);

    void setMute(boolean z10);

    void setPlayListener(ITXLivePlayListener iTXLivePlayListener);

    void setPlayerView(TXCloudVideoView tXCloudVideoView);

    void setRenderMode(int i10);

    void setRenderRotation(int i10);

    void setSurface(Surface surface);

    void setSurfaceSize(int i10, int i11);

    void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener);

    void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener);

    int setVideoRenderListener(TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj);

    void setVolume(int i10);

    void showDebugView(boolean z10);

    void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener);

    int startLivePlay(String str, int i10);

    int startRecord(int i10);

    int stopPlay(boolean z10);

    int stopRecord();

    int switchStream(String str);
}
