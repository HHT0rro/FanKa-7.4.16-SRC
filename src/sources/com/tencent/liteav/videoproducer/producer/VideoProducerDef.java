package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface VideoProducerDef {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum CameraCaptureMode {
        AUTO(0),
        PERFORMANCE(1),
        HIGH_QUALITY(2),
        MANUAL(3);

        public final int mValue;

        CameraCaptureMode(int i10) {
            this.mValue = i10;
        }

        public static CameraCaptureMode a(int i10) {
            for (CameraCaptureMode cameraCaptureMode : values()) {
                if (cameraCaptureMode.mValue == i10) {
                    return cameraCaptureMode;
                }
            }
            return AUTO;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum GSensorMode {
        DISABLE(0),
        UI_AUTO_LAYOUT(1),
        UI_FIX_LAYOUT(2);


        /* renamed from: d, reason: collision with root package name */
        private static final GSensorMode[] f44874d = values();
        public int mValue;

        GSensorMode(int i10) {
            this.mValue = i10;
        }

        public static GSensorMode a(int i10) {
            for (GSensorMode gSensorMode : f44874d) {
                if (gSensorMode.mValue == i10) {
                    return gSensorMode;
                }
            }
            return UI_FIX_LAYOUT;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum HomeOrientation {
        UNSET(-1),
        UP(0),
        LEFT(1),
        RIGHT(2),
        DOWN(3);


        /* renamed from: f, reason: collision with root package name */
        private static final HomeOrientation[] f44881f = values();
        public int mValue;

        HomeOrientation(int i10) {
            this.mValue = i10;
        }

        public static HomeOrientation a(int i10) {
            for (HomeOrientation homeOrientation : f44881f) {
                if (homeOrientation.mValue == i10) {
                    return homeOrientation;
                }
            }
            return DOWN;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum StreamType {
        STREAM_TYPE_BIG_VIDEO(0),
        STREAM_TYPE_SMALL_VIDEO(1),
        STREAM_TYPE_SUB_VIDEO(2);


        /* renamed from: d, reason: collision with root package name */
        private static final StreamType[] f44886d = values();
        public final int mValue;

        StreamType(int i10) {
            this.mValue = i10;
        }

        public static StreamType a(int i10) {
            for (StreamType streamType : f44886d) {
                if (streamType.mValue == i10) {
                    return streamType;
                }
            }
            return STREAM_TYPE_BIG_VIDEO;
        }
    }
}
