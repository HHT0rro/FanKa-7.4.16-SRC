package com.tencent.liteav;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TXLiteAVCode {
    public static final int ERR_AUDIO_ENCODE_FAIL = -1304;
    public static final int ERR_AUDIO_PLUGIN_INSTALLED_BUT_NEED_RESTART = -1333;
    public static final int ERR_AUDIO_PLUGIN_INSTALL_FAILED = -1332;
    public static final int ERR_AUDIO_PLUGIN_INSTALL_NOT_AUTHORIZED = -1331;
    public static final int ERR_AUDIO_PLUGIN_START_FAIL = -1330;
    public static final int ERR_BGM_DECODE_FAILED = -4002;
    public static final int ERR_BGM_INVALID_OPERATION = -4004;
    public static final int ERR_BGM_OPEN_FAILED = -4001;
    public static final int ERR_BGM_OVER_LIMIT = -4003;
    public static final int ERR_BUFFER_TYPE_UNSUPPORTED = -1328;
    public static final int ERR_CAMERA_NOT_AUTHORIZED = -1314;
    public static final int ERR_CAMERA_OCCUPY = -1316;
    public static final int ERR_CAMERA_SET_PARAM_FAIL = -1315;
    public static final int ERR_CAMERA_START_FAIL = -1301;
    public static final int ERR_CLOUD_MIX_TRANSCODING_REQUEST_TIME_OUT = -3322;
    public static final int ERR_CLOUD_MIX_TRANSCODING_SERVER_FAILED = -3324;
    public static final int ERR_CONNECT_OTHER_ROOM_AS_AUDIENCE = -3330;
    public static final int ERR_DISCONNECTED = -8;
    public static final int ERR_ENTER_ROOM_PARAM_NULL = -3316;
    public static final int ERR_FAILED = -1;
    public static final int ERR_INVALID_LICENSE = -5;
    public static final int ERR_INVALID_PARAMETER = -2;
    public static final int ERR_MIC_NOT_AUTHORIZED = -1317;
    public static final int ERR_MIC_OCCUPY = -1319;
    public static final int ERR_MIC_SET_PARAM_FAIL = -1318;
    public static final int ERR_MIC_START_FAIL = -1302;
    public static final int ERR_MIC_STOP_FAIL = -1320;
    public static final int ERR_NOT_SUPPORTED = -4;
    public static final int ERR_NO_AVAILABLE_HEVC_DECODERS = -2304;
    public static final int ERR_NULL = 0;
    public static final int ERR_PIXEL_FORMAT_UNSUPPORTED = -1327;
    public static final int ERR_PUBLISH_CDN_STREAM_REQUEST_TIME_OUT = -3321;
    public static final int ERR_PUBLISH_CDN_STREAM_SERVER_FAILED = -3323;
    public static final int ERR_REFUSED = -3;
    public static final int ERR_REQUEST_SERVER_TIMEOUT = -6;
    public static final int ERR_ROOM_ENTER_FAIL = -3301;
    public static final int ERR_ROOM_ID_INVALID = -3318;
    public static final int ERR_ROOM_REQUEST_CONN_ROOM_INVALID_PARAM = -3328;
    public static final int ERR_ROOM_REQUEST_CONN_ROOM_TIMEOUT = -3326;
    public static final int ERR_ROOM_REQUEST_DISCONN_ROOM_TIMEOUT = -3327;
    public static final int ERR_ROOM_REQUEST_ENTER_ROOM_REFUSED = -3340;
    public static final int ERR_ROOM_REQUEST_ENTER_ROOM_TIMEOUT = -3308;
    public static final int ERR_ROOM_REQUEST_IP_TIMEOUT = -3307;
    public static final int ERR_ROOM_REQUEST_START_PUBLISHING_ERROR = -3334;
    public static final int ERR_ROOM_REQUEST_START_PUBLISHING_TIMEOUT = -3333;
    public static final int ERR_ROOM_REQUEST_STOP_PUBLISHING_ERROR = -3336;
    public static final int ERR_ROOM_REQUEST_STOP_PUBLISHING_TIMEOUT = -3335;
    public static final int ERR_SCREEN_CAPTURE_START_FAIL = -1308;
    public static final int ERR_SCREEN_CAPTURE_STOPPED = -7001;
    public static final int ERR_SCREEN_CAPTURE_UNSURPORT = -1309;
    public static final int ERR_SCREEN_SHARE_NOT_AUTHORIZED = -102015;
    public static final int ERR_SCREEN_SHRAE_OCCUPIED_BY_OTHER = -102016;
    public static final int ERR_SDK_APPID_INVALID = -3317;
    public static final int ERR_SERVER_CENTER_ANOTHER_USER_PUSH_SUB_VIDEO = -102016;
    public static final int ERR_SERVER_CENTER_NO_PRIVILEDGE_PUSH_SUB_VIDEO = -102015;
    public static final int ERR_SERVER_INFO_ECDH_GET_TINYID = -100018;
    public static final int ERR_SERVER_INFO_PRIVILEGE_FLAG_ERROR = -100006;
    public static final int ERR_SERVER_INFO_SERVICE_SUSPENDED = -100013;
    public static final int ERR_SERVER_PROCESS_FAILED = -7;
    public static final int ERR_SPEAKER_SET_PARAM_FAIL = -1322;
    public static final int ERR_SPEAKER_START_FAIL = -1321;
    public static final int ERR_SPEAKER_STOP_FAIL = -1323;
    public static final int ERR_TRTC_CONNECT_OTHER_ROOM_AS_AUDIENCE = -3330;
    public static final int ERR_TRTC_CONNECT_OTHER_ROOM_INVALID_PARAMETER = -3328;
    public static final int ERR_TRTC_CONNECT_OTHER_ROOM_TIMEOUT = -3326;
    public static final int ERR_TRTC_CONNECT_SERVER_TIMEOUT = -3308;
    public static final int ERR_TRTC_DISCONNECT_OTHER_ROOM_TIMEOUT = -3327;
    public static final int ERR_TRTC_ENTER_ROOM_FAILED = -3301;
    public static final int ERR_TRTC_ENTER_ROOM_REFUSED = -3340;
    public static final int ERR_TRTC_INVALID_PRIVATE_MAPKEY = -100006;
    public static final int ERR_TRTC_INVALID_ROOM_ID = -3318;
    public static final int ERR_TRTC_INVALID_SDK_APPID = -3317;
    public static final int ERR_TRTC_INVALID_USER_ID = -3319;
    public static final int ERR_TRTC_INVALID_USER_SIG = -3320;
    public static final int ERR_TRTC_MIX_TRANSCODING_FAILED = -3324;
    public static final int ERR_TRTC_MIX_TRANSCODING_TIMEOUT = -3322;
    public static final int ERR_TRTC_PUSH_THIRD_PARTY_CLOUD_FAILED = -3323;
    public static final int ERR_TRTC_PUSH_THIRD_PARTY_CLOUD_TIMEOUT = -3321;
    public static final int ERR_TRTC_REQUEST_IP_TIMEOUT = -3307;
    public static final int ERR_TRTC_ROOM_PARAM_NULL = -3316;
    public static final int ERR_TRTC_SERVICE_SUSPENDED = -100013;
    public static final int ERR_TRTC_START_PUBLISHING_FAILED = -3334;
    public static final int ERR_TRTC_START_PUBLISHING_TIMEOUT = -3333;
    public static final int ERR_TRTC_STOP_PUBLISHING_FAILED = -3336;
    public static final int ERR_TRTC_STOP_PUBLISHING_TIMEOUT = -3335;
    public static final int ERR_TRTC_USER_SIG_CHECK_FAILED = -100018;
    public static final int ERR_UNSUPPORTED_RESOLUTION = -1305;
    public static final int ERR_UNSUPPORTED_SAMPLERATE = -1306;
    public static final int ERR_USER_ID_INVALID = -3319;
    public static final int ERR_USER_SIG_INVALID = -3320;
    public static final int ERR_VIDEO_ENCODE_FAIL = -1303;
    public static final int WARNING_AUDIO_FRAME_DECODE_FAIL = 2102;
    public static final int WARNING_AUDIO_RECORDING_WRITE_FAIL = 7001;
    public static final int WARNING_BLUETOOTH_DEVICE_CONNECT_FAIL = 1207;
    public static final int WARNING_CAMERA_DEVICE_EMPTY = 1111;
    public static final int WARNING_CAMERA_NOT_AUTHORIZED = 1112;
    public static final int WARNING_CURRENT_DECODE_TYPE_CHANGED = 2008;
    public static final int WARNING_CURRENT_ENCODE_TYPE_CHANGED = 1104;
    public static final int WARNING_HW_DECODER_START_FAIL = 2106;
    public static final int WARNING_HW_ENCODER_START_FAIL = 1103;
    public static final int WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE = 6001;
    public static final int WARNING_INSUFFICIENT_CAPTURE_FPS = 1108;
    public static final int WARNING_MICROPHONE_DEVICE_ABNORMAL = 1204;
    public static final int WARNING_MICROPHONE_DEVICE_EMPTY = 1201;
    public static final int WARNING_MICROPHONE_HOWLING_DETECTED = 7002;
    public static final int WARNING_MICROPHONE_IS_OCCUPIED = 1208;
    public static final int WARNING_MICROPHONE_NOT_AUTHORIZED = 1203;
    public static final int WARNING_OUT_OF_MEMORY = 1113;
    public static final int WARNING_REDUCE_CAPTURE_RESOLUTION = 1110;
    public static final int WARNING_SCREEN_CAPTURE_NOT_AUTHORIZED = 1206;
    public static final int WARNING_SPEAKER_DEVICE_ABNORMAL = 1205;
    public static final int WARNING_SPEAKER_DEVICE_EMPTY = 1202;
    public static final int WARNING_SW_DECODER_START_FAIL = 2109;
    public static final int WARNING_SW_ENCODER_START_FAIL = 1109;
    public static final int WARNING_UPSTREAM_AUDIO_AND_VIDEO_OUT_OF_SYNC = 6006;
    public static final int WARNING_VIDEO_DECODER_HW_TO_SW = 2108;
    public static final int WARNING_VIDEO_ENCODER_SW_TO_HW = 1107;
    public static final int WARNING_VIDEO_FRAME_DECODE_FAIL = 2101;
    public static final int WARNING_VIDEO_RENDER_FAIL = 2110;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public @interface ErrorCodeType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public @interface WarningCodeType {
    }
}
