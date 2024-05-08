package com.zego.zegoliveroom.constants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoConstants {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AECMode {
        public static final int aggressive = 0;
        public static final int medium = 1;
        public static final int soft = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ANSMode {
        public static final int AI = 3;
        public static final int AI_BALANCED = 3;
        public static final int HIGH = 2;
        public static final int LOW = 0;
        public static final int MEDIUM = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioDeviceMode {
        public static final int Auto = 3;
        public static final int Communication = 1;
        public static final int Communication2 = 4;
        public static final int Communication3 = 5;
        public static final int Communication4 = 8;
        public static final int General = 2;
        public static final int General2 = 6;
        public static final int General3 = 7;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioRecordMask {
        public static final int Capture = 1;
        public static final int Mix = 4;
        public static final int NoRecord = 0;
        public static final int Render = 2;
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioRouteType {
        public static final int Bluetooth = 2;
        public static final int EarPhone = 1;
        public static final int LoudSpeaker = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Config {
        public static final String AUDIO_JITTER_BREAK_THRESHOLD_MS = "audio_jitter_break_threshold_ms";
        public static final String AV_RETRY_TIME = "av_retry_time";
        public static final String CAMERA_CHECK_POSITION = "camera_check_position";
        public static final String PLAY_CLEAR_LAST_FRAME = "play_clear_last_frame";
        public static final String PREFER_PLAY_ULTRA_SOURCE = "prefer_play_ultra_source";
        public static final String PREVIEW_CLEAR_LAST_FRAME = "preview_clear_last_frame";
        public static final String ROOM_RETRY_TIME = "room_retry_time";
        public static final String TRANSFORM_HTTP_TO_HTTPS_ON_INIT = "transform_http_to_https_on_init";
        public static final String VCAP_EXTERNAL_HANDLE_ROTATION = "vcap_external_handle_rotation";
        public static final String VIDEO_ACCELERATOR_WHITELIST = "video_accelerator_whitelist";
        public static final String VIDEO_JITTER_BREAK_THRESHOLD_MS = "video_jitter_break_threshold_ms";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DeviceError {
        public static final int DeviceErrorGeneric = -1;
        public static final int DeviceErrorInUseByOther = -5;
        public static final int DeviceErrorInvalidID = -2;
        public static final int DeviceErrorNoAuthorization = -3;
        public static final int DeviceErrorZeroFPS = -4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DeviceErrorReason {
        public static final int Disabled = 2;
        public static final int GenericError = -1;
        public static final int InBackground = 5;
        public static final int InUseByOther = -5;
        public static final int InUseBySiri = -9;
        public static final int Interruption = 4;
        public static final int InvalidID = -2;
        public static final int MagneticCase = -11;
        public static final int MediaServiceLost = -8;
        public static final int Mute = 3;
        public static final int NoAuthorization = -3;
        public static final int None = 0;
        public static final int RebootRequired = -7;
        public static final int SoundLevelTooLow = -10;
        public static final int Unplugged = -6;
        public static final int ZeroFPS = -4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DeviceNameType {
        public static final String DeviceNameCamera = "camera";
        public static final String DeviceNameMicrophone = "microphone";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DeviceStatus {
        public static final int DEVICE_STATUS_CLOSE = 1;
        public static final int DEVICE_STATUS_OPEN = 0;
        public static final int DEVICE_STATUS_UNKNOWN = -1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ErrorMask {
        public static final int NerworkErrorMask = 4096;
        public static final int ReloginErrorMask = 65536;
        public static final int RoomServerErrorMask = 1048576;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class LatencyMode {
        public static final int Low = 1;
        public static final int Low2 = 3;
        public static final int Low3 = 4;
        public static final int Normal = 0;
        public static final int Normal2 = 2;
        public static final int Normal3 = 5;
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MediaInfoType {
        public static final int SeiUserUnregisted = 2;
        public static final int SeiZegoDefined = 1;
        public static final int SideInfoZegoDefined = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ModuleType {
        public static final int AUDIO = 12;
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class PublishChannelIndex {
        public static final int AUX = 1;
        public static final int FOURTH = 3;
        public static final int MAIN = 0;
        public static final int THIRD = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class PublishConfig {
        public static final String KEY_PUBLISH_CDN_TARGET = "publish_cdn_target";
        public static final String KEY_PUBLISH_CUSTOM_TARGET = "publish_custom_target";

        @Deprecated
        public static final String PUBLISH_CUSTOM_TARGET = "publishCustomTarget";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class PublishFlag {
        public static final int JoinPublish = 0;
        public static final int MixStream = 2;
        public static final int SingleAnchor = 4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ResultCode {
        public static final int NO = 1;
        public static final int YES = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class RoomError {
        public static final int DatiCommitError = 3001;
        public static final int DatiRepeatError = 3003;
        public static final int DatiTimeoutError = 3002;
        public static final int LoginNetChangeError = 104;
        public static final int LoginNetworkError = 101;
        public static final int LoginPushError = 102;
        public static final int LoginServerError = 103;
        public static final int NotLoginError = 105;
        public static final int RequestParamError = 106;
        public static final int SessionError = 141;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class RoomRole {
        public static final int Anchor = 1;
        public static final int Audience = 2;
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SeiSendType {
        public static final int SeiSendInVideoFrame = 1;
        public static final int SeiSendSingleFrame = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class StreamKey {
        public static final String FLV_URL_LIST = "flvList";
        public static final String HLS_URL_LST = "hlsList";
        public static final String MIX_CONFIG_SEQ = "mixConfigSeq";
        public static final String MIX_NON_EXISTS_STREAM = "nonExists";
        public static final String MIX_STREAM_HEIGHT = "mixStreamHeight";
        public static final String MIX_STREAM_ID = "mixStreamID";
        public static final String MIX_STREAM_WIDTH = "mixStreamWidth";
        public static final String RTMP_URL_LIST = "rtmpList";
        public static final String STREAM_ID = "streamID";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class StreamUpdateType {
        public static final int Added = 2001;
        public static final int Deleted = 2002;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class VideoEncoderRateControlStrategy {
        public static final int ABR = 0;
        public static final int CBR = 1;
        public static final int CRF = 3;
        public static final int VBR = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class VideoStreamLayer {
        public static final int VideoStreamLayer_Auto = -1;
        public static final int VideoStreamLayer_BaseLayer = 0;
        public static final int VideoStreamLayer_ExtendLayer = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoCapturePipelineScaleMode {
        public static final int POST = 1;
        public static final int PRE = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoFeedbackType {
        public static final int Complaint = 3;
        public static final int Help = 2;
        public static final int Normal = 0;
        public static final int Switch = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoGeoFenceAeraCode {
        public static final int AS = 5;
        public static final int CN = 2;
        public static final int EU = 4;
        public static final int IN = 6;
        public static final int NA = 3;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoGeoFenceType {
        public static final int Exclude = 2;
        public static final int Include = 1;
        public static final int None = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoLiveQuality {
        public static final int Die = 4;
        public static final int Excellent = 0;
        public static final int Good = 1;
        public static final int Middle = 2;
        public static final int Poor = 3;
        public static final int Unknown = -1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoRoomMode {
        public static final int MultiRoom = 1;
        public static final int SingleRoom = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoStreamCensorshipMode {
        public static final int CensorshipAudio = 1;
        public static final int CensorshipAudioAndVideo = 3;
        public static final int CensorshipNone = 0;
        public static final int CensorshipVideo = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoTrafficControlMinVideoBitrateMode {
        public static final int ZEGOAPI_MIN_VIDEO_BITRATE_NO_VIDEO = 0;
        public static final int ZEGOAPI_MIN_VIDEO_BITRATE_ULTRA_LOW_FPS = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoTrafficControlProperty {
        public static final int ZEGOAPI_TRAFFIC_CONTROL_ADAPTIVE_FPS = 1;
        public static final int ZEGOAPI_TRAFFIC_CONTROL_AUDIO_BITRATE = 4;
        public static final int ZEGOAPI_TRAFFIC_CONTROL_BASIC = 0;
        public static final int ZEGOAPI_TRAFFIC_CONTROL_RESOLUTION = 2;
        public static final int ZEGOAPI_TRAFFIC_FPS = 1;
        public static final int ZEGOAPI_TRAFFIC_NONE = 0;
        public static final int ZEGOAPI_TRAFFIC_RESOLUTION = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVideoCodecAvc {
        public static final int VIDEO_CODEC_DEFAULT = 0;
        public static final int VIDEO_CODEC_H265 = 3;
        public static final int VIDEO_CODEC_MULTILAYER = 1;
        public static final int VIDEO_CODEC_UNKNOWN = 100;
        public static final int VIDEO_CODEC_VP8 = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVideoMirrorMode {
        public static final int VIDEO_MIRROR_MODE_PREVIEW_MIRROR_PUBLISH_NO_MIRROR = 0;
        public static final int VIDEO_MIRROR_MODE_PREVIEW_NO_MIRROR_PUBLISH_MIRROR = 3;
        public static final int VIDEO_MIRROR_MODE_PREVIEW_PUBLISH_BOTH_MIRROR = 1;
        public static final int VIDEO_MIRROR_MODE_PREVIEW_PUBLISH_BOTH_NO_MIRROR = 2;
    }
}
