package com.tencent.liteav.trtc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.base.util.f;
import com.tencent.liteav.base.util.j;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TRTCCloudImpl extends TRTCCloud implements TXAudioEffectManager.TXMusicPlayObserver {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f43196a;

    /* renamed from: b, reason: collision with root package name */
    private static TRTCCloudImpl f43197b;

    /* renamed from: c, reason: collision with root package name */
    private Context f43198c;

    /* renamed from: d, reason: collision with root package name */
    private TRTCCloudListener f43199d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private TrtcCloudJni f43200e;

    /* renamed from: f, reason: collision with root package name */
    private TRTCCloud.BGMNotify f43201f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private TXAudioEffectManagerImpl f43202g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private TXDeviceManagerImpl f43203h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private TXBeautyManager f43204i;

    /* renamed from: j, reason: collision with root package name */
    private int f43205j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<TRTCCloudImpl> f43206k = new ArrayList<>();

    private TRTCCloudImpl(Context context, boolean z10) {
        b(context);
        this.f43198c = context;
        a(context, 0L, z10);
    }

    private static void b(@NonNull Context context) {
        synchronized (TRTCCloudImpl.class) {
            if (!f43196a) {
                ContextUtils.initApplicationContext(context.getApplicationContext());
                ContextUtils.setDataDirectorySuffix("liteav");
                TrtcCloudJni.init(0);
                f43196a = true;
            }
            if (context instanceof Activity) {
                j.a().a((Activity) context);
            }
        }
    }

    public static TRTCCloud createInstance(Context context) {
        return new TRTCCloudImpl(context, false);
    }

    public static void destroyInstance(TRTCCloud tRTCCloud) {
        if (tRTCCloud instanceof TRTCCloudImpl) {
            ((TRTCCloudImpl) tRTCCloud).f43200e.destroy();
        } else {
            LiteavLog.w("TRTCCloudImpl", "destroyInstance trtcCloud=".concat(String.valueOf(tRTCCloud)));
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void ConnectOtherRoom(String str) {
        this.f43200e.connectOtherRoom(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void DisconnectOtherRoom() {
        this.f43200e.disconnectOtherRoom();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void addListener(TRTCCloudListener tRTCCloudListener) {
        this.f43200e.addListener(tRTCCloudListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public String callExperimentalAPI(String str) {
        return this.f43200e.callExperimentalAPI(str);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int checkAudioCapabilitySupport(int i10) {
        return (i10 == 2 && this.f43203h.isLowLatencyEarMonitorSupported()) ? 1 : 0;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TRTCCloud createSubCloud() {
        TRTCCloudImpl tRTCCloudImpl;
        synchronized (TRTCCloudImpl.class) {
            tRTCCloudImpl = new TRTCCloudImpl(ContextUtils.getApplicationContext(), this.f43200e.getTrtcCloudJni());
            this.f43206k.add(tRTCCloudImpl);
        }
        return tRTCCloudImpl;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void destroySubCloud(TRTCCloud tRTCCloud) {
        synchronized (TRTCCloudImpl.class) {
            if (tRTCCloud instanceof TRTCCloudImpl) {
                LiteavLog.i("TRTCCloudImpl", "destructor destroySubCloud");
                ((TRTCCloudImpl) tRTCCloud).f43200e.destroy();
                this.f43206k.remove(tRTCCloud);
            }
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enable3DSpatialAudioEffect(boolean z10) {
        this.f43200e.enable3DSpatialAudioEffect(z10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableAudioEarMonitoring(boolean z10) {
        this.f43202g.enableVoiceEarMonitor(z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableAudioVolumeEvaluation(boolean z10, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams) {
        this.f43200e.enableAudioVolumeEvaluation(z10, tRTCAudioVolumeEvaluateParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomAudioCapture(boolean z10) {
        this.f43200e.enableCustomAudioCapture(z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomAudioRendering(boolean z10) {
        this.f43200e.enableCustomAudioRendering(z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomVideoCapture(int i10, boolean z10) {
        this.f43200e.enableCustomVideoCapture(i10, z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int enableEncSmallVideoStream(boolean z10, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        return this.f43200e.enableEncSmallVideoStream(z10, tRTCVideoEncParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableMixExternalAudioFrame(boolean z10, boolean z11) {
        this.f43200e.enableMixExternalAudioFrame(z10, z11);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int enablePayloadPrivateEncryption(boolean z10, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
        return this.f43200e.enablePayloadPrivateEncryption(z10, tRTCPayloadPrivateEncryptionConfig);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean enableTorch(boolean z10) {
        return this.f43203h.enableCameraTorch(z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i10) {
        this.f43200e.enterRoom(tRTCParams, i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void exitRoom() {
        this.f43200e.exitRoom();
        try {
            File file = new File(b());
            if (file.exists() && file.isDirectory() && f.a(file, 5) > 52428800) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (Exception e2) {
            LiteavLog.w("TRTCCloudImpl", "clearCache error " + e2.toString());
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public long generateCustomPTS() {
        return TimeUtil.a();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int getAudioCaptureVolume() {
        return this.f43200e.getAudioCaptureVolume();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXAudioEffectManager getAudioEffectManager() {
        return this.f43202g;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int getAudioPlayoutVolume() {
        return this.f43200e.getAudioPlayoutVolume();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int getBGMDuration(String str) {
        return (int) this.f43202g.getMusicDurationInMS(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXBeautyManager getBeautyManager() {
        return this.f43204i;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.f43200e.getCustomAudioRenderingFrame(tRTCAudioFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXDeviceManager getDeviceManager() {
        return this.f43203h;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.f43203h.isCameraAutoFocusFaceModeSupported();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraFocusPositionInPreviewSupported() {
        return this.f43203h.isCameraFocusPositionInPreviewSupported();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraTorchSupported() {
        return this.f43203h.isCameraTorchSupported();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean isCameraZoomSupported() {
        return this.f43203h.isCameraZoomSupported();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        return this.f43200e.mixExternalAudioFrame(tRTCAudioFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteAllRemoteAudio(boolean z10) {
        this.f43200e.muteAllRemoteAudio(z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteAllRemoteVideoStreams(boolean z10) {
        this.f43200e.muteAllRemoteVideoStreams(z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteLocalAudio(boolean z10) {
        this.f43200e.muteLocalAudio(z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteLocalVideo(int i10, boolean z10) {
        this.f43200e.muteLocalVideo(i10, z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteRemoteAudio(String str, boolean z10) {
        this.f43200e.muteRemoteAudio(str, z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteRemoteVideoStream(String str, int i10, boolean z10) {
        this.f43200e.muteRemoteVideoStream(str, i10, z10);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onComplete(int i10, int i11) {
        TRTCCloud.BGMNotify bGMNotify = this.f43201f;
        if (bGMNotify != null) {
            bGMNotify.onBGMComplete(i11);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onPlayProgress(int i10, long j10, long j11) {
        TRTCCloud.BGMNotify bGMNotify = this.f43201f;
        if (bGMNotify != null) {
            bGMNotify.onBGMProgress(j10, j11);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onStart(int i10, int i11) {
        TRTCCloud.BGMNotify bGMNotify = this.f43201f;
        if (bGMNotify != null) {
            bGMNotify.onBGMStart(i11);
        }
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void pauseAudioEffect(int i10) {
        this.f43202g.pauseAudioEffect(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void pauseBGM() {
        this.f43202g.pausePlayMusic(Integer.MAX_VALUE);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void pauseScreenCapture() {
        this.f43200e.pauseScreenCapture(this.f43205j);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam tRTCAudioEffectParam) {
        if (tRTCAudioEffectParam == null) {
            return;
        }
        final int i10 = tRTCAudioEffectParam.effectId;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(i10, b(tRTCAudioEffectParam.path));
        audioMusicParam.publish = tRTCAudioEffectParam.publish;
        audioMusicParam.loopCount = tRTCAudioEffectParam.loopCount;
        audioMusicParam.isShortFile = true;
        this.f43202g.playAudioEffect(audioMusicParam);
        this.f43202g.setEffectObserver(i10, new TXAudioEffectManager.TXMusicPlayObserver() { // from class: com.tencent.liteav.trtc.TRTCCloudImpl.1
            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public final void onComplete(int i11, int i12) {
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.f43199d;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onAudioEffectFinished(i10, i12);
                }
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public final void onPlayProgress(int i11, long j10, long j11) {
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public final void onStart(int i11, int i12) {
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.f43199d;
                if (tRTCCloudListener == null || i12 >= 0) {
                    return;
                }
                tRTCCloudListener.onAudioEffectFinished(i10, i12);
            }
        });
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void playBGM(String str, TRTCCloud.BGMNotify bGMNotify) {
        this.f43201f = bGMNotify;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(Integer.MAX_VALUE, str);
        audioMusicParam.publish = true;
        audioMusicParam.loopCount = 0;
        this.f43202g.setMusicObserver(Integer.MAX_VALUE, this);
        this.f43202g.startPlayMusic(audioMusicParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void removeListener(TRTCCloudListener tRTCCloudListener) {
        this.f43200e.removeListener(tRTCCloudListener);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void resumeAudioEffect(int i10) {
        this.f43202g.resumeAudioEffect(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void resumeBGM() {
        this.f43202g.resumePlayMusic(Integer.MAX_VALUE);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void resumeScreenCapture() {
        this.f43200e.resumeScreenCapture(this.f43205j);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void selectMotionTmpl(String str) {
        this.f43204i.setMotionTmpl(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.f43200e.sendCustomAudioData(tRTCAudioFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean sendCustomCmdMsg(int i10, byte[] bArr, boolean z10, boolean z11) {
        if (bArr == null) {
            LiteavLog.w("TRTCCloudImpl", "custom msg data is null.");
            return false;
        }
        return this.f43200e.sendCustomCmdMsg(i10, bArr, z10, z11);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void sendCustomVideoData(int i10, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        if (tRTCVideoFrame == null) {
            LiteavLog.w("TRTCCloudImpl", "sendCustomVideoData frame is null");
            return;
        }
        if (tRTCVideoFrame.bufferType == 3) {
            GLES20.glFinish();
        }
        this.f43200e.sendCustomVideoData(i10, tRTCVideoFrame);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean sendSEIMsg(byte[] bArr, int i10) {
        if (bArr != null && i10 != 0) {
            return this.f43200e.sendSEIMsg(bArr, i10);
        }
        LiteavLog.w("TRTCCloudImpl", "sei msg data is null or repeatCount is zero.");
        return false;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void set3DSpatialReceivingRange(String str, int i10) {
        this.f43200e.set3DSpatialReceivingRange(str, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setAllAudioEffectsVolume(int i10) {
        this.f43202g.setAllAudioEffectsVolume(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioCaptureVolume(int i10) {
        this.f43200e.setAudioCaptureVolume(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setAudioEffectVolume(int i10, int i11) {
        this.f43202g.setAudioEffectVolume(i10, i11);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        this.f43200e.setAudioFrameListener(tRTCAudioFrameListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioPlayoutVolume(int i10) {
        this.f43200e.setAudioPlayoutVolume(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setAudioQuality(int i10) {
        this.f43200e.setAudioQuality(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioRoute(int i10) {
        this.f43203h.setAudioRoute(TXDeviceManagerImpl.audioRouteFromInt(i10));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBGMPlayoutVolume(int i10) {
        this.f43202g.setMusicPlayoutVolume(Integer.MAX_VALUE, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int setBGMPosition(int i10) {
        this.f43202g.seekMusicToPosInMS(Integer.MAX_VALUE, i10);
        return 0;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBGMPublishVolume(int i10) {
        this.f43202g.setMusicPublishVolume(Integer.MAX_VALUE, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBGMVolume(int i10) {
        this.f43202g.setMusicPlayoutVolume(Integer.MAX_VALUE, i10);
        this.f43202g.setMusicPublishVolume(Integer.MAX_VALUE, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setBeautyStyle(int i10, int i11, int i12, int i13) {
        this.f43204i.setBeautyStyle(i10);
        this.f43204i.setBeautyLevel(i11);
        this.f43204i.setWhitenessLevel(i12);
        this.f43204i.setRuddyLevel(i13);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setCapturedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        return this.f43200e.setCapturedAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setChinLevel(int i10) {
        this.f43204i.setChinLevel(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setDebugViewMargin(String str, TRTCCloud.TRTCViewMargin tRTCViewMargin) {
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setDefaultStreamRecvMode(boolean z10, boolean z11) {
        this.f43200e.setDefaultStreamRecvMode(z10, z11);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setEyeScaleLevel(int i10) {
        this.f43204i.setEyeScaleLevel(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFaceShortLevel(int i10) {
        this.f43204i.setFaceShortLevel(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFaceSlimLevel(int i10) {
        this.f43204i.setFaceSlimLevel(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFaceVLevel(int i10) {
        this.f43204i.setFaceVLevel(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFilter(Bitmap bitmap) {
        this.f43204i.setFilter(bitmap);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFilterConcentration(float f10) {
        this.f43204i.setFilterStrength(f10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setFocusPosition(int i10, int i11) {
        this.f43203h.setCameraFocusPosition(i10, i11);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setGSensorMode(int i10) {
        this.f43200e.setGSensorMode(0, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean setGreenScreenFile(String str) {
        return false;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setListener(TRTCCloudListener tRTCCloudListener) {
        Log.d("TRTCCloudImpl", "setListener ".concat(String.valueOf(tRTCCloudListener)), new Object[0]);
        this.f43199d = tRTCCloudListener;
        this.f43200e.setListener(tRTCCloudListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setListenerHandler(Handler handler) {
        this.f43200e.setListenerHandler(handler);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalProcessedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        return this.f43200e.setLocalProcessedAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setLocalRenderParams(TRTCCloudDef.TRTCRenderParams tRTCRenderParams) {
        setLocalViewFillMode(tRTCRenderParams.fillMode);
        setLocalViewRotation(tRTCRenderParams.rotation);
        setLocalViewMirror(tRTCRenderParams.mirrorType);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalVideoProcessListener(int i10, int i11, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener) {
        return this.f43200e.setLocalVideoProcessListener(0, i10, i11, tRTCVideoFrameListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalVideoRenderListener(int i10, int i11, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        return this.f43200e.setLocalVideoRenderListener(i10, i11, tRTCVideoRenderListener);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setLocalViewFillMode(int i10) {
        this.f43200e.setLocalViewFillMode(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setLocalViewMirror(int i10) {
        this.f43200e.setLocalViewMirror(i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setLocalViewRotation(int i10) {
        this.f43200e.setLocalViewRotation(b(i10));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setMicVolumeOnMixing(int i10) {
        this.f43202g.setVoiceCaptureVolume(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setMixExternalAudioVolume(int i10, int i11) {
        this.f43200e.setMixExternalAudioVolume(i10, i11);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        this.f43200e.setMixTranscodingConfig(tRTCTranscodingConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setMixedPlayAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        return this.f43200e.setMixedPlayAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setMotionMute(boolean z10) {
        this.f43204i.setMotionMute(z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.f43200e.setNetworkQosParam(tRTCNetworkQosParam);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setNoseSlimLevel(int i10) {
        this.f43204i.setNoseSlimLevel(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2) {
        this.f43200e.setPerspectiveCorrectionPoints(str, pointFArr, pointFArr2);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public int setPriorRemoteVideoStreamType(int i10) {
        return this.f43200e.setPriorRemoteVideoStreamType(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
        this.f43200e.setRemoteAudioParallelParams(tRTCAudioParallelParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteAudioVolume(String str, int i10) {
        this.f43200e.setRemoteAudioVolume(str, i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteRenderParams(String str, int i10, TRTCCloudDef.TRTCRenderParams tRTCRenderParams) {
        this.f43200e.setRemoteViewFillMode(str, i10, tRTCRenderParams.fillMode);
        this.f43200e.setRemoteViewRotation(str, i10, b(tRTCRenderParams.rotation));
        this.f43200e.setRemoteViewMirror(str, i10, tRTCRenderParams.mirrorType);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteSubStreamViewFillMode(String str, int i10) {
        this.f43200e.setRemoteViewFillMode(str, 2, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteSubStreamViewRotation(String str, int i10) {
        this.f43200e.setRemoteViewRotation(str, 2, b(i10));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setRemoteVideoRenderListener(String str, int i10, int i11, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        return this.f43200e.setRemoteVideoRenderListener(str, i10, i11, tRTCVideoRenderListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setRemoteVideoStreamType(String str, int i10) {
        return this.f43200e.setRemoteVideoStreamType(str, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteViewFillMode(String str, int i10) {
        this.f43200e.setRemoteViewFillMode(str, 0, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setRemoteViewRotation(String str, int i10) {
        this.f43200e.setRemoteViewRotation(str, 0, b(i10));
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setReverbType(int i10) {
        this.f43202g.setVoiceReverbType(TXAudioEffectManagerImpl.voiceReverbTypeFromInt(i10));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setSubStreamEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.f43200e.setVideoEncoderParams(2, tRTCVideoEncParam);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setSystemVolumeType(int i10) {
        this.f43203h.setSystemVolumeType(TXDeviceManagerImpl.systemVolumeTypefromInt(i10));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderMirror(boolean z10) {
        this.f43200e.setVideoEncoderMirror(z10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.f43200e.setVideoEncoderParams(0, tRTCVideoEncParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderRotation(int i10) {
        this.f43200e.setVideoEncoderRotation(b(i10));
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoMuteImage(Bitmap bitmap, int i10) {
        this.f43200e.setVideoMuteImage(bitmap, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public boolean setVoiceChangerType(int i10) {
        this.f43202g.setVoiceChangerType(TXAudioEffectManagerImpl.voiceChangerTypeFromInt(i10));
        return true;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setWatermark(Bitmap bitmap, int i10, float f10, float f11, float f12) {
        this.f43200e.setWatermark(bitmap, i10, f10, f11, f12);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void setZoom(int i10) {
        this.f43203h.setCameraZoomRatio(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void showDebugView(int i10) {
        this.f43200e.showDashboardManager(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void snapshotVideo(String str, int i10, int i11, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.f43200e.snapshotVideo(str, i10, i11, tRTCSnapshotListener);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        return this.f43200e.startAudioRecording(tRTCAudioRecordingParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalAudio(int i10) {
        this.f43200e.startLocalAudio(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalPreview(boolean z10, TXCloudVideoView tXCloudVideoView) {
        this.f43200e.startLocalPreview(z10, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
        this.f43200e.startLocalRecording(tRTCLocalRecordingParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        this.f43200e.startPublishCDNStream(tRTCPublishCDNParam);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.f43200e.startPublishMediaStream(tRTCPublishTarget, tRTCStreamEncoderParam, tRTCStreamMixingConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startPublishing(String str, int i10) {
        this.f43200e.startPublishing(str, i10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startRemoteSubStreamView(String str, TXCloudVideoView tXCloudVideoView) {
        startRemoteView(str, 2, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startRemoteView(String str, int i10, TXCloudVideoView tXCloudVideoView) {
        this.f43200e.startRemoteView(str, i10, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startScreenCapture(int i10, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.f43205j = i10;
        this.f43200e.startScreenCapture(i10, tRTCVideoEncParam, tRTCScreenShareParams);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
        this.f43200e.startSpeedTest(tRTCSpeedTestParams);
        return 0;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startSystemAudioLoopback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 29) {
            LiteavLog.e("TRTCCloudImpl", "current system don't support system audio loopback");
        } else {
            this.f43200e.startSystemAudioLoopback();
        }
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopAllAudioEffects() {
        this.f43202g.stopAllAudioEffects();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAllRemoteView() {
        this.f43200e.stopAllRemoteView();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopAudioEffect(int i10) {
        this.f43202g.stopAudioEffect(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAudioRecording() {
        this.f43200e.stopAudioRecording();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopBGM() {
        this.f43202g.stopPlayMusic(Integer.MAX_VALUE);
        this.f43202g.setMusicObserver(Integer.MAX_VALUE, null);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalAudio() {
        this.f43200e.stopLocalAudio();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalPreview() {
        this.f43200e.stopLocalPreview();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalRecording() {
        this.f43200e.stopLocalRecording();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopPublishCDNStream() {
        this.f43200e.stopPublishCDNStream();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopPublishMediaStream(String str) {
        this.f43200e.stopPublishMediaStream(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopPublishing() {
        this.f43200e.stopPublishing();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopRemoteSubStreamView(String str) {
        stopRemoteView(str, 2);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopRemoteView(String str, int i10) {
        this.f43200e.stopRemoteView(str, i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopScreenCapture() {
        this.f43200e.stopScreenCapture(this.f43205j);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopSpeedTest() {
        this.f43200e.stopSpeedTest();
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopSystemAudioLoopback() {
        this.f43200e.stopSystemAudioLoopback();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void switchCamera() {
        this.f43203h.switchCamera(!this.f43203h.isFrontCamera());
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRole(int i10) {
        this.f43200e.switchRole(i10);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
        this.f43200e.switchRoom(tRTCSwitchRoomConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateLocalView(TXCloudVideoView tXCloudVideoView) {
        this.f43200e.updateLocalView(tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateOtherRoomForwardMode(String str) {
        this.f43200e.updateOtherRoomForwardMode(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.f43200e.updatePublishMediaStream(str, tRTCPublishTarget, tRTCStreamEncoderParam, tRTCStreamMixingConfig);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateRemote3DSpatialPosition(String str, int[] iArr) {
        this.f43200e.updateRemote3DSpatialPosition(str, iArr);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateRemoteView(String str, int i10, TXCloudVideoView tXCloudVideoView) {
        this.f43200e.updateRemoteView(str, i10, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
        this.f43200e.updateSelf3DSpatialPosition(iArr, fArr, fArr2, fArr3);
    }

    public static TRTCCloud a(Context context) {
        TRTCCloudImpl tRTCCloudImpl;
        synchronized (TRTCCloudImpl.class) {
            if (f43197b == null) {
                f43197b = new TRTCCloudImpl(context, true);
            }
            tRTCCloudImpl = f43197b;
        }
        return tRTCCloudImpl;
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableAudioVolumeEvaluation(int i10, boolean z10) {
        TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams = new TRTCCloudDef.TRTCAudioVolumeEvaluateParams();
        tRTCAudioVolumeEvaluateParams.interval = i10;
        tRTCAudioVolumeEvaluateParams.enableVadDetection = z10;
        tRTCAudioVolumeEvaluateParams.enableSpectrumCalculation = false;
        enableAudioVolumeEvaluation(true, tRTCAudioVolumeEvaluateParams);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableCustomVideoCapture(boolean z10) {
        enableCustomVideoCapture(0, z10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void muteLocalVideo(boolean z10) {
        this.f43200e.muteLocalVideo(0, z10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void muteRemoteVideoStream(String str, boolean z10) {
        muteRemoteVideoStream(str, 0, z10);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void snapshotVideo(String str, int i10, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.f43200e.snapshotVideo(str, i10, SnapshotSourceType.VIEW.mValue, tRTCSnapshotListener);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startLocalAudio() {
        this.f43200e.startLocalAudio();
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        this.f43200e.startRemoteView(str, tXCloudVideoView);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startSpeedTest(int i10, String str, String str2) {
        this.f43200e.startSpeedTest(i10, str, str2);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void stopRemoteView(String str) {
        this.f43200e.stopRemoteView(str);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRole(int i10, String str) {
        this.f43200e.switchRole(i10, str);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.f43205j = 0;
        startScreenCapture(0, tRTCVideoEncParam, tRTCScreenShareParams);
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        sendCustomVideoData(0, tRTCVideoFrame);
    }

    private TRTCCloudImpl(Context context, long j10) {
        b(context);
        this.f43198c = context;
        a(context, j10, false);
    }

    public static void a() {
        synchronized (TRTCCloudImpl.class) {
            if (f43197b != null) {
                LiteavLog.i("TRTCCloudImpl", "destructor destroySharedInstance");
                Iterator<TRTCCloudImpl> iterator2 = f43197b.f43206k.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().f43200e.destroy();
                }
                f43197b.f43200e.destroy();
                f43197b = null;
            }
        }
    }

    @Override // com.tencent.trtc.DeprecatedTRTCCloud
    public void enableAudioVolumeEvaluation(int i10) {
        enableAudioVolumeEvaluation(i10, false);
    }

    public static void b(boolean z10) {
        TrtcCloudJni.setLogCompressEnabled(z10);
    }

    private String b() {
        return ((Object) this.f43198c.getCacheDir()) + File.separator + "liteav_effect";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf A[Catch: Exception -> 0x010e, TRY_LEAVE, TryCatch #1 {Exception -> 0x010e, blocks: (B:11:0x003f, B:13:0x004e, B:14:0x005e, B:17:0x006a, B:18:0x00a4, B:20:0x00aa, B:22:0x00b5, B:26:0x00bf, B:35:0x00d2, B:36:0x00d5, B:37:0x00d8, B:42:0x00f8, B:44:0x00fd, B:50:0x0102, B:55:0x0107, B:52:0x010d, B:67:0x008a, B:68:0x0052, B:70:0x0058, B:75:0x0028, B:10:0x0018), top: B:9:0x0018, inners: #5 }] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v24, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.trtc.TRTCCloudImpl.b(java.lang.String):java.lang.String");
    }

    private void a(Context context, long j10, boolean z10) {
        this.f43198c = context.getApplicationContext();
        if (j10 == 0) {
            this.f43200e = new TrtcCloudJni(z10);
        } else {
            this.f43200e = new TrtcCloudJni(j10, z10);
        }
        this.f43203h = new TXDeviceManagerImpl(this.f43200e.createDeviceManager());
        this.f43202g = new TXAudioEffectManagerImpl(this.f43200e.createAudioEffectManager());
        this.f43204i = new TXBeautyManagerImpl(this.f43200e.createBeautyManager());
    }

    public static void a(int i10) {
        TrtcCloudJni.setLogLevel(i10);
    }

    public static void a(boolean z10) {
        TrtcCloudJni.setConsoleEnabled(z10);
    }

    public static void a(String str) {
        TrtcCloudJni.setLogDirPath(str);
    }

    private static int b(int i10) {
        if (i10 < 0) {
            return 0;
        }
        return i10 > 3 ? (i10 / 90) % 4 : i10;
    }
}
