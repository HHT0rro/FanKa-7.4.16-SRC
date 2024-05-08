package com.tencent.ugc;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.amap.api.services.core.AMapException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TXRecordCommon {
    public static final int AUDIO_SAMPLERATE_16000 = 16000;
    public static final int AUDIO_SAMPLERATE_32000 = 32000;
    public static final int AUDIO_SAMPLERATE_44100 = 44100;
    public static final int AUDIO_SAMPLERATE_48000 = 48000;
    public static final int AUDIO_SAMPLERATE_8000 = 8000;
    public static final int EVT_CAMERA_CANNOT_USE = 3;
    public static final String EVT_DESCRIPTION = "EVT_DESCRIPTION";
    public static final int EVT_ID_PAUSE = 1;
    public static final int EVT_ID_RESUME = 2;
    public static final int EVT_ID_STARTED = 6;
    public static final int EVT_ID_VIDEO_GENERATED = 5;
    public static final int EVT_MIC_CANNOT_USE = 4;
    public static final String EVT_PARAM1 = "EVT_PARAM1";
    public static final String EVT_PARAM2 = "EVT_PARAM2";
    public static final String EVT_TIME = "EVT_TIME";
    public static final int RECORD_PROFILE_BASELINE = 1;
    public static final int RECORD_PROFILE_DEFAULT = 0;
    public static final int RECORD_PROFILE_HIGH = 3;
    public static final int RECORD_PROFILE_MAIN = 2;
    public static final int RECORD_RESULT_COMPOSE_CANCEL = -7;
    public static final int RECORD_RESULT_COMPOSE_INTERNAL_ERR = -9;
    public static final int RECORD_RESULT_COMPOSE_SET_DST_PATH_ERR = -5;
    public static final int RECORD_RESULT_COMPOSE_SET_SRC_PATH_ERR = -4;
    public static final int RECORD_RESULT_COMPOSE_START_ERR = -6;
    public static final int RECORD_RESULT_COMPOSE_VERIFY_FAIL = -8;
    public static final int RECORD_RESULT_FAILED = -1;
    public static final int RECORD_RESULT_FILE_ERR = -3;
    public static final int RECORD_RESULT_OK = 0;
    public static final int RECORD_RESULT_OK_LESS_THAN_MINDURATION = 1;
    public static final int RECORD_RESULT_OK_REACHED_MAXDURATION = 2;
    public static final int RECORD_RESULT_SUSPEND_FOR_NO_TASK = -2;
    public static final int RECORD_SPEED_FAST = 3;
    public static final int RECORD_SPEED_FASTEST = 4;
    public static final int RECORD_SPEED_NORMAL = 2;
    public static final int RECORD_SPEED_SLOW = 1;
    public static final int RECORD_SPEED_SLOWEST = 0;
    public static final int RECORD_TYPE_STREAM_SOURCE = 1;
    public static final int START_RECORD_ERR_API_IS_LOWER_THAN_18 = -3;
    public static final int START_RECORD_ERR_IS_IN_RECORDING = -1;
    public static final int START_RECORD_ERR_LICENCE_VERIFICATION_FAILED = -5;
    public static final int START_RECORD_ERR_NOT_INIT = -4;
    public static final int START_RECORD_ERR_VIDEO_PATH_IS_EMPTY = -2;
    public static final int START_RECORD_OK = 0;
    public static final int VIDEO_ASPECT_RATIO_16_9 = 3;
    public static final int VIDEO_ASPECT_RATIO_1_1 = 2;
    public static final int VIDEO_ASPECT_RATIO_3_4 = 1;
    public static final int VIDEO_ASPECT_RATIO_4_3 = 4;
    public static final int VIDEO_ASPECT_RATIO_9_16 = 0;
    public static final int VIDEO_QUALITY_HIGH = 3;
    public static final int VIDEO_QUALITY_LMEDIUM = 1;
    public static final int VIDEO_QUALITY_LOW = 0;
    public static final int VIDEO_QUALITY_MEDIUM = 2;
    public static final int VIDEO_RENDER_MIRROR_TYPE_AUTO = 0;
    public static final int VIDEO_RENDER_MIRROR_TYPE_DISABLE = 2;
    public static final int VIDEO_RENDER_MIRROR_TYPE_ENABLE = 1;
    public static final int VIDEO_RENDER_MODE_ADJUST_RESOLUTION = 1;
    public static final int VIDEO_RENDER_MODE_FULL_FILL_SCREEN = 0;
    public static final int VIDEO_RESOLUTION_1080_1920 = 4;
    public static final int VIDEO_RESOLUTION_360_640 = 0;
    public static final int VIDEO_RESOLUTION_480_640 = 1;
    public static final int VIDEO_RESOLUTION_540_960 = 2;
    public static final int VIDEO_RESOLUTION_720_1280 = 3;
    public static final int VIDOE_REVERB_TYPE_0 = 0;
    public static final int VIDOE_REVERB_TYPE_1 = 1;
    public static final int VIDOE_REVERB_TYPE_2 = 2;
    public static final int VIDOE_REVERB_TYPE_3 = 3;
    public static final int VIDOE_REVERB_TYPE_4 = 4;
    public static final int VIDOE_REVERB_TYPE_5 = 5;
    public static final int VIDOE_REVERB_TYPE_6 = 6;
    public static final int VIDOE_REVERB_TYPE_7 = 7;
    public static final int VIDOE_VOICECHANGER_TYPE_0 = 0;
    public static final int VIDOE_VOICECHANGER_TYPE_1 = 1;
    public static final int VIDOE_VOICECHANGER_TYPE_10 = 10;
    public static final int VIDOE_VOICECHANGER_TYPE_11 = 11;
    public static final int VIDOE_VOICECHANGER_TYPE_2 = 2;
    public static final int VIDOE_VOICECHANGER_TYPE_3 = 3;
    public static final int VIDOE_VOICECHANGER_TYPE_4 = 4;
    public static final int VIDOE_VOICECHANGER_TYPE_6 = 6;
    public static final int VIDOE_VOICECHANGER_TYPE_7 = 7;
    public static final int VIDOE_VOICECHANGER_TYPE_8 = 8;
    public static final int VIDOE_VOICECHANGER_TYPE_9 = 9;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ITXBGMNotify {
        void onBGMComplete(int i10);

        void onBGMProgress(long j10, long j11);

        void onBGMStart();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ITXVideoRecordListener {
        void onRecordComplete(TXRecordResult tXRecordResult);

        void onRecordEvent(int i10, Bundle bundle);

        void onRecordProgress(long j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class TXRecordResult {
        public String coverPath;
        public String descMsg;
        public int retCode;
        public String videoPath;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class TXUGCCustomConfig {
        public int profile;
        public int videoResolution = 2;
        public int videoFps = 20;
        public int videoBitrate = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
        public int videoGop = 3;
        public Bitmap watermark = null;
        public int watermarkX = 0;
        public int watermarkY = 0;
        public boolean isFront = true;
        public boolean touchFocus = false;
        public boolean enableHighResolutionCapture = false;
        public int minDuration = 5000;
        public int maxDuration = 60000;
        public int audioSampleRate = 48000;
        public boolean needEdit = true;
        public boolean enableAEC = true;
        public boolean enableANS = true;
        public boolean enableAGC = true;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class TXUGCSimpleConfig {
        public int profile;
        public int videoQuality = 2;
        public Bitmap watermark = null;
        public int watermarkX = 0;
        public int watermarkY = 0;
        public boolean isFront = true;
        public boolean touchFocus = false;
        public int minDuration = 5000;
        public int maxDuration = 60000;
        public boolean needEdit = true;
    }
}
