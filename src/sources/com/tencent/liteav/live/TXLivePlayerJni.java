package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TXLivePlayerJni implements com.tencent.rtmp.a, TXCloudVideoView.b {
    private static final String TAG = "TXLivePlayerJni";
    private TXLivePlayer.ITXAudioRawDataListener mAudioRawDataListener;
    private Integer mAudioRoute;
    private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeEvaluationListener;
    private TXLivePlayConfig mConfig;
    private DisplayTarget mDisplayTarget;
    private Boolean mEnableHardwareDecoder;
    private Boolean mIsAudioMuted;
    private ITXLivePlayListener mListener;
    private Integer mRenderMode;
    private Integer mRenderRotate;
    private Boolean mShowDebugView;
    private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
    private TXLivePlayer.ITXVideoRawDataListener mVideoRawDataListener;
    private TXRecordCommon.ITXVideoRecordListener mVideoRecordListener;
    private TXLivePlayer.ITXLivePlayVideoRenderListener mVideoRenderListener;
    private Integer mVolume;
    private Integer mVolumeIntervalMs;
    public long mNativeTXLivePlayerJni = 0;
    private Object mGLContext = null;
    private final Map<String, String> mExperimentalAPIMap = new HashMap();

    public TXLivePlayerJni(Context context) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
    }

    private static String genFilePath(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(Long.valueOf(valueOf + "000").longValue()));
            String diskFileDir = getDiskFileDir(context);
            if (TextUtils.isEmpty(diskFileDir)) {
                return null;
            }
            return new File(diskFileDir, String.format("TXUGC_%s".concat(String.valueOf(str)), format)).getAbsolutePath();
        } catch (Exception e2) {
            LiteavLog.e(TAG, "create file path failed.", e2);
            return null;
        }
    }

    private static String getDiskFileDir(Context context) {
        if (context == null) {
            return null;
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            return context.getFilesDir().getPath();
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        return externalFilesDir != null ? externalFilesDir.getPath() : null;
    }

    @CalledByNative
    public static String[] getMapKeys(Map<String, String> map) {
        String[] strArr = new String[map.size()];
        Iterator<String> iterator2 = map.h().iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            strArr[i10] = iterator2.next();
            i10++;
        }
        return strArr;
    }

    @CalledByNative
    public static String[] getMapValues(Map<String, String> map, String[] strArr) {
        String[] strArr2 = new String[map.size()];
        int length = strArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            strArr2[i11] = map.get(strArr[i10]);
            i10++;
            i11++;
        }
        return strArr2;
    }

    private boolean isNativeValid() {
        return this.mNativeTXLivePlayerJni != 0;
    }

    private static native void nativeCallExperimentalAPI(long j10, String str);

    private static native long nativeCreate(WeakReference<TXLivePlayerJni> weakReference);

    private static native void nativeDestroy(long j10);

    private static native void nativeEnableAudioVolumeEvaluation(long j10, int i10);

    private static native void nativeEnableCustomAudioProcess(long j10, boolean z10);

    private static native void nativeEnableCustomRenderI420(long j10, boolean z10);

    private static native void nativeEnableCustomRenderTexture(long j10, boolean z10, Object obj);

    private static native void nativeEnableHardwareDecode(long j10, boolean z10);

    private static native long nativeGetCurrentRenderPts(long j10);

    private static native boolean nativeIsPlaying(long j10);

    private static native void nativePause(long j10);

    private static native void nativeResume(long j10);

    private static native void nativeSetAudioRoute(long j10, int i10);

    private static native void nativeSetConfig(long j10, float f10, float f11, float f12, int i10, int i11, int i12, boolean z10, boolean z11, boolean z12, String str, Map map);

    private static native void nativeSetMute(long j10, boolean z10);

    private static native void nativeSetPlayerView(long j10, DisplayTarget displayTarget);

    private static native void nativeSetRenderMode(long j10, int i10);

    private static native void nativeSetRenderRotation(long j10, int i10);

    private static native void nativeSetVolume(long j10, int i10);

    private static native void nativeShowDebugView(long j10, boolean z10);

    private static native void nativeSnapshot(long j10);

    private static native int nativeStartPlay(long j10, String str, int i10);

    private static native void nativeStartRecord(long j10, int i10, String str);

    private static native void nativeStopPlay(long j10, boolean z10);

    private static native void nativeStopRecord(long j10);

    private static native int nativeSwitchStream(long j10, String str);

    @CalledByNative
    public static TXLivePlayerJni weakToStrongReference(WeakReference<TXLivePlayerJni> weakReference) {
        return weakReference.get();
    }

    public boolean addVideoRawData(byte[] bArr) {
        return false;
    }

    @Override // com.tencent.rtmp.a
    public void callExperimentalAPI(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("api") && !TextUtils.isEmpty(jSONObject.getString("api"))) {
                this.mExperimentalAPIMap.put(jSONObject.getString("api"), str);
                if (isNativeValid()) {
                    nativeCallExperimentalAPI(this.mNativeTXLivePlayerJni, str);
                    return;
                }
                return;
            }
            LiteavLog.e(TAG, "call experimental api failed. json: ".concat(String.valueOf(str)));
        } catch (Exception e2) {
            e2.printStackTrace();
            LiteavLog.e(TAG, "call experimental api failed. json:".concat(String.valueOf(str)));
        }
    }

    @Override // com.tencent.rtmp.a
    public void enableAudioVolumeEvaluation(int i10) {
        synchronized (this) {
            this.mVolumeIntervalMs = Integer.valueOf(i10);
            if (isNativeValid()) {
                nativeEnableAudioVolumeEvaluation(this.mNativeTXLivePlayerJni, i10);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public boolean enableHardwareDecode(boolean z10) {
        synchronized (this) {
            this.mEnableHardwareDecoder = Boolean.valueOf(z10);
            if (isNativeValid()) {
                nativeEnableHardwareDecode(this.mNativeTXLivePlayerJni, z10);
            }
        }
        return true;
    }

    @Override // com.tencent.rtmp.a
    public long getCurrentRenderPts() {
        synchronized (this) {
            if (!isNativeValid()) {
                return 0L;
            }
            return nativeGetCurrentRenderPts(this.mNativeTXLivePlayerJni);
        }
    }

    @Override // com.tencent.rtmp.a
    public boolean isPlaying() {
        synchronized (this) {
            if (!isNativeValid()) {
                return false;
            }
            return nativeIsPlaying(this.mNativeTXLivePlayerJni);
        }
    }

    @CalledByNative
    public void onAudioInfoChanged(int i10, int i11, int i12) {
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.mAudioRawDataListener;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onAudioInfoChanged(i10, i11, i12);
        }
    }

    @CalledByNative
    public void onAudioVolumeEvaluationNotify(int i10) {
        TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = this.mAudioVolumeEvaluationListener;
        if (iTXAudioVolumeEvaluationListener != null) {
            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i10);
        }
    }

    @CalledByNative
    public void onNetStatus(Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener = this.mListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onNetStatus(bundle);
        }
    }

    @CalledByNative
    public void onPcmDataAvailable(byte[] bArr, long j10) {
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.mAudioRawDataListener;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onPcmDataAvailable(bArr, j10);
        }
    }

    @CalledByNative
    public void onPlayEvent(int i10, Bundle bundle) {
        ITXLivePlayListener iTXLivePlayListener = this.mListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onPlayEvent(i10, bundle);
        }
    }

    @CalledByNative
    public void onRecordComplete(int i10, String str, String str2, String str3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
            if (i10 == 0) {
                tXRecordResult.retCode = 0;
            } else {
                tXRecordResult.retCode = -1;
            }
            tXRecordResult.descMsg = str;
            tXRecordResult.videoPath = str2;
            tXRecordResult.coverPath = str3;
            iTXVideoRecordListener.onRecordComplete(tXRecordResult);
        }
    }

    @CalledByNative
    public void onRecordEvent(int i10, Bundle bundle) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordEvent(i10, bundle);
        }
    }

    @CalledByNative
    public void onRecordProgress(long j10) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordProgress(j10);
        }
    }

    @CalledByNative
    public void onRenderVideoFrame(int i10, int i11, Object obj, int i12, int i13, int i14, int i15, long j10, byte[] bArr, ByteBuffer byteBuffer) {
        TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener = this.mVideoRenderListener;
        if (iTXLivePlayVideoRenderListener != null) {
            TXLivePlayer.TXLiteAVTexture tXLiteAVTexture = new TXLivePlayer.TXLiteAVTexture();
            tXLiteAVTexture.textureId = i12;
            tXLiteAVTexture.width = i13;
            tXLiteAVTexture.height = i14;
            tXLiteAVTexture.eglContext = obj;
            iTXLivePlayVideoRenderListener.onRenderVideoFrame(tXLiteAVTexture);
        }
        TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener = this.mVideoRawDataListener;
        if (iTXVideoRawDataListener != null) {
            iTXVideoRawDataListener.onVideoRawDataAvailable(bArr, i13, i14, (int) j10);
        }
    }

    @Override // com.tencent.rtmp.ui.TXCloudVideoView.b
    public void onShowLog(boolean z10) {
        showDebugView(z10);
    }

    @CalledByNative
    public void onSnapshot(Bitmap bitmap) {
        TXLivePlayer.ITXSnapshotListener iTXSnapshotListener = this.mSnapshotListener;
        if (iTXSnapshotListener != null) {
            iTXSnapshotListener.onSnapshot(bitmap);
        }
    }

    @Override // com.tencent.rtmp.a
    public void pause() {
        synchronized (this) {
            if (isNativeValid()) {
                nativePause(this.mNativeTXLivePlayerJni);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void resume() {
        synchronized (this) {
            if (isNativeValid()) {
                nativeResume(this.mNativeTXLivePlayerJni);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setAudioRawDataListener(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
        synchronized (this) {
            this.mAudioRawDataListener = iTXAudioRawDataListener;
            if (isNativeValid()) {
                nativeEnableCustomAudioProcess(this.mNativeTXLivePlayerJni, iTXAudioRawDataListener != null);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setAudioRoute(int i10) {
        synchronized (this) {
            this.mAudioRoute = Integer.valueOf(i10);
            if (isNativeValid()) {
                nativeSetAudioRoute(this.mNativeTXLivePlayerJni, i10);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setAudioVolumeEvaluationListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mAudioVolumeEvaluationListener = iTXAudioVolumeEvaluationListener;
    }

    @Override // com.tencent.rtmp.a
    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        synchronized (this) {
            if (tXLivePlayConfig == null) {
                return;
            }
            this.mConfig = tXLivePlayConfig;
            if (isNativeValid()) {
                nativeSetConfig(this.mNativeTXLivePlayerJni, this.mConfig.getCacheTime(), this.mConfig.getMaxAutoAdjustCacheTime(), this.mConfig.getMinAutoAdjustCacheTime(), this.mConfig.getVideoBlockThreshold(), this.mConfig.getConnectRetryCount(), this.mConfig.getConnectRetryInterval(), this.mConfig.isAutoAdjustCacheTime(), this.mConfig.isEnableMessage(), this.mConfig.isEnableMetaData(), this.mConfig.getFlvSessionKey(), this.mConfig.getHeaders());
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setMute(boolean z10) {
        synchronized (this) {
            this.mIsAudioMuted = Boolean.valueOf(z10);
            if (isNativeValid()) {
                nativeSetMute(this.mNativeTXLivePlayerJni, z10);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mListener = iTXLivePlayListener;
    }

    @Override // com.tencent.rtmp.a
    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView != null) {
            a.a(tXCloudVideoView, new WeakReference(this));
            showDebugView(a.a(tXCloudVideoView));
        }
        synchronized (this) {
            if (tXCloudVideoView != null) {
                this.mDisplayTarget = new DisplayTarget(tXCloudVideoView);
            } else {
                this.mDisplayTarget = null;
            }
            if (isNativeValid()) {
                nativeSetPlayerView(this.mNativeTXLivePlayerJni, this.mDisplayTarget);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setRenderMode(int i10) {
        synchronized (this) {
            this.mRenderMode = Integer.valueOf(i10);
            if (isNativeValid()) {
                nativeSetRenderMode(this.mNativeTXLivePlayerJni, i10);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setRenderRotation(int i10) {
        synchronized (this) {
            this.mRenderRotate = Integer.valueOf(i10);
            if (isNativeValid()) {
                nativeSetRenderRotation(this.mNativeTXLivePlayerJni, i10);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setSurface(Surface surface) {
        synchronized (this) {
            if (surface != null) {
                this.mDisplayTarget = new DisplayTarget(surface);
            } else {
                this.mDisplayTarget = null;
            }
            if (isNativeValid()) {
                nativeSetPlayerView(this.mNativeTXLivePlayerJni, this.mDisplayTarget);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setSurfaceSize(int i10, int i11) {
    }

    @Override // com.tencent.rtmp.a
    public void setVideoRawDataListener(TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener) {
        synchronized (this) {
            if (this.mVideoRenderListener != null) {
                this.mVideoRenderListener = null;
                this.mGLContext = null;
                if (isNativeValid()) {
                    nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, false, null);
                }
            }
            this.mVideoRawDataListener = iTXVideoRawDataListener;
            if (isNativeValid()) {
                nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, iTXVideoRawDataListener != null);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mVideoRecordListener = iTXVideoRecordListener;
    }

    @Override // com.tencent.rtmp.a
    public int setVideoRenderListener(TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        synchronized (this) {
            if (this.mVideoRawDataListener != null) {
                this.mVideoRawDataListener = null;
                if (isNativeValid()) {
                    nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, false);
                }
            }
            this.mVideoRenderListener = iTXLivePlayVideoRenderListener;
            if (iTXLivePlayVideoRenderListener == null) {
                obj = null;
            }
            this.mGLContext = obj;
            if (isNativeValid()) {
                nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, iTXLivePlayVideoRenderListener != null, this.mGLContext);
            }
        }
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public void setVolume(int i10) {
        synchronized (this) {
            this.mVolume = Integer.valueOf(i10);
            if (isNativeValid()) {
                nativeSetVolume(this.mNativeTXLivePlayerJni, i10);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void showDebugView(boolean z10) {
        synchronized (this) {
            this.mShowDebugView = Boolean.valueOf(z10);
            if (isNativeValid()) {
                nativeShowDebugView(this.mNativeTXLivePlayerJni, z10);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        synchronized (this) {
            this.mSnapshotListener = iTXSnapshotListener;
            if (isNativeValid()) {
                nativeSnapshot(this.mNativeTXLivePlayerJni);
            }
        }
    }

    @Override // com.tencent.rtmp.a
    public int startLivePlay(String str, int i10) {
        int nativeStartPlay;
        synchronized (this) {
            if (!isNativeValid()) {
                long nativeCreate = nativeCreate(new WeakReference(this));
                this.mNativeTXLivePlayerJni = nativeCreate;
                nativeSetPlayerView(nativeCreate, this.mDisplayTarget);
                TXLivePlayConfig tXLivePlayConfig = this.mConfig;
                if (tXLivePlayConfig != null) {
                    nativeSetConfig(this.mNativeTXLivePlayerJni, tXLivePlayConfig.getCacheTime(), this.mConfig.getMaxAutoAdjustCacheTime(), this.mConfig.getMinAutoAdjustCacheTime(), this.mConfig.getVideoBlockThreshold(), this.mConfig.getConnectRetryCount(), this.mConfig.getConnectRetryInterval(), this.mConfig.isAutoAdjustCacheTime(), this.mConfig.isEnableMessage(), this.mConfig.isEnableMetaData(), this.mConfig.getFlvSessionKey(), this.mConfig.getHeaders());
                }
                boolean z10 = true;
                if (this.mVideoRenderListener != null) {
                    nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, false);
                    nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, true, this.mGLContext);
                } else if (this.mVideoRawDataListener != null) {
                    nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, false, this.mGLContext);
                    nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, true);
                } else {
                    nativeEnableCustomRenderTexture(this.mNativeTXLivePlayerJni, false, this.mGLContext);
                    nativeEnableCustomRenderI420(this.mNativeTXLivePlayerJni, false);
                }
                long j10 = this.mNativeTXLivePlayerJni;
                if (this.mAudioRawDataListener == null) {
                    z10 = false;
                }
                nativeEnableCustomAudioProcess(j10, z10);
                Integer num = this.mRenderMode;
                if (num != null) {
                    nativeSetRenderMode(this.mNativeTXLivePlayerJni, num.intValue());
                }
                Integer num2 = this.mRenderRotate;
                if (num2 != null) {
                    nativeSetRenderRotation(this.mNativeTXLivePlayerJni, num2.intValue());
                }
                Boolean bool = this.mEnableHardwareDecoder;
                if (bool != null) {
                    nativeEnableHardwareDecode(this.mNativeTXLivePlayerJni, bool.booleanValue());
                }
                Integer num3 = this.mVolume;
                if (num3 != null) {
                    nativeSetVolume(this.mNativeTXLivePlayerJni, num3.intValue());
                }
                Integer num4 = this.mAudioRoute;
                if (num4 != null) {
                    nativeSetAudioRoute(this.mNativeTXLivePlayerJni, num4.intValue());
                }
                Integer num5 = this.mVolumeIntervalMs;
                if (num5 != null) {
                    nativeEnableAudioVolumeEvaluation(this.mNativeTXLivePlayerJni, num5.intValue());
                }
                Boolean bool2 = this.mIsAudioMuted;
                if (bool2 != null) {
                    nativeSetMute(this.mNativeTXLivePlayerJni, bool2.booleanValue());
                }
                Boolean bool3 = this.mShowDebugView;
                if (bool3 != null) {
                    nativeShowDebugView(this.mNativeTXLivePlayerJni, bool3.booleanValue());
                }
                Iterator<Map.Entry<String, String>> iterator2 = this.mExperimentalAPIMap.entrySet().iterator2();
                while (iterator2.hasNext()) {
                    nativeCallExperimentalAPI(this.mNativeTXLivePlayerJni, iterator2.next().getValue());
                }
            }
            nativeStartPlay = nativeStartPlay(this.mNativeTXLivePlayerJni, str, i10);
        }
        return nativeStartPlay;
    }

    @Override // com.tencent.rtmp.a
    public int startRecord(int i10) {
        synchronized (this) {
            if (isNativeValid()) {
                String genFilePath = genFilePath(ContextUtils.getApplicationContext(), ".mp4");
                if (TextUtils.isEmpty(genFilePath)) {
                    return -1;
                }
                nativeStartRecord(this.mNativeTXLivePlayerJni, i10, genFilePath);
            }
            return 0;
        }
    }

    @Override // com.tencent.rtmp.a
    public int stopPlay(boolean z10) {
        synchronized (this) {
            if (isNativeValid()) {
                nativeStopPlay(this.mNativeTXLivePlayerJni, z10);
                nativeDestroy(this.mNativeTXLivePlayerJni);
                this.mNativeTXLivePlayerJni = 0L;
            }
        }
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int stopRecord() {
        synchronized (this) {
            if (isNativeValid()) {
                nativeStopRecord(this.mNativeTXLivePlayerJni);
            }
        }
        return 0;
    }

    @Override // com.tencent.rtmp.a
    public int switchStream(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LiteavLog.e(TAG, "Invalid params.");
                return -1;
            }
            if (!isNativeValid()) {
                return -1;
            }
            return nativeSwitchStream(this.mNativeTXLivePlayerJni, str);
        }
    }
}
