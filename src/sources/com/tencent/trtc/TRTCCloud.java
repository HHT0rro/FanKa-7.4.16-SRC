package com.tencent.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Handler;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.trtc.TRTCCloudImpl;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class TRTCCloud extends DeprecatedTRTCCloud {
    private static a mTXLogListener;
    public static WeakReference<TRTCCloud> sInstance;

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface BGMNotify {
        void onBGMComplete(int i10);

        void onBGMProgress(long j10, long j11);

        void onBGMStart(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCViewMargin {
        public float bottomMargin;
        public float leftMargin;
        public float rightMargin;
        public float topMargin;

        public TRTCViewMargin(float f10, float f11, float f12, float f13) {
            this.leftMargin = f10;
            this.topMargin = f12;
            this.rightMargin = f11;
            this.bottomMargin = f13;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements LiteavLog.a {

        /* renamed from: a, reason: collision with root package name */
        public TRTCCloudListener.TRTCLogListener f45375a = null;

        @Override // com.tencent.liteav.base.util.LiteavLog.a
        public final void a(int i10, String str, String str2) {
            TRTCCloudListener.TRTCLogListener tRTCLogListener = this.f45375a;
            if (tRTCLogListener != null) {
                tRTCLogListener.onLog(str2, i10, str);
            }
        }
    }

    public static void destroySharedInstance() {
        TRTCCloudImpl.a();
    }

    public static String getSDKVersion() {
        return CommonUtil.getSDKVersionStr();
    }

    public static void setConsoleEnabled(boolean z10) {
        TRTCCloudImpl.a(z10);
    }

    public static void setLogCompressEnabled(boolean z10) {
        TRTCCloudImpl.b(z10);
    }

    public static void setLogDirPath(String str) {
        TRTCCloudImpl.a(str);
    }

    public static void setLogLevel(int i10) {
        TRTCCloudImpl.a(i10);
    }

    public static void setLogListener(TRTCCloudListener.TRTCLogListener tRTCLogListener) {
        a aVar = mTXLogListener;
        if (aVar != null) {
            aVar.f45375a = null;
        }
        if (tRTCLogListener != null) {
            a aVar2 = new a();
            mTXLogListener = aVar2;
            aVar2.f45375a = tRTCLogListener;
        } else {
            mTXLogListener = null;
        }
        LiteavLog.setCallback(mTXLogListener);
        LiteavLog.nativeSetLogCallbackEnabled(mTXLogListener != null);
    }

    public static TRTCCloud sharedInstance(Context context) {
        return TRTCCloudImpl.a(context);
    }

    public abstract void ConnectOtherRoom(String str);

    public abstract void DisconnectOtherRoom();

    public abstract void addListener(TRTCCloudListener tRTCCloudListener);

    public abstract String callExperimentalAPI(String str);

    public abstract TRTCCloud createSubCloud();

    public abstract void destroySubCloud(TRTCCloud tRTCCloud);

    public abstract void enable3DSpatialAudioEffect(boolean z10);

    public abstract void enableAudioVolumeEvaluation(boolean z10, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams);

    public abstract void enableCustomAudioCapture(boolean z10);

    public abstract void enableCustomAudioRendering(boolean z10);

    public abstract void enableCustomVideoCapture(int i10, boolean z10);

    public abstract int enableEncSmallVideoStream(boolean z10, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void enableMixExternalAudioFrame(boolean z10, boolean z11);

    public abstract int enablePayloadPrivateEncryption(boolean z10, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig);

    public abstract void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i10);

    public abstract void exitRoom();

    public abstract long generateCustomPTS();

    public abstract int getAudioCaptureVolume();

    public abstract TXAudioEffectManager getAudioEffectManager();

    public abstract int getAudioPlayoutVolume();

    public abstract TXBeautyManager getBeautyManager();

    public abstract void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract TXDeviceManager getDeviceManager();

    public abstract int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract void muteAllRemoteAudio(boolean z10);

    public abstract void muteAllRemoteVideoStreams(boolean z10);

    public abstract void muteLocalAudio(boolean z10);

    public abstract void muteLocalVideo(int i10, boolean z10);

    public abstract void muteRemoteAudio(String str, boolean z10);

    public abstract void muteRemoteVideoStream(String str, int i10, boolean z10);

    public abstract void pauseScreenCapture();

    public abstract void removeListener(TRTCCloudListener tRTCCloudListener);

    public abstract void resumeScreenCapture();

    public abstract void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract boolean sendCustomCmdMsg(int i10, byte[] bArr, boolean z10, boolean z11);

    public abstract void sendCustomVideoData(int i10, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame);

    public abstract boolean sendSEIMsg(byte[] bArr, int i10);

    public abstract void set3DSpatialReceivingRange(String str, int i10);

    public abstract void setAudioCaptureVolume(int i10);

    public abstract void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener);

    public abstract void setAudioPlayoutVolume(int i10);

    public abstract void setAudioRoute(int i10);

    public abstract int setCapturedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat);

    public abstract void setDebugViewMargin(String str, TRTCViewMargin tRTCViewMargin);

    public abstract void setDefaultStreamRecvMode(boolean z10, boolean z11);

    public abstract void setGSensorMode(int i10);

    public abstract void setListener(TRTCCloudListener tRTCCloudListener);

    public abstract void setListenerHandler(Handler handler);

    public abstract int setLocalProcessedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat);

    public abstract void setLocalRenderParams(TRTCCloudDef.TRTCRenderParams tRTCRenderParams);

    public abstract int setLocalVideoProcessListener(int i10, int i11, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener);

    public abstract int setLocalVideoRenderListener(int i10, int i11, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener);

    public abstract void setMixExternalAudioVolume(int i10, int i11);

    public abstract void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig);

    public abstract int setMixedPlayAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat);

    public abstract void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam);

    public abstract void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2);

    public abstract void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams);

    public abstract void setRemoteAudioVolume(String str, int i10);

    public abstract void setRemoteRenderParams(String str, int i10, TRTCCloudDef.TRTCRenderParams tRTCRenderParams);

    public abstract int setRemoteVideoRenderListener(String str, int i10, int i11, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener);

    public abstract int setRemoteVideoStreamType(String str, int i10);

    public abstract void setSubStreamEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void setVideoEncoderMirror(boolean z10);

    public abstract void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void setVideoEncoderRotation(int i10);

    public abstract void setVideoMuteImage(Bitmap bitmap, int i10);

    public abstract void setWatermark(Bitmap bitmap, int i10, float f10, float f11, float f12);

    public abstract void showDebugView(int i10);

    public abstract void snapshotVideo(String str, int i10, int i11, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener);

    public abstract int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams);

    public abstract void startLocalAudio(int i10);

    public abstract void startLocalPreview(boolean z10, TXCloudVideoView tXCloudVideoView);

    public abstract void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams);

    public abstract void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam);

    public abstract void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig);

    public abstract void startPublishing(String str, int i10);

    public abstract void startRemoteView(String str, int i10, TXCloudVideoView tXCloudVideoView);

    public abstract void startScreenCapture(int i10, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams);

    public abstract int startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams);

    public abstract void startSystemAudioLoopback();

    public abstract void stopAllRemoteView();

    public abstract void stopAudioRecording();

    public abstract void stopLocalAudio();

    public abstract void stopLocalPreview();

    public abstract void stopLocalRecording();

    public abstract void stopPublishCDNStream();

    public abstract void stopPublishMediaStream(String str);

    public abstract void stopPublishing();

    public abstract void stopRemoteView(String str, int i10);

    public abstract void stopScreenCapture();

    public abstract void stopSpeedTest();

    public abstract void stopSystemAudioLoopback();

    public abstract void switchRole(int i10);

    public abstract void switchRole(int i10, String str);

    public abstract void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig);

    public abstract void updateLocalView(TXCloudVideoView tXCloudVideoView);

    public abstract void updateOtherRoomForwardMode(String str);

    public abstract void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig);

    public abstract void updateRemote3DSpatialPosition(String str, int[] iArr);

    public abstract void updateRemoteView(String str, int i10, TXCloudVideoView tXCloudVideoView);

    public abstract void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3);
}
