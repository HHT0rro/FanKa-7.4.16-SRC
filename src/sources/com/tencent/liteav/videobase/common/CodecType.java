package com.tencent.liteav.videobase.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum CodecType {
    UNKNOWN(-1),
    H264(0),
    H265(1),
    VP8(2),
    KAV1(3);


    /* renamed from: f, reason: collision with root package name */
    private static final CodecType[] f43368f = values();
    public final int mValue;

    CodecType(int i10) {
        this.mValue = i10;
    }

    public static CodecType a(int i10) {
        for (CodecType codecType : f43368f) {
            if (i10 == codecType.mValue) {
                return codecType;
            }
        }
        return H264;
    }
}
