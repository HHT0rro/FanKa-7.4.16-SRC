package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.base.util.s;
import com.tencent.liteav.live.TXLivePlayerJni;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TXLivePlayer {
    public static final int PLAY_TYPE_LIVE_FLV = 1;
    public static final int PLAY_TYPE_LIVE_HLS = 7;
    public static final int PLAY_TYPE_LIVE_RTMP = 0;
    public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
    public static final String TAG = "TXLivePlayer";
    private a mImpl;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ITXAudioRawDataListener {
        void onAudioInfoChanged(int i10, int i11, int i12);

        void onPcmDataAvailable(byte[] bArr, long j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ITXLivePlayVideoRenderListener {
        void onRenderVideoFrame(TXLiteAVTexture tXLiteAVTexture);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ITXVideoRawDataListener {
        void onVideoRawDataAvailable(byte[] bArr, int i10, int i11, int i12);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TXLiteAVTexture {
        public Object eglContext;
        public int height;
        public int textureId;
        public int width;
    }

    static {
        s.a();
    }

    public TXLivePlayer(Context context) {
        this.mImpl = new TXLivePlayerJni(context);
    }

    public void callExperimentalAPI(String str) {
        this.mImpl.callExperimentalAPI(str);
    }

    public void enableAudioVolumeEvaluation(int i10) {
        this.mImpl.enableAudioVolumeEvaluation(i10);
    }

    public boolean enableHardwareDecode(boolean z10) {
        return this.mImpl.enableHardwareDecode(z10);
    }

    public long getCurrentRenderPts() {
        return this.mImpl.getCurrentRenderPts();
    }

    public boolean isPlaying() {
        return this.mImpl.isPlaying();
    }

    public void pause() {
        this.mImpl.pause();
    }

    public void resume() {
        this.mImpl.resume();
    }

    public void setAudioRawDataListener(ITXAudioRawDataListener iTXAudioRawDataListener) {
        this.mImpl.setAudioRawDataListener(iTXAudioRawDataListener);
    }

    public void setAudioRoute(int i10) {
        this.mImpl.setAudioRoute(i10);
    }

    public void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mImpl.setAudioVolumeEvaluationListener(iTXAudioVolumeEvaluationListener);
    }

    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        this.mImpl.setConfig(tXLivePlayConfig);
    }

    public void setMute(boolean z10) {
        this.mImpl.setMute(z10);
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mImpl.setPlayListener(iTXLivePlayListener);
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        this.mImpl.setPlayerView(tXCloudVideoView);
    }

    public void setRenderMode(int i10) {
        this.mImpl.setRenderMode(i10);
    }

    public void setRenderRotation(int i10) {
        this.mImpl.setRenderRotation(i10);
    }

    public void setSurface(Surface surface) {
        this.mImpl.setSurface(surface);
    }

    public void setSurfaceSize(int i10, int i11) {
        this.mImpl.setSurfaceSize(i10, i11);
    }

    public void setVideoRawDataListener(ITXVideoRawDataListener iTXVideoRawDataListener) {
        this.mImpl.setVideoRawDataListener(iTXVideoRawDataListener);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mImpl.setVideoRecordListener(iTXVideoRecordListener);
    }

    public int setVideoRenderListener(ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        return this.mImpl.setVideoRenderListener(iTXLivePlayVideoRenderListener, obj);
    }

    public void setVolume(int i10) {
        this.mImpl.setVolume(i10);
    }

    public void showDebugView(boolean z10) {
        this.mImpl.showDebugView(z10);
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        this.mImpl.snapshot(iTXSnapshotListener);
    }

    public int startLivePlay(String str, int i10) {
        return this.mImpl.startLivePlay(str, i10);
    }

    public int startRecord(int i10) {
        return this.mImpl.startRecord(i10);
    }

    public int stopPlay(boolean z10) {
        return this.mImpl.stopPlay(z10);
    }

    public int stopRecord() {
        return this.mImpl.stopRecord();
    }

    public int switchStream(String str) {
        return this.mImpl.switchStream(str);
    }
}
