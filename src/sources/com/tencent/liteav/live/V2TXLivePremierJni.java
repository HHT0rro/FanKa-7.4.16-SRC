package com.tencent.liteav.live;

import com.huawei.quickcard.base.Attributes;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.s;
import com.tencent.liteav.videobase.common.b;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePremier;
import org.json.JSONObject;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class V2TXLivePremierJni {
    private static final String TAG = "V2TXLivePremierJni";
    private static long mNativeV2TXLivePremierJni;
    private static V2TXLivePremier.V2TXLivePremierObserver sObserver;

    static {
        s.a();
        mNativeV2TXLivePremierJni = 0L;
    }

    public static int callExperimentalAPI(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("api")) {
                LiteavLog.e(TAG, "callExperimentalAPI[lack api or illegal type]: ".concat(String.valueOf(str)));
                return -2;
            }
            String string = jSONObject.getString("api");
            if (!jSONObject.has("params")) {
                LiteavLog.e(TAG, "callExperimentalAPI[lack params or illegal type]: ".concat(String.valueOf(str)));
                return -2;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            if (string.equals("forceRemoteAudioPlayout")) {
                return forceRemoteAudioPlayout(jSONObject2);
            }
            if (string.equals("isSupportHDR")) {
                return isSupportHDR(jSONObject2);
            }
            return -4;
        } catch (Exception e2) {
            LiteavLog.e(TAG, "callExperimentalAPI[failed]: " + str + " " + ((Object) e2));
            return -2;
        }
    }

    private static void createNativeV2TXLivePremierIfNeed() {
        synchronized (V2TXLivePremierJni.class) {
            if (mNativeV2TXLivePremierJni == 0) {
                mNativeV2TXLivePremierJni = nativeCreate();
            }
        }
    }

    public static int enableAudioCaptureObserver(boolean z10, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        createNativeV2TXLivePremierIfNeed();
        return nativeEnableAudioCaptureObserver(mNativeV2TXLivePremierJni, z10, v2TXLiveAudioFrameObserverFormat.sampleRate, v2TXLiveAudioFrameObserverFormat.channel, v2TXLiveAudioFrameObserverFormat.samplesPerCall, v2TXLiveAudioFrameObserverFormat.mode.ordinal());
    }

    public static int enableAudioPlayoutObserver(boolean z10, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        createNativeV2TXLivePremierIfNeed();
        return nativeEnableAudioPlayoutObserver(mNativeV2TXLivePremierJni, z10, v2TXLiveAudioFrameObserverFormat.sampleRate, v2TXLiveAudioFrameObserverFormat.channel, v2TXLiveAudioFrameObserverFormat.samplesPerCall, v2TXLiveAudioFrameObserverFormat.mode.ordinal());
    }

    public static int enableVoiceEarMonitorObserver(boolean z10) {
        createNativeV2TXLivePremierIfNeed();
        return nativeEnableVoiceEarMonitorObserver(mNativeV2TXLivePremierJni, z10);
    }

    private static int forceRemoteAudioPlayout(JSONObject jSONObject) {
        createNativeV2TXLivePremierIfNeed();
        if (jSONObject == null) {
            LiteavLog.e(TAG, "forceRemoteAudioPlayout param is null");
            return -2;
        }
        if (!jSONObject.has(Attributes.Style.ENABLE)) {
            LiteavLog.e(TAG, "forceRemoteAudioPlayout[lack parameter]: enable");
            return -2;
        }
        nativeForceRemoteAudioPlayout(mNativeV2TXLivePremierJni, jSONObject.optBoolean(Attributes.Style.ENABLE, false));
        return 0;
    }

    private static int isSupportHDR(JSONObject jSONObject) {
        createNativeV2TXLivePremierIfNeed();
        if (jSONObject == null) {
            LiteavLog.e(TAG, "isSupportHDR param is null");
            return -2;
        }
        if (jSONObject.has("hdrType")) {
            return (jSONObject.optString("hdrType", "HDR10").equals("HDR10") && nativeIsSupportHDR(mNativeV2TXLivePremierJni, b.HDR10.mValue)) ? 0 : -4;
        }
        LiteavLog.e(TAG, "isSupportHDR[lack parameter]: hdrType");
        return -2;
    }

    private static native long nativeCreate();

    private static native int nativeEnableAudioCaptureObserver(long j10, boolean z10, int i10, int i11, int i12, int i13);

    private static native int nativeEnableAudioPlayoutObserver(long j10, boolean z10, int i10, int i11, int i12, int i13);

    private static native int nativeEnableVoiceEarMonitorObserver(long j10, boolean z10);

    private static native void nativeForceRemoteAudioPlayout(long j10, boolean z10);

    private static native boolean nativeIsSupportHDR(long j10, int i10);

    @CalledByNative
    public static void onAudioCaptureData(byte[] bArr, long j10, int i10, int i11) {
        V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = sObserver;
        if (v2TXLivePremierObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i10;
        v2TXLiveAudioFrame.channel = i11;
        v2TXLiveAudioFrame.timestamp = j10;
        v2TXLivePremierObserver.onCaptureAudioFrame(v2TXLiveAudioFrame);
    }

    @CalledByNative
    public static void onAudioPlayoutData(byte[] bArr, long j10, int i10, int i11) {
        V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = sObserver;
        if (v2TXLivePremierObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i10;
        v2TXLiveAudioFrame.channel = i11;
        v2TXLiveAudioFrame.timestamp = j10;
        v2TXLivePremierObserver.onPlayoutAudioFrame(v2TXLiveAudioFrame);
    }

    @CalledByNative
    public static void onEarMonitoringData(byte[] bArr, int i10, int i11) {
        V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = sObserver;
        if (v2TXLivePremierObserver == null) {
            return;
        }
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i10;
        v2TXLiveAudioFrame.channel = i11;
        v2TXLivePremierObserver.onVoiceEarMonitorAudioFrame(v2TXLiveAudioFrame);
    }

    public static void setObserver(V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver) {
        sObserver = v2TXLivePremierObserver;
    }
}
