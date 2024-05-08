package com.tencent.trtc;

import android.view.View;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLContext;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TRTCCloudDef {
    public static final int TRTCAVStatusChangeReasonBufferingBegin = 1;
    public static final int TRTCAVStatusChangeReasonBufferingEnd = 2;
    public static final int TRTCAVStatusChangeReasonInternal = 0;
    public static final int TRTCAVStatusChangeReasonLocalStarted = 3;
    public static final int TRTCAVStatusChangeReasonLocalStopped = 4;
    public static final int TRTCAVStatusChangeReasonRemoteStarted = 5;
    public static final int TRTCAVStatusChangeReasonRemoteStopped = 6;
    public static final int TRTCAVStatusLoading = 2;
    public static final int TRTCAVStatusPlaying = 1;
    public static final int TRTCAVStatusStopped = 0;
    public static final int TRTCAudioCapabilityLowLatencyChorus = 1;
    public static final int TRTCAudioCapabilityLowLatencyEarMonitor = 2;
    public static final int TRTCAudioSampleRate16000 = 16000;
    public static final int TRTCAudioSampleRate32000 = 32000;
    public static final int TRTCAudioSampleRate44100 = 44100;
    public static final int TRTCAudioSampleRate48000 = 48000;
    public static final int TRTCRoleAnchor = 20;
    public static final int TRTCRoleAudience = 21;
    public static final int TRTCSystemVolumeTypeAuto = 0;
    public static final int TRTCSystemVolumeTypeMedia = 1;
    public static final int TRTCSystemVolumeTypeVOIP = 2;
    public static final int TRTC_APP_SCENE_AUDIOCALL = 2;
    public static final int TRTC_APP_SCENE_LIVE = 1;
    public static final int TRTC_APP_SCENE_VIDEOCALL = 0;
    public static final int TRTC_APP_SCENE_VOICE_CHATROOM = 3;
    public static final int TRTC_AUDIO_FRAME_FORMAT_PCM = 1;
    public static final int TRTC_AUDIO_FRAME_OPERATION_MODE_READONLY = 1;
    public static final int TRTC_AUDIO_FRAME_OPERATION_MODE_READWRITE = 0;
    public static final int TRTC_AUDIO_QUALITY_DEFAULT = 2;
    public static final int TRTC_AUDIO_QUALITY_MUSIC = 3;
    public static final int TRTC_AUDIO_QUALITY_SPEECH = 1;
    public static final int TRTC_AUDIO_ROUTE_BLUETOOTH_HEADSET = 3;
    public static final int TRTC_AUDIO_ROUTE_EARPIECE = 1;
    public static final int TRTC_AUDIO_ROUTE_SOUND_CARD = 4;
    public static final int TRTC_AUDIO_ROUTE_SPEAKER = 0;
    public static final int TRTC_AUDIO_ROUTE_WIRED_HEADSET = 2;
    public static final int TRTC_AudioRecordingContent_All = 0;
    public static final int TRTC_AudioRecordingContent_Local = 1;
    public static final int TRTC_AudioRecordingContent_Remote = 2;
    public static final int TRTC_BEAUTY_STYLE_NATURE = 1;
    public static final int TRTC_BEAUTY_STYLE_PITU = 2;
    public static final int TRTC_BEAUTY_STYLE_SMOOTH = 0;
    public static final int TRTC_DEBUG_VIEW_LEVEL_ALL = 2;
    public static final int TRTC_DEBUG_VIEW_LEVEL_GONE = 0;
    public static final int TRTC_DEBUG_VIEW_LEVEL_STATUS = 1;
    public static final int TRTC_EncryptionAlgorithm_Aes_128_Gcm = 0;
    public static final int TRTC_EncryptionAlgorithm_Aes_256_Gcm = 1;
    public static final int TRTC_GSENSOR_MODE_DISABLE = 0;
    public static final int TRTC_GSENSOR_MODE_UIAUTOLAYOUT = 1;
    public static final int TRTC_GSENSOR_MODE_UIFIXLAYOUT = 2;
    public static final int TRTC_LOG_LEVEL_DEBUG = 1;
    public static final int TRTC_LOG_LEVEL_ERROR = 4;
    public static final int TRTC_LOG_LEVEL_FATAL = 5;
    public static final int TRTC_LOG_LEVEL_INFO = 2;
    public static final int TRTC_LOG_LEVEL_NULL = 6;
    public static final int TRTC_LOG_LEVEL_VERBOSE = 0;
    public static final int TRTC_LOG_LEVEL_WARN = 3;
    public static final int TRTC_MixInputType_AudioVideo = 1;
    public static final int TRTC_MixInputType_PureAudio = 3;
    public static final int TRTC_MixInputType_PureVideo = 2;
    public static final int TRTC_MixInputType_Undefined = 0;
    public static final int TRTC_MixInputType_Watermark = 4;
    public static final int TRTC_PublishBigStream_ToCdn = 1;
    public static final int TRTC_PublishMixStream_ToCdn = 3;
    public static final int TRTC_PublishMixStream_ToRoom = 4;
    public static final int TRTC_PublishMode_Unknown = 0;
    public static final int TRTC_PublishSubStream_ToCdn = 2;
    public static final int TRTC_QUALITY_Bad = 4;
    public static final int TRTC_QUALITY_Down = 6;
    public static final int TRTC_QUALITY_Excellent = 1;
    public static final int TRTC_QUALITY_Good = 2;
    public static final int TRTC_QUALITY_Poor = 3;
    public static final int TRTC_QUALITY_UNKNOWN = 0;
    public static final int TRTC_QUALITY_Vbad = 5;
    public static final int TRTC_RECORD_TYPE_AUDIO = 0;
    public static final int TRTC_RECORD_TYPE_BOTH = 2;
    public static final int TRTC_RECORD_TYPE_VIDEO = 1;
    public static final int TRTC_REVERB_TYPE_0 = 0;
    public static final int TRTC_REVERB_TYPE_1 = 1;
    public static final int TRTC_REVERB_TYPE_2 = 2;
    public static final int TRTC_REVERB_TYPE_3 = 3;
    public static final int TRTC_REVERB_TYPE_4 = 4;
    public static final int TRTC_REVERB_TYPE_5 = 5;
    public static final int TRTC_REVERB_TYPE_6 = 6;
    public static final int TRTC_REVERB_TYPE_7 = 7;
    public static final String TRTC_SDK_VERSION = "11.4.0.13189";
    public static final int TRTC_SNAPSHOT_SOURCE_TYPE_STREAM = 0;
    public static final int TRTC_SNAPSHOT_SOURCE_TYPE_VIEW = 1;
    public static final int TRTC_SpeedTestScene_Delay_Bandwidth_Testing = 2;
    public static final int TRTC_SpeedTestScene_Delay_Testing = 1;
    public static final int TRTC_SpeedTestScene_Online_Chorus_Testing = 3;
    public static final int TRTC_TranscodingConfigMode_Manual = 1;
    public static final int TRTC_TranscodingConfigMode_Template_PresetLayout = 3;
    public static final int TRTC_TranscodingConfigMode_Template_PureAudio = 2;
    public static final int TRTC_TranscodingConfigMode_Template_ScreenSharing = 4;
    public static final int TRTC_TranscodingConfigMode_Unknown = 0;
    public static final int TRTC_VIDEO_BUFFER_TYPE_BYTE_ARRAY = 2;
    public static final int TRTC_VIDEO_BUFFER_TYPE_BYTE_BUFFER = 1;
    public static final int TRTC_VIDEO_BUFFER_TYPE_TEXTURE = 3;
    public static final int TRTC_VIDEO_BUFFER_TYPE_UNKNOWN = 0;
    public static final int TRTC_VIDEO_MIRROR_TYPE_AUTO = 0;
    public static final int TRTC_VIDEO_MIRROR_TYPE_DISABLE = 2;
    public static final int TRTC_VIDEO_MIRROR_TYPE_ENABLE = 1;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_I420 = 1;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_NV21 = 4;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_RGBA = 5;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_TEXTURE_EXTERNAL_OES = 3;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_Texture_2D = 2;
    public static final int TRTC_VIDEO_PIXEL_FORMAT_UNKNOWN = 0;
    public static final int TRTC_VIDEO_QOS_PREFERENCE_CLEAR = 2;
    public static final int TRTC_VIDEO_QOS_PREFERENCE_SMOOTH = 1;
    public static final int TRTC_VIDEO_RENDER_MODE_FILL = 0;
    public static final int TRTC_VIDEO_RENDER_MODE_FIT = 1;
    public static final int TRTC_VIDEO_RESOLUTION_120_120 = 1;
    public static final int TRTC_VIDEO_RESOLUTION_1280_720 = 112;
    public static final int TRTC_VIDEO_RESOLUTION_160_120 = 50;
    public static final int TRTC_VIDEO_RESOLUTION_160_160 = 3;
    public static final int TRTC_VIDEO_RESOLUTION_160_90 = 100;
    public static final int TRTC_VIDEO_RESOLUTION_1920_1080 = 114;
    public static final int TRTC_VIDEO_RESOLUTION_240_180 = 52;
    public static final int TRTC_VIDEO_RESOLUTION_256_144 = 102;
    public static final int TRTC_VIDEO_RESOLUTION_270_270 = 5;
    public static final int TRTC_VIDEO_RESOLUTION_280_210 = 54;
    public static final int TRTC_VIDEO_RESOLUTION_320_180 = 104;
    public static final int TRTC_VIDEO_RESOLUTION_320_240 = 56;
    public static final int TRTC_VIDEO_RESOLUTION_400_300 = 58;
    public static final int TRTC_VIDEO_RESOLUTION_480_270 = 106;
    public static final int TRTC_VIDEO_RESOLUTION_480_360 = 60;
    public static final int TRTC_VIDEO_RESOLUTION_480_480 = 7;
    public static final int TRTC_VIDEO_RESOLUTION_640_360 = 108;
    public static final int TRTC_VIDEO_RESOLUTION_640_480 = 62;
    public static final int TRTC_VIDEO_RESOLUTION_960_540 = 110;
    public static final int TRTC_VIDEO_RESOLUTION_960_720 = 64;
    public static final int TRTC_VIDEO_RESOLUTION_MODE_LANDSCAPE = 0;
    public static final int TRTC_VIDEO_RESOLUTION_MODE_PORTRAIT = 1;
    public static final int TRTC_VIDEO_ROTATION_0 = 0;
    public static final int TRTC_VIDEO_ROTATION_180 = 2;
    public static final int TRTC_VIDEO_ROTATION_270 = 3;
    public static final int TRTC_VIDEO_ROTATION_90 = 1;
    public static final int TRTC_VIDEO_STREAM_TYPE_BIG = 0;
    public static final int TRTC_VIDEO_STREAM_TYPE_SMALL = 1;
    public static final int TRTC_VIDEO_STREAM_TYPE_SUB = 2;
    public static final int TRTC_VOICE_CHANGER_TYPE_0 = 0;
    public static final int TRTC_VOICE_CHANGER_TYPE_1 = 1;
    public static final int TRTC_VOICE_CHANGER_TYPE_10 = 10;
    public static final int TRTC_VOICE_CHANGER_TYPE_11 = 11;
    public static final int TRTC_VOICE_CHANGER_TYPE_2 = 2;
    public static final int TRTC_VOICE_CHANGER_TYPE_3 = 3;
    public static final int TRTC_VOICE_CHANGER_TYPE_4 = 4;
    public static final int TRTC_VOICE_CHANGER_TYPE_5 = 5;
    public static final int TRTC_VOICE_CHANGER_TYPE_6 = 6;
    public static final int TRTC_VOICE_CHANGER_TYPE_7 = 7;
    public static final int TRTC_VOICE_CHANGER_TYPE_8 = 8;
    public static final int TRTC_VOICE_CHANGER_TYPE_9 = 9;
    public static final int VIDEO_QOS_CONTROL_CLIENT = 0;
    public static final int VIDEO_QOS_CONTROL_SERVER = 1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCAudioEffectParam {
        public int effectId;
        public String path;
        public int loopCount = 0;
        public boolean publish = false;
        public int volume = 100;

        public TRTCAudioEffectParam(int i10, String str) {
            this.path = str;
            this.effectId = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCAudioFrame {
        public int channel;
        public byte[] data;
        public byte[] extraData;
        public int sampleRate;
        public long timestamp;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCAudioFrameCallbackFormat {
        public int sampleRate = 0;
        public int channel = 0;
        public int samplesPerCall = 0;
        public int mode = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCAudioParallelParams {
        public int maxCount = 0;
        public ArrayList<String> includeUsers = new ArrayList<>();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCAudioRecordingParams {
        public String filePath = "";
        public int recordingContent = 0;
        public int maxDurationPerFile = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCAudioVolumeEvaluateParams {
        public int interval = 300;
        public boolean enableVadDetection = false;
        public boolean enableSpectrumCalculation = false;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCLocalRecordingParams {
        public String filePath = "";
        public int recordType = 2;
        public int interval = -1;
        public int maxDurationPerFile = 0;

        public String toString() {
            return "filePath=" + this.filePath + ", recordType=" + this.recordType + ", interval=" + this.interval + ", maxDurationPerFile=" + this.maxDurationPerFile;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCNetworkQosParam {
        public int controlMode;
        public int preference;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCPayloadPrivateEncryptionConfig {
        public int encryptionAlgorithm = 0;
        public String encryptionKey = null;
        public final byte[] encryptionSalt;

        public TRTCPayloadPrivateEncryptionConfig() {
            byte[] bArr = new byte[32];
            this.encryptionSalt = bArr;
            Arrays.fill(bArr, (byte) 0);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCPublishCDNParam {
        public int appId;
        public int bizId;
        public String streamId;
        public String url;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCPublishTarget {
        public int mode = 0;
        public ArrayList<TRTCPublishCdnUrl> cdnUrlList = new ArrayList<>();
        public TRTCUser mixStreamIdentity = new TRTCUser();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCQuality {
        public int quality;
        public String userId;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCRenderParams {
        public int fillMode;
        public int mirrorType;
        public int rotation;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCScreenShareParams {
        public boolean enableForegroundService = false;
        public View floatingView;
        public Object mediaProjection;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCSpeedTestParams {
        public int expectedDownBandwidth;
        public int expectedUpBandwidth;
        public int scene;
        public int sdkAppId;
        public String userId;
        public String userSig;

        public String toString() {
            return "sdkAppId:" + this.sdkAppId + " userId:" + this.userId + " expectedUpBandwidth:" + this.expectedDownBandwidth + " expectedDownBandwidth:" + this.expectedDownBandwidth + " scene:" + this.scene;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCSpeedTestResult {
        public int availableDownBandwidth;
        public int availableUpBandwidth;
        public int downJitter;
        public float downLostRate;
        public String errMsg;
        public String ip;
        public int quality;
        public int rtt;
        public boolean success;
        public int upJitter;
        public float upLostRate;

        public String toString() {
            return "success:" + this.success + " errMsg:" + this.errMsg + " ip:" + this.ip + " quality:" + this.quality + " upLostRate:" + this.upLostRate + " downLostRate:" + this.downLostRate + " rtt:" + this.rtt + " availableUpBandwidth:" + this.availableUpBandwidth + " availableDownBandwidth:" + this.availableDownBandwidth + " upJitter:" + this.upJitter + " downJitter:" + this.downJitter;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCStreamEncoderParam {
        public int videoEncodedWidth = 0;
        public int videoEncodedHeight = 0;
        public int videoEncodedFPS = 0;
        public int videoEncodedGOP = 0;
        public int videoEncodedKbps = 0;
        public int audioEncodedSampleRate = 0;
        public int audioEncodedChannelNum = 0;
        public int audioEncodedKbps = 0;
        public int audioEncodedCodecType = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCStreamMixingConfig {
        public int backgroundColor = 0;
        public String backgroundImage = "";
        public ArrayList<TRTCVideoLayout> videoLayoutList = new ArrayList<>();
        public ArrayList<TRTCUser> audioMixUserList = new ArrayList<>();
        public ArrayList<TRTCWatermark> watermarkList = new ArrayList<>();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCSwitchRoomConfig {
        public int roomId = 0;
        public String strRoomId = null;
        public String userSig = null;
        public String privateMapKey = null;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCTexture {
        public EGLContext eglContext10;
        public android.opengl.EGLContext eglContext14;
        public int textureId;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCUser {
        public String userId = "";
        public int intRoomId = 0;
        public String strRoomId = "";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCVideoEncParam {
        public boolean enableAdjustRes;
        public int minVideoBitrate;
        public int videoBitrate;
        public int videoFps;
        public int videoResolution;
        public int videoResolutionMode;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCVideoFrame {
        public ByteBuffer buffer;
        public int bufferType;
        public byte[] data;
        public int height;
        public int pixelFormat;
        public int rotation;
        public TRTCTexture texture;
        public long timestamp;
        public int width;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCVideoLayout {

        /* renamed from: x, reason: collision with root package name */
        public int f45378x = 0;

        /* renamed from: y, reason: collision with root package name */
        public int f45379y = 0;
        public int width = 0;
        public int height = 0;
        public int zOrder = 0;
        public int fillMode = 0;
        public int backgroundColor = 0;
        public String placeHolderImage = "";
        public TRTCUser fixedVideoUser = new TRTCUser();
        public int fixedVideoStreamType = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCVolumeInfo {
        public float[] spectrumData;
        public String userId;
        public int vad;
        public int volume;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCWatermark {
        public String watermarkUrl = "";

        /* renamed from: x, reason: collision with root package name */
        public int f45380x = 0;

        /* renamed from: y, reason: collision with root package name */
        public int f45381y = 0;
        public int height = 0;
        public int width = 0;
        public int zOrder = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCPublishCdnUrl {
        public boolean isInternalLine;
        public String rtmpUrl;

        public TRTCPublishCdnUrl() {
            this.rtmpUrl = "";
            this.isInternalLine = true;
        }

        public TRTCPublishCdnUrl(String str, boolean z10) {
            this.rtmpUrl = str;
            this.isInternalLine = z10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCParams {
        public String businessInfo;
        public String privateMapKey;
        public int role;
        public int roomId;
        public int sdkAppId;
        public String strRoomId;
        public String streamId;
        public String userDefineRecordId;
        public String userId;
        public String userSig;

        public TRTCParams() {
            this.sdkAppId = 0;
            this.userId = "";
            this.userSig = "";
            this.roomId = 0;
            this.strRoomId = "";
            this.role = 20;
            this.streamId = "";
            this.userDefineRecordId = "";
            this.privateMapKey = "";
            this.businessInfo = "";
        }

        public TRTCParams(int i10, String str, String str2, int i11, String str3, String str4) {
            this.role = 20;
            this.streamId = "";
            this.userDefineRecordId = "";
            this.sdkAppId = i10;
            this.userId = str;
            this.userSig = str2;
            this.roomId = i11;
            this.strRoomId = "";
            this.privateMapKey = str3;
            this.businessInfo = str4;
        }

        public TRTCParams(int i10, String str, String str2, String str3, String str4, String str5) {
            this.roomId = 0;
            this.role = 20;
            this.streamId = "";
            this.userDefineRecordId = "";
            this.sdkAppId = i10;
            this.userId = str;
            this.userSig = str2;
            this.strRoomId = str3;
            this.privateMapKey = str4;
            this.businessInfo = str5;
        }

        public TRTCParams(TRTCParams tRTCParams) {
            this.sdkAppId = 0;
            this.userId = "";
            this.userSig = "";
            this.roomId = 0;
            this.strRoomId = "";
            this.role = 20;
            this.streamId = "";
            this.userDefineRecordId = "";
            this.privateMapKey = "";
            this.businessInfo = "";
            this.sdkAppId = tRTCParams.sdkAppId;
            this.userId = tRTCParams.userId;
            this.userSig = tRTCParams.userSig;
            this.roomId = tRTCParams.roomId;
            this.strRoomId = tRTCParams.strRoomId;
            this.role = tRTCParams.role;
            this.streamId = tRTCParams.streamId;
            this.userDefineRecordId = tRTCParams.userDefineRecordId;
            this.privateMapKey = tRTCParams.privateMapKey;
            this.businessInfo = tRTCParams.businessInfo;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCMixUser {
        public int height;
        public String image;
        public int inputType;
        public boolean pureAudio;
        public int renderMode;
        public String roomId;
        public int soundLevel;
        public int streamType;
        public String userId;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f45376x;

        /* renamed from: y, reason: collision with root package name */
        public int f45377y;
        public int zOrder;

        public TRTCMixUser() {
            this.userId = "";
            this.f45376x = 0;
            this.f45377y = 0;
            this.width = 0;
            this.height = 0;
            this.zOrder = 0;
            this.streamType = 0;
            this.inputType = 0;
            this.renderMode = 0;
            this.soundLevel = 100;
            this.image = null;
        }

        public String toString() {
            return "userId=" + this.userId + ", roomId=" + this.roomId + ", x=" + this.f45376x + ", y=" + this.f45377y + ", width=" + this.width + ", height=" + this.height + ", zOrder=" + this.zOrder + ", streamType=" + this.streamType + ", pureAudio=" + this.pureAudio + ", inputType=" + this.inputType + ", renderMode=" + this.renderMode + ", soundLevel=" + this.soundLevel + ", image=" + this.image;
        }

        public TRTCMixUser(String str, int i10, int i11, int i12, int i13, int i14) {
            this.userId = str;
            this.f45376x = i10;
            this.f45377y = i11;
            this.width = i12;
            this.height = i13;
            this.zOrder = i14;
            this.streamType = 0;
            this.inputType = 0;
            this.renderMode = 0;
            this.soundLevel = 100;
            this.image = null;
        }

        public TRTCMixUser(TRTCMixUser tRTCMixUser) {
            this.userId = tRTCMixUser.userId;
            this.roomId = tRTCMixUser.roomId;
            this.f45376x = tRTCMixUser.f45376x;
            this.f45377y = tRTCMixUser.f45377y;
            this.width = tRTCMixUser.width;
            this.height = tRTCMixUser.height;
            this.zOrder = tRTCMixUser.zOrder;
            this.streamType = tRTCMixUser.streamType;
            this.pureAudio = tRTCMixUser.pureAudio;
            this.inputType = tRTCMixUser.inputType;
            this.renderMode = tRTCMixUser.renderMode;
            this.soundLevel = tRTCMixUser.soundLevel;
            this.image = tRTCMixUser.image;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCTranscodingConfig {
        public int appId;
        public int audioBitrate;
        public int audioChannels;
        public int audioCodec;
        public int audioSampleRate;
        public int backgroundColor;
        public String backgroundImage;
        public int bizId;
        public ArrayList<TRTCMixUser> mixUsers;
        public int mode;
        public String streamId;
        public int videoBitrate;
        public int videoFramerate;
        public int videoGOP;
        public int videoHeight;
        public String videoSeiParams;
        public int videoWidth;

        public TRTCTranscodingConfig() {
            this.mode = 0;
            this.videoWidth = 0;
            this.videoHeight = 0;
            this.videoBitrate = 0;
            this.videoFramerate = 15;
            this.videoGOP = 2;
            this.backgroundColor = 0;
            this.backgroundImage = null;
            this.audioSampleRate = 48000;
            this.audioBitrate = 64;
            this.audioChannels = 1;
            this.audioCodec = 0;
            this.streamId = null;
            this.videoSeiParams = null;
        }

        public String toString() {
            return "appId=" + this.appId + ", bizId=" + this.bizId + ", mode=" + this.mode + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitrate=" + this.videoBitrate + ", videoFramerate=" + this.videoFramerate + ", videoGOP=" + this.videoGOP + ", backgroundColor=" + this.backgroundColor + ", backgroundImage=" + this.backgroundImage + ", audioSampleRate=" + this.audioSampleRate + ", audioBitrate=" + this.audioBitrate + ", audioChannels=" + this.audioChannels + ", audioCodec=" + this.audioCodec + ", streamId=" + this.streamId + ", videoSeiParams=" + this.videoSeiParams + ", mixUsers=" + ((Object) this.mixUsers);
        }

        public TRTCTranscodingConfig(TRTCTranscodingConfig tRTCTranscodingConfig) {
            this.appId = tRTCTranscodingConfig.appId;
            this.bizId = tRTCTranscodingConfig.bizId;
            this.mode = tRTCTranscodingConfig.mode;
            this.videoWidth = tRTCTranscodingConfig.videoWidth;
            this.videoHeight = tRTCTranscodingConfig.videoHeight;
            this.videoBitrate = tRTCTranscodingConfig.videoBitrate;
            this.videoFramerate = tRTCTranscodingConfig.videoFramerate;
            this.videoGOP = tRTCTranscodingConfig.videoGOP;
            this.backgroundColor = tRTCTranscodingConfig.backgroundColor;
            this.backgroundImage = tRTCTranscodingConfig.backgroundImage;
            this.audioSampleRate = tRTCTranscodingConfig.audioSampleRate;
            this.audioBitrate = tRTCTranscodingConfig.audioBitrate;
            this.audioChannels = tRTCTranscodingConfig.audioChannels;
            this.audioCodec = tRTCTranscodingConfig.audioCodec;
            this.streamId = tRTCTranscodingConfig.streamId;
            this.videoSeiParams = tRTCTranscodingConfig.videoSeiParams;
            this.mixUsers = new ArrayList<>(tRTCTranscodingConfig.mixUsers);
        }
    }
}
