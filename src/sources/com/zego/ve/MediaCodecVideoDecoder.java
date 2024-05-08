package com.zego.ve;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MediaCodecVideoDecoder {
    private static final int DEQUEUE_INPUT_TIMEOUT = 500000;
    private static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String FORMAT_KEY_STRIDE = "stride";
    private static final String H264_MIME_TYPE = "video/avc";
    private static final String HEVC_MIME_TYPE = "video/hevc";
    private static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaCodecVideoDecoder";
    private static final int VIDEO_CODEC_H264 = 2;
    private static final int VIDEO_CODEC_HEVC = 3;
    private static final int VIDEO_CODEC_VP8 = 0;
    private static final int VIDEO_CODEC_VP9 = 1;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors;
    private static MediaCodecVideoDecoderErrorCallback errorCallback;
    private static MediaCodecVideoDecoder runningInstance;
    private int colorFormat;
    private int cropLeft;
    private int cropTop;
    private boolean hasDecodedFirstFrame;
    private int height;
    private ByteBuffer[] inputBuffers;
    private boolean isImageReader;
    private ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;
    private int width;
    private static Set<String> hwDecoderDisabledTypes = new HashSet();
    private static final String[] supportedVp8HwCodecPrefixes = {"OMX.qcom.", "OMX.hisi.", "OMX.IMG.", "OMX.Nvidia.", "OMX.Exynos.", "OMX.Intel."};
    private static final String[] supportedVp9HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos."};
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.MTK.", "OMX.hisi.", "OMX.IMG.", "OMX.k3.", "OMX.TI.", "OMX.rk.", "OMX.amlogic.", "OMX.Intel.", "OMX.Nvidia.", "OMX.allwinner.", "OMX.MS.", "OMX.realtek.", "OMX.Freescale.", "OMX.sprd.", "c2.qti."};
    private static final String[] supportedHEVCHwCodecPrefixes = {"OMX.qcom.", "OMX.hisi.", "OMX.IMG.", "OMX.Intel.", "OMX.MTK", "OMX.Exynos.", "c2.qti."};
    private static final int COLOR_FormatYUV420Flexible = 2135033992;
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int COLOR_QCOM_FormatYUV420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    private static final int[] supportedColorList = {19, COLOR_FormatYUV420Flexible, 21, 2141391872, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m, COLOR_QCOM_FormatYUV420PackedSemiPlanar64x32Tile2m8ka, 2130706688, 2130708361};
    private static final int[] supportedSurfaceColorList = {2130708361, COLOR_FormatYUV420Flexible};
    private static boolean enableWhitelist = true;
    private static final String[] HW_BLACKLISTS = {"omx.google.", "omx.ffmpeg.", "omx.pv", "omx.k3.ffmpeg.", "omx.avcodec.", "omx.ittiam.", "omx.sec.avc.sw.", "omx.marvell.video.h264decoder"};
    private static final String[] HW_SURFACE_BLACKLISTS = {"OMX.MS.", "OMX.MTK"};
    private static final String[] H264_HW_EXCEPTION_MODELS = {"V1818CA"};
    private static final String[] H265_HW_EXCEPTION_MODELS = {"V1818CA"};
    private Thread mediaCodecThread = null;
    private MediaCodec mediaCodec = null;
    private String codecName = null;
    private Surface surface = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class DecoderProperties {
        public final String codecName;
        public final int colorFormat;

        public DecoderProperties(String str, int i10) {
            this.codecName = str;
            this.colorFormat = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface MediaCodecVideoDecoderErrorCallback {
        void onMediaCodecVideoDecoderCriticalError(int i10);
    }

    private void checkOnMediaCodecThread() throws IllegalStateException {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new IllegalStateException("MediaCodecVideoDecoder previously operated on " + ((Object) this.mediaCodecThread) + " but is now called on " + ((Object) Thread.currentThread()));
    }

    private int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(500000L);
        } catch (IllegalStateException unused) {
            return -2;
        }
    }

    private DecodedOutputBuffer dequeueOutputBuffer(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        checkOnMediaCodecThread();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        while (true) {
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(i10));
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer == -1) {
                        return null;
                    }
                    boolean z10 = !this.hasDecodedFirstFrame;
                    this.hasDecodedFirstFrame = true;
                    boolean z11 = (bufferInfo.flags & 4) != 0;
                    if (this.colorFormat != COLOR_FormatYUV420Flexible) {
                        ByteBuffer byteBuffer = getByteBuffer(false, dequeueOutputBuffer);
                        byteBuffer.position(bufferInfo.offset);
                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        return new DecodedOutputBuffer(dequeueOutputBuffer, byteBuffer, bufferInfo.presentationTimeUs, z10, z11);
                    }
                    Image.Plane[] planes = this.mediaCodec.getOutputImage(dequeueOutputBuffer).getPlanes();
                    return new DecodedOutputBuffer(dequeueOutputBuffer, planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), planes[1].getPixelStride() == 1 && planes[2].getPixelStride() == 1, bufferInfo.presentationTimeUs, z10, z11);
                }
                MediaFormat outputFormat = this.mediaCodec.getOutputFormat();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Decoder format changed: ");
                sb2.append(outputFormat.toString());
                if (outputFormat.containsKey(FORMAT_KEY_CROP_LEFT) && outputFormat.containsKey(FORMAT_KEY_CROP_RIGHT) && outputFormat.containsKey(FORMAT_KEY_CROP_BOTTOM) && outputFormat.containsKey(FORMAT_KEY_CROP_TOP)) {
                    this.cropTop = outputFormat.getInteger(FORMAT_KEY_CROP_TOP);
                    this.cropLeft = outputFormat.getInteger(FORMAT_KEY_CROP_LEFT);
                    i11 = (outputFormat.getInteger(FORMAT_KEY_CROP_RIGHT) - this.cropLeft) + 1;
                    i12 = (outputFormat.getInteger(FORMAT_KEY_CROP_BOTTOM) - this.cropTop) + 1;
                } else {
                    this.cropTop = 0;
                    this.cropLeft = 0;
                    i11 = 0;
                    i12 = 0;
                }
                if (outputFormat.containsKey("width") && outputFormat.containsKey("height")) {
                    i13 = outputFormat.getInteger("width");
                    i14 = outputFormat.getInteger("height");
                } else {
                    i13 = 0;
                    i14 = 0;
                }
                if (!this.hasDecodedFirstFrame) {
                    if (i13 != 0 && i14 != 0 && i13 <= this.width && i14 <= this.height) {
                        this.width = i13;
                        this.height = i14;
                    }
                    if (i11 != 0 && i12 != 0 && i11 <= this.width && i12 <= this.height) {
                        this.width = i11;
                        this.height = i12;
                    }
                } else if (i13 != this.width || i14 != this.height) {
                    break;
                }
                if (i14 != 0) {
                    this.sliceHeight = i14;
                }
                if (this.codecName.startsWith("OMX.rk") && this.colorFormat == 21) {
                    this.colorFormat = 21;
                } else if (outputFormat.containsKey("color-format")) {
                    this.colorFormat = outputFormat.getInteger("color-format");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Color: 0x");
                    sb3.append(Integer.toHexString(this.colorFormat));
                }
                if (outputFormat.containsKey(FORMAT_KEY_STRIDE)) {
                    this.stride = outputFormat.getInteger(FORMAT_KEY_STRIDE);
                } else {
                    this.stride = i13;
                }
                if (outputFormat.containsKey(FORMAT_KEY_SLICE_HEIGHT)) {
                    this.sliceHeight = outputFormat.getInteger(FORMAT_KEY_SLICE_HEIGHT);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Output frame stride and slice height: ");
                sb4.append(this.stride);
                sb4.append(" x ");
                sb4.append(this.sliceHeight);
                this.stride = Math.max(this.width, this.stride);
                int i15 = this.colorFormat;
                if ((19 == i15 || 21 == i15) && i14 != this.sliceHeight) {
                    this.sliceHeight = this.height;
                } else {
                    this.sliceHeight = Math.max(this.height, this.sliceHeight);
                }
                this.hasDecodedFirstFrame = false;
            }
        }
        throw new RuntimeException("Unexpected size change. Configured " + this.width + StringUtils.NO_PRINT_CODE + this.height + ". New " + i13 + StringUtils.NO_PRINT_CODE + i14);
    }

    public static void disableH264HwCodec() {
        hwDecoderDisabledTypes.add("video/avc");
    }

    public static void disableHEVCHwCodec() {
        hwDecoderDisabledTypes.add(HEVC_MIME_TYPE);
    }

    public static void disableVp8HwCodec() {
        hwDecoderDisabledTypes.add(VP8_MIME_TYPE);
    }

    public static void disableVp9HwCodec() {
        hwDecoderDisabledTypes.add(VP9_MIME_TYPE);
    }

    private static DecoderProperties findDecoder(String str, String[] strArr, int[] iArr) {
        String str2;
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Trying to find HW decoder for mime ");
        sb2.append(str);
        if (str.equals("video/avc")) {
            List asList = Arrays.asList(H264_HW_EXCEPTION_MODELS);
            String str3 = Build.MODEL;
            if (asList.contains(str3)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Model: ");
                sb3.append(str3);
                sb3.append(" has black listed H.264 decoder.");
                return null;
            }
        } else if (str.equals(HEVC_MIME_TYPE)) {
            List asList2 = Arrays.asList(H265_HW_EXCEPTION_MODELS);
            String str4 = Build.MODEL;
            if (asList2.contains(str4)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Model: ");
                sb4.append(str4);
                sb4.append(" has black listed H.265 decoder.");
                return null;
            }
        }
        for (int i10 = 0; i10 < MediaCodecList.getCodecCount(); i10++) {
            try {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i10);
                if (!codecInfoAt.isEncoder()) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            str2 = null;
                            break;
                        }
                        if (supportedTypes[i11].equals(str)) {
                            str2 = codecInfoAt.getName();
                            break;
                        }
                        i11++;
                    }
                    if (str2 != null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Found candidate decoder ");
                        sb5.append(str2);
                        boolean z11 = true;
                        if (enableWhitelist) {
                            int length2 = strArr.length;
                            int i12 = 0;
                            while (true) {
                                if (i12 >= length2) {
                                    z11 = false;
                                    break;
                                }
                                if (str2.startsWith(strArr[i12])) {
                                    break;
                                }
                                i12++;
                            }
                        } else {
                            String lowerCase = str2.toLowerCase();
                            String[] strArr2 = HW_BLACKLISTS;
                            int length3 = strArr2.length;
                            int i13 = 0;
                            while (true) {
                                if (i13 >= length3) {
                                    z10 = false;
                                    break;
                                }
                                if (lowerCase.startsWith(strArr2[i13])) {
                                    z10 = true;
                                    break;
                                }
                                i13++;
                            }
                            z11 = true ^ z10;
                        }
                        if (z11) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                            for (int i14 : capabilitiesForType.colorFormats) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("Color: 0x");
                                sb6.append(Integer.toHexString(i14));
                            }
                            for (int i15 : iArr) {
                                for (int i16 : capabilitiesForType.colorFormats) {
                                    if (i16 == i15) {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("Found target decoder ");
                                        sb7.append(str2);
                                        sb7.append(". Color: 0x");
                                        sb7.append(Integer.toHexString(i16));
                                        return new DecoderProperties(str2, i16);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("No HW decoder found for mime ");
        sb8.append(str);
        return null;
    }

    private void flush() {
        if (this.mediaCodecThread == null || this.mediaCodec == null) {
            return;
        }
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.flush();
        } catch (Exception unused) {
        }
    }

    public static String getCodecName() {
        return findDecoder("video/avc", supportedH264HwCodecPrefixes, supportedColorList).codecName;
    }

    private int getColorFormat(int i10, Object obj) {
        DecoderProperties decoderInfo;
        String str = "h264";
        if (i10 == 0) {
            decoderInfo = getDecoderInfo(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes, obj != null);
            str = "vp8";
        } else if (i10 == 2) {
            decoderInfo = getDecoderInfo("video/avc", supportedH264HwCodecPrefixes, obj != null);
        } else if (i10 != 3) {
            decoderInfo = null;
        } else {
            decoderInfo = getDecoderInfo(HEVC_MIME_TYPE, supportedHEVCHwCodecPrefixes, obj != null);
            str = "hevc";
        }
        if (decoderInfo == null) {
            return 0;
        }
        int i11 = decoderInfo.colorFormat;
        if (ImageReader.class.isInstance(obj) && decoderInfo.codecName.startsWith("OMX")) {
            i11 = COLOR_FormatYUV420Flexible;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getColorFormat, codec: ");
        sb2.append(str);
        sb2.append(" Color: 0x");
        sb2.append(Integer.toHexString(decoderInfo.colorFormat));
        return i11;
    }

    private DecoderProperties getDecoderInfo(String str, String[] strArr, boolean z10) {
        String str2;
        boolean z11;
        if (str.equals("video/avc")) {
            List asList = Arrays.asList(H264_HW_EXCEPTION_MODELS);
            String str3 = Build.MODEL;
            if (asList.contains(str3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Model: ");
                sb2.append(str3);
                sb2.append(" has black listed H.264 decoder.");
                return null;
            }
        } else if (str.equals(HEVC_MIME_TYPE)) {
            List asList2 = Arrays.asList(H265_HW_EXCEPTION_MODELS);
            String str4 = Build.MODEL;
            if (asList2.contains(str4)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Model: ");
                sb3.append(str4);
                sb3.append(" has black listed H.265 decoder.");
                return null;
            }
        }
        for (int i10 = 0; i10 < MediaCodecList.getCodecCount(); i10++) {
            try {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i10);
                if (!codecInfoAt.isEncoder()) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            str2 = null;
                            break;
                        }
                        if (supportedTypes[i11].equals(str)) {
                            str2 = codecInfoAt.getName();
                            break;
                        }
                        i11++;
                    }
                    if (str2 != null) {
                        boolean z12 = true;
                        if (enableWhitelist) {
                            int length2 = strArr.length;
                            int i12 = 0;
                            while (true) {
                                if (i12 >= length2) {
                                    z12 = false;
                                    break;
                                }
                                if (str2.startsWith(strArr[i12])) {
                                    break;
                                }
                                i12++;
                            }
                        } else {
                            String lowerCase = str2.toLowerCase();
                            String[] strArr2 = HW_BLACKLISTS;
                            int length3 = strArr2.length;
                            int i13 = 0;
                            while (true) {
                                if (i13 >= length3) {
                                    z11 = false;
                                    break;
                                }
                                if (lowerCase.startsWith(strArr2[i13])) {
                                    z11 = true;
                                    break;
                                }
                                i13++;
                            }
                            z12 = true ^ z11;
                        }
                        if (z12) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                            if (z10) {
                                for (int i14 : capabilitiesForType.colorFormats) {
                                    if (i14 >= 1879048192) {
                                        return new DecoderProperties(str2, i14);
                                    }
                                }
                            } else {
                                for (int i15 : capabilitiesForType.colorFormats) {
                                    for (int i16 : supportedColorList) {
                                        if (i15 == i16) {
                                            return new DecoderProperties(str2, i15);
                                        }
                                    }
                                }
                            }
                            return new DecoderProperties(str2, capabilitiesForType.colorFormats[0]);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private Surface getSurface(Object obj, int i10, int i11) {
        if (SurfaceTexture.class.isInstance(obj)) {
            this.isImageReader = false;
            SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
            if (Build.VERSION.SDK_INT >= 24) {
                surfaceTexture.setDefaultBufferSize(i10, i11);
            }
            this.surface = new Surface(surfaceTexture);
        } else if (ImageReader.class.isInstance(obj)) {
            this.isImageReader = true;
            this.surface = ((ImageReader) obj).getSurface();
        }
        return this.surface;
    }

    private boolean initDecode(int i10, int i11, int i12, ByteBuffer byteBuffer, Object obj, boolean z10) {
        String str;
        DecoderProperties findDecoder;
        String str2;
        if (this.mediaCodecThread != null) {
            return false;
        }
        if (i10 == 0) {
            str = VP8_MIME_TYPE;
            findDecoder = findDecoder(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes, supportedColorList);
            str2 = "vp8";
        } else if (i10 == 2) {
            str = "video/avc";
            str2 = "h264";
            findDecoder = findDecoder("video/avc", supportedH264HwCodecPrefixes, supportedColorList);
        } else if (i10 != 3) {
            str = "";
            str2 = "h264";
            findDecoder = null;
        } else {
            str = HEVC_MIME_TYPE;
            findDecoder = findDecoder(HEVC_MIME_TYPE, supportedHEVCHwCodecPrefixes, supportedColorList);
            str2 = "hevc";
        }
        if (findDecoder == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Java initDecode, codec: ");
        sb2.append(str2);
        sb2.append(" Color: 0x");
        sb2.append(Integer.toHexString(findDecoder.colorFormat));
        runningInstance = this;
        this.mediaCodecThread = Thread.currentThread();
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i11, i12);
            if (obj == null) {
                createVideoFormat.setInteger("color-format", findDecoder.colorFormat);
            } else if (SurfaceTexture.class.isInstance(obj)) {
                this.isImageReader = false;
                SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
                if (Build.VERSION.SDK_INT >= 24) {
                    surfaceTexture.setDefaultBufferSize(i11, i12);
                }
                this.surface = new Surface(surfaceTexture);
            } else if (ImageReader.class.isInstance(obj)) {
                this.isImageReader = true;
                this.surface = ((ImageReader) obj).getSurface();
                createVideoFormat.setInteger("color-format", findDecoder.codecName.startsWith("OMX") ? COLOR_FormatYUV420Flexible : findDecoder.colorFormat);
            }
            if (byteBuffer != null) {
                createVideoFormat.setByteBuffer("csd-0", byteBuffer);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Format: ");
            sb3.append((Object) createVideoFormat);
            MediaCodec createByCodecName = MediaCodecVideoEncoder.createByCodecName(findDecoder.codecName);
            this.mediaCodec = createByCodecName;
            if (createByCodecName == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Can not create media decoder: ");
                sb4.append(str2);
                return false;
            }
            if (z10 && findDecoder.codecName.contains("OMX.hisi")) {
                createVideoFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
                createVideoFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
            }
            this.mediaCodec.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
            this.mediaCodec.start();
            String str3 = findDecoder.codecName;
            this.codecName = str3;
            this.colorFormat = findDecoder.colorFormat;
            this.hasDecodedFirstFrame = false;
            this.width = i11;
            this.height = i12;
            if (z10 && !str3.contains("OMX.hisi")) {
                Bundle bundle = new Bundle();
                bundle.putInt("low-latency", 1);
                this.mediaCodec.setParameters(bundle);
            }
            return true;
        } catch (Error unused) {
            printStackTrace();
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean isH264HwSupported(boolean z10) {
        enableWhitelist = z10;
        return (hwDecoderDisabledTypes.contains("video/avc") || findDecoder("video/avc", supportedH264HwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        boolean z10;
        DecoderProperties findDecoder = findDecoder("video/avc", supportedH264HwCodecPrefixes, supportedSurfaceColorList);
        if (findDecoder != null) {
            for (String str : HW_SURFACE_BLACKLISTS) {
                if (!findDecoder.codecName.startsWith(str)) {
                }
            }
            z10 = true;
            return hwDecoderDisabledTypes.contains("video/avc") && findDecoder != null && z10;
        }
        z10 = false;
        if (hwDecoderDisabledTypes.contains("video/avc")) {
        }
    }

    public static boolean isHEVCHwSupported(boolean z10) {
        enableWhitelist = z10;
        return (hwDecoderDisabledTypes.contains(HEVC_MIME_TYPE) || findDecoder(HEVC_MIME_TYPE, supportedHEVCHwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isVp8HwSupported(boolean z10) {
        return (hwDecoderDisabledTypes.contains(VP8_MIME_TYPE) || findDecoder(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isVp9HwSupported(boolean z10) {
        return (hwDecoderDisabledTypes.contains(VP9_MIME_TYPE) || findDecoder(VP9_MIME_TYPE, supportedVp9HwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoDecoder mediaCodecVideoDecoder = runningInstance;
        if (mediaCodecVideoDecoder == null || (thread = mediaCodecVideoDecoder.mediaCodecThread) == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stackTraceElement.toString();
            }
        }
    }

    private boolean queueConfig(int i10, int i11) {
        checkOnMediaCodecThread();
        try {
            ByteBuffer byteBuffer = getByteBuffer(true, i10);
            byteBuffer.position(0);
            byteBuffer.limit(i11);
            this.mediaCodec.queueInputBuffer(i10, 0, i11, 0L, 2);
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private boolean queueEOS(int i10) {
        checkOnMediaCodecThread();
        try {
            ByteBuffer byteBuffer = getByteBuffer(true, i10);
            byteBuffer.position(0);
            byteBuffer.limit(0);
            this.mediaCodec.queueInputBuffer(i10, 0, 0, 0L, 4);
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private boolean queueInputBuffer(int i10, int i11, long j10) {
        checkOnMediaCodecThread();
        try {
            ByteBuffer byteBuffer = getByteBuffer(true, i10);
            byteBuffer.position(0);
            byteBuffer.limit(i11);
            this.mediaCodec.queueInputBuffer(i10, 0, i11, j10, 0);
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private void release() {
        if (this.mediaCodecThread == null || this.mediaCodec == null) {
            return;
        }
        checkOnMediaCodecThread();
        if (this.mediaCodec != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable() { // from class: com.zego.ve.MediaCodecVideoDecoder.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MediaCodecVideoDecoder.this.mediaCodec.stop();
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        MediaCodecVideoDecoder.this.mediaCodec.release();
                        MediaCodecVideoDecoder.this.mediaCodec = null;
                        throw th;
                    }
                    MediaCodecVideoDecoder.this.mediaCodec.release();
                    MediaCodecVideoDecoder.this.mediaCodec = null;
                    if (!MediaCodecVideoDecoder.this.isImageReader && MediaCodecVideoDecoder.this.surface != null) {
                        MediaCodecVideoDecoder.this.surface.release();
                        MediaCodecVideoDecoder.this.surface = null;
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
                    errorCallback.onMediaCodecVideoDecoderCriticalError(codecErrors);
                }
            }
        }
        this.mediaCodecThread = null;
        runningInstance = null;
    }

    public static void setErrorCallback(MediaCodecVideoDecoderErrorCallback mediaCodecVideoDecoderErrorCallback) {
        errorCallback = mediaCodecVideoDecoderErrorCallback;
    }

    private boolean surfaceIsImageReader(Object obj) {
        return ImageReader.class.isInstance(obj);
    }

    public ByteBuffer getByteBuffer(boolean z10, int i10) {
        return z10 ? this.mediaCodec.getInputBuffer(i10) : this.mediaCodec.getOutputBuffer(i10);
    }

    public boolean returnDecodedOutputBuffer(int i10) {
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(i10, this.surface != null);
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public boolean returnDecodedOutputBufferWithTS(int i10, long j10) {
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(i10, j10);
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class DecodedOutputBuffer {
        private ByteBuffer buffer;
        private final boolean eos;
        public final boolean formatChanged;
        private final int index;
        private boolean isI420;
        private final long presentationTimeStampUs;
        private ByteBuffer uBuffer;
        private int uStride;
        private ByteBuffer vBuffer;
        private int vStride;
        private ByteBuffer yBuffer;
        private int yStride;

        public DecodedOutputBuffer(int i10, ByteBuffer byteBuffer, long j10, boolean z10, boolean z11) {
            this.index = i10;
            this.buffer = byteBuffer;
            this.presentationTimeStampUs = j10;
            this.formatChanged = z10;
            this.eos = z11;
        }

        public DecodedOutputBuffer(int i10, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i11, int i12, int i13, boolean z10, long j10, boolean z11, boolean z12) {
            this.index = i10;
            this.yBuffer = byteBuffer;
            this.uBuffer = byteBuffer2;
            this.vBuffer = byteBuffer3;
            this.yStride = i11;
            this.uStride = i12;
            this.vStride = i13;
            this.presentationTimeStampUs = j10;
            this.formatChanged = z11;
            this.eos = z12;
        }
    }
}
