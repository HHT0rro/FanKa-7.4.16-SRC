package com.zego.zegoliveroom;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.zego.zegoavkit2.ZegoStreamExtraPlayInfo;
import com.zego.zegoavkit2.entities.ZegoColorEnhancementParams;
import com.zego.zegoavkit2.entities.ZegoObjectSegmentationConfig;
import com.zego.zegoavkit2.entities.ZegoStreamRelayCDNInfo;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamInfo;
import com.zego.zegoliveroom.entity.ZegoAudioAuxDataConfig;
import com.zego.zegoliveroom.entity.ZegoAudioFrame;
import com.zego.zegoliveroom.entity.ZegoBigRoomMessage;
import com.zego.zegoliveroom.entity.ZegoExtPrepSet;
import com.zego.zegoliveroom.entity.ZegoPlayStats;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoProxyInfo;
import com.zego.zegoliveroom.entity.ZegoPublishDualStreamConfig;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoRoomMessage;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import com.zego.zegoliveroom.entity.ZegoUser;
import com.zego.zegoliveroom.entity.ZegoUserState;
import com.zego.zegoliveroom.utils.SoLoadUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoLiveRoomJNI {
    private static volatile boolean hasInitSuccess;
    private static volatile IJniZegoIMCallback sJNIZegoIMCallback;
    private static volatile IJniZegoLiveRoomCallback sJNIZegoLiveRoomCallback;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface IJniZegoIMCallback {
        void onRecvBigRoomMessage(String str, ZegoBigRoomMessage[] zegoBigRoomMessageArr);

        void onRecvRoomMessage(String str, ZegoRoomMessage[] zegoRoomMessageArr);

        void onSendBigRoomMessage(int i10, String str, int i11, String str2);

        void onSendRoomMessage(int i10, String str, int i11, long j10);

        void onUpdateOnlineCount(String str, int i10);

        void onUserUpdate(ZegoUserState[] zegoUserStateArr, int i10, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface IJniZegoLiveRoomCallback {
        void onAVEngineStart();

        void onAVEngineStop();

        void onAlignedAudioAuxDataCallback(ZegoAudioFrame zegoAudioFrame, int i10);

        ZegoAudioFrame onAudioPostp(ZegoAudioFrame zegoAudioFrame, String str);

        ZegoAudioFrame onAudioPrep(ZegoAudioFrame zegoAudioFrame);

        void onAudioPrepVADStateUpdate(int i10);

        ZegoAudioFrame onAudioProc(ZegoAudioFrame zegoAudioFrame);

        void onAudioRecordCallback(byte[] bArr, int i10, int i11, int i12, int i13);

        void onAudioRouteChange(int i10);

        void onCaptureAudioFirstFrame();

        void onCaptureVideoFirstFrame();

        void onCaptureVideoFirstFrame(int i10);

        void onCaptureVideoSizeChanged(int i10, int i11);

        void onCaptureVideoSizeChanged(int i10, int i11, int i12);

        void onCapturedAudioVADStateUpdate(int i10);

        void onCustomCommand(int i10, int i11, String str);

        void onDeviceError(String str, int i10);

        void onDisconnect(int i10, String str);

        void onEndJoinLive(int i10, int i11, String str);

        void onExperimentalAPICallback(String str);

        void onFatalError(int i10);

        void onInitSDK(int i10);

        void onInviteJoinLiveRequest(int i10, String str, String str2, String str3);

        void onInviteJoinLiveResponse(int i10, String str, String str2, int i11);

        void onJoinLiveRequest(int i10, String str, String str2, String str3);

        void onJoinLiveResponse(int i10, String str, String str2, int i11);

        void onKickOut(int i10, String str, String str2);

        void onLiveEvent(int i10, HashMap<String, String> hashMap);

        void onLogHook(String str);

        void onLogUploadResult(int i10);

        void onLogWillOverwrite();

        void onLoginRoom(int i10, String str, ZegoStreamInfo[] zegoStreamInfoArr);

        void onNetTypeChange(int i10);

        void onNetworkQuality(String str, int i10, int i11);

        void onPlayQualityUpdate(String str, ZegoPlayStreamQuality zegoPlayStreamQuality);

        void onPlayStateUpdate(int i10, String str);

        void onPlayStatsUpdate(ZegoPlayStats zegoPlayStats);

        void onPlayVideoSuperResolutionUpdate(String str, int i10, int i11);

        void onPreviewSnapshot(int i10, Bitmap bitmap);

        void onPreviewSnapshot(Bitmap bitmap);

        void onPreviewVideoFirstFrame(int i10);

        void onPublishQulityUpdate(String str, ZegoPublishStreamQuality zegoPublishStreamQuality);

        void onPublishStateUpdate(int i10, String str, HashMap<String, Object> hashMap);

        void onReconnect(int i10, String str);

        void onRecvCustomCommand(String str, String str2, String str3, String str4);

        void onRecvEndJoinLiveCommand(String str, String str2, String str3);

        void onRecvRealtimeSequentialData(ByteBuffer byteBuffer, String str);

        void onRecvRemoteAudioFirstFrame(String str);

        void onRecvRemoteVideoFirstFrame(String str);

        void onRelayCDNStateUpdate(ZegoStreamRelayCDNInfo[] zegoStreamRelayCDNInfoArr, String str);

        void onRemoteCameraStatusUpdate(String str, int i10, int i11);

        void onRemoteMicStatusUpdate(String str, int i10, int i11);

        void onRemoteSpeakerStatusUpdate(String str, int i10, int i11);

        void onRenderRemoteVideoFirstFrame(String str);

        void onRequestDumpData();

        void onRequestUploadDumpData(String str, boolean z10);

        void onRoomInfoUpdated(ZegoRoomInfo zegoRoomInfo, String str);

        void onRunLoopObserveCallback(long j10, int i10, int i11, int i12, int i13);

        void onSendLocalAudioFirstFrame(int i10);

        void onSendLocalVideoFirstFrame(int i10);

        void onSendRealtimeSequentialData(int i10, int i11);

        void onSnapshot(Bitmap bitmap, String str);

        void onStartDumpData(int i10);

        void onStopDumpData(int i10, String str);

        void onStreamEvent(int i10, String str, HashMap<String, String> hashMap);

        void onStreamExtraInfoUpdated(ZegoStreamInfo[] zegoStreamInfoArr, String str);

        void onStreamUpdated(int i10, ZegoStreamInfo[] zegoStreamInfoArr, String str);

        void onTempBroken(int i10, String str);

        void onTokenWillExpired(String str, int i10);

        void onUpdatePublishTargetState(int i10, String str, int i11);

        void onUploadDumpData(int i10);

        void onVideoDecoderError(int i10, int i11, String str);

        void onVideoEncoderChanged(int i10, int i11, int i12);

        void onVideoEncoderError(int i10, int i11, int i12);

        void onVideoObjectSegmentationStateChanged(int i10, int i11, int i12);

        void onVideoSizeChanged(String str, int i10, int i11);
    }

    static {
        try {
            System.loadLibrary(ZegoSdkInfo.LIBRARY_NAME);
            hasInitSuccess = true;
        } catch (UnsatisfiedLinkError unused) {
            hasInitSuccess = false;
        }
    }

    public static native int activateAllAudioPlayStream(boolean z10);

    public static native int activateAllVideoPlayStream(boolean z10);

    public static native int activateAudioPlayStream(String str, boolean z10);

    public static native int activateVideoPlayStream(String str, boolean z10, int i10);

    public static native int addPublishTarget(String str, String str2);

    public static native int callExperimentalAPI(String str);

    public static native int deletePublishTarget(String str, String str2);

    public static native void enableAEC(boolean z10);

    public static native void enableAECWhenHeadsetDetected(boolean z10);

    public static native void enableAGC(boolean z10);

    public static native void enableAlignedAudioAuxData(boolean z10, ZegoAudioAuxDataConfig zegoAudioAuxDataConfig);

    public static native void enableAlphaChannelVideoEncoder(boolean z10, int i10, int i11);

    public static native void enableAudioPostp(boolean z10, String str);

    public static native void enableAudioPrepVADStableStateMonitor(boolean z10, int i10);

    public static native void enableAudioRouteCallback(boolean z10);

    public static native void enableAudioVADStableStateCallback(boolean z10);

    public static native boolean enableAux(boolean z10);

    public static native boolean enableBeautifying(int i10, int i11);

    public static native boolean enableCamera(boolean z10, int i10);

    public static native boolean enableCaptureMirror(boolean z10, int i10);

    public static native void enableCapturedAudioVADStableStateMonitor(boolean z10, int i10);

    public static native void enableCheckPoc(boolean z10);

    public static native void enableColorEnhancement(boolean z10, ZegoColorEnhancementParams zegoColorEnhancementParams, int i10);

    public static native void enableDTX(boolean z10);

    public static native void enableDumpDataCallback(boolean z10);

    public static native boolean enableH265EncodeFallback(boolean z10);

    public static native boolean enableLoopback(boolean z10);

    public static native boolean enableMic(boolean z10);

    public static native boolean enableMicDevice(boolean z10);

    public static native void enableNetTypeCallback(boolean z10);

    public static native boolean enableNoiseSuppress(boolean z10);

    public static native boolean enablePlayVirtualStereo(boolean z10, int i10, String str);

    public static native boolean enablePreviewMirror(boolean z10, int i10);

    public static native boolean enableRateControl(boolean z10, int i10);

    public static native void enableRealtimeSequentialDataCallback(boolean z10);

    public static native void enableRunLoopObserveCallback(boolean z10);

    public static native void enableScreenCaptureEncodeOptimization(boolean z10, int i10);

    public static native boolean enableSelectedAudioRecord(int i10, int i11, int i12);

    public static native boolean enableSpeaker(boolean z10);

    public static native boolean enableTorch(boolean z10, int i10);

    public static native void enableTrafficControl(int i10, boolean z10, int i11);

    public static native boolean enableTransientNoiseSuppress(boolean z10);

    public static native void enableVAD(boolean z10);

    public static native void enableVideoObjectSegmentation(boolean z10, int i10, int i11);

    public static native void enableVideoObjectSegmentationWithConfig(boolean z10, ZegoObjectSegmentationConfig zegoObjectSegmentationConfig, int i10);

    public static native void enableVideoSuperResolution(String str, boolean z10);

    public static native boolean enableViewMirror(boolean z10, String str);

    public static native int endJoinLive(String str, String str2);

    public static int ensureSoLoaded(Context context, String str) {
        int i10;
        if (hasInitSuccess || TextUtils.isEmpty(str)) {
            i10 = 0;
        } else {
            hasInitSuccess = SoLoadUtil.loadSpecialLibrary(str, context);
            i10 = hasInitSuccess ? 1 : -1;
        }
        if (hasInitSuccess) {
            return i10;
        }
        hasInitSuccess = SoLoadUtil.loadSoFile("libZegoLiveRoom.so", context);
        return hasInitSuccess ? 2 : -2;
    }

    public static native int getAudioRouteType();

    public static native float getCaptureSoundLevel();

    public static native int getMaxPlayChannelCount();

    public static native int getMaxPublishChannelCount();

    public static native float getSoundLevelOfStream(String str);

    public static native ZegoUser getUserByStreamID(String str);

    public static native String getVideoCodecCapabilityList();

    public static native boolean initSDK(int i10, byte[] bArr, Context context, ClassLoader classLoader);

    public static native void initVideoSuperResolution();

    public static native int inviteJoinLive(String str, String str2);

    public static native int isVideoDecoderSupported(int i10, int i11);

    public static native int isVideoEncoderSupported(int i10, int i11);

    public static native void logPrint(String str);

    public static native void logPrintVerbose(String str);

    public static native boolean loginRoom(String str, String str2, int i10);

    public static native boolean logoutRoom(String str);

    public static native int muteAudioPublish(boolean z10, int i10);

    public static native int muteVideoPublish(boolean z10, int i10);

    public static void onAVEngineStart() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAVEngineStart();
        }
    }

    public static void onAVEngineStop() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAVEngineStop();
        }
    }

    public static void onAlignedAudioAuxDataCallback(ZegoAudioFrame zegoAudioFrame, int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAlignedAudioAuxDataCallback(zegoAudioFrame, i10);
        }
    }

    public static ZegoAudioFrame onAudioPostp(ZegoAudioFrame zegoAudioFrame, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        return iJniZegoLiveRoomCallback != null ? iJniZegoLiveRoomCallback.onAudioPostp(zegoAudioFrame, str) : zegoAudioFrame;
    }

    public static ZegoAudioFrame onAudioPrepNew(ZegoAudioFrame zegoAudioFrame) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        return iJniZegoLiveRoomCallback != null ? iJniZegoLiveRoomCallback.onAudioPrep(zegoAudioFrame) : zegoAudioFrame;
    }

    public static void onAudioPrepVADStateUpdate(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAudioPrepVADStateUpdate(i10);
        }
    }

    public static ZegoAudioFrame onAudioProc(ZegoAudioFrame zegoAudioFrame) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        return iJniZegoLiveRoomCallback != null ? iJniZegoLiveRoomCallback.onAudioProc(zegoAudioFrame) : zegoAudioFrame;
    }

    public static void onAudioRecordCallback(byte[] bArr, int i10, int i11, int i12, int i13) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAudioRecordCallback(bArr, i10, i11, i12, i13);
        }
    }

    public static void onAudioRouteChange(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onAudioRouteChange(i10);
        }
    }

    public static void onCaptureAudioFirstFrame() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureAudioFirstFrame();
        }
    }

    public static void onCaptureVideoFirstFrame() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureVideoFirstFrame();
        }
    }

    public static void onCaptureVideoSizeChanged(int i10, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureVideoSizeChanged(i10, i11);
        }
    }

    public static void onCapturedAudioVADStateUpdate(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCapturedAudioVADStateUpdate(i10);
        }
    }

    public static void onCustomCommand(int i10, int i11, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCustomCommand(i10, i11, str);
        }
    }

    public static void onDeviceError(String str, int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onDeviceError(str, i10);
        }
    }

    public static void onDisconnect(int i10, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onDisconnect(i10, str);
        }
    }

    public static void onEndJoinLive(int i10, int i11, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onEndJoinLive(i10, i11, str);
        }
    }

    public static void onExperimentalAPICallback(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onExperimentalAPICallback(str);
        }
    }

    public static void onFatalError(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onFatalError(i10);
        }
    }

    public static void onInitSDK(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onInitSDK(i10);
        }
    }

    public static void onInviteJoinLiveRequest(int i10, String str, String str2, String str3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onInviteJoinLiveRequest(i10, str, str2, str3);
        }
    }

    public static void onInviteJoinLiveResponse(int i10, String str, String str2, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onInviteJoinLiveResponse(i10, str, str2, i11);
        }
    }

    public static void onJoinLiveRequest(int i10, String str, String str2, String str3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onJoinLiveRequest(i10, str, str2, str3);
        }
    }

    public static void onJoinLiveResponse(int i10, String str, String str2, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onJoinLiveResponse(i10, str, str2, i11);
        }
    }

    public static void onKickOut(int i10, String str, String str2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onKickOut(i10, str, str2);
        }
    }

    public static void onLiveEvent(int i10, String[] strArr, String[] strArr2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            int length = strArr.length <= strArr2.length ? strArr.length : strArr2.length;
            for (int i11 = 0; i11 < length; i11++) {
                hashMap.put(strArr[i11], strArr2[i11]);
            }
            iJniZegoLiveRoomCallback.onLiveEvent(i10, hashMap);
        }
    }

    public static void onLogHook(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onLogHook(str);
        }
    }

    public static void onLogUploadResult(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onLogUploadResult(i10);
        }
    }

    public static void onLogWillOverwrite() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onLogWillOverwrite();
        }
    }

    public static void onLoginRoom(int i10, String str, ZegoStreamInfo[] zegoStreamInfoArr, long j10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onLoginRoom(i10, str, zegoStreamInfoArr);
        }
    }

    public static void onNetTypeChange(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onNetTypeChange(i10);
        }
    }

    public static void onNetworkQuality(String str, int i10, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onNetworkQuality(str, i10, i11);
        }
    }

    public static void onPlayQualityUpdate(String str, ZegoPlayStreamQuality zegoPlayStreamQuality) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPlayQualityUpdate(str, zegoPlayStreamQuality);
        }
    }

    public static void onPlayStateUpdate(int i10, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPlayStateUpdate(i10, str);
        }
    }

    public static void onPlayStatsUpdate(ZegoPlayStats zegoPlayStats) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPlayStatsUpdate(zegoPlayStats);
        }
    }

    public static void onPlayVideoSuperResolutionUpdate(String str, int i10, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPlayVideoSuperResolutionUpdate(str, i10, i11);
        }
    }

    public static void onPreviewSnapshot(Bitmap bitmap) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPreviewSnapshot(bitmap);
        }
    }

    public static void onPreviewVideoFirstFrame(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPreviewVideoFirstFrame(i10);
        }
    }

    public static void onPublishQulityUpdate(String str, ZegoPublishStreamQuality zegoPublishStreamQuality) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPublishQulityUpdate(str, zegoPublishStreamQuality);
        }
    }

    public static void onPublishStateUpdate(int i10, String str, String[] strArr, String[] strArr2, String[] strArr3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("streamID", str);
            hashMap.put("rtmpList", strArr);
            hashMap.put("flvList", strArr2);
            hashMap.put("hlsList", strArr3);
            iJniZegoLiveRoomCallback.onPublishStateUpdate(i10, str, hashMap);
        }
    }

    public static void onReconnect(int i10, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onReconnect(i10, str);
        }
    }

    public static void onRecvBigRoomMessage(String str, ZegoBigRoomMessage[] zegoBigRoomMessageArr) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onRecvBigRoomMessage(str, zegoBigRoomMessageArr);
        }
    }

    public static void onRecvCustomCommand(String str, String str2, String str3, String str4) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvCustomCommand(str, str2, str3, str4);
        }
    }

    public static void onRecvEndJoinLiveCommand(String str, String str2, String str3) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvEndJoinLiveCommand(str, str2, str3);
        }
    }

    public static void onRecvRealtimeSequentialData(ByteBuffer byteBuffer, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvRealtimeSequentialData(byteBuffer, str);
        }
    }

    public static void onRecvRemoteAudioFirstFrame(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvRemoteAudioFirstFrame(str);
        }
    }

    public static void onRecvRemoteVideoFirstFrame(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRecvRemoteVideoFirstFrame(str);
        }
    }

    public static void onRecvRoomMessage(String str, ZegoRoomMessage[] zegoRoomMessageArr) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onRecvRoomMessage(str, zegoRoomMessageArr);
        }
    }

    public static void onRelayCDNStateUpdate(ZegoStreamRelayCDNInfo[] zegoStreamRelayCDNInfoArr, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRelayCDNStateUpdate(zegoStreamRelayCDNInfoArr, str);
        }
    }

    public static void onRemoteCameraStatusUpdate(String str, int i10, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRemoteCameraStatusUpdate(str, i10, i11);
        }
    }

    public static void onRemoteMicStatusUpdate(String str, int i10, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRemoteMicStatusUpdate(str, i10, i11);
        }
    }

    public static void onRemoteSpeakerStatusUpdate(String str, int i10, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRemoteSpeakerStatusUpdate(str, i10, i11);
        }
    }

    public static void onRenderRemoteVideoFirstFrame(String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRenderRemoteVideoFirstFrame(str);
        }
    }

    public static void onRequestDumpData() {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRequestDumpData();
        }
    }

    public static void onRequestUploadDumpData(String str, boolean z10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRequestUploadDumpData(str, z10);
        }
    }

    public static void onRoomInfoUpdated(ZegoRoomInfo zegoRoomInfo, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRoomInfoUpdated(zegoRoomInfo, str);
        }
    }

    public static void onRunLoopObserveCallback(long j10, int i10, int i11, int i12, int i13) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onRunLoopObserveCallback(j10, i10, i11, i12, i13);
        }
    }

    public static void onSendBigRoomMessage(int i10, String str, int i11, String str2) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onSendBigRoomMessage(i10, str, i11, str2);
        }
    }

    public static void onSendLocalAudioFirstFrame(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onSendLocalAudioFirstFrame(i10);
        }
    }

    public static void onSendLocalVideoFirstFrame(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onSendLocalVideoFirstFrame(i10);
        }
    }

    public static void onSendRealtimeSequentialData(int i10, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onSendRealtimeSequentialData(i10, i11);
        }
    }

    public static void onSendRoomMessage(int i10, String str, int i11, long j10) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onSendRoomMessage(i10, str, i11, j10);
        }
    }

    public static void onSnapshot(Bitmap bitmap, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onSnapshot(bitmap, str);
        }
    }

    public static void onStartDumpData(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onStartDumpData(i10);
        }
    }

    public static void onStopDumpData(int i10, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onStopDumpData(i10, str);
        }
    }

    public static void onStreamEvent(int i10, String str, String[] strArr, String[] strArr2) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            int length = strArr.length <= strArr2.length ? strArr.length : strArr2.length;
            for (int i11 = 0; i11 < length; i11++) {
                hashMap.put(strArr[i11], strArr2[i11]);
            }
            iJniZegoLiveRoomCallback.onStreamEvent(i10, str, hashMap);
        }
    }

    public static void onStreamExtraInfoUpdated(ZegoStreamInfo[] zegoStreamInfoArr, long j10, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onStreamExtraInfoUpdated(zegoStreamInfoArr, str);
        }
    }

    public static void onStreamUpdated(int i10, ZegoStreamInfo[] zegoStreamInfoArr, long j10, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onStreamUpdated(i10, zegoStreamInfoArr, str);
        }
    }

    public static void onTempBroken(int i10, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onTempBroken(i10, str);
        }
    }

    public static void onTokenWillExpired(String str, int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onTokenWillExpired(str, i10);
        }
    }

    public static void onUpdateOnlineCount(String str, int i10) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onUpdateOnlineCount(str, i10);
        }
    }

    public static void onUpdatePublishTargetState(int i10, String str, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onUpdatePublishTargetState(i10, str, i11);
        }
    }

    public static void onUploadDumpData(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onUploadDumpData(i10);
        }
    }

    public static void onUserUpdate(ZegoUserState[] zegoUserStateArr, int i10, String str) {
        IJniZegoIMCallback iJniZegoIMCallback = sJNIZegoIMCallback;
        if (iJniZegoIMCallback != null) {
            iJniZegoIMCallback.onUserUpdate(zegoUserStateArr, i10, str);
        }
    }

    public static void onVideoDecoderError(int i10, int i11, String str) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onVideoDecoderError(i10, i11, str);
        }
    }

    public static void onVideoEncoderChanged(int i10, int i11, int i12) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onVideoEncoderChanged(i10, i11, i12);
        }
    }

    public static void onVideoEncoderError(int i10, int i11, int i12) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onVideoEncoderError(i10, i11, i12);
        }
    }

    public static void onVideoObjectSegmentationStateChanged(int i10, int i11, int i12) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onVideoObjectSegmentationStateChanged(i10, i11, i12);
        }
    }

    public static void onVideoSizeChanged(String str, int i10, int i11) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onVideoSizeChanged(str, i10, i11);
        }
    }

    public static native void pauseModule(int i10);

    public static native void removeDumpData();

    public static native int requestJoinLive(String str);

    public static native boolean requireHardwareDecoder(boolean z10, String str);

    public static native boolean requireHardwareEncoder(boolean z10);

    public static native boolean requireHardwareEncoderByChannel(boolean z10, int i10);

    public static native boolean respondInviteJoinLiveReq(int i10, int i11, String str);

    public static native boolean respondJoinLiveReq(int i10, int i11, String str);

    public static native void resumeModule(int i10);

    public static native int sendBigRoomMessage(int i10, int i11, String str, String str2);

    public static native int sendCustomCommand(ZegoUser[] zegoUserArr, long j10, String str, String str2);

    public static native int sendRealtimeSequentialData(ByteBuffer byteBuffer, int i10, int i11);

    public static native int sendRoomMessageEx(int i10, int i11, String str, String str2);

    public static native void setAECMode(int i10);

    public static native void setAlignedAudioAuxDataCallback(boolean z10);

    public static native boolean setAppOrientation(int i10, int i11);

    public static native boolean setAppOrientationMode(int i10);

    public static native boolean setAudioBitrate(int i10, int i11);

    public static native void setAudioCaptureShiftOnMix(int i10);

    public static native void setAudioChannelCount(int i10);

    public static native void setAudioChannelCountByChannel(int i10, int i11);

    public static native boolean setAudioDevice(int i10, String str);

    public static native void setAudioDeviceMode(int i10);

    public static boolean setAudioMixMode(int i10, List<String> list) {
        return setAudioMixModeInner(i10, list == null ? new String[0] : (String[]) list.toArray(new String[list.size()]));
    }

    public static native boolean setAudioMixModeInner(int i10, String[] strArr);

    public static native void setAudioPostpCallback(boolean z10, ZegoExtPrepSet zegoExtPrepSet);

    public static native void setAudioPrepAfterLoopbackCallback(boolean z10, ZegoExtPrepSet zegoExtPrepSet);

    public static native void setAudioPrepCallback(boolean z10, ZegoExtPrepSet zegoExtPrepSet);

    public static native boolean setAudioSource(int i10, int i11);

    public static native boolean setBuiltInSpeakerOn(boolean z10);

    public static native void setBusinessType(int i10);

    public static native void setCDNPublishTarget(String str, int i10);

    public static native boolean setCaptureFrameRotation(int i10, int i11);

    public static native void setCapturePipelineScaleMode(int i10);

    public static native void setCaptureVolume(int i10);

    public static native void setChannelExtraParam(String str, int i10);

    public static native void setCloudProxyConfig(ZegoProxyInfo[] zegoProxyInfoArr, String str, boolean z10);

    public static native void setConfig(String str);

    public static native boolean setCustomCDNPublishTarget(String str, int[] iArr, String[] strArr, int i10);

    public static native boolean setCustomToken(String str);

    public static native void setDummyCaptureImagePath(String str, int i10);

    public static native void setExperimentalAPICallback(boolean z10);

    public static native boolean setFilter(int i10, int i11);

    public static native boolean setFrontCam(boolean z10, int i10);

    public static native boolean setGeoFence(int i10, int[] iArr);

    public static native void setLatencyMode(int i10);

    public static native void setLatencyModeByChannel(int i10, int i11);

    public static native void setLocalProxyConfig(ZegoProxyInfo[] zegoProxyInfoArr, boolean z10);

    public static native void setLogHook();

    public static native boolean setLogPathAndSize(String str, long j10, String str2, Context context, int i10);

    public static native void setLoopbackVolume(int i10);

    public static native boolean setLowlightEnhancement(int i10, int i11);

    public static native void setMinVideoBitrateForTrafficControl(int i10, int i11, int i12);

    public static native void setMinVideoFpsForTrafficControl(int i10, int i11);

    public static native void setMinVideoResolutionForTrafficControl(int i10, int i11, int i12);

    public static native boolean setMixStreamConfig(String str, int i10, int i11);

    public static native boolean setNoiseSuppressMode(int i10);

    public static native boolean setPlayQualityMonitorCycle(long j10);

    public static native boolean setPlayStreamFocus(String str);

    public static native int setPlayStreamsAlignmentProperty(int i10);

    public static native boolean setPlayVolume(int i10);

    public static native boolean setPlayVolume2(int i10, String str);

    public static native boolean setPolishFactor(float f10, int i10);

    public static native boolean setPolishStep(float f10, int i10);

    public static native void setPreviewCropRect(int i10, int i11, int i12, int i13, int i14, int i15, int i16);

    public static native boolean setPreviewRotation(int i10, int i11);

    public static native boolean setPreviewView(Object obj, int i10);

    public static native boolean setPreviewView2(Object obj, boolean z10, int i10);

    public static native boolean setPreviewViewBackgroundColor(int i10, int i11);

    public static native boolean setPreviewViewMode(int i10, int i11);

    public static native void setPreviewWaterMarkRect(int i10, int i11, int i12, int i13, int i14);

    public static native void setPublishConfig(String str, int i10);

    public static native boolean setPublishDualStreamConfig(ZegoPublishDualStreamConfig[] zegoPublishDualStreamConfigArr, int i10, int i11);

    public static native void setPublishEncryptKey(byte[] bArr, int i10);

    public static native boolean setPublishQualityMonitorCycle(long j10);

    public static native void setPublishWaterMarkRect(int i10, int i11, int i12, int i13, int i14);

    public static native boolean setRecvBufferLevelLimit(int i10, int i11, String str);

    public static native boolean setRoomConfig(boolean z10, boolean z11, String str);

    public static native boolean setRoomMaxUserCount(int i10, String str);

    public static native boolean setRoomMode(int i10);

    public static native boolean setSharpenFactor(float f10, int i10);

    public static native int setStreamAlignmentProperty(int i10, int i11);

    public static native void setTestEnv(boolean z10);

    public static native boolean setToken(String str, String str2);

    public static native void setTrafficControlFocusOn(int i10, int i11);

    public static native boolean setUser(String str, String str2);

    public static native void setVerbose(boolean z10);

    public static native boolean setVideoBitrate(int i10, int i11);

    public static native boolean setVideoCaptureDeviceId(String str, int i10);

    public static native boolean setVideoCaptureResolution(int i10, int i11, int i12);

    public static native boolean setVideoCodecId(int i10, int i11);

    public static native boolean setVideoEncodeResolution(int i10, int i11, int i12);

    public static native void setVideoEncoderRateControlConfig(int i10, int i11, int i12);

    public static native boolean setVideoFPS(int i10, int i11);

    public static native boolean setVideoKeyFrameInterval(int i10, int i11);

    public static native boolean setVideoMirrorMode(int i10, int i11);

    public static native boolean setVideoSource(int i10, int i11, int i12);

    public static native boolean setViewBackgroundColor(int i10, String str);

    public static native void setViewCropRect(int i10, int i11, int i12, int i13, int i14, int i15, String str);

    public static native boolean setViewMode(int i10, String str);

    public static native boolean setViewRotation(int i10, String str);

    public static native void setWaterMarkImagePath(String str, int i10);

    public static native boolean setWhitenFactor(float f10, int i10);

    public static void setZegoIMCallback(IJniZegoIMCallback iJniZegoIMCallback) {
        sJNIZegoIMCallback = iJniZegoIMCallback;
    }

    public static void setZegoLiveRoomCallback(IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback) {
        sJNIZegoLiveRoomCallback = iJniZegoLiveRoomCallback;
    }

    public static native void startDumpData(int i10);

    public static native boolean startPlayingStream(String str, Object obj, ZegoStreamExtraPlayInfo zegoStreamExtraPlayInfo);

    public static native boolean startPlayingStreamWithParams(String str, Object obj, boolean z10, ZegoStreamExtraPlayInfo zegoStreamExtraPlayInfo, String str2);

    public static native boolean startPreview(int i10);

    public static native boolean startPublishing(String str, String str2, int i10);

    public static native boolean startPublishing2(String str, String str2, int i10, int i11, String str3);

    public static native boolean startPublishing3(String str, String str2, int i10, int i11, int i12, int i13, String str3, String str4);

    public static native void stopDumpData();

    public static native boolean stopPlayingStream(String str);

    public static native boolean stopPreview(int i10);

    public static native boolean stopPublishing(int i10);

    public static native boolean switchRoom(String str, String str2, int i10);

    public static native boolean switchRoom2(String str, String str2, String str3, int i10);

    public static native boolean takePreviewSnapshot(int i10);

    public static native boolean takeSnapshot(String str);

    public static native boolean unInitSDK();

    public static native void uninitVideoSuperResolution();

    public static native boolean updateMixInputStreams(ZegoMixStreamInfo[] zegoMixStreamInfoArr);

    public static native void updatePlayDecryptKey(String str, byte[] bArr);

    public static native boolean updatePlayToken(String str, byte[] bArr);

    public static native boolean updatePlayView(String str, Object obj);

    public static native boolean updatePlayView2(String str, Object obj, boolean z10);

    public static native boolean updateStreamExtraInfo(String str, int i10);

    public static native void uploadDumpData();

    public static native void uploadLog();

    public static native String version();

    public static native String version2();

    public static void onCaptureVideoFirstFrame(int i10) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureVideoFirstFrame(i10);
        }
    }

    public static void onCaptureVideoSizeChanged(int i10, int i11, int i12) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onCaptureVideoSizeChanged(i10, i11, i12);
        }
    }

    public static void onPreviewSnapshot(int i10, Bitmap bitmap) {
        IJniZegoLiveRoomCallback iJniZegoLiveRoomCallback = sJNIZegoLiveRoomCallback;
        if (iJniZegoLiveRoomCallback != null) {
            iJniZegoLiveRoomCallback.onPreviewSnapshot(i10, bitmap);
        }
    }
}
