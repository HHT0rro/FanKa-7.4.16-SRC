package com.zego.zegoavkit2;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoConstants {
    public static final String KEY_FLV_URL_LIST = "flvList";
    public static final String KEY_HLS_URL_LST = "hlsList";
    public static final String KEY_MIX_STREAM_ID = "mixStreamID";
    public static final String KEY_PUBLISH_CDN_TARGET = "publish_cdn_target";
    public static final String KEY_PUBLISH_CUSTOM_TARGET = "publish_custom_target";
    public static final String KEY_RTMP_URL_LIST = "rtmpList";
    public static final String KEY_STREAM_ID = "streamID";
    public static final String ZegoVideoDataAuxPublishingStream = " ";
    public static final String ZegoVideoDataMainPublishingStream = "";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AECMode {
        public static final int aggressive = 0;
        public static final int medium = 1;
        public static final int soft = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioDeviceType {
        public static final int Input = 0;
        public static final int Output = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioRouteType {
        public static final int AirPlay = 5;
        public static final int Bluetooth = 2;
        public static final int EarPhone = 1;
        public static final int LoudSpeaker = 0;
        public static final int Receiver = 3;
        public static final int UsbAudio = 4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class AudioVADType {
        public static final int noise = 0;
        public static final int speech = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CDNProtocol {
        public static final int QUIC = 2;
        public static final int TCP = 1;
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
        public static final int MultiForegroundApp = 6;
        public static final int Mute = 3;
        public static final int NoAuthorization = -3;
        public static final int None = 0;
        public static final int RebootRequired = -7;
        public static final int SoundLevelTooLow = -10;
        public static final int SystemPressure = 7;
        public static final int Unplugged = -6;
        public static final int ZeroFPS = -4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class EncodeProfile {
        public static final int baseline = 0;
        public static final int high = 2;
        public static final int main = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class HttpDNSType {
        public static final int ALIYUN = 3;
        public static final int NONE = 0;
        public static final int TENCENT = 2;
        public static final int WANGSU = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MediaInfoType {
        public static final int SeiUserUnregisted = 2;
        public static final int SeiZegoDefined = 1;
        public static final int SideInfoZegoDefined = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NetType {
        public static final int Line = 1;
        public static final int Mobile2G = 3;
        public static final int Mobile3G = 4;
        public static final int Mobile4G = 5;
        public static final int Mobile5G = 6;
        public static final int None = 0;
        public static final int UNKNOWN = 32;
        public static final int Wifi = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class PublishChannelIndex {
        public static final int AUX = 1;
        public static final int MAIN = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SeiSendType {
        public static final int SeiSendInVideoFrame = 1;
        public static final int SeiSendSingleFrame = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TrafficControlFocusOn {
        public static final int FocusOnLocalOnly = 0;
        public static final int FocusOnRemote = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoAPIErrorCode {
        public static final int AudioDeviceEngineError = 5102;
        public static final int ExternalAudioDeviceWasNotEnabled = 5101;
        public static final int InvalidParameter = 1;
        public static final int OK = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoAlphaLayoutType {
        public static final int BOTTOM = 3;
        public static final int LEFT = 1;
        public static final int NONE = 0;
        public static final int RIGHT = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoAudioMixMode {
        public static final int Focused = 1;
        public static final int Raw = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoAudioSourceType {
        public static final int AUDIO_SRC_EXTERNAL_CAPTURE = 2;
        public static final int AUDIO_SRC_MAIN_PUBLISH_CHN = 4;
        public static final int AUDIO_SRC_MEDIA_CAPTURE = 3;
        public static final int AUDIO_SRC_MIC = 1;
        public static final int AUDIO_SRC_NONE = 0;
        public static final int AUDIO_SRC_PLAYER = 5;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoBackgroundBlurLevel {
        public static final int HIGH = 0;
        public static final int LOW = 0;
        public static final int MEDIUM = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoBackgroundProcessType {
        public static final int BLUR = 2;
        public static final int COLOR = 1;
        public static final int IMAGE = 3;
        public static final int TRANSPARENT = 0;
        public static final int VIDEO = 4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoCodecError {
        public static final int Failed = -2;
        public static final int LowFPS = -3;
        public static final int None = 0;
        public static final int NotSupport = -1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoDumpDataType {
        public static final int AUDIO = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoLowlightEnhanceMode {
        public static final int ZEGO_LOWLIGHT_ENHANCE_MODE_AUTO = 2;
        public static final int ZEGO_LOWLIGHT_ENHANCE_MODE_OFF = 0;
        public static final int ZEGO_LOWLIGHT_ENHANCE_MODE_ON = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoMediaStreamType {
        public static final int AUDIO = 0;
        public static final int AV = 2;
        public static final int VIDEO = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoObjectSegmentationState {
        public static final int OFF = 0;
        public static final int ON = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoObjectSegmentationType {
        public static final int ANY_BACKGROUND = 0;
        public static final int GREEN_SCREEN_BACKGROUND = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoOrientationMode {
        public static final int ZEGO_ORIENTATION_MODE_ADAPTION = 1;
        public static final int ZEGO_ORIENTATION_MODE_ALIGNMENT = 2;
        public static final int ZEGO_ORIENTATION_MODE_CUSTOM = 0;
        public static final int ZEGO_ORIENTATION_MODE_FIXED_RESOLUTION_RATIO = 3;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoPublishFlag {
        public static final int JOIN_PUBLISH = 0;
        public static final int MIX_STREAM = 2;
        public static final int SINGLE_ANCHOR = 4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoResourceType {
        public static final int RESOURCE_TYPE_CDN = 0;
        public static final int RESOURCE_TYPE_L3 = 2;
        public static final int RESOURCE_TYPE_RTC = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVideoCodecAvc {
        public static final int VIDEO_CODEC_DEFAULT = 0;
        public static final int VIDEO_CODEC_H264_DUAL_STREAM = 4;
        public static final int VIDEO_CODEC_H265 = 3;
        public static final int VIDEO_CODEC_MULTILAYER = 1;
        public static final int VIDEO_CODEC_UNKNOWN = 100;
        public static final int VIDEO_CODEC_VP8 = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVideoCodecBackend {
        public static final int VIDEO_CODEC_BACKEND_ANY = 0;
        public static final int VIDEO_CODEC_BACKEND_HARDWARE = 2;
        public static final int VIDEO_CODEC_BACKEND_SOFTWARE = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVideoConfigPreference {
        public static final int BALANCED = 2;
        public static final int CLEAR = 1;
        public static final int SMOOTH = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVideoMirrorMode {
        public static final int VIDEO_MIRROR_MODE_PREVIEW_MIRROR_PUBLISH_NO_MIRROR = 0;
        public static final int VIDEO_MIRROR_MODE_PREVIEW_NO_MIRROR_PUBLISH_MIRROR = 3;
        public static final int VIDEO_MIRROR_MODE_PREVIEW_PUBLISH_BOTH_MIRROR = 1;
        public static final int VIDEO_MIRROR_MODE_PREVIEW_PUBLISH_BOTH_NO_MIRROR = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ZegoVideoSourceType {
        public static final int VIDEO_SRC_CAMERA = 2;
        public static final int VIDEO_SRC_DEFAULT = 0;
        public static final int VIDEO_SRC_EXTERNAL_CAPTURE = 3;
        public static final int VIDEO_SRC_MAIN_PUBLISH_CHN = 4;
        public static final int VIDEO_SRC_NONE = 1;
        public static final int VIDEO_SRC_PLAYER = 5;
        public static final int VIDEO_SRC_SCREEN_CAPTURE = 6;
    }
}
