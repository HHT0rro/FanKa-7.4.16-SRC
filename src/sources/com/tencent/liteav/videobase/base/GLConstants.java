package com.tencent.liteav.videobase.base;

import com.tencent.liteav.base.annotations.CalledByNative;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface GLConstants {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f43290a = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f43291b = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f43292c = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f43293d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: e, reason: collision with root package name */
    public static final float[] f43294e = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: f, reason: collision with root package name */
    public static final float[] f43295f = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: g, reason: collision with root package name */
    public static final float[] f43296g = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: h, reason: collision with root package name */
    public static final float[] f43297h = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ColorRange {
        UNKNOWN(0),
        VIDEO_RANGE(1),
        FULL_RANGE(2);

        private final int mJniValue;

        ColorRange(int i10) {
            this.mJniValue = i10;
        }

        public static ColorRange a(int i10) {
            for (ColorRange colorRange : values()) {
                if (colorRange.mJniValue == i10) {
                    return colorRange;
                }
            }
            return UNKNOWN;
        }

        @CalledByNative
        public final int getValue() {
            return this.mJniValue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ColorSpace {
        UNKNOWN(0),
        BT601(1),
        BT709(2);

        private final int mJniValue;

        ColorSpace(int i10) {
            this.mJniValue = i10;
        }

        public static ColorSpace a(int i10) {
            for (ColorSpace colorSpace : values()) {
                if (colorSpace.mJniValue == i10) {
                    return colorSpace;
                }
            }
            return UNKNOWN;
        }

        @CalledByNative
        public final int getValue() {
            return this.mJniValue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum GLScaleType {
        CENTER_CROP(0),
        FIT_CENTER(1),
        FILL(2);


        /* renamed from: d, reason: collision with root package name */
        private static final GLScaleType[] f43309d = values();
        public int mValue;

        GLScaleType(int i10) {
            this.mValue = i10;
        }

        public static GLScaleType a(int i10) {
            for (GLScaleType gLScaleType : f43309d) {
                if (gLScaleType.mValue == i10) {
                    return gLScaleType;
                }
            }
            return FIT_CENTER;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum MirrorMode {
        AUTO(0),
        ENABLE(1),
        DISABLE(2);


        /* renamed from: d, reason: collision with root package name */
        private static final MirrorMode[] f43314d = values();
        public int mValue;

        MirrorMode(int i10) {
            this.mValue = i10;
        }

        public static MirrorMode a(int i10) {
            for (MirrorMode mirrorMode : f43314d) {
                if (mirrorMode.mValue == i10) {
                    return mirrorMode;
                }
            }
            return AUTO;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum PixelBufferType {
        BYTE_BUFFER(0),
        TEXTURE_2D(1),
        TEXTURE_OES(2),
        BYTE_ARRAY(3);


        /* renamed from: e, reason: collision with root package name */
        private static final PixelBufferType[] f43320e = values();
        public int mValue;

        PixelBufferType(int i10) {
            this.mValue = i10;
        }

        public static PixelBufferType a(int i10) {
            for (PixelBufferType pixelBufferType : f43320e) {
                if (pixelBufferType.mValue == i10) {
                    return pixelBufferType;
                }
            }
            return TEXTURE_2D;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum PixelFormatType {
        I420(0),
        NV12(1),
        NV21(2),
        RGB(3),
        YUY2(4),
        RGBA(5),
        BGR(6),
        YV12(7),
        BGRA(8),
        ARGB(9),
        YUV422P(10),
        UYVY(11),
        YUYV(12),
        JPG(13),
        H264(14),
        MAX(100);


        /* renamed from: q, reason: collision with root package name */
        private static final PixelFormatType[] f43338q = values();
        private final int mJniValue;

        PixelFormatType(int i10) {
            this.mJniValue = i10;
        }

        public static PixelFormatType a(int i10) {
            for (PixelFormatType pixelFormatType : f43338q) {
                if (pixelFormatType.mJniValue == i10) {
                    return pixelFormatType;
                }
            }
            return null;
        }

        @CalledByNative
        public final int getValue() {
            return this.mJniValue;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ResolutionMode {
        LANDSCAPE(0),
        PORTRAIT(1),
        LANDSCAPE_WITHOUT_ROTATION(2);

        public int mValue;

        ResolutionMode(int i10) {
            this.mValue = i10;
        }

        public static ResolutionMode a(int i10) {
            for (ResolutionMode resolutionMode : values()) {
                if (resolutionMode.mValue == i10) {
                    return resolutionMode;
                }
            }
            return PORTRAIT;
        }
    }
}
