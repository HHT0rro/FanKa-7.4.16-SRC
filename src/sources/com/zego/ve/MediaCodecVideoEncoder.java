package com.zego.ve;

import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MediaCodecVideoEncoder extends MediaCodec.Callback {
    private static final double BITRATE_CORRECTION_MAX_SCALE = 2.0d;
    private static final double BITRATE_CORRECTION_SEC = 3.0d;
    private static final int BITRATE_CORRECTION_STEPS = 10;
    private static final int COLOR_FormatYUV420Flexible = 2135033992;
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int DEQUEUE_TIMEOUT = 0;
    private static final String[] H264_HW_EXCEPTION_MODELS;
    private static final String H264_MIME_TYPE = "video/avc";
    private static final String[] H265_HW_EXCEPTION_MODELS;
    private static final String HEVC_MIME_TYPE = "video/hevc";
    private static final String[] HW_BLACKLISTS;
    private static final int MAXIMUM_INITIAL_FPS = 60;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaCodecVideoEncoder";
    private static final int VIDEO_ControlRateCQ = 0;
    private static final int VIDEO_ControlRateConstant = 2;
    private static final int VIDEO_ControlRateVariable = 1;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static final MediaCodecProperties amlogicH264HwProperties;
    private static int codecErrors;
    private static boolean enableWhitelist;
    private static MediaCodecVideoEncoderErrorCallback errorCallback;
    private static final MediaCodecProperties exynosH264HwProperties;
    private static final MediaCodecProperties exynosHEVCHwProperties;
    private static final MediaCodecProperties exynosVp8HwProperties;
    private static final MediaCodecProperties freescaleH264HwProperties;
    private static final MediaCodecProperties[] h264HwList;
    private static final MediaCodecProperties[] hevcHwList;
    private static Set<String> hwEncoderDisabledTypes = new HashSet();
    private static final MediaCodecProperties intelH264HwProperties;
    private static final MediaCodecProperties intelVp8HwProperties;
    private static final MediaCodecProperties kirin960H264HwProperties;
    private static final MediaCodecProperties kirin960HEVCHwProperties;
    private static final MediaCodecProperties kirinH264HwProperties;
    private static final MediaCodecProperties kirinHEVCHwProperties;
    private static final MediaCodecProperties mstarH264HwProperties;
    private static final MediaCodecProperties mtkH264HwProperties;
    private static final MediaCodecProperties mtkHEVCHwProperties;
    private static final MediaCodecProperties nvidiaH264HwProperties;
    private static final MediaCodecProperties qcomH264HwProperties;
    private static final MediaCodecProperties qcomHEVCHwProperties;
    private static final MediaCodecProperties qcomVp8HwProperties;
    private static final MediaCodecProperties rkH264HwProperties;
    private static MediaCodecVideoEncoder runningInstance;
    private static final MediaCodecProperties sprdH264HwProperties;
    private static final int[] supportedColorList;
    private static final int[] supportedSurfaceColorList;
    private static final MediaCodecProperties tiH264HwProperties;
    private static final MediaCodecProperties[] vp8HwList;
    private static final MediaCodecProperties winnerH264HwProperties;
    private double bitrateAccumulator;
    private double bitrateAccumulatorMax;
    private int bitrateAdjustmentScaleExp;
    private double bitrateObservationTimeMs;
    private int colorFormat;
    private long forcedKeyFrameMs;
    private int height;
    private ByteBuffer[] inputBuffers;
    private Surface inputSurface;
    private long lastKeyFrameMs;
    private MediaCodec mediaCodec;
    private Thread mediaCodecThread;
    private int originFps;
    private ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;
    private int targetBitrateBps;
    private int targetFps;
    private VideoCodecType type;
    private int width;
    private BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
    private ByteBuffer configData = null;
    private VImage cacheImage = new VImage();
    private boolean isRunning = false;
    private long pthis = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum BitrateAdjustmentType {
        NO_ADJUSTMENT,
        FRAMERATE_ADJUSTMENT,
        DYNAMIC_ADJUSTMENT
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EncoderProperties {
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecName;
        public final int colorFormat;
        public final int rcMode;
        public final boolean supportedHighProfile;
        public final boolean supportedProfile;

        public EncoderProperties(String str, int i10, BitrateAdjustmentType bitrateAdjustmentType, int i11, boolean z10, boolean z11) {
            this.codecName = str;
            this.colorFormat = i10;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
            this.rcMode = i11;
            this.supportedProfile = z10;
            this.supportedHighProfile = z11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class MediaCodecProperties {
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecPrefix;
        public final int minSdk;

        public MediaCodecProperties(String str, int i10, BitrateAdjustmentType bitrateAdjustmentType) {
            this.codecPrefix = str;
            this.minSdk = i10;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface MediaCodecVideoEncoderErrorCallback {
        void onMediaCodecVideoEncoderCriticalError(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class OutputBufferInfo {
        public final ByteBuffer buffer;
        public final int index;
        public final boolean isKeyFrame;
        public final long presentationTimestampUs;
        public final int size;

        public OutputBufferInfo(int i10, ByteBuffer byteBuffer, int i11, boolean z10, long j10) {
            this.index = i10;
            this.buffer = byteBuffer;
            this.size = i11;
            this.isKeyFrame = z10;
            this.presentationTimestampUs = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class VImage {
        private boolean isI420;
        private ByteBuffer uBuffer;
        private int uStride;
        private ByteBuffer vBuffer;
        private int vStride;
        private ByteBuffer yBuffer;
        private int yStride;

        private VImage() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum VideoCodecType {
        VIDEO_CODEC_H264_AVC,
        VIDEO_CODEC_H264_AVC_MULTILAYER,
        VIDEO_CODEC_H265,
        VIDEO_CODEC_VP8
    }

    static {
        BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
        MediaCodecProperties mediaCodecProperties = new MediaCodecProperties("OMX.qcom.", 19, bitrateAdjustmentType);
        qcomVp8HwProperties = mediaCodecProperties;
        MediaCodecProperties mediaCodecProperties2 = new MediaCodecProperties("OMX.Exynos.", 23, bitrateAdjustmentType);
        exynosVp8HwProperties = mediaCodecProperties2;
        MediaCodecProperties mediaCodecProperties3 = new MediaCodecProperties("OMX.Intel.", 21, bitrateAdjustmentType);
        intelVp8HwProperties = mediaCodecProperties3;
        vp8HwList = new MediaCodecProperties[]{mediaCodecProperties, mediaCodecProperties2, mediaCodecProperties3};
        MediaCodecProperties mediaCodecProperties4 = new MediaCodecProperties("OMX.qcom.", 19, bitrateAdjustmentType);
        qcomH264HwProperties = mediaCodecProperties4;
        MediaCodecProperties mediaCodecProperties5 = new MediaCodecProperties("OMX.Exynos.", 21, bitrateAdjustmentType);
        exynosH264HwProperties = mediaCodecProperties5;
        MediaCodecProperties mediaCodecProperties6 = new MediaCodecProperties("OMX.MTK.", 19, bitrateAdjustmentType);
        mtkH264HwProperties = mediaCodecProperties6;
        MediaCodecProperties mediaCodecProperties7 = new MediaCodecProperties("OMX.IMG.", 19, bitrateAdjustmentType);
        kirinH264HwProperties = mediaCodecProperties7;
        MediaCodecProperties mediaCodecProperties8 = new MediaCodecProperties("OMX.rk.", 19, bitrateAdjustmentType);
        rkH264HwProperties = mediaCodecProperties8;
        MediaCodecProperties mediaCodecProperties9 = new MediaCodecProperties("OMX.hisi.", 19, bitrateAdjustmentType);
        kirin960H264HwProperties = mediaCodecProperties9;
        MediaCodecProperties mediaCodecProperties10 = new MediaCodecProperties("OMX.allwinner.", 19, bitrateAdjustmentType);
        winnerH264HwProperties = mediaCodecProperties10;
        MediaCodecProperties mediaCodecProperties11 = new MediaCodecProperties("OMX.TI.", 19, bitrateAdjustmentType);
        tiH264HwProperties = mediaCodecProperties11;
        MediaCodecProperties mediaCodecProperties12 = new MediaCodecProperties("OMX.MS.", 19, bitrateAdjustmentType);
        mstarH264HwProperties = mediaCodecProperties12;
        MediaCodecProperties mediaCodecProperties13 = new MediaCodecProperties("OMX.Freescale.", 19, bitrateAdjustmentType);
        freescaleH264HwProperties = mediaCodecProperties13;
        MediaCodecProperties mediaCodecProperties14 = new MediaCodecProperties("OMX.sprd.", 19, bitrateAdjustmentType);
        sprdH264HwProperties = mediaCodecProperties14;
        MediaCodecProperties mediaCodecProperties15 = new MediaCodecProperties("OMX.amlogic.", 19, bitrateAdjustmentType);
        amlogicH264HwProperties = mediaCodecProperties15;
        MediaCodecProperties mediaCodecProperties16 = new MediaCodecProperties("OMX.Intel.", 19, bitrateAdjustmentType);
        intelH264HwProperties = mediaCodecProperties16;
        MediaCodecProperties mediaCodecProperties17 = new MediaCodecProperties("OMX.Nvidia.", 19, bitrateAdjustmentType);
        nvidiaH264HwProperties = mediaCodecProperties17;
        h264HwList = new MediaCodecProperties[]{mediaCodecProperties4, mediaCodecProperties5, mediaCodecProperties6, mediaCodecProperties7, mediaCodecProperties9, mediaCodecProperties11, mediaCodecProperties16, mediaCodecProperties17, mediaCodecProperties8, mediaCodecProperties10, mediaCodecProperties12, mediaCodecProperties13, mediaCodecProperties14, mediaCodecProperties15};
        MediaCodecProperties mediaCodecProperties18 = new MediaCodecProperties("OMX.qcom.", 21, bitrateAdjustmentType);
        qcomHEVCHwProperties = mediaCodecProperties18;
        MediaCodecProperties mediaCodecProperties19 = new MediaCodecProperties("OMX.hisi.", 21, bitrateAdjustmentType);
        kirin960HEVCHwProperties = mediaCodecProperties19;
        MediaCodecProperties mediaCodecProperties20 = new MediaCodecProperties("OMX.IMG.", 21, bitrateAdjustmentType);
        kirinHEVCHwProperties = mediaCodecProperties20;
        MediaCodecProperties mediaCodecProperties21 = new MediaCodecProperties("OMX.MTK.", 21, bitrateAdjustmentType);
        mtkHEVCHwProperties = mediaCodecProperties21;
        MediaCodecProperties mediaCodecProperties22 = new MediaCodecProperties("OMX.Exynos.", 21, bitrateAdjustmentType);
        exynosHEVCHwProperties = mediaCodecProperties22;
        hevcHwList = new MediaCodecProperties[]{mediaCodecProperties18, mediaCodecProperties19, mediaCodecProperties20, mediaCodecProperties21, mediaCodecProperties22};
        H264_HW_EXCEPTION_MODELS = new String[]{"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "EML-AL00", "XT1079", "PACM00", "SM-G9250", "V1818CA"};
        H265_HW_EXCEPTION_MODELS = new String[]{"V1818CA", "X600"};
        enableWhitelist = true;
        HW_BLACKLISTS = new String[]{"omx.google.", "omx.ffmpeg.", "omx.pv", "omx.k3.ffmpeg.", "omx.avcodec.", "omx.ittiam.", "omx.sec.avc.sw.", "omx.marvell.video.h264encoder"};
        supportedColorList = new int[]{21, COLOR_FormatYUV420Flexible, 2141391872, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m, 19, 20, 2130706688, 2130708361};
        supportedSurfaceColorList = new int[]{2130708361};
    }

    private void checkOnMediaCodecThread() {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new RuntimeException("MediaCodecVideoEncoder previously operated on " + ((Object) this.mediaCodecThread) + " but is now called on " + ((Object) Thread.currentThread()));
    }

    public static MediaCodec createByCodecName(String str) {
        try {
            return MediaCodec.createByCodecName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void disableH264HwCodec() {
        hwEncoderDisabledTypes.add("video/avc");
    }

    public static void disableHEVCHwCodec() {
        hwEncoderDisabledTypes.add(HEVC_MIME_TYPE);
    }

    public static void disableVp8HwCodec() {
        hwEncoderDisabledTypes.add(VP8_MIME_TYPE);
    }

    public static void disableVp9HwCodec() {
        hwEncoderDisabledTypes.add(VP9_MIME_TYPE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static EncoderProperties findHwEncoder(String str, MediaCodecProperties[] mediaCodecPropertiesArr, int[] iArr, int i10) {
        MediaCodecInfo mediaCodecInfo;
        String str2;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        MediaCodecProperties[] mediaCodecPropertiesArr2 = mediaCodecPropertiesArr;
        EncoderProperties encoderProperties = null;
        if (str.equals("video/avc")) {
            List asList = Arrays.asList(H264_HW_EXCEPTION_MODELS);
            String str3 = Build.MODEL;
            if (asList.contains(str3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Model: ");
                sb2.append(str3);
                sb2.append(" has black listed H.264 encoder.");
                return null;
            }
        } else if (str.equals(HEVC_MIME_TYPE)) {
            List asList2 = Arrays.asList(H265_HW_EXCEPTION_MODELS);
            String str4 = Build.MODEL;
            if (asList2.contains(str4)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Model: ");
                sb3.append(str4);
                sb3.append(" has black listed H.265 encoder.");
                return null;
            }
        }
        int i11 = 0;
        while (i11 < MediaCodecList.getCodecCount()) {
            try {
                try {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i11);
                } catch (IllegalArgumentException unused) {
                    mediaCodecInfo = encoderProperties;
                }
                if (mediaCodecInfo != 0 && mediaCodecInfo.isEncoder()) {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length) {
                            str2 = encoderProperties;
                            break;
                        }
                        if (supportedTypes[i12].equals(str)) {
                            str2 = mediaCodecInfo.getName();
                            break;
                        }
                        i12++;
                    }
                    if (str2 != 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Found candidate encoder ");
                        sb4.append(str2);
                        BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
                        if (enableWhitelist) {
                            int length2 = mediaCodecPropertiesArr2.length;
                            int i13 = 0;
                            while (true) {
                                if (i13 >= length2) {
                                    z11 = false;
                                    break;
                                }
                                MediaCodecProperties mediaCodecProperties = mediaCodecPropertiesArr2[i13];
                                if (str2.startsWith(mediaCodecProperties.codecPrefix)) {
                                    int i14 = Build.VERSION.SDK_INT;
                                    if (i14 < mediaCodecProperties.minSdk) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("Codec ");
                                        sb5.append(str2);
                                        sb5.append(" is disabled due to SDK version ");
                                        sb5.append(i14);
                                    } else {
                                        BitrateAdjustmentType bitrateAdjustmentType2 = mediaCodecProperties.bitrateAdjustmentType;
                                        if (bitrateAdjustmentType2 != BitrateAdjustmentType.NO_ADJUSTMENT) {
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append("Codec ");
                                            sb6.append(str2);
                                            sb6.append(" requires bitrate adjustment: ");
                                            sb6.append((Object) bitrateAdjustmentType2);
                                            bitrateAdjustmentType = bitrateAdjustmentType2;
                                        }
                                        z11 = true;
                                    }
                                }
                                i13++;
                            }
                        } else {
                            String lowerCase = str2.toLowerCase();
                            String[] strArr = HW_BLACKLISTS;
                            int length3 = strArr.length;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= length3) {
                                    z10 = false;
                                    break;
                                }
                                if (lowerCase.startsWith(strArr[i15])) {
                                    z10 = true;
                                    break;
                                }
                                i15++;
                            }
                            z11 = !z10;
                        }
                        if (z11) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                                for (int i16 : capabilitiesForType.colorFormats) {
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append("Color: 0x");
                                    sb7.append(Integer.toHexString(i16));
                                }
                                for (int i17 : iArr) {
                                    for (int i18 : capabilitiesForType.colorFormats) {
                                        if (i18 == i17) {
                                            StringBuilder sb8 = new StringBuilder();
                                            sb8.append("Found target encoder for mime ");
                                            sb8.append(str);
                                            sb8.append(" : ");
                                            sb8.append(str2);
                                            sb8.append(". Color: 0x");
                                            sb8.append(Integer.toHexString(i18));
                                            sb8.append(". Bitrate adjustment: ");
                                            sb8.append((Object) bitrateAdjustmentType);
                                            int i19 = Build.VERSION.SDK_INT;
                                            MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                                            if (encoderCapabilities == null || i10 == -1 || !encoderCapabilities.isBitrateModeSupported(i10)) {
                                                z12 = false;
                                            } else {
                                                StringBuilder sb9 = new StringBuilder();
                                                sb9.append(i10);
                                                sb9.append("mode is supported");
                                                z12 = true;
                                            }
                                            if (i19 < 23 || !str.equals("video/avc")) {
                                                z13 = false;
                                                z14 = false;
                                            } else {
                                                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, 640, 480);
                                                createVideoFormat.setInteger("profile", 1);
                                                boolean isFormatSupported = capabilitiesForType.isFormatSupported(createVideoFormat);
                                                createVideoFormat.setInteger("profile", 8);
                                                z13 = isFormatSupported;
                                                z14 = capabilitiesForType.isFormatSupported(createVideoFormat);
                                            }
                                            return new EncoderProperties(str2, i18, bitrateAdjustmentType, (z12 || i10 == -1) ? i10 : -1, z13, z14);
                                        }
                                    }
                                }
                            } catch (IllegalArgumentException unused2) {
                                continue;
                            }
                        }
                    }
                }
                i11++;
                mediaCodecPropertiesArr2 = mediaCodecPropertiesArr;
                encoderProperties = null;
            } catch (Exception unused3) {
                printStackTrace();
                return null;
            }
        }
        return encoderProperties;
    }

    private double getBitrateScale(int i10) {
        return Math.pow(BITRATE_CORRECTION_MAX_SCALE, i10 / 10.0d);
    }

    public static String getCodecName() {
        return findHwEncoder("video/avc", h264HwList, supportedColorList, -1).codecName;
    }

    private int getProfileType(String str, int i10, int i11) {
        int i12 = 8;
        if (i10 != 0) {
            i11 = 8;
        }
        if (str.equals("main")) {
            i12 = 2;
        } else if (!str.equals("high")) {
            if (str.equals("high10")) {
                i12 = 16;
            } else if (str.equals("high422")) {
                i12 = 32;
            } else if (str.equals("high444")) {
                i12 = 64;
            } else {
                i12 = str.equals("extended") ? 4 : i11;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("profile: ");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(i12);
        return i12;
    }

    public static boolean isH264HwSupported(boolean z10) {
        enableWhitelist = z10;
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HwList, supportedColorList, -1) == null) ? false : true;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HwList, supportedSurfaceColorList, -1) == null) ? false : true;
    }

    public static boolean isHEVCHwSupported(boolean z10) {
        enableWhitelist = z10;
        return (hwEncoderDisabledTypes.contains(HEVC_MIME_TYPE) || findHwEncoder(HEVC_MIME_TYPE, hevcHwList, supportedColorList, -1) == null) ? false : true;
    }

    public static boolean isVp8HwSupported(boolean z10) {
        return false;
    }

    private static native int on_error(long j10, int i10);

    private static native int on_input_buffer_available(long j10, int i10);

    private static native int on_output_buffer_available(long j10, OutputBufferInfo outputBufferInfo);

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoEncoder mediaCodecVideoEncoder = runningInstance;
        if (mediaCodecVideoEncoder == null || (thread = mediaCodecVideoEncoder.mediaCodecThread) == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stackTraceElement.toString();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void reportEncodedFrame(int r11) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.MediaCodecVideoEncoder.reportEncodedFrame(int):void");
    }

    public static void setErrorCallback(MediaCodecVideoEncoderErrorCallback mediaCodecVideoEncoderErrorCallback) {
        errorCallback = mediaCodecVideoEncoderErrorCallback;
    }

    private boolean setRates(int i10, int i11) {
        checkOnMediaCodecThread();
        BitrateAdjustmentType bitrateAdjustmentType = this.bitrateAdjustmentType;
        BitrateAdjustmentType bitrateAdjustmentType2 = BitrateAdjustmentType.DYNAMIC_ADJUSTMENT;
        if (bitrateAdjustmentType == bitrateAdjustmentType2) {
            double d10 = i10;
            this.bitrateAccumulatorMax = d10 / 8.0d;
            int i12 = this.targetBitrateBps;
            if (i12 > 0 && i10 < i12) {
                this.bitrateAccumulator = (this.bitrateAccumulator * d10) / i12;
            }
        }
        this.targetBitrateBps = i10;
        this.targetFps = i11;
        if (bitrateAdjustmentType == BitrateAdjustmentType.FRAMERATE_ADJUSTMENT && i11 > 0) {
            int i13 = (this.originFps * i10) / i11;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setRates: ");
            sb2.append(i10 / 1000);
            sb2.append(" -> ");
            sb2.append(i13 / 1000);
            sb2.append(" kbps. Fps: ");
            sb2.append(this.targetFps);
            i10 = i13;
        } else if (bitrateAdjustmentType == bitrateAdjustmentType2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("setRates: ");
            sb3.append(i10 / 1000);
            sb3.append(" kbps. Fps: ");
            sb3.append(this.targetFps);
            sb3.append(". ExpScale: ");
            sb3.append(this.bitrateAdjustmentScaleExp);
            int i14 = this.bitrateAdjustmentScaleExp;
            if (i14 != 0) {
                i10 = (int) (i10 * getBitrateScale(i14));
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("setRates: ");
            sb4.append(i10 / 1000);
            sb4.append(" kbps. Fps: ");
            sb4.append(this.targetFps);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i10);
            this.mediaCodec.setParameters(bundle);
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public void checkKeyFrameRequired(boolean z10, long j10) {
        boolean z11;
        long j11 = (j10 + 500) / 1000;
        if (this.lastKeyFrameMs < 0) {
            this.lastKeyFrameMs = j11;
        }
        if (!z10) {
            long j12 = this.forcedKeyFrameMs;
            if (j12 > 0 && j11 > this.lastKeyFrameMs + j12) {
                z11 = true;
                if (!z10 || z11) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("request-sync", 0);
                    this.mediaCodec.setParameters(bundle);
                    this.lastKeyFrameMs = j11;
                }
                return;
            }
        }
        z11 = false;
        if (z10) {
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("request-sync", 0);
        this.mediaCodec.setParameters(bundle2);
        this.lastKeyFrameMs = j11;
    }

    public int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(0L);
        } catch (IllegalStateException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("dequeueIntputBuffer failed");
            sb2.append(e2.getMessage());
            return -2;
        }
    }

    public OutputBufferInfo dequeueOutputBuffer() {
        checkOnMediaCodecThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Config frame generated. Offset: ");
                    sb2.append(bufferInfo.offset);
                    sb2.append(". Size: ");
                    sb2.append(bufferInfo.size);
                    this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                    ByteBuffer byteBuffer = getByteBuffer(false, dequeueOutputBuffer);
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    this.configData.put(byteBuffer);
                    this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                }
            }
            int i10 = dequeueOutputBuffer;
            if (i10 >= 0) {
                ByteBuffer duplicate = getByteBuffer(false, i10).duplicate();
                duplicate.position(bufferInfo.offset);
                duplicate.limit(bufferInfo.offset + bufferInfo.size);
                reportEncodedFrame(bufferInfo.size);
                return new OutputBufferInfo(i10, duplicate.slice(), bufferInfo.size, (bufferInfo.flags & 1) != 0, bufferInfo.presentationTimeUs);
            }
            if (i10 == -3) {
                return dequeueOutputBuffer();
            }
            if (i10 == -2) {
                return dequeueOutputBuffer();
            }
            if (i10 == -1) {
                return null;
            }
            throw new RuntimeException("dequeueOutputBuffer: " + i10);
        } catch (IllegalStateException unused) {
            return new OutputBufferInfo(-1, null, -1, false, -1L);
        }
    }

    public boolean encodeBuffer(boolean z10, int i10, int i11, long j10) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z10, j10);
            this.mediaCodec.queueInputBuffer(i10, 0, i11, j10, 0);
            return true;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean encodeTexture(boolean z10, int i10, float[] fArr, long j10) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z10, j10);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public ByteBuffer getByteBuffer(boolean z10, int i10) {
        return z10 ? this.mediaCodec.getInputBuffer(i10) : this.mediaCodec.getOutputBuffer(i10);
    }

    public VImage getImage(int i10) {
        Image.Plane[] planes = this.mediaCodec.getInputImage(i10).getPlanes();
        this.cacheImage.yBuffer = planes[0].getBuffer();
        this.cacheImage.yStride = planes[0].getRowStride();
        this.cacheImage.uBuffer = planes[1].getBuffer();
        this.cacheImage.uStride = planes[1].getRowStride();
        this.cacheImage.vBuffer = planes[2].getBuffer();
        this.cacheImage.vStride = planes[2].getRowStride();
        if (planes[1].getPixelStride() == 1 && planes[2].getPixelStride() == 1) {
            this.cacheImage.isI420 = true;
        } else {
            this.cacheImage.isI420 = false;
        }
        return this.cacheImage;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0231  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean initEncode(int r21, int r22, int r23, int r24, int r25, boolean r26, int r27, int r28, java.lang.String r29, int r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.MediaCodecVideoEncoder.initEncode(int, int, int, int, int, boolean, int, int, java.lang.String, int, boolean):boolean");
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        MediaCodec mediaCodec2;
        if (this.isRunning && (mediaCodec2 = this.mediaCodec) != null && mediaCodec.equals(mediaCodec2)) {
            printStackTrace();
            on_error(this.pthis, -1);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i10) {
        MediaCodec mediaCodec2;
        if (this.isRunning && (mediaCodec2 = this.mediaCodec) != null && mediaCodec.equals(mediaCodec2)) {
            on_input_buffer_available(this.pthis, i10);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i10, MediaCodec.BufferInfo bufferInfo) {
        MediaCodec mediaCodec2;
        if (this.isRunning && (mediaCodec2 = this.mediaCodec) != null && mediaCodec.equals(mediaCodec2)) {
            if ((bufferInfo.flags & 2) != 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Config frame generated. Offset: ");
                sb2.append(bufferInfo.offset);
                sb2.append(". Size: ");
                sb2.append(bufferInfo.size);
                this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                ByteBuffer byteBuffer = getByteBuffer(false, i10);
                byteBuffer.position(bufferInfo.offset);
                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                this.configData.put(byteBuffer);
                this.mediaCodec.releaseOutputBuffer(i10, false);
                return;
            }
            ByteBuffer duplicate = getByteBuffer(false, i10).duplicate();
            duplicate.position(bufferInfo.offset);
            duplicate.limit(bufferInfo.offset + bufferInfo.size);
            reportEncodedFrame(bufferInfo.size);
            on_output_buffer_available(this.pthis, new OutputBufferInfo(i10, duplicate.slice(), bufferInfo.size, (bufferInfo.flags & 1) != 0, bufferInfo.presentationTimeUs));
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    public void release() {
        if (this.mediaCodecThread == null) {
            return;
        }
        checkOnMediaCodecThread();
        this.isRunning = false;
        if (this.mediaCodec != null) {
            Surface surface = this.inputSurface;
            if (surface != null) {
                surface.release();
                this.inputSurface = null;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable() { // from class: com.zego.ve.MediaCodecVideoEncoder.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MediaCodecVideoEncoder.this.mediaCodec.stop();
                        MediaCodecVideoEncoder.this.mediaCodec.release();
                        MediaCodecVideoEncoder.this.mediaCodec = null;
                    } catch (Exception unused) {
                    }
                    countDownLatch.countDown();
                }
            }).start();
            if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
                codecErrors++;
                if (errorCallback != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invoke codec error callback. Errors: ");
                    sb2.append(codecErrors);
                    errorCallback.onMediaCodecVideoEncoderCriticalError(codecErrors);
                }
            }
        }
        this.mediaCodecThread = null;
        runningInstance = null;
    }

    public boolean releaseOutputBuffer(int i10) {
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(i10, false);
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public int setThis(long j10) {
        this.pthis = j10;
        return 0;
    }

    public void signalEOS() {
        MediaCodec mediaCodec = this.mediaCodec;
        if (mediaCodec == null) {
            return;
        }
        if (this.inputSurface != null) {
            mediaCodec.signalEndOfInputStream();
            return;
        }
        int dequeueInputBuffer = dequeueInputBuffer();
        while (dequeueInputBuffer == -1) {
            try {
                Thread.sleep(100L);
                dequeueInputBuffer = dequeueInputBuffer();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        if (dequeueInputBuffer >= 0) {
            this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        }
    }
}
