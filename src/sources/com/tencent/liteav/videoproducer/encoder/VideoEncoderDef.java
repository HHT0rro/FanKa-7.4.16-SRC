package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.h;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface VideoEncoderDef {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum BitrateMode {
        CBR(0),
        VBR(1),
        CQ(2);


        /* renamed from: d, reason: collision with root package name */
        private static final BitrateMode[] f44456d = values();
        public int mValue;

        BitrateMode(int i10) {
            this.mValue = i10;
        }

        public static BitrateMode a(int i10) {
            for (BitrateMode bitrateMode : f44456d) {
                if (i10 == bitrateMode.mValue) {
                    return bitrateMode;
                }
            }
            return VBR;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class EncodeAbility {

        /* renamed from: a, reason: collision with root package name */
        public boolean f44458a = true;

        /* renamed from: b, reason: collision with root package name */
        public boolean f44459b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f44460c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f44461d = false;

        @CalledByNative("EncodeAbility")
        public boolean isSupportHwHEVC() {
            return this.f44461d;
        }

        @CalledByNative("EncodeAbility")
        public boolean isSupportRPS() {
            return this.f44458a;
        }

        @CalledByNative("EncodeAbility")
        public boolean isSupportSVC() {
            return this.f44459b;
        }

        @CalledByNative("EncodeAbility")
        public boolean isSupportSwHEVC() {
            return this.f44460c;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum EncodeStrategy {
        PREFER_HARDWARE(0),
        PREFER_SOFTWARE(1),
        USE_HARDWARE_ONLY(2),
        USE_SOFTWARE_ONLY(3);


        /* renamed from: e, reason: collision with root package name */
        private static final EncodeStrategy[] f44466e = values();
        public int mValue;

        EncodeStrategy(int i10) {
            this.mValue = i10;
        }

        public static EncodeStrategy a(int i10) {
            for (EncodeStrategy encodeStrategy : f44466e) {
                if (encodeStrategy.mValue == i10) {
                    return encodeStrategy;
                }
            }
            return PREFER_HARDWARE;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum EncoderComplexity {
        UNKNOWN(65535),
        HYPER_FAST(0),
        ULTRA_FAST(1),
        SUPER_FAST(2),
        VERY_FAST(3),
        FAST(4);

        public final int mValue;

        EncoderComplexity(int i10) {
            this.mValue = i10;
        }

        public static EncoderComplexity a(int i10) {
            for (EncoderComplexity encoderComplexity : values()) {
                if (encoderComplexity.mValue == i10) {
                    return encoderComplexity;
                }
            }
            return UNKNOWN;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum EncoderProfile {
        PROFILE_BASELINE(1),
        PROFILE_MAIN(2),
        PROFILE_HIGH(3),
        PROFILE_BASELINERPS(11),
        PROFILE_MAINRPS(12),
        PROFILE_HIGHRPS(13);


        /* renamed from: g, reason: collision with root package name */
        private static final EncoderProfile[] f44481g = values();
        public int mValue;

        EncoderProfile(int i10) {
            this.mValue = i10;
        }

        public static EncoderProfile a(int i10) {
            for (EncoderProfile encoderProfile : f44481g) {
                if (i10 == encoderProfile.mValue) {
                    return encoderProfile;
                }
            }
            return PROFILE_BASELINE;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class EncoderProperty {

        /* renamed from: a, reason: collision with root package name */
        public a f44483a;

        /* renamed from: b, reason: collision with root package name */
        public ReferenceStrategy f44484b;

        /* renamed from: c, reason: collision with root package name */
        public CodecType f44485c;

        public EncoderProperty(a aVar, ReferenceStrategy referenceStrategy, CodecType codecType) {
            this.f44483a = aVar;
            this.f44484b = referenceStrategy;
            this.f44485c = codecType;
        }

        @CalledByNative("EncoderProperty")
        public int getCodecType() {
            return this.f44485c.mValue;
        }

        @CalledByNative("EncoderProperty")
        public int getEncoderType() {
            return this.f44483a.value;
        }

        @CalledByNative("EncoderProperty")
        public int getReferenceStrategy() {
            return this.f44484b.mValue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ReferenceStrategy {
        FIX_GOP(0),
        RPS(1),
        SVC(2),
        UNLIMITED_GOP(3);


        /* renamed from: e, reason: collision with root package name */
        private static final ReferenceStrategy[] f44490e = values();
        public int mValue;

        ReferenceStrategy(int i10) {
            this.mValue = i10;
        }

        public static ReferenceStrategy a(int i10) {
            for (ReferenceStrategy referenceStrategy : f44490e) {
                if (i10 == referenceStrategy.mValue) {
                    return referenceStrategy;
                }
            }
            return FIX_GOP;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class VideoEncoderDataListener {
        public void onEncodedFail(h.a aVar) {
        }

        public void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z10) {
        }

        public void onOutputFormatChanged(MediaFormat mediaFormat) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        HARDWARE(1),
        SOFTWARE(2);

        public int value;

        a(int i10) {
            this.value = i10;
        }
    }
}
