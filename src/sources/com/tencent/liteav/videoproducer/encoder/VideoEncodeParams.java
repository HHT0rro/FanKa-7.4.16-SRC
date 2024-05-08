package com.tencent.liteav.videoproducer.encoder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONException;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class VideoEncodeParams implements Cloneable {
    public boolean annexb;
    public long baseFrameIndex;
    public long baseGopIndex;
    public int bitrate;
    public VideoEncoderDef.BitrateMode bitrateMode;
    public CodecType codecType;
    public boolean enableBFrame;
    public VideoEncoderDef.EncoderComplexity encoderComplexity;
    public VideoEncoderDef.EncoderProfile encoderProfile;
    public int fps;
    public boolean fullIFrame;
    public int gop;
    public int height;
    public boolean isTranscodingMode;
    public JSONArray mediaCodecDeviceRelatedParams;
    public VideoEncoderDef.ReferenceStrategy referenceStrategy;
    public int width;

    @CalledByNative
    public VideoEncodeParams() {
        this.width = 0;
        this.height = 0;
        this.fps = 20;
        this.gop = 3;
        this.bitrate = 0;
        this.annexb = true;
        this.encoderProfile = null;
        this.bitrateMode = VideoEncoderDef.BitrateMode.CBR;
        this.baseFrameIndex = 0L;
        this.baseGopIndex = 0L;
        this.fullIFrame = false;
        this.enableBFrame = false;
        this.referenceStrategy = VideoEncoderDef.ReferenceStrategy.FIX_GOP;
        this.codecType = CodecType.H264;
        this.isTranscodingMode = false;
        this.encoderComplexity = null;
        this.mediaCodecDeviceRelatedParams = null;
    }

    private int checkFieldDiffCounts(Object obj, Object obj2) {
        int i10 = 0;
        for (Field field : VideoEncodeParams.class.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                if (!CommonUtil.equals(field.get(obj), field.get(obj2))) {
                    i10++;
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
        return i10;
    }

    @CalledByNative
    public static VideoEncoderDef.BitrateMode createEncoderBitrateMode(int i10) {
        return VideoEncoderDef.BitrateMode.a(i10);
    }

    @CalledByNative
    public static VideoEncoderDef.EncoderComplexity createEncoderComplexity(int i10) {
        return VideoEncoderDef.EncoderComplexity.a(i10);
    }

    @CalledByNative
    public static VideoEncoderDef.EncoderProfile createEncoderProfileType(int i10) {
        return VideoEncoderDef.EncoderProfile.a(i10);
    }

    @CalledByNative
    public static CodecType createEncoderVideoCodec(int i10) {
        return CodecType.a(i10);
    }

    @CalledByNative
    public static VideoEncoderDef.ReferenceStrategy createReferenceStrategy(int i10) {
        return VideoEncoderDef.ReferenceStrategy.a(i10);
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof VideoEncodeParams) && checkFieldDiffCounts(this, obj) == 0;
    }

    @CalledByNative
    public final long getBaseFrameIndex() {
        return this.baseFrameIndex;
    }

    @CalledByNative
    public final long getBaseGopIndex() {
        return this.baseGopIndex;
    }

    @CalledByNative
    public final int getBitrate() {
        return this.bitrate;
    }

    @CalledByNative
    public final int getBitrateMode() {
        return this.bitrateMode.mValue;
    }

    @CalledByNative
    public final int getCodecType() {
        return this.codecType.mValue;
    }

    @CalledByNative
    public final int getEncoderComplexity() {
        VideoEncoderDef.EncoderComplexity encoderComplexity = this.encoderComplexity;
        if (encoderComplexity == null) {
            return VideoEncoderDef.EncoderComplexity.VERY_FAST.mValue;
        }
        return encoderComplexity.mValue;
    }

    @CalledByNative
    public final int getEncoderProfile() {
        return this.encoderProfile.mValue;
    }

    @CalledByNative
    public final int getFps() {
        return this.fps;
    }

    @CalledByNative
    public final int getGop() {
        return this.gop;
    }

    @CalledByNative
    public final int getHeight() {
        return this.height;
    }

    public final JSONArray getMediaCodecDeviceRelatedParams() {
        return this.mediaCodecDeviceRelatedParams;
    }

    public final VideoEncoderDef.ReferenceStrategy getReferenceStrategy() {
        return this.referenceStrategy;
    }

    @CalledByNative
    public final int getWidth() {
        return this.width;
    }

    @CalledByNative
    public final boolean isAnnexb() {
        return this.annexb;
    }

    @CalledByNative
    public final boolean isEnablesBframe() {
        return this.enableBFrame;
    }

    @CalledByNative
    public final boolean isEnablesRps() {
        return this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.RPS;
    }

    @CalledByNative
    public final boolean isEnablesSvc() {
        return this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.SVC;
    }

    @CalledByNative
    public final boolean isEnablesUnlimitedGop() {
        return this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.UNLIMITED_GOP;
    }

    @CalledByNative
    public final boolean isFullIFrame() {
        return this.fullIFrame;
    }

    @CalledByNative
    public final boolean isTranscodingMode() {
        return this.isTranscodingMode;
    }

    @CalledByNative
    public final void setAnnexb(boolean z10) {
        this.annexb = z10;
    }

    @CalledByNative
    public final void setBFrameEnabled(boolean z10) {
        this.enableBFrame = z10;
    }

    @CalledByNative
    public final void setBaseFrameIndex(long j10) {
        this.baseFrameIndex = j10;
    }

    @CalledByNative
    public final void setBaseGopIndex(long j10) {
        this.baseGopIndex = j10;
    }

    @CalledByNative
    public final void setBitrate(int i10) {
        this.bitrate = i10;
    }

    @CalledByNative
    public final void setBitrateMode(VideoEncoderDef.BitrateMode bitrateMode) {
        this.bitrateMode = bitrateMode;
    }

    @CalledByNative
    public final void setCodecType(CodecType codecType) {
        this.codecType = codecType;
    }

    @CalledByNative
    public final void setEncoderComplexity(VideoEncoderDef.EncoderComplexity encoderComplexity) {
        this.encoderComplexity = encoderComplexity;
    }

    @CalledByNative
    public final void setEncoderProfile(VideoEncoderDef.EncoderProfile encoderProfile) {
        this.encoderProfile = encoderProfile;
    }

    @CalledByNative
    public final void setFps(int i10) {
        this.fps = i10;
    }

    @CalledByNative
    public final void setFullIFrame(boolean z10) {
        this.fullIFrame = z10;
    }

    @CalledByNative
    public final void setGop(int i10) {
        this.gop = i10;
    }

    @CalledByNative
    public final void setHeight(int i10) {
        this.height = i10;
    }

    @CalledByNative
    public final void setMediaCodecDeviceRelatedParams(JSONArray jSONArray) {
        this.mediaCodecDeviceRelatedParams = jSONArray;
    }

    @CalledByNative
    public final void setReferenceStrategy(VideoEncoderDef.ReferenceStrategy referenceStrategy) {
        this.referenceStrategy = referenceStrategy;
    }

    @CalledByNative
    public final void setTranscodingModeEnabled(boolean z10) {
        this.isTranscodingMode = z10;
    }

    @CalledByNative
    public final void setWidth(int i10) {
        this.width = i10;
    }

    @NonNull
    public final String toString() {
        return "width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", gop=" + this.gop + ", bitrate=" + this.bitrate + ", annexb=" + this.annexb + ", encoderProfile=" + ((Object) this.encoderProfile) + ", bitrateMode=" + ((Object) this.bitrateMode) + ", baseFrameIndex=" + this.baseFrameIndex + ", baseGopIndex=" + this.baseGopIndex + ", fullIFrame=" + this.fullIFrame + ", enableBFrame=" + this.enableBFrame + ", referenceStrategy=" + ((Object) this.referenceStrategy) + ", codecType=" + ((Object) this.codecType) + ", isTransCodingMode=" + this.isTranscodingMode + ", mediaCodecDeviceRelatedParams=" + ((Object) this.mediaCodecDeviceRelatedParams) + ", encoderComplexity=" + ((Object) this.encoderComplexity);
    }

    public VideoEncodeParams(VideoEncodeParams videoEncodeParams) {
        this.width = 0;
        this.height = 0;
        this.fps = 20;
        this.gop = 3;
        this.bitrate = 0;
        this.annexb = true;
        this.encoderProfile = null;
        this.bitrateMode = VideoEncoderDef.BitrateMode.CBR;
        this.baseFrameIndex = 0L;
        this.baseGopIndex = 0L;
        this.fullIFrame = false;
        this.enableBFrame = false;
        this.referenceStrategy = VideoEncoderDef.ReferenceStrategy.FIX_GOP;
        this.codecType = CodecType.H264;
        this.isTranscodingMode = false;
        this.encoderComplexity = null;
        this.mediaCodecDeviceRelatedParams = null;
        if (videoEncodeParams == null) {
            return;
        }
        this.width = videoEncodeParams.width;
        this.height = videoEncodeParams.height;
        this.fps = videoEncodeParams.fps;
        this.gop = videoEncodeParams.gop;
        this.bitrate = videoEncodeParams.bitrate;
        this.annexb = videoEncodeParams.annexb;
        this.encoderProfile = videoEncodeParams.encoderProfile;
        this.bitrateMode = videoEncodeParams.bitrateMode;
        this.baseFrameIndex = videoEncodeParams.baseFrameIndex;
        this.baseGopIndex = videoEncodeParams.baseGopIndex;
        this.fullIFrame = videoEncodeParams.fullIFrame;
        this.enableBFrame = videoEncodeParams.enableBFrame;
        this.codecType = videoEncodeParams.codecType;
        this.referenceStrategy = videoEncodeParams.referenceStrategy;
        this.isTranscodingMode = videoEncodeParams.isTranscodingMode;
        this.encoderComplexity = videoEncodeParams.encoderComplexity;
        if (videoEncodeParams.mediaCodecDeviceRelatedParams != null) {
            try {
                this.mediaCodecDeviceRelatedParams = new JSONArray(videoEncodeParams.mediaCodecDeviceRelatedParams.toString());
            } catch (JSONException unused) {
            }
        }
    }
}
