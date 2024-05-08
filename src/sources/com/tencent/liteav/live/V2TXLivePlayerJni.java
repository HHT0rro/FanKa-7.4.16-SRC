package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.microedition.khronos.egl.EGLContext;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class V2TXLivePlayerJni extends V2TXLivePlayer {
    private static final String TAG = "V2TXLivePlayerJni";
    private GLConstants.PixelBufferType mBufferType;
    private DisplayTarget mDisplayTarget;
    private Boolean mEnableCustomRendering;
    private Boolean mEnableExtensionCallback;
    private Boolean mEnableObserveAudioFrame;
    private Boolean mIsPauseAudio;
    private Boolean mIsPauseVideo;
    private Float mMax;
    private Float mMin;
    private V2TXLivePlayerObserver mObserver;
    private GLConstants.PixelFormatType mPixelFormatType;
    private V2TXLivePlayerImpl mProxy;
    private Rotation mRotation;
    private GLConstants.GLScaleType mScaleType;
    private Boolean mShowDebugView;
    private Integer mVolume;
    private Integer mVolumeIntervalMs;
    public long mNativeV2TXLivePlayerJni = 0;
    private boolean mClearLastImage = true;
    private Object mGLContext = null;
    private Set<Integer> mSEIPayloadSet = new HashSet();
    private HashMap<String, Object> mPropertyMap = new HashMap<>();

    /* renamed from: com.tencent.liteav.live.V2TXLivePlayerJni$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43116a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f43117b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f43118c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f43119d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f43120e;

        static {
            int[] iArr = new int[Rotation.values().length];
            f43120e = iArr;
            try {
                iArr[Rotation.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43120e[Rotation.ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43120e[Rotation.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43120e[Rotation.ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[GLConstants.PixelBufferType.values().length];
            f43119d = iArr2;
            try {
                iArr2[GLConstants.PixelBufferType.BYTE_BUFFER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43119d[GLConstants.PixelBufferType.BYTE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f43119d[GLConstants.PixelBufferType.TEXTURE_2D.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[GLConstants.PixelFormatType.values().length];
            f43118c = iArr3;
            try {
                iArr3[GLConstants.PixelFormatType.I420.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f43118c[GLConstants.PixelFormatType.RGBA.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[V2TXLiveDef.V2TXLiveFillMode.values().length];
            f43117b = iArr4;
            try {
                iArr4[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f43117b[V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeScaleFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr5 = new int[V2TXLiveDef.V2TXLiveRotation.values().length];
            f43116a = iArr5;
            try {
                iArr5[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f43116a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation180.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f43116a[V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public V2TXLivePlayerJni(Context context, V2TXLivePlayerImpl v2TXLivePlayerImpl) {
        this.mProxy = v2TXLivePlayerImpl;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
    }

    private void enableExtensionCallback(boolean z10) {
        synchronized (this) {
            this.mEnableExtensionCallback = Boolean.valueOf(z10);
            if (isNativeValid()) {
                nativeEnableExtensionCallback(this.mNativeV2TXLivePlayerJni, z10);
            }
        }
    }

    @CalledByNative
    public static V2TXLiveDef.V2TXLivePlayerStatistics getJavaV2TXLivePlayerStatistics(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24) {
        V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics = new V2TXLiveDef.V2TXLivePlayerStatistics();
        v2TXLivePlayerStatistics.appCpu = i10;
        v2TXLivePlayerStatistics.systemCpu = i11;
        v2TXLivePlayerStatistics.rtt = i12;
        v2TXLivePlayerStatistics.width = i13;
        v2TXLivePlayerStatistics.height = i14;
        v2TXLivePlayerStatistics.fps = i15;
        v2TXLivePlayerStatistics.videoBitrate = i16;
        v2TXLivePlayerStatistics.audioBitrate = i17;
        v2TXLivePlayerStatistics.audioPacketLoss = i18;
        v2TXLivePlayerStatistics.videoPacketLoss = i19;
        v2TXLivePlayerStatistics.jitterBufferDelay = i20;
        v2TXLivePlayerStatistics.audioTotalBlockTime = i21;
        v2TXLivePlayerStatistics.audioBlockRate = i22;
        v2TXLivePlayerStatistics.videoTotalBlockTime = i23;
        v2TXLivePlayerStatistics.videoBlockRate = i24;
        return v2TXLivePlayerStatistics;
    }

    private static ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamListFormJsonString(String str) {
        ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> arrayList = new ArrayList<>();
        if (str != null && !str.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    arrayList.add(new V2TXLiveDef.V2TXLiveStreamInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), jSONObject.getString("url")));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    private boolean isNativeValid() {
        return this.mNativeV2TXLivePlayerJni != 0;
    }

    private static native long nativeCreate(WeakReference<V2TXLivePlayerJni> weakReference);

    private static native void nativeDestroy(long j10);

    private static native int nativeEnableCustomRendering(long j10, boolean z10, int i10, int i11);

    private static native void nativeEnableExtensionCallback(long j10, boolean z10);

    private static native int nativeEnableObserveAudioFrame(long j10, boolean z10);

    private static native int nativeEnableReceiveSeiMessage(long j10, boolean z10, int i10);

    private static native int nativeEnableVolumeEvaluation(long j10, int i10);

    private static native String nativeGetStreamList(long j10);

    private static native int nativeIsPlaying(long j10);

    private static native int nativePauseAudio(long j10);

    private static native int nativePauseVideo(long j10);

    private static native int nativeResumeAudio(long j10);

    private static native int nativeResumeVideo(long j10);

    private static native int nativeSetCacheParams(long j10, float f10, float f11);

    private static native int nativeSetPlayoutVolume(long j10, int i10);

    private static native int nativeSetProperty(long j10, String str, Object obj);

    private static native int nativeSetRenderFillMode(long j10, int i10);

    private static native int nativeSetRenderRotation(long j10, int i10);

    private static native int nativeSetRenderView(long j10, DisplayTarget displayTarget);

    private static native void nativeSetSharedEGLContext(long j10, Object obj);

    private static native void nativeShowDebugView(long j10, boolean z10);

    private static native int nativeSnapshot(long j10);

    private static native int nativeStartPlay(long j10, String str);

    private static native int nativeStopPlay(long j10, boolean z10);

    private static native int nativeSwitchStream(long j10, String str);

    @CalledByNative
    public static V2TXLivePlayerJni weakToStrongReference(WeakReference<V2TXLivePlayerJni> weakReference) {
        return weakReference.get();
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveAudioFrame(boolean z10) {
        synchronized (this) {
            this.mEnableObserveAudioFrame = Boolean.valueOf(z10);
            if (!isNativeValid()) {
                return 0;
            }
            return nativeEnableObserveAudioFrame(this.mNativeV2TXLivePlayerJni, z10);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableObserveVideoFrame(boolean z10, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        synchronized (this) {
            V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat2 = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
            if (v2TXLivePixelFormat == v2TXLivePixelFormat2 && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray) {
                this.mPixelFormatType = GLConstants.PixelFormatType.I420;
                this.mBufferType = GLConstants.PixelBufferType.BYTE_ARRAY;
            } else if (v2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture) {
                this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
                this.mBufferType = GLConstants.PixelBufferType.TEXTURE_2D;
            } else if (v2TXLivePixelFormat == v2TXLivePixelFormat2 && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer) {
                this.mPixelFormatType = GLConstants.PixelFormatType.I420;
                this.mBufferType = GLConstants.PixelBufferType.BYTE_BUFFER;
            } else {
                LiteavLog.e(TAG, "Enable custom render failed, invalid params. format:" + ((Object) v2TXLivePixelFormat) + " type:" + ((Object) v2TXLiveBufferType));
                return -4;
            }
            this.mEnableCustomRendering = Boolean.valueOf(z10);
            if (!isNativeValid()) {
                return 0;
            }
            return nativeEnableCustomRendering(this.mNativeV2TXLivePlayerJni, z10, this.mPixelFormatType.getValue(), this.mBufferType.ordinal());
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableReceiveSeiMessage(boolean z10, int i10) {
        synchronized (this) {
            if (z10) {
                this.mSEIPayloadSet.add(Integer.valueOf(i10));
            } else {
                this.mSEIPayloadSet.remove(Integer.valueOf(i10));
            }
            if (!isNativeValid()) {
                return 0;
            }
            return nativeEnableReceiveSeiMessage(this.mNativeV2TXLivePlayerJni, z10, i10);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int enableVolumeEvaluation(int i10) {
        synchronized (this) {
            this.mVolumeIntervalMs = Integer.valueOf(i10);
            if (!isNativeValid()) {
                return 0;
            }
            return nativeEnableVolumeEvaluation(this.mNativeV2TXLivePlayerJni, i10);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamList() {
        synchronized (this) {
            if (isNativeValid()) {
                return getStreamListFormJsonString(nativeGetStreamList(this.mNativeV2TXLivePlayerJni));
            }
            return new ArrayList<>();
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int isPlaying() {
        synchronized (this) {
            if (!isNativeValid()) {
                return 0;
            }
            return nativeIsPlaying(this.mNativeV2TXLivePlayerJni);
        }
    }

    @CalledByNative
    public void onAudioLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioLoading(this.mProxy, bundle);
        }
    }

    @CalledByNative
    public void onAudioPlaying(boolean z10, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioPlaying(this.mProxy, z10, bundle);
        }
    }

    @CalledByNative
    public void onConnected(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onConnected(this.mProxy, bundle);
        }
    }

    @CalledByNative
    public void onError(int i10, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onError(this.mProxy, i10, str, bundle);
        }
    }

    @CalledByNative
    public void onNetworkQuality(int i10) {
    }

    @CalledByNative
    public void onPlayEvent(int i10, Bundle bundle) {
    }

    @CalledByNative
    public void onPlayNetStatus(Bundle bundle) {
    }

    @CalledByNative
    public void onPlayoutAudioFrame(byte[] bArr, int i10, int i11) {
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i10;
        v2TXLiveAudioFrame.channel = i11;
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onPlayoutAudioFrame(this.mProxy, v2TXLiveAudioFrame);
        }
    }

    @CalledByNative
    public void onPlayoutVolumeUpdate(int i10) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onPlayoutVolumeUpdate(this.mProxy, i10);
        }
    }

    @CalledByNative
    public void onReceiveSeiMessage(int i10, byte[] bArr) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onReceiveSeiMessage(this.mProxy, i10, bArr);
        }
    }

    @CalledByNative
    public void onRenderVideoFrame(int i10, int i11, Object obj, int i12, int i13, int i14, int i15, long j10, byte[] bArr, ByteBuffer byteBuffer) {
        V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
        GLConstants.PixelFormatType a10 = GLConstants.PixelFormatType.a(i10);
        int i16 = AnonymousClass1.f43118c[a10.ordinal()];
        if (i16 == 1) {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        } else if (i16 != 2) {
            LiteavLog.e(TAG, "Invalid pixelFormat. pixelFormat:" + ((Object) a10) + ".");
        } else {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
        }
        GLConstants.PixelBufferType a11 = GLConstants.PixelBufferType.a(i11);
        int i17 = AnonymousClass1.f43119d[a11.ordinal()];
        if (i17 == 1) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
        } else if (i17 == 2) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
        } else if (i17 != 3) {
            LiteavLog.e(TAG, "Invalid bufferType. bufferType:" + ((Object) a11) + ".");
        } else {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
        }
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = new V2TXLiveDef.V2TXLiveTexture();
        v2TXLiveTexture.textureId = i12;
        if (obj instanceof EGLContext) {
            v2TXLiveTexture.eglContext10 = (EGLContext) obj;
        } else if (obj instanceof android.opengl.EGLContext) {
            v2TXLiveTexture.eglContext14 = (android.opengl.EGLContext) obj;
        }
        v2TXLiveVideoFrame.texture = v2TXLiveTexture;
        v2TXLiveVideoFrame.data = bArr;
        v2TXLiveVideoFrame.buffer = byteBuffer;
        v2TXLiveVideoFrame.width = i13;
        v2TXLiveVideoFrame.height = i14;
        int i18 = AnonymousClass1.f43120e[Rotation.a(i15).ordinal()];
        if (i18 == 1) {
            v2TXLiveVideoFrame.rotation = 0;
        } else if (i18 == 2) {
            v2TXLiveVideoFrame.rotation = 90;
        } else if (i18 == 3) {
            v2TXLiveVideoFrame.rotation = 180;
        } else if (i18 != 4) {
            v2TXLiveVideoFrame.rotation = 0;
        } else {
            v2TXLiveVideoFrame.rotation = 270;
        }
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onRenderVideoFrame(this.mProxy, v2TXLiveVideoFrame);
        }
    }

    @CalledByNative
    public void onSnapshotComplete(Bitmap bitmap) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onSnapshotComplete(this.mProxy, bitmap);
        }
    }

    @CalledByNative
    public void onStatisticsUpdate(V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onStatisticsUpdate(this.mProxy, v2TXLivePlayerStatistics);
        }
    }

    @CalledByNative
    public void onStreamSwitched(int i10, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onStreamSwitched(this.mProxy, str, i10);
        }
    }

    @CalledByNative
    public void onVideoLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoLoading(this.mProxy, bundle);
        }
    }

    @CalledByNative
    public void onVideoPlaying(boolean z10, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoPlaying(this.mProxy, z10, bundle);
        }
    }

    @CalledByNative
    public void onVideoResolutionChanged(int i10, int i11) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoResolutionChanged(this.mProxy, i10, i11);
        }
    }

    @CalledByNative
    public void onWarning(int i10, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onWarning(this.mProxy, i10, str, bundle);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseAudio() {
        synchronized (this) {
            this.mIsPauseAudio = Boolean.TRUE;
            if (!isNativeValid()) {
                return 0;
            }
            return nativePauseAudio(this.mNativeV2TXLivePlayerJni);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int pauseVideo() {
        synchronized (this) {
            this.mIsPauseVideo = Boolean.TRUE;
            if (!isNativeValid()) {
                return 0;
            }
            return nativePauseVideo(this.mNativeV2TXLivePlayerJni);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeAudio() {
        synchronized (this) {
            this.mIsPauseAudio = Boolean.FALSE;
            if (!isNativeValid()) {
                return 0;
            }
            return nativeResumeAudio(this.mNativeV2TXLivePlayerJni);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int resumeVideo() {
        synchronized (this) {
            this.mIsPauseVideo = Boolean.FALSE;
            if (!isNativeValid()) {
                return 0;
            }
            return nativeResumeVideo(this.mNativeV2TXLivePlayerJni);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setCacheParams(float f10, float f11) {
        synchronized (this) {
            if (f10 < 0.0f || f11 < 0.0f) {
                return -2;
            }
            this.mMin = Float.valueOf(f10);
            this.mMax = Float.valueOf(f11);
            if (!isNativeValid()) {
                return 0;
            }
            return nativeSetCacheParams(this.mNativeV2TXLivePlayerJni, f10, f11);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void setObserver(V2TXLivePlayerObserver v2TXLivePlayerObserver) {
        this.mObserver = v2TXLivePlayerObserver;
        if (v2TXLivePlayerObserver == null || !(v2TXLivePlayerObserver instanceof com.tencent.live2.impl.a.a)) {
            return;
        }
        enableExtensionCallback(true);
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setPlayoutVolume(int i10) {
        synchronized (this) {
            this.mVolume = Integer.valueOf(i10);
            if (!isNativeValid()) {
                return 0;
            }
            return nativeSetPlayoutVolume(this.mNativeV2TXLivePlayerJni, i10);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x00ae. Please report as an issue. */
    @Override // com.tencent.live2.V2TXLivePlayer
    public int setProperty(String str, Object obj) {
        synchronized (this) {
            char c4 = 65535;
            switch (str.hashCode()) {
                case -2131574212:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioCodecType)) {
                        c4 = '\n';
                        break;
                    }
                    break;
                case -1973995807:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetLebCacheParams)) {
                        c4 = '\t';
                        break;
                    }
                    break;
                case -1551400628:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetLEBEnvironment)) {
                        c4 = 5;
                        break;
                    }
                    break;
                case -1459700216:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetPreferLocalIPStack)) {
                        c4 = '\b';
                        break;
                    }
                    break;
                case -780243797:
                    if (str.equals(V2TXLiveProperty.kV2EnableHardwareAcceleration)) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -525993788:
                    if (str.equals(V2TXLiveProperty.kV2SetHeaders)) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 480042124:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize)) {
                        c4 = CharUtils.CR;
                        break;
                    }
                    break;
                case 582452376:
                    if (str.equals(V2TXLiveProperty.kV2ClearLastImage)) {
                        c4 = 11;
                        break;
                    }
                    break;
                case 1120433643:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface)) {
                        c4 = '\f';
                        break;
                    }
                    break;
                case 1615550654:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetOpenGLContext)) {
                        c4 = 14;
                        break;
                    }
                    break;
                case 1637676021:
                    if (str.equals(V2TXLiveProperty.kV2MaxNumberOfReconnection)) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1694085113:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2EnableRTMPAcc)) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 1899639930:
                    if (str.equals(V2TXLiveProperty.kV2SecondsBetweenReconnection)) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 2013602325:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute)) {
                        c4 = 7;
                        break;
                    }
                    break;
                case 2085561276:
                    if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetFramework)) {
                        c4 = 4;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                    synchronized (this) {
                        this.mPropertyMap.put(str, obj);
                        if (isNativeValid()) {
                            nativeSetProperty(this.mNativeV2TXLivePlayerJni, str, obj);
                        }
                        return 0;
                    }
                case 11:
                    if (!(obj instanceof Boolean)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    synchronized (this) {
                        this.mClearLastImage = ((Boolean) obj).booleanValue();
                        return 0;
                    }
                case '\f':
                    if (obj == null) {
                        synchronized (this) {
                            this.mDisplayTarget = null;
                            if (isNativeValid()) {
                                nativeSetRenderView(this.mNativeV2TXLivePlayerJni, null);
                            }
                        }
                        return 0;
                    }
                    if (!(obj instanceof Surface)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    synchronized (this) {
                        this.mDisplayTarget = new DisplayTarget((Surface) obj);
                        if (isNativeValid()) {
                            nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
                        }
                        return 0;
                    }
                case '\r':
                    LiteavLog.i(TAG, "set surface size is unnecessary");
                    return 0;
                case 14:
                    if (!(obj instanceof EGLContext) && !(obj instanceof android.opengl.EGLContext)) {
                        LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                        return -2;
                    }
                    synchronized (this) {
                        this.mGLContext = obj;
                        if (isNativeValid()) {
                            nativeSetSharedEGLContext(this.mNativeV2TXLivePlayerJni, this.mGLContext);
                        }
                        return 0;
                    }
                default:
                    LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                    return -4;
            }
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        synchronized (this) {
            int i10 = AnonymousClass1.f43117b[v2TXLiveFillMode.ordinal()];
            if (i10 == 1) {
                this.mScaleType = GLConstants.GLScaleType.CENTER_CROP;
            } else if (i10 != 2) {
                this.mScaleType = GLConstants.GLScaleType.FIT_CENTER;
            } else {
                this.mScaleType = GLConstants.GLScaleType.FILL;
            }
            if (!isNativeValid()) {
                return 0;
            }
            return nativeSetRenderFillMode(this.mNativeV2TXLivePlayerJni, this.mScaleType.mValue);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        synchronized (this) {
            int i10 = AnonymousClass1.f43116a[v2TXLiveRotation.ordinal()];
            if (i10 == 1) {
                this.mRotation = Rotation.ROTATION_90;
            } else if (i10 == 2) {
                this.mRotation = Rotation.ROTATION_180;
            } else if (i10 != 3) {
                this.mRotation = Rotation.NORMAL;
            } else {
                this.mRotation = Rotation.ROTATION_270;
            }
            if (!isNativeValid()) {
                return 0;
            }
            return nativeSetRenderRotation(this.mNativeV2TXLivePlayerJni, this.mRotation.mValue);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        synchronized (this) {
            if (tXCloudVideoView != null) {
                this.mDisplayTarget = new DisplayTarget(tXCloudVideoView);
            } else {
                this.mDisplayTarget = null;
            }
            if (!isNativeValid()) {
                return 0;
            }
            return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public void showDebugView(boolean z10) {
        synchronized (this) {
            this.mShowDebugView = Boolean.valueOf(z10);
            if (isNativeValid()) {
                nativeShowDebugView(this.mNativeV2TXLivePlayerJni, z10);
            }
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int snapshot() {
        synchronized (this) {
            if (!isNativeValid()) {
                return -3;
            }
            return nativeSnapshot(this.mNativeV2TXLivePlayerJni);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int startLivePlay(String str) {
        int nativeStartPlay;
        synchronized (this) {
            if (!isNativeValid()) {
                long nativeCreate = nativeCreate(new WeakReference(this));
                this.mNativeV2TXLivePlayerJni = nativeCreate;
                Boolean bool = this.mShowDebugView;
                if (bool != null) {
                    nativeShowDebugView(nativeCreate, bool.booleanValue());
                }
                Boolean bool2 = this.mEnableExtensionCallback;
                if (bool2 != null) {
                    nativeEnableExtensionCallback(this.mNativeV2TXLivePlayerJni, bool2.booleanValue());
                }
                nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
                Rotation rotation = this.mRotation;
                if (rotation != null) {
                    nativeSetRenderRotation(this.mNativeV2TXLivePlayerJni, rotation.mValue);
                }
                GLConstants.GLScaleType gLScaleType = this.mScaleType;
                if (gLScaleType != null) {
                    nativeSetRenderFillMode(this.mNativeV2TXLivePlayerJni, gLScaleType.mValue);
                }
                Boolean bool3 = this.mIsPauseAudio;
                if (bool3 != null) {
                    if (bool3.booleanValue()) {
                        nativePauseAudio(this.mNativeV2TXLivePlayerJni);
                    } else {
                        nativeResumeAudio(this.mNativeV2TXLivePlayerJni);
                    }
                }
                Boolean bool4 = this.mIsPauseVideo;
                if (bool4 != null) {
                    if (bool4.booleanValue()) {
                        nativePauseVideo(this.mNativeV2TXLivePlayerJni);
                    } else {
                        nativeResumeVideo(this.mNativeV2TXLivePlayerJni);
                    }
                }
                Integer num = this.mVolume;
                if (num != null) {
                    nativeSetPlayoutVolume(this.mNativeV2TXLivePlayerJni, num.intValue());
                }
                Float f10 = this.mMin;
                if (f10 != null && this.mMax != null) {
                    nativeSetCacheParams(this.mNativeV2TXLivePlayerJni, f10.floatValue(), this.mMax.floatValue());
                }
                Integer num2 = this.mVolumeIntervalMs;
                if (num2 != null) {
                    nativeEnableVolumeEvaluation(this.mNativeV2TXLivePlayerJni, num2.intValue());
                }
                Boolean bool5 = this.mEnableCustomRendering;
                if (bool5 != null && this.mPixelFormatType != null && this.mBufferType != null) {
                    nativeEnableCustomRendering(this.mNativeV2TXLivePlayerJni, bool5.booleanValue(), this.mPixelFormatType.getValue(), this.mBufferType.ordinal());
                }
                Boolean bool6 = this.mEnableObserveAudioFrame;
                if (bool6 != null) {
                    nativeEnableObserveAudioFrame(this.mNativeV2TXLivePlayerJni, bool6.booleanValue());
                }
                if (this.mSEIPayloadSet.size() > 0) {
                    Iterator<Integer> iterator2 = this.mSEIPayloadSet.iterator2();
                    while (iterator2.hasNext()) {
                        nativeEnableReceiveSeiMessage(this.mNativeV2TXLivePlayerJni, true, iterator2.next().intValue());
                    }
                }
                nativeSetSharedEGLContext(this.mNativeV2TXLivePlayerJni, this.mGLContext);
                for (Map.Entry<String, Object> entry : this.mPropertyMap.entrySet()) {
                    nativeSetProperty(this.mNativeV2TXLivePlayerJni, entry.getKey(), entry.getValue());
                }
            }
            nativeStartPlay = nativeStartPlay(this.mNativeV2TXLivePlayerJni, str);
        }
        return nativeStartPlay;
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int stopPlay() {
        synchronized (this) {
            if (isNativeValid()) {
                nativeStopPlay(this.mNativeV2TXLivePlayerJni, this.mClearLastImage);
                nativeDestroy(this.mNativeV2TXLivePlayerJni);
                this.mNativeV2TXLivePlayerJni = 0L;
            }
        }
        return 0;
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int switchStream(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LiteavLog.e(TAG, "Invalid params.");
                return -2;
            }
            if (!isNativeValid()) {
                return 0;
            }
            return nativeSwitchStream(this.mNativeV2TXLivePlayerJni, str);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(TextureView textureView) {
        synchronized (this) {
            if (textureView != null) {
                this.mDisplayTarget = new DisplayTarget(textureView);
            } else {
                this.mDisplayTarget = null;
            }
            if (!isNativeValid()) {
                return 0;
            }
            return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
        }
    }

    @Override // com.tencent.live2.V2TXLivePlayer
    public int setRenderView(SurfaceView surfaceView) {
        synchronized (this) {
            if (surfaceView != null) {
                this.mDisplayTarget = new DisplayTarget(surfaceView);
            } else {
                this.mDisplayTarget = null;
            }
            if (!isNativeValid()) {
                return 0;
            }
            return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, this.mDisplayTarget);
        }
    }
}
